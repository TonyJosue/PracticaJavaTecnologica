package ModeloDaoInterfazGenerico;

import java.sql.Connection;

import contexto.ConexionBD;


public interface IConexionDAO {
	public static final String NOMBREDB="matricula";
	 public static final String UBICACIONDB="127.0.0.1";
	 public static final String PUERTODB="5432";
	 public static final String USUARIODB="postgres";
	 public static final String ClAVEDB="123456";
	 static final Connection  conexion= ConexionBD.GenericaDb(UBICACIONDB, NOMBREDB, USUARIODB,ClAVEDB);
}
