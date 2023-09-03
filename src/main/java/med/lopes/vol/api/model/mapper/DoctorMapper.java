package med.lopes.vol.api.model.mapper;

import med.lopes.vol.api.domain.entities.Address;
import med.lopes.vol.api.domain.entities.Doctor;
import med.lopes.vol.api.model.AddressModel;
import med.lopes.vol.api.model.DoctorModel;
import org.springframework.stereotype.Component;

/**
 * The type Doctor mapper.
 */
@Component
public class DoctorMapper {

    /**
     * To model doctor model.
     *
     * @param entity the entity
     * @return the doctor model
     */
    public DoctorModel toModel(Doctor entity) {

        return DoctorModel.builder()
                .crm(entity.getCrm())
                .email(entity.getEmail())
                .name(entity.getName())
                .id(entity.getId())
                .speciality(entity.getSpeciality())
                .address(toAddressModel(entity.getAddress()))

                .build();

    }

    /**
     * To address model address model.
     *
     * @param entity the entity
     * @return the address model
     */
    public AddressModel toAddressModel(Address entity) {
        return AddressModel.builder()
                .addressType(entity.getAddressType())
                .neighborhood(entity.getNeighborhood())
                .postalCode(entity.getPostalCode())
                .city(entity.getCity())
                .state(entity.getState())
                .number(entity.getNumber())
                .notes(entity.getNotes())
                .build();
    }
}
