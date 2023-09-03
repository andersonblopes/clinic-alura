package med.lopes.vol.api.model.input;

/**
 * The type Patient input.
 */
public record PatientInput(String name,
                           String email,
                           String phoneNumber,
                           String cpf,
                           AddressInput address) {
}
