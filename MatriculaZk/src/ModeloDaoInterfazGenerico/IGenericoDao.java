package ModeloDaoInterfazGenerico;

import java.sql.SQLException;
import java.util.List;

public interface IGenericoDao <T extends Object> extends IConexionDAO {
	
	public T buscar(String id);
	public void registrar(Object T) throws SQLException;
	public void modificar(Object T)  throws SQLException;
	public void eliminar(Object T);
	public List<T> listar();

}
