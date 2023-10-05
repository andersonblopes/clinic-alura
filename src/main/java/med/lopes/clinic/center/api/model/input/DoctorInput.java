package med.lopes.clinic.center.api.model.input;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import med.lopes.clinic.center.api.domain.enums.Speciality;

/**
 * The type Doctor input.
 */
public record DoctorInput(@NotBlank String name,
                          @NotBlank
                          @Email
                          String email,
                          @NotBlank
                          @Pattern(regexp = "\\d{4,6}")
                          String crm,
                          @NotBlank
                          String phone,
                          @NotNull
                          Speciality speciality,
                          @NotNull
                          @Valid
                          AddressInput address) {
}
