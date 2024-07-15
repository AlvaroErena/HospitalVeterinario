package hospital.veterinario.apirest;

import hospital.veterinario.models.Ingreso;
import hospital.veterinario.services.IngresoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/ingreso")
public class IngresoController {

    private final IngresoService ingresoService;

    @Autowired
    public IngresoController(IngresoService ingresoService) {
        this.ingresoService = ingresoService;
    }

    @GetMapping
    public List<Ingreso> getAllIngresos() {
        return ingresoService.getAllIngresos();
    }

    @GetMapping("/{id}")
    public Ingreso getIngresoById(@PathVariable Long id) {
        return ingresoService.getIngresoById(id);
    }

    @PostMapping
    public Ingreso createIngreso(@RequestParam Long mascotaId, @RequestParam LocalDate fechaAltaIngreso) {
        return ingresoService.createIngreso(mascotaId, fechaAltaIngreso);
    }

    @PutMapping("/{id}")
    public Ingreso updateIngreso(@PathVariable Long id, @RequestParam Long mascotaId, @RequestBody Ingreso updatedIngreso) {
        return ingresoService.updateIngreso(id, mascotaId, updatedIngreso);
    }

    @DeleteMapping("/{id}")
    public void deleteIngreso(@PathVariable Long id) {
        ingresoService.deleteIngreso(id);
    }
}