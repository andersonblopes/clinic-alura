package med.lopes.clinic.center.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import med.lopes.clinic.center.api.model.PatientModel;
import med.lopes.clinic.center.api.model.input.PatientInput;
import med.lopes.clinic.center.api.model.input.PatientUpdateInput;
import med.lopes.clinic.center.api.service.PatientService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.data.domain.Sort.Direction.ASC;

/**
 * The type Patient controller.
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/patients")
public class PatientController {

    private final PatientService patientService;

    /**
     * Create response entity.
     *
     * @param input the input
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<PatientModel> create(@RequestBody @Valid PatientInput input) {
        return ResponseEntity.ok().body(patientService.create(input));
    }

    /**
     * List response entity.
     *
     * @param pageable the pageable
     * @return the response entity
     */
    @GetMapping
    public ResponseEntity<Page<PatientModel>> list(@PageableDefault(page = 0, size = 10, sort = {"name"}, direction = ASC) Pageable pageable) {
        return ResponseEntity.ok().body(patientService.list(pageable));
    }

    /**
     * Update response entity.
     *
     * @param patientId the patient id
     * @param input     the input
     * @return the response entity
     */
    @PutMapping("/{patientId}")
    public ResponseEntity<PatientModel> update(@PathVariable("patientId") Long patientId, @RequestBody @Valid PatientUpdateInput input) {
        return ResponseEntity.ok().body(patientService.update(patientId, input));
    }

    /**
     * Deactivate.
     *
     * @param patientId the patient id
     */
    @DeleteMapping("/{patientId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deactivate(@PathVariable("patientId") Long patientId) {
        patientService.deactivate(patientId);
    }

}
