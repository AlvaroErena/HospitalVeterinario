package hospital.veterinario.models;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Persona {

    public Persona(Long id, String nombre, String dni, List<Mascota> mascotas) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dni = dni;
		this.mascotas = mascotas;
	}

	public Persona() {
		// TODO Auto-generated constructor stub
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;
    private String dni;

    @OneToMany(mappedBy = "responsable")
    private List<Mascota> mascotas;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public List<Mascota> getMascotas() {
		return mascotas;
	}

	public void setMascotas(List<Mascota> mascotas) {
		this.mascotas = mascotas;
	}
    
}
