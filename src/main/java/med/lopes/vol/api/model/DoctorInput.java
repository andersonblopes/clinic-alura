package med.lopes.vol.api.model;

public record DoctorInput(String name,
                          String email,
                          String crm,
                          Speciality speciality,
                          AddressInput address) {
}
