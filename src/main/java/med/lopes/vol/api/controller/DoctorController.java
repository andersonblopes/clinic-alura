package med.lopes.vol.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import med.lopes.vol.api.model.DoctorModel;
import med.lopes.vol.api.model.input.DoctorInput;
import med.lopes.vol.api.service.DoctorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Doctor controller.
 */
@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/doctors")
public class DoctorController {

    private final DoctorService doctorService;

    /**
     * Create response entity.
     *
     * @param input the input
     * @return the response entity
     */
    @PostMapping
    public ResponseEntity<DoctorModel> create(@RequestBody @Valid DoctorInput input) {
        return ResponseEntity.ok().body(doctorService.create(input));
    }

}
