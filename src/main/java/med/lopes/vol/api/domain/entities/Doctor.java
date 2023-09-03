package med.lopes.vol.api.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import med.lopes.vol.api.domain.enums.Speciality;
import med.lopes.vol.api.model.input.DoctorInput;

/**
 * The type Doctor.
 */
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@Table(name = "doctor")
@Entity(name = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    @Embedded
    private Address address;

    /**
     * Instantiates a new Doctor.
     *
     * @param input the input
     */
    public Doctor(DoctorInput input) {
        this.crm = input.crm();
        this.email = input.email();
        this.name = input.name();
        this.speciality = input.speciality();
        this.address = new Address(input.address());
    }
}
