package med.lopes.vol.api.model.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.hibernate.validator.constraints.br.CPF;

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
