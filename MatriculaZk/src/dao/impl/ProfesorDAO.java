package dao.impl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Modelos.Alumno;
import Modelos.Profesor;
import dao.interfaz.IProfesorDAO;

public class ProfesorDAO  implements IProfesorDAO{

	@Override
	public  Profesor buscar(String id) {
			Profesor profesor =null;
		try{	
		
		Statement  stmt= conexion.createStatement();
		StringBuilder sb= new  StringBuilder("select * from profesor where cedula='"  ).append(id).append("'").append("and estatus= 'A'");
		ResultSet rs =  stmt.executeQuery(sb.toString());
		while(rs.next()){
		    profesor = new Profesor();
			profesor.setCedula(rs.getString(1));
			profesor.setNombre(rs.getString(2));
			profesor.setSexo(rs.getString(3));
			profesor.setEdad(rs.getInt(4));
			
			//alumno.setSeccion(rs.getString(6));
			//alumno.setEstatus(rs.getString(7).toString());
			
		}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		
	return profesor;
			
	}

	@Override
	public void registrar(Object T) throws SQLException {
		Profesor profesor = (Profesor)T;
		if(profesor!= null){
		try{
		String insertTableSQL= "INSERT INTO profesor" +"(cedula, nombre,sexo, edad, seccion, estatus) VALUES" 
		                                            +"(?,?,?,?,?,?)";
		PreparedStatement preparedStatement = conexion.prepareStatement(insertTableSQL);
		preparedStatement.setString(1, profesor.getCedula());
		preparedStatement.setString(2,profesor.getNombre());
		preparedStatement.setString(3, profesor.getSexo());
		preparedStatement.setLong(4, profesor.getEdad());
		preparedStatement.setString(5, null);
		preparedStatement.setString(6, "A");
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
	public void modificar(Object T) {
		
		Profesor profesorUpdate = (Profesor)T;
		if(profesorUpdate!= null){
			try{
			String insertTableSQL = "update profesor set nombre=?, sexo=?, edad=?"
			                       +"where cedula=? and estatus='A'";
			PreparedStatement preparedStatement = conexion.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, profesorUpdate.getNombre());
			preparedStatement.setString(2, profesorUpdate.getSexo());
			preparedStatement.setInt(3, profesorUpdate.getEdad());	
			preparedStatement.setString(4, profesorUpdate.getCedula());
			preparedStatement.executeUpdate();

			}catch(SQLException e){
				
				e.printStackTrace();
				System.out.println("Error al Modificar");
			}
			
			
		}
		
	}

	@Override
	public void eliminar(Object T) {
		Profesor profesorE= (Profesor)T;
		if(profesorE!=null){
			try{
			String insertTableSQL = "update profesor set estatus=?" +"where cedula=? and estatus='A' ";
			PreparedStatement preparedStatement = conexion.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, "I");
			preparedStatement.setString(2, profesorE.getCedula());
			preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("No se elimino el registro");
		}
		System.out.println("Eliminacion exitosa");
	}

	}

	@Override
	public List<Profesor> listar() {
		List<Profesor> listaProfesor = new ArrayList<Profesor>();
		Profesor profesor = new Profesor();
		try {
			Statement stm = conexion.createStatement();
			String selectProfesor = "select * from profesor where estatus ='A'";
			ResultSet rs = stm.executeQuery(selectProfesor);
			while(rs.next()){
			profesor.setCedula(rs.getString(1));
			profesor.setNombre(rs.getString(2));
			listaProfesor.add(profesor);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		// TODO Auto-generated method stub
		return listaProfesor;
	}
	

}
