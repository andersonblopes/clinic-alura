package med.lopes.vol.api.domain.repository;

import med.lopes.vol.api.domain.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The interface Patient repository.
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {
}
