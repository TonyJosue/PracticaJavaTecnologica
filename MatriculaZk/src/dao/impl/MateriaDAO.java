package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelos.Alumno;
import Modelos.Materia;
import Modelos.Profesor;
import Modelos.Seccion;
import dao.interfaz.IMateriaDao;

public class MateriaDAO implements IMateriaDao {

	@Override
	public Materia buscar(String id) {
		Materia materia =null;
		try{
			
		
		Statement  stmt= conexion.createStatement();
		StringBuilder sb= new  StringBuilder("select * from materia where codigo='"  ).append(id).append("'").append("and estatus= 'A'");
		ResultSet rs =  stmt.executeQuery(sb.toString());
		while(rs.next()){
			materia = new Materia();
			materia.setCodigo(rs.getString(1));
			materia.setNombre(rs.getString(2));
			
			//alumno.setSeccion(rs.getString(6));
			//alumno.setEstatus(rs.getString(7).toString());
			
		}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		
	
		
	return materia;
	}

	@Override
	public void registrar(Object T) throws SQLException {
		Materia materia = (Materia)T;
		if(materia!= null){
		try{
		String insertTableSQL= "INSERT INTO materia" +"(codigo, nombre, estatus) VALUES" 
		                                            +"(?,?,?)";
		PreparedStatement preparedStatement = conexion.prepareStatement(insertTableSQL);
		preparedStatement.setString(1, materia.getCodigo());
		preparedStatement.setString(2,materia.getNombre());
		preparedStatement.setString(3, "A");
		preparedStatement.executeUpdate();
		System.out.println("Operancion   Exitosa");
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("Operancion no Exitosa");
		}
		}else
		
		System.out.println("Operancion no Exitosa");
			
		
	}

	@Override
	public void modificar(Object T) throws SQLException {
		Materia materiaUpdate = (Materia)T;
		if(materiaUpdate!= null){
			try{
			String insertTableSQL = "update materia set nombre=? "
			                       +"where codigo=? and estatus='A'";
			PreparedStatement preparedStatement = conexion.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, materiaUpdate.getNombre());
			preparedStatement.setString(2, materiaUpdate.getCodigo());
			preparedStatement.executeUpdate();

			}catch(SQLException e){
				
				e.printStackTrace();
				System.out.println("Error al Modificar");
			}
			
			
		}
		
		
	}

	@Override
	public void eliminar(Object T) {
		Materia materiaE= (Materia)T;
		if(materiaE!=null){
			try{
			String insertTableSQL = "update materia set estatus=?" +"where codigo=? and estatus='A' ";
			PreparedStatement preparedStatement = conexion.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, "I");
			preparedStatement.setString(2, materiaE.getCodigo());
			preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("No se elimino el registro");
		}
		System.out.println("Eliminacion exitosa");
	}

	}

	@Override
	public List<Materia> listar() {
		
		List<Materia> listaMateria= new ArrayList<Materia> ();
		try {
			Statement stm= conexion.createStatement();
			String selectTableSQL ="select * from materia where estatus= 'A'";
			ResultSet rs = stm.executeQuery(selectTableSQL);
			while(rs.next()){
				Materia materia= new Materia();
				materia.setCodigo(rs.getString(1));
				materia.setNombre(rs.getString(2));	
				listaMateria.add(materia);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaMateria;
	


	}
		
	}


