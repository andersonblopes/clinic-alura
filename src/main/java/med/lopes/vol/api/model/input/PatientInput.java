package med.lopes.vol.api.model.input;

import med.lopes.vol.api.model.AddressInput;

public record PatientInput(String name,
                           String email,
                           String phoneNumber,
                           String cpf,
                           AddressInput address) {
}
