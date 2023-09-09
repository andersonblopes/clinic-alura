package med.lopes.clinic.center.api.model.input;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

/**
 * The type Address input.
 */
public record AddressInput(
        @NotBlank
        String description,
        @NotBlank
        String neighborhood,
        @NotBlank
        @Pattern(regexp = "\\d{4}")
        String postalCode,
        @NotBlank
        String city,
        @NotBlank
        String state,
        String number,
        String notes) {
}
