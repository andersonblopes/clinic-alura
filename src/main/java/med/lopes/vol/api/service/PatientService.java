package med.lopes.vol.api.service;

import lombok.RequiredArgsConstructor;
import med.lopes.vol.api.domain.entities.Patient;
import med.lopes.vol.api.domain.repository.PatientRepository;
import med.lopes.vol.api.model.PatientModel;
import med.lopes.vol.api.model.input.PatientInput;
import med.lopes.vol.api.model.mapper.PatientMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * The type Patient service.
 */
@RequiredArgsConstructor
@Service
public class PatientService {

    private final PatientRepository patientRepository;
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
}
