package hospital.veterinario.apirest;

import hospital.veterinario.models.Ingreso;
import hospital.veterinario.models.Mascota;
import hospital.veterinario.services.MascotaService;
import hospital.veterinario.services.IngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mascota")
public class MascotaController {

    private final MascotaService mascotaService;
    private final IngresoService ingresoService;

    @Autowired
    public MascotaController(MascotaService mascotaService, IngresoService ingresoService) {
        this.mascotaService = mascotaService;
        this.ingresoService = ingresoService;
    }

    @GetMapping("/{id}")
    public Mascota getMascotaById(@PathVariable Long id) {
        return mascotaService.getMascotaById(id);
    }

    @GetMapping("/{id}/ingreso")
    public List<Ingreso> getIngresosByMascotaId(@PathVariable Long id) {
        return ingresoService.getIngresosByMascotaId(id);
    }

    @PostMapping
    public Mascota createMascota(@RequestBody Mascota mascota) {
        return mascotaService.saveMascota(mascota);
    }

    @DeleteMapping("/{id}")
    public void deleteMascota(@PathVariable Long id) {
        mascotaService.deleteMascota(id);
    }
}
