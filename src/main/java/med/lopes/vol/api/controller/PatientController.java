package med.lopes.vol.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import med.lopes.vol.api.model.PatientModel;
import med.lopes.vol.api.model.input.PatientInput;
import med.lopes.vol.api.service.PatientService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

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
     * @return the response entity
     */
    @GetMapping
    public ResponseEntity<Set<PatientModel>> list() {
        return ResponseEntity.ok().body(patientService.list());
    }

}
