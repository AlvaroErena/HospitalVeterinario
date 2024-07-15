package hospital.veterinario.services;

import hospital.veterinario.models.Mascota;
import hospital.veterinario.repositories.MascotaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MascotaService {

    private final MascotaRepository mascotaRepository;

    @Autowired
    public MascotaService(MascotaRepository mascotaRepository) {
        this.mascotaRepository = mascotaRepository;
    }

    public List<Mascota> getAllMascotas() {
        return mascotaRepository.findAll();
    }

    public Mascota getMascotaById(Long id) {
        return mascotaRepository.findById(id).orElse(null);
    }

    public Mascota saveMascota(Mascota mascota) {
        return mascotaRepository.save(mascota);
    }

    public void deleteMascota(Long id) {
        Mascota mascota = getMascotaById(id);
        if (mascota != null) {
        	
        	// Cambia el estado a "desactivada"
            mascota.setActiva(false);
            mascotaRepository.save(mascota);
        }
    }
}
