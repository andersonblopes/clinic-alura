package med.lopes.vol.api.service;

import lombok.RequiredArgsConstructor;
import med.lopes.vol.api.domain.entities.Doctor;
import med.lopes.vol.api.domain.repository.DoctorRepository;
import med.lopes.vol.api.exceptions.custom.EntityNotFoundException;
import med.lopes.vol.api.model.DoctorModel;
import med.lopes.vol.api.model.input.DoctorInput;
import med.lopes.vol.api.model.input.DoctorUpdateInput;
import med.lopes.vol.api.model.mapper.AddressMapper;
import med.lopes.vol.api.model.mapper.DoctorMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static java.util.Objects.nonNull;
import static org.springframework.util.StringUtils.hasText;

/**
 * The type Doctor service.
 */
@RequiredArgsConstructor
@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final AddressMapper addressMapper;
    private final DoctorMapper doctorMapper;

    /**
     * Create a doctor model.
     *
     * @param input the input
     * @return the doctor model
     */
    @Transactional
    public DoctorModel create(DoctorInput input) {

        var entity = doctorMapper.toEntity(input);
        doctorRepository.save(entity);

        return doctorMapper.toModel(entity);
    }

    /**
     * List page.
     *
     * @param pageable the pageable
     * @return the page
     */
    public Page<DoctorModel> list(Pageable pageable) {
        Page<Doctor> page = doctorRepository.findAll(pageable);

        return doctorMapper.toPage(page);
    }

    /**
     * Update a doctor model.
     *
     * @param doctorId the doctor id
     * @param input    the input
     * @return the doctor model
     */
    @Transactional
    public DoctorModel update(Long doctorId, DoctorUpdateInput input) {

        Doctor entity = null;
        Optional<Doctor> entityOptional = doctorRepository.findById(doctorId);

        if (entityOptional.isEmpty()) {
            throw new EntityNotFoundException("Entity with id: " + doctorId + ", not found");
        }

        entity = entityOptional.get();

        if (hasText(input.name())) {
            entity.setName(input.name());
        }

        if (hasText(input.phone())) {
            entity.setPhone(input.phone());
        }

        if (nonNull(input.address())) {
            entity.setAddress(addressMapper.toUpdateEntity(entity.getAddress(), input.address()));
        }

        return doctorMapper.toModel(entity);
    }
}
