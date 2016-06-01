package dao.impl;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.xml.transform.Result;

import Modelos.Alumno;
import Modelos.Materia;
import Modelos.Profesor;
import Modelos.Seccion;
import dao.interfaz.IAlumnoDAO;


public class AlumnoDAO implements IAlumnoDAO
{

	public AlumnoDAO(){
    	
    }

	@Override
	public Alumno buscar(String id) {
		Alumno alumno =null;
		try{
			
		
		Statement  stmt= conexion.createStatement();
		StringBuilder sb= new  StringBuilder("select * from alumno where cedula='"  ).append(id).append("'").append("and estatus= 'A'");
		ResultSet rs =  stmt.executeQuery(sb.toString());
		while(rs.next()){
			 alumno = new Alumno();
			alumno.setCedula(rs.getString(1));
			alumno.setNombre(rs.getString(2));
			alumno.setSexo(rs.getString(3));
			alumno.setEdad(rs.getInt(4));
			alumno.setGrado(rs.getString(5));
			//alumno.setSeccion(rs.getString(6));
			//alumno.setEstatus(rs.getString(7).toString());
			
		}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		
	
		
	return alumno;
	}

	@Override
	public void registrar(Object T) throws SQLException {
		Alumno alumno = (Alumno)T;
		if(alumno!= null){
		try{
		String insertTableSQL= "INSERT INTO alumno" +"(cedula, nombre,sexo, edad, grado, seccion, estatus) VALUES" 
		                                            +"(?,?,?,?,?,?,?)";
		PreparedStatement preparedStatement = conexion.prepareStatement(insertTableSQL);
		preparedStatement.setString(1, alumno.getCedula());
		preparedStatement.setString(2, alumno.getNombre());
		preparedStatement.setString(3, alumno.getSexo());
		preparedStatement.setLong(4, alumno.getEdad());
		preparedStatement.setString(5, alumno.getGrado());
		preparedStatement.setString(6, null);
		preparedStatement.setString(7, "A");
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
		Alumno alumnoUpdate = (Alumno)T;
		if(alumnoUpdate!= null){
			try{
			String insertTableSQL = "update alumno set nombre=?, sexo=?, edad=?,grado=?"
			                       +"where cedula=? and estatus='A'";
			PreparedStatement preparedStatement = conexion.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, alumnoUpdate.getNombre());
			preparedStatement.setString(2, alumnoUpdate.getSexo());
			preparedStatement.setInt(3, alumnoUpdate.getEdad());
			preparedStatement.setString(4, alumnoUpdate.getGrado());
			preparedStatement.setString(5, alumnoUpdate.getCedula());
			preparedStatement.executeUpdate();

			}catch(SQLException e){
				
				e.printStackTrace();
				System.out.println("Error al Modificar");
			}
			
			
		}
		System.out.println("Actulizacion Exitosa");
	

	}	
		
		
		
	

	@Override
	public void eliminar(Object T) {
		Alumno alumnoE= (Alumno)T;
		if(alumnoE!=null){
			try{
			String insertTableSQL = "update alumno set estatus=?" +"where cedula=? and estatus='A' ";
			PreparedStatement preparedStatement = conexion.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, "I");
			preparedStatement.setString(2, alumnoE.getCedula());
			preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("No se elimino el registro");
		}
		System.out.println("Eliminacion exitosa");
	}

	}

	@Override
	public List<Alumno> listar() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Alumno> listaAlumnoNoInscrito() {

		List<Alumno> listaAlumnoNoIns= new ArrayList<Alumno> ();
	
		try {
			Statement stm= conexion.createStatement();
			String selectTableSQL ="select * from alumno where estatus='A' and seccion= 'null'  ";
			ResultSet rs = stm.executeQuery(selectTableSQL);
			while(rs.next()){
				Alumno alumno= new Alumno();
				alumno.setCedula(rs.getString(1));
				alumno.setNombre(rs.getString(2));
				alumno.setSexo(rs.getString(3));
				alumno.setEdad(rs.getInt(4));
				alumno.setGrado(rs.getString(5));
				listaAlumnoNoIns.add(alumno);

			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaAlumnoNoIns;
	

		
}

	@Override
	public void inscribirAlumno(Alumno alumno,String seccion) {
		Alumno alumnoI= new Alumno();
		if(alumnoI!= null){
			try {
				
				String selectAlumno = "update alumno set seccion=? where cedula=? ";
				PreparedStatement preparedStatement = conexion.prepareStatement(selectAlumno);
				preparedStatement.setString(1, seccion);
				preparedStatement.setString(2, alumno.getCedula());
				preparedStatement.executeUpdate();
				
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
		
	}


}
