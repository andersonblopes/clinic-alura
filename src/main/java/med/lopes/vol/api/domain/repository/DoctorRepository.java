package med.lopes.vol.api.domain.repository;

import med.lopes.vol.api.domain.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Doctor repository.
 */
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
