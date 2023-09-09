package med.lopes.vol.api.domain.repository;

import med.lopes.vol.api.domain.entities.Doctor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * The interface Doctor repository.
 */
public interface DoctorRepository extends JpaRepository<Doctor, Long> {

    /**
     * Find by id and active true optional.
     *
     * @param id the id
     * @return the optional
     */
    Optional<Doctor> findByIdAndActiveTrue(Long id);

    /**
     * Find by active true page.
     *
     * @param pageable the pageable
     * @return the page
     */
    Page<Doctor> findByActiveTrue(Pageable pageable);
}
