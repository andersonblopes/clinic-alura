package med.lopes.vol.api.domain.entities;

import jakarta.persistence.Embeddable;
import lombok.*;
import med.lopes.vol.api.model.input.AddressInput;

/**
 * The type Address.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Embeddable
public class Address {

    private String addressType;
    private String neighborhood;
    private String postalCode;
    private String city;
    private String state;
    private String number;
    private String notes;

    /**
     * Instantiates a new Address.
     *
     * @param input the input
     */
    public Address(AddressInput input) {
        this.addressType = input.addressType();
        this.neighborhood = input.neighborhood();
        this.postalCode = input.postalCode();
        this.city = input.city();
        this.state = input.state();
        this.number = input.number();
        this.notes = input.notes();
    }
}
