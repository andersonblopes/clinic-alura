package med.lopes.vol.api.model.input;

import med.lopes.vol.api.domain.enums.Speciality;

/**
 * The type Doctor input.
 */
public record DoctorInput(String name,
                          String email,
                          String crm,
                          Speciality speciality,
                          AddressInput address) {
}
