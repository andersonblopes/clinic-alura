package med.lopes.vol.api.domain.entities;

import jakarta.persistence.*;
import lombok.*;
import med.lopes.vol.api.domain.enums.Speciality;

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

    @Column(name = "name")
    private String name;

    @Column(name = "email")
    private String email;

    @Column(name = "crm")
    private String crm;

    @Column(name = "phone")
    private String phone;

    @Enumerated(EnumType.STRING)
    @Column(name = "specialty")
    private Speciality specialty;

    @Embedded
    private Address address;
}
