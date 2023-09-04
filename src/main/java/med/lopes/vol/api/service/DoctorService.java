package med.lopes.vol.api.service;

import lombok.RequiredArgsConstructor;
import med.lopes.vol.api.domain.entities.Doctor;
import med.lopes.vol.api.domain.repository.DoctorRepository;
import med.lopes.vol.api.model.DoctorModel;
import med.lopes.vol.api.model.input.DoctorInput;
import med.lopes.vol.api.model.mapper.DoctorMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The type Doctor service.
 */
@RequiredArgsConstructor
@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
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
}
