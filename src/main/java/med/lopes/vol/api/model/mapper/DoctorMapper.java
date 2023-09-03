package med.lopes.vol.api.model.mapper;

import med.lopes.vol.api.domain.entities.Address;
import med.lopes.vol.api.domain.entities.Doctor;
import med.lopes.vol.api.model.AddressModel;
import med.lopes.vol.api.model.DoctorModel;
import med.lopes.vol.api.model.input.AddressInput;
import med.lopes.vol.api.model.input.DoctorInput;
import org.springframework.stereotype.Component;

/**
 * The type Doctor mapper.
 */
@Component
public class DoctorMapper {

    /**
     * To entity doctor.
     *
     * @param input the input
     * @return the doctor
     */
    public Doctor toEntity(DoctorInput input) {

        return Doctor.builder()
                .crm(input.crm())
                .email(input.email())
                .name(input.name())
                .phone(input.phone())
                .specialty(input.speciality())
                .address(toEntity(input.address()))
                .build();
    }


    /**
     * To entity address.
     *
     * @param input the input
     * @return the address
     */
    public Address toEntity(AddressInput input) {
        return Address.builder()
                .addressType(input.addressType())
                .neighborhood(input.neighborhood())
                .postalCode(input.postalCode())
                .city(input.city())
                .state(input.state())
                .number(input.number())
                .notes(input.notes())
                .build();
    }

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
                .phone(entity.getPhone())
                .id(entity.getId())
                .speciality(entity.getSpecialty())
                .address(toAddressModel(entity.getAddress()))

                .build();

    }

    /**
     * To address model.
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
