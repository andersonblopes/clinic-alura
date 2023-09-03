package med.lopes.vol.api.model.domain.repository;

import med.lopes.vol.api.model.domain.entities.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Doctor repository.
 */
public interface DoctorRepository extends JpaRepository<Doctor, Long> {
}
