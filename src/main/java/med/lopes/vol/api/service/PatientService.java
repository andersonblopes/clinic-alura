package med.lopes.vol.api.service;

import lombok.RequiredArgsConstructor;
import med.lopes.vol.api.domain.entities.Patient;
import med.lopes.vol.api.domain.repository.PatientRepository;
import med.lopes.vol.api.exceptions.custom.EntityNotFoundException;
import med.lopes.vol.api.model.PatientModel;
import med.lopes.vol.api.model.input.PatientInput;
import med.lopes.vol.api.model.input.PatientUpdateInput;
import med.lopes.vol.api.model.mapper.AddressMapper;
import med.lopes.vol.api.model.mapper.PatientMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static java.util.Objects.nonNull;
import static org.springframework.util.StringUtils.hasText;

/**
 * The type Patient service.
 */
@RequiredArgsConstructor
@Service
public class PatientService {

    private final PatientRepository patientRepository;
    private final AddressMapper addressMapper;
    private final PatientMapper patientMapper;

    /**
     * Create patient model.
     *
     * @param input the input
     * @return the patient model
     */
    @Transactional
    public PatientModel create(PatientInput input) {

        var entity = patientMapper.toEntity(input);
        patientRepository.save(entity);

        return patientMapper.toModel(entity);
    }

    /**
     * List page.
     *
     * @param pageable the pageable
     * @return the page
     */
    public Page<PatientModel> list(Pageable pageable) {
        Page<Patient> patientList = patientRepository.findAll(pageable);

        return patientMapper.toPage(patientList);
    }

    /**
     * Update a patient model.
     *
     * @param patientId the patient id
     * @param input     the input
     * @return the patient model
     */
    @Transactional
    public PatientModel update(Long patientId, PatientUpdateInput input) {

        Patient entity = null;
        Optional<Patient> entityOptional = patientRepository.findById(patientId);

        if (entityOptional.isEmpty()) {
            throw new EntityNotFoundException("Entity with id: " + patientId + ", not found");

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


        return patientMapper.toModel(entity);
    }
}
