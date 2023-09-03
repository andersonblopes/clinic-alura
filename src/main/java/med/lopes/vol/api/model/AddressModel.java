package med.lopes.vol.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * The type Address model.
 */
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AddressModel {

    private String description;
    private String neighborhood;
    private String postalCode;
    private String city;
    private String state;
    private String number;
    private String notes;
}
