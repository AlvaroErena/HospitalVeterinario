package hospital.veterinario.repositories;

import hospital.veterinario.models.Ingreso;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IngresoRepository extends JpaRepository<Ingreso, Long> {
    List<Ingreso> findByMascotaId(Long mascotaId);
}