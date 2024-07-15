package hospital.veterinario.repositories;

import hospital.veterinario.models.Mascota;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface MascotaRepository extends JpaRepository<Mascota, Long> {
}
