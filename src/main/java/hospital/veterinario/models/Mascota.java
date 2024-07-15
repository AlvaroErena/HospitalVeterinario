package hospital.veterinario.models;

import jakarta.persistence.*;

@Entity
public class Mascota {

    public Mascota(Long id, String especie, String raza, int edad, String codigoIdentificacion, Persona responsable) {
		super();
		this.id = id;
		this.especie = especie;
		this.raza = raza;
		this.edad = edad;
		this.codigoIdentificacion = codigoIdentificacion;
		this.responsable = responsable;
		this.activa = true;
	}

	public Mascota() {
		// TODO Auto-generated constructor stub
	}

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String especie;
    private String raza;
    private int edad;
    private String codigoIdentificacion;

    @ManyToOne
    @JoinColumn(name = "responsable_id")
    private Persona responsable;
	
	private boolean activa = true; // nuevo campo para el estado

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getEspecie() {
		return especie;
	}

	public void setEspecie(String especie) {
		this.especie = especie;
	}

	public String getRaza() {
		return raza;
	}

	public void setRaza(String raza) {
		this.raza = raza;
	}

	public int getEdad() {
		return edad;
	}

	public void setEdad(int edad) {
		this.edad = edad;
	}

	public String getCodigoIdentificacion() {
		return codigoIdentificacion;
	}

	public void setCodigoIdentificacion(String codigoIdentificacion) {
		this.codigoIdentificacion = codigoIdentificacion;
	}

	public Persona getResponsable() {
		return responsable;
	}

	public void setResponsable(Persona responsable) {
		this.responsable = responsable;
	}
	
	public boolean isActiva() {
		return activa;
	}

	public void setActiva(boolean activa) {
		this.activa = activa;
	}
}
