package med.lopes.vol.api.domain.repository;

import med.lopes.vol.api.domain.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The interface Patient repository.
 */
public interface PatientRepository extends JpaRepository<Patient, Long> {

    /**
     * Find by active true optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<Patient> findByIdAndActiveTrue(Long id);

    /**
     * Find by active true page.
     *
     * @param pageable the pageable
     * @return the page
     */
    Page<Patient> findByActiveTrue(Pageable pageable);
}
