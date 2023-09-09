package med.lopes.clinic.center.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Hello controller.
 */
@RestController
@RequestMapping("/v1/hello")
public class HelloController {

    /**
     * Hello string.
     *
     * @return the string
     */
    @GetMapping
    public String hello() {
        return "Hello world!";
    }
}
