package med.lopes.vol.api.controller;

import lombok.extern.slf4j.Slf4j;
import med.lopes.vol.api.model.input.DoctorInput;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Doctor controller.
 */
@Slf4j
@RestController
@RequestMapping("/doctors")
public class DoctorController {

    /**
     * Create.
     *
     * @param input the input
     */
    @PostMapping
    public void create(@RequestBody DoctorInput input) {
        log.info(String.valueOf(input));
    }

}
