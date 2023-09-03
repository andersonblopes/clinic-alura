package med.lopes.vol.api.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import med.lopes.vol.api.domain.enums.Speciality;

/**
 * The type Doctor model.
 */
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DoctorModel {

    private Long id;
    private String name;
    private String email;
    private String crm;
    private String phone;
    private Speciality speciality;
    private AddressModel address;
}
