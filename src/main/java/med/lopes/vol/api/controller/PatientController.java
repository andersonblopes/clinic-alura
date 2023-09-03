package med.lopes.vol.api.controller;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import med.lopes.vol.api.model.input.PatientInput;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Patient controller.
 */
@Slf4j
@RestController
@RequestMapping("/patients")
public class PatientController {

    /**
     * Create.
     *
     * @param input the input
     */
    @PostMapping
    public void create(@RequestBody @Valid PatientInput input) {
        log.info(String.valueOf(input));
    }

}
