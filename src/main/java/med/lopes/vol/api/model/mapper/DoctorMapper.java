package med.lopes.vol.api.model.mapper;

import lombok.RequiredArgsConstructor;
import med.lopes.vol.api.domain.entities.Doctor;
import med.lopes.vol.api.model.DoctorModel;
import med.lopes.vol.api.model.input.DoctorInput;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 * The type Doctor mapper.
 */
@RequiredArgsConstructor
@Component
public class DoctorMapper {

    private final AddressMapper addressMapper;

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
                .address(addressMapper.toEntity(input.address()))
                .build();
    }

    /**
     * To model a doctor model.
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
                .address(addressMapper.toModel(entity.getAddress()))

                .build();

    }

    /**
     * To page.
     *
     * @param page the page
     * @return the page
     */
    public Page<DoctorModel> toPage(Page<Doctor> page) {
        return page.map(this::toModel);
    }
}
