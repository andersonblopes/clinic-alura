package med.lopes.vol.api.service;

import lombok.RequiredArgsConstructor;
import med.lopes.vol.api.domain.entities.Doctor;
import med.lopes.vol.api.domain.repository.DoctorRepository;
import med.lopes.vol.api.model.DoctorModel;
import med.lopes.vol.api.model.input.DoctorInput;
import med.lopes.vol.api.model.mapper.DoctorMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;

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
     * List set.
     *
     * @return the set
     */
    public Set<DoctorModel> list() {
        List<Doctor> doctorList = doctorRepository.findAll();

        return doctorMapper.toSet(doctorList);
    }
}
