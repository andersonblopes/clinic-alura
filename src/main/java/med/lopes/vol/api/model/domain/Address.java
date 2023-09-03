package med.lopes.vol.api.model.domain;

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

    /**
     * The Address type.
     */
    private String addressType;
    /**
     * The Neighborhood.
     */
    private String neighborhood;
    /**
     * The Postal code.
     */
    private String postalCode;
    /**
     * The City.
     */
    private String city;
    /**
     * The State.
     */
    private String state;
    /**
     * The Number.
     */
    private String number;
    /**
     * The Notes.
     */
    private String notes;
}
