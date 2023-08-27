package med.lopes.vol.api.controller;

import lombok.extern.slf4j.Slf4j;
import med.lopes.vol.api.model.input.PatientInput;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/patients")
public class PatientController {

    @PostMapping
    public void creat(@RequestBody PatientInput input) {
        log.info(String.valueOf(input));
    }

}
