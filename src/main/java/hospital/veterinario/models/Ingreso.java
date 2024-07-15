package hospital.veterinario.models;

import jakarta.persistence.*;
import java.time.LocalDate;
import hospital.veterinario.utils.EstadoIngreso;

@Entity
public class Ingreso {

    public Ingreso(Long id, LocalDate fechaAltaIngreso, LocalDate fechaFinalizacionIngreso, EstadoIngreso estado,
			Mascota mascota, Persona personaRegistra) {
		super();
		this.id = id;
		this.fechaAltaIngreso = fechaAltaIngreso;
		this.fechaFinalizacionIngreso = fechaFinalizacionIngreso;
		this.estado = estado;
		this.mascota = mascota;
		this.personaRegistra = personaRegistra;
	}

	public Ingreso() {
		// TODO Auto-generated constructor stub
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate fechaAltaIngreso;
    private LocalDate fechaFinalizacionIngreso;

    @Enumerated(EnumType.STRING)
    private EstadoIngreso estado;

    @ManyToOne
    @JoinColumn(name = "mascota_id")
    private Mascota mascota;

    @ManyToOne
    @JoinColumn(name = "persona_id")
    private Persona personaRegistra;

    @PrePersist
    @PreUpdate
    public void validate() {
        if (estado == EstadoIngreso.FINALIZADO && fechaFinalizacionIngreso == null) {
            throw new IllegalStateException("No se puede finalizar un ingreso sin una fecha de fin.");
        }
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LocalDate getFechaAltaIngreso() {
		return fechaAltaIngreso;
	}

	public void setFechaAltaIngreso(LocalDate fechaAltaIngreso) {
		this.fechaAltaIngreso = fechaAltaIngreso;
	}

	public LocalDate getFechaFinalizacionIngreso() {
		return fechaFinalizacionIngreso;
	}

	public void setFechaFinalizacionIngreso(LocalDate fechaFinalizacionIngreso) {
		this.fechaFinalizacionIngreso = fechaFinalizacionIngreso;
	}

	public EstadoIngreso getEstado() {
		return estado;
	}

	public void setEstado(EstadoIngreso estado) {
		this.estado = estado;
	}

	public Mascota getMascota() {
		return mascota;
	}

	public void setMascota(Mascota mascota) {
		this.mascota = mascota;
	}

	public Persona getPersonaRegistra() {
		return personaRegistra;
	}

	public void setPersonaRegistra(Persona personaRegistra) {
		this.personaRegistra = personaRegistra;
	}
}
