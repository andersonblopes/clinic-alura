package med.lopes.vol.api.model;

public record AddressInput(String addressType,
                           String neighborhood,
                           String postalCode,
                           String city,
                           String state,
                           String number,
                           String notes) {
}
