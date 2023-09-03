package med.lopes.vol.api.model.mapper;

import med.lopes.vol.api.domain.entities.Address;
import med.lopes.vol.api.model.AddressModel;
import med.lopes.vol.api.model.input.AddressInput;
import org.springframework.stereotype.Component;

/**
 * The type Address mapper.
 */
@Component
public class AddressMapper {

    /**
     * To entity address.
     *
     * @param input the input
     * @return the address
     */
    public Address toEntity(AddressInput input) {
        return Address.builder()
                .description(input.description())
                .neighborhood(input.neighborhood())
                .postalCode(input.postalCode())
                .city(input.city())
                .state(input.state())
                .number(input.number())
                .notes(input.notes())
                .build();
    }

    /**
     * To model address model.
     *
     * @param entity the entity
     * @return the address model
     */
    public AddressModel toModel(Address entity) {
        return AddressModel.builder()
                .description(entity.getDescription())
                .neighborhood(entity.getNeighborhood())
                .postalCode(entity.getPostalCode())
                .city(entity.getCity())
                .state(entity.getState())
                .number(entity.getNumber())
                .notes(entity.getNotes())
                .build();
    }
}
