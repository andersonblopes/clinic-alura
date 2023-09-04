package med.lopes.vol.api.model.input;

/**
 * The type Patient update input.
 */
public record PatientUpdateInput(
        String name,
        String phone,
        AddressInput address) {
}
