package hospital.veterinario.config;

import hospital.veterinario.models.Ingreso;
import hospital.veterinario.models.Mascota;
import hospital.veterinario.models.Persona;
import hospital.veterinario.repositories.IngresoRepository;
import hospital.veterinario.repositories.MascotaRepository;
import hospital.veterinario.repositories.PersonaRepository;
import hospital.veterinario.utils.EstadoIngreso;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;

@Configuration
public class DataInitializer {

    @Autowired
    private PersonaRepository personaRepository;

    @Autowired
    private MascotaRepository mascotaRepository;

    @Autowired
    private IngresoRepository ingresoRepository;

    @Bean
    public CommandLineRunner loadData() {
        return args -> {
            // Crear personas
            Persona persona = new Persona();
            persona.setNombre("Pablo Perez");
            persona.setDni("11115678A");
            personaRepository.save(persona);
            
            // Crear personas
            Persona persona1 = new Persona();
            persona1.setNombre("Juan Perez");
            persona1.setDni("22225678B");
            personaRepository.save(persona1);
            
            // Crear personas
            Persona persona2 = new Persona();
            persona2.setNombre("Alberto Perez");
            persona2.setDni("33335678C");
            personaRepository.save(persona2);
            
            // Crear personas
            Persona persona3 = new Persona();
            persona3.setNombre("Antonio Perez");
            persona3.setDni("44445678D");
            personaRepository.save(persona3);

            // Crear mascotas
            Mascota mascota = new Mascota();
            mascota.setEspecie("Perro");
            mascota.setRaza("Labrador");
            mascota.setEdad(3);
            mascota.setCodigoIdentificacion("AAA123");
            mascota.setResponsable(persona);
            mascotaRepository.save(mascota);
            
            // Crear mascotas
            Mascota mascota1 = new Mascota();
            mascota1.setEspecie("Perro");
            mascota1.setRaza("Caniche");
            mascota1.setEdad(3);
            mascota1.setCodigoIdentificacion("BBB123");
            mascota1.setResponsable(persona1);
            mascotaRepository.save(mascota1);
            
            // Crear mascotas
            Mascota mascota2 = new Mascota();
            mascota2.setEspecie("Perro");
            mascota2.setRaza("Pitbull");
            mascota2.setEdad(3);
            mascota2.setCodigoIdentificacion("CCC123");
            mascota2.setResponsable(persona2);
            mascotaRepository.save(mascota2);
            
            // Crear mascotas
            Mascota mascota3 = new Mascota();
            mascota3.setEspecie("Perro");
            mascota3.setRaza("Shiba");
            mascota3.setEdad(3);
            mascota3.setCodigoIdentificacion("DDD123");
            mascota3.setResponsable(persona3);
            mascotaRepository.save(mascota3);

            // Crear ingresos
            Ingreso ingreso = new Ingreso();
            ingreso.setFechaAltaIngreso(LocalDate.of(2023, 1, 1));
            ingreso.setFechaFinalizacionIngreso(LocalDate.of(2023, 1, 10));
            ingreso.setEstado(EstadoIngreso.FINALIZADO);
            ingreso.setMascota(mascota3);
            ingreso.setPersonaRegistra(persona3);
            ingresoRepository.save(ingreso);
        };
    }
}
