package med.lopes.vol.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * The type Patient model.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PatientModel {

    private Long id;
    private String name;
    private String email;
    private String cpf;
    private String phone;
    private AddressModel address;
}
