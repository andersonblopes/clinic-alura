package med.lopes.clinic.center.api.model.mapper;

import lombok.RequiredArgsConstructor;
import med.lopes.clinic.center.api.domain.entities.Patient;
import med.lopes.clinic.center.api.model.PatientModel;
import med.lopes.clinic.center.api.model.input.PatientInput;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

/**
 * The type Patient mapper.
 */
@RequiredArgsConstructor
@Component
public class PatientMapper {

    private final AddressMapper addressMapper;

    /**
     * To entity patient.
     *
     * @param input the input
     * @return the patient
     */
    public Patient toEntity(PatientInput input) {

        return Patient.builder()
                .cpf(input.cpf())
                .email(input.email())
                .name(input.name())
                .phone(input.phone())
                .address(addressMapper.toEntity(input.address()))
                .build();
    }


    /**
     * To model patient model.
     *
     * @param entity the entity
     * @return the patient model
     */
    public PatientModel toModel(Patient entity) {

        return PatientModel.builder()
                .cpf(entity.getCpf())
                .email(entity.getEmail())
                .name(entity.getName())
                .phone(entity.getPhone())
                .id(entity.getId())
                .address(addressMapper.toModel(entity.getAddress()))

                .build();

    }

    /**
     * To page page.
     *
     * @param page the page
     * @return the page
     */
    public Page<PatientModel> toPage(Page<Patient> page) {
        return page.map(this::toModel);
    }
}
