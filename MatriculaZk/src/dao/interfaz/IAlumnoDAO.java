package dao.interfaz;

import java.util.List;

import ModeloDaoInterfazGenerico.IGenericoDao;
import Modelos.Alumno;

public interface IAlumnoDAO extends IGenericoDao<Alumno> {
	
	public List<Alumno> listaAlumnoNoInscrito();
	public void inscribirAlumno(Alumno alumno, String seccion);
	

}
