package dao.interfaz;

import ModeloDaoInterfazGenerico.IGenericoDao;
import Modelos.Seccion;

public interface ISeccionDao extends IGenericoDao<Seccion> {
	
	public  Seccion buscarSeccionSinMateria (String id);
	public void modificarE(Seccion seccion, String materia, String profesor);
	

		
	
	


}
