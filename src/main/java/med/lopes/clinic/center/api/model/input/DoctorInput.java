package med.lopes.clinic.center.api.model.input;

import med.lopes.clinic.center.api.domain.enums.Speciality;

import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

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
