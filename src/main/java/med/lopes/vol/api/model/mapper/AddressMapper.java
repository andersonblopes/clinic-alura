package med.lopes.vol.api.model.mapper;

import med.lopes.vol.api.domain.entities.Address;
import med.lopes.vol.api.model.AddressModel;
import med.lopes.vol.api.model.input.AddressInput;
import org.springframework.stereotype.Component;

import static org.springframework.util.StringUtils.hasText;

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

    /**
     * To update entity address.
     *
     * @param address the address
     * @param input   the input
     * @return the address
     */
    public Address toUpdateEntity(Address address, AddressInput input) {
        address.setDescription(hasText(input.description()) ? input.description() : address.getDescription());
        address.setNeighborhood(hasText(input.neighborhood()) ? input.neighborhood() : address.getNeighborhood());
        address.setNotes(hasText(input.notes()) ? input.notes() : address.getNotes());
        address.setNumber(hasText(input.number()) ? input.number() : address.getNumber());
        address.setPostalCode(hasText(input.postalCode()) ? input.postalCode() : address.getPostalCode());
        address.setCity(hasText(input.city()) ? input.city() : address.getCity());
        address.setState(hasText(input.state()) ? input.state() : address.getState());

        return address;
    }
}
