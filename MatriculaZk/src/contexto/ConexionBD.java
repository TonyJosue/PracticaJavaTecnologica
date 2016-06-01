package contexto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionBD {

	public static String driver;
	public static String url;
	public static String ip;
	public static String bd;
	public static String usr;
	public static String pass;
	public static Connection conexion;
	@SuppressWarnings("unused")
	private String conf_logs;

	ConexionBD() {
		
	}

	public static Connection GenericaDb(String ipx, String bdx, String usrx, String passx){
		if(conexion==null){
		driver = "org.postgresql.Driver";

		bd = bdx;
		usr = usrx;
		pass = passx;
		url = "jdbc:postgresql://"+ipx+"/"+bdx;

		try{
			Class.forName(driver).newInstance();
			conexion = (Connection) DriverManager.getConnection(url,usr,pass);
			System.out.println("Conexion EXITOSA a Base de Datos '" +bd+ "'.");
		}
		catch (Exception exc){
			System.out.println("Conexion FALLIDA a Base de Datos '" +bd+ "'. Error: " + exc);
		}
		}
		return conexion;
	}

	public Connection getConexion(){
		return conexion;
	}

	public Connection CerrarConexion() throws SQLException{
		conexion.close(); conexion = null;
		return conexion;
	}
}
