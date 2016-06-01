package Modelos;

public class Profesor extends Persona {
	
	private String cedula;
	private Seccion seccion;
	
	public Profesor() {
		super();
	}
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	public Seccion getSeccion() {
		return seccion;
	}
	public void setSeccion(Seccion seccion) {
		this.seccion = seccion;
	}
	
	
	
	

}
