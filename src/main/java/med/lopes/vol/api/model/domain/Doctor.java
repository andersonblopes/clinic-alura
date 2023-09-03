package med.lopes.vol.api.model.domain;

import jakarta.persistence.*;
import lombok.*;
import med.lopes.vol.api.model.enums.Speciality;

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

    /**
     * The Id.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * The Name.
     */
    private String name;
    /**
     * The Email.
     */
    private String email;
    /**
     * The Cns.
     */
    private String cns;

    /**
     * The Speciality.
     */
    @Enumerated(EnumType.STRING)
    private Speciality speciality;

    /**
     * The Address.
     */
    @Embedded
    private Address address;
}
