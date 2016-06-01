package Modelos;

import java.util.List;

public class Seccion {
	
	private String codigo;
	private Materia materia;
	private Profesor profesor;
	private List<Alumno> listaA;
	private char estatus;
	
	public Seccion() {
		super();
	}
	
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public Materia getMateria() {
		return materia;
	}
	public void setMateria(Materia materia) {
		this.materia = materia;
	}
	public List<Alumno> getListaA() {
		return listaA;
	}
	public void setListaA(List<Alumno> listaA) {
		this.listaA = listaA;
	}

	public Profesor getProfesor() {
		return profesor;
	}

	public void setProfesor(Profesor profesor) {
		this.profesor = profesor;
	}

	public char getEstatus() {
		return estatus;
	}

	public void setEstatus(char estatus) {
		this.estatus = estatus;
	}
	
	
	
	
	
	

}
