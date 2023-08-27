package med.lopes.vol.api.controller;

import lombok.extern.slf4j.Slf4j;
import med.lopes.vol.api.model.DoctorInput;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/doctors")
public class DoctorController {

    @PostMapping
    public void creat(@RequestBody DoctorInput input) {
        log.info(String.valueOf(input));
    }

}
