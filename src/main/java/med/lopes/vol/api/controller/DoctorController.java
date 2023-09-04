package med.lopes.vol.api.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import med.lopes.vol.api.model.DoctorModel;
import med.lopes.vol.api.model.input.DoctorInput;
import med.lopes.vol.api.service.DoctorService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.data.domain.Sort.Direction.ASC;

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

    /**
     * List response entity.
     *
     * @param pageable the pageable
     * @return the response entity
     */
    @GetMapping
    public ResponseEntity<Page<DoctorModel>> list(@PageableDefault(page = 0, size = 10, sort = {"name"}, direction = ASC) Pageable pageable) {
        return ResponseEntity.ok().body(doctorService.list(pageable));
    }

}
