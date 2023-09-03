package med.lopes.vol.api.domain.entities;

import jakarta.persistence.Embeddable;
import lombok.*;

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
}
