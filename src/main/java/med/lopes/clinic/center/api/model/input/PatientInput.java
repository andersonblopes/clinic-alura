package med.lopes.clinic.center.api.model.input;

import org.hibernate.validator.constraints.br.CPF;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * The type Patient input.
 */
public record PatientInput(
        @NotBlank String name,
        @NotBlank
        @Email
        String email,
        @NotBlank
        String phone,
        @NotBlank
        @CPF
        String cpf,
        @NotNull
        @Valid AddressInput address) {
}
