package hospital.veterinario.services;

import hospital.veterinario.models.Ingreso;
import hospital.veterinario.models.Mascota;
import hospital.veterinario.repositories.IngresoRepository;
import hospital.veterinario.repositories.MascotaRepository;
import hospital.veterinario.utils.EstadoIngreso;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class IngresoService {

    private final IngresoRepository ingresoRepository;
    private final MascotaRepository mascotaRepository;

    @Autowired
    public IngresoService(IngresoRepository ingresoRepository, MascotaRepository mascotaRepository) {
        this.ingresoRepository = ingresoRepository;
        this.mascotaRepository = mascotaRepository;
    }

    public List<Ingreso> getAllIngresos() {
        return ingresoRepository.findAll();
    }

    public Ingreso getIngresoById(Long id) {
        return ingresoRepository.findById(id).orElse(null);
    }

    public Ingreso saveIngreso(Ingreso ingreso) {
        return ingresoRepository.save(ingreso);
    }

    public Ingreso createIngreso(Long mascotaId, LocalDate fechaAltaIngreso) {
        Optional<Mascota> mascotaOpt = mascotaRepository.findById(mascotaId);
        if (mascotaOpt.isPresent() && mascotaOpt.get().isActiva()) {
            Mascota mascota = mascotaOpt.get();
            Ingreso ingreso = new Ingreso();
            ingreso.setFechaAltaIngreso(fechaAltaIngreso);
            ingreso.setEstado(EstadoIngreso.ALTA);
            ingreso.setMascota(mascota);
            return ingresoRepository.save(ingreso);
        }
        return null;
    }

    public Ingreso updateIngreso(Long ingresoId, Long mascotaId, Ingreso updatedIngreso) {
        Optional<Ingreso> ingresoOpt = ingresoRepository.findById(ingresoId);
        Optional<Mascota> mascotaOpt = mascotaRepository.findById(mascotaId);

        if (ingresoOpt.isPresent() && mascotaOpt.isPresent() && mascotaOpt.get().isActiva()) {
            Ingreso ingreso = ingresoOpt.get();
            ingreso.setFechaAltaIngreso(updatedIngreso.getFechaAltaIngreso());
            ingreso.setFechaFinalizacionIngreso(updatedIngreso.getFechaFinalizacionIngreso());
            ingreso.setEstado(updatedIngreso.getEstado());
            ingreso.setMascota(mascotaOpt.get());
            return ingresoRepository.save(ingreso);
        }
        return null;
    }

    public void deleteIngreso(Long id) {
        Optional<Ingreso> ingresoOpt = ingresoRepository.findById(id);
        if (ingresoOpt.isPresent()) {
            Ingreso ingreso = ingresoOpt.get();
            ingreso.setEstado(EstadoIngreso.ANULADO);
            ingresoRepository.save(ingreso);
        }
    }

    public List<Ingreso> getIngresosByMascotaId(Long mascotaId) {
        Optional<Mascota> mascotaOpt = mascotaRepository.findById(mascotaId);
        if (mascotaOpt.isPresent() && mascotaOpt.get().isActiva()) {
            return ingresoRepository.findByMascotaId(mascotaId);
        }
        return List.of();
    }
}
