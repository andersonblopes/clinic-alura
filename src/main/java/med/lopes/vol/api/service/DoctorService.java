package med.lopes.vol.api.service;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import med.lopes.vol.api.domain.entities.Doctor;
import med.lopes.vol.api.domain.repository.DoctorRepository;
import med.lopes.vol.api.model.DoctorModel;
import med.lopes.vol.api.model.input.DoctorInput;
import med.lopes.vol.api.model.mapper.DoctorMapper;
import org.springframework.stereotype.Service;

/**
 * The type Doctor service.
 */
@RequiredArgsConstructor
@Service
public class DoctorService {

    private final DoctorRepository doctorRepository;
    private final DoctorMapper doctorMapper;

    /**
     * Create doctor model.
     *
     * @param input the input
     * @return the doctor model
     */
    @Transactional
    public DoctorModel create(DoctorInput input) {

        var entity = new Doctor(input);
        doctorRepository.save(entity);

        return doctorMapper.toModel(entity);
    }
}
