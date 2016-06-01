package dao.impl;

import java.lang.reflect.Array;
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
import dao.interfaz.ISeccionDao;

public class SeccionDAO implements ISeccionDao {

	@Override
	public Seccion buscar(String id) {
		Seccion seccion =null;
		try{
			
		
		Statement  stmt= conexion.createStatement();
		StringBuilder sb= new  StringBuilder("select * from seccion where codigo='"  ).append(id).append("'").append("and estatus= 'A'");
		ResultSet rs =  stmt.executeQuery(sb.toString());
		while(rs.next()){
			seccion = new Seccion();
			MateriaDAO materiaDao= new MateriaDAO();
			ProfesorDAO profesorDao= new ProfesorDAO();
			seccion.setCodigo(rs.getString(1));
			Materia materia=materiaDao.buscar(rs.getString(2));
			if(materia!=null)
			seccion.setMateria(materia);
			Profesor profesor = profesorDao.buscar(rs.getString(3));
			seccion.setProfesor(profesor);
			
			//alumno.setSeccion(rs.getString(6));
			//alumno.setEstatus(rs.getString(7).toString());
			
		}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
		
	
		
	return seccion;
	}

	@Override
	public void registrar(Object T) throws SQLException {
		Seccion seccion = (Seccion)T;
		Materia materia = new Materia();
		String materiaa = null;
		if(materia!=null){
			materiaa= materia.getCodigo();
		}
		if(seccion!= null){
		try{
		String insertTableSQL= "INSERT INTO seccion" +"(codigo, materia, profesor, estatus) VALUES" 
		                                            +"(?,?,?,?)";
		PreparedStatement preparedStatement = conexion.prepareStatement(insertTableSQL);
		preparedStatement.setString(1, seccion.getCodigo());
		
		preparedStatement.setString(2,materiaa );
		preparedStatement.setString(3, null);
		preparedStatement.setString(4, "A");
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
		
		
	}

	@Override
	public void eliminar(Object T) {
		// TODO Auto-generated method stub
		Seccion seccionE= (Seccion)T;
		if(seccionE!=null){
			try{
			String insertTableSQL = "update seccion set estatus=?" +"where codigo=? and estatus='A'";
			PreparedStatement preparedStatement = conexion.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, "I");
			preparedStatement.setString(2, seccionE.getCodigo());
			preparedStatement.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
			System.out.println("No se elimino el registro");
		}
		System.out.println("Eliminacion exitosa");
	}

	}

	@Override
	public List<Seccion> listar() {
		
		List<Seccion> listaSeccion= new ArrayList<Seccion> ();
		MateriaDAO materiadao= new MateriaDAO();
		ProfesorDAO profesordao= new ProfesorDAO();
	
		try {
			Statement stm= conexion.createStatement();
			String selectTableSQL ="select * from seccion where estatus= 'A'";
			ResultSet rs = stm.executeQuery(selectTableSQL);
			while(rs.next()){
				Seccion seccion= new Seccion();
				seccion.setCodigo(rs.getString(1));
				Materia materia= materiadao.buscar(rs.getString(2));
				if(materia!=null){
				seccion.setMateria(materia);
				}
				
				Profesor profesor = profesordao.buscar(rs.getString(3));
				if(profesor!=null){
				seccion.setProfesor(profesor);
				}
				listaSeccion.add(seccion);
				
			}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return listaSeccion;
	


	}

	@Override
	public Seccion buscarSeccionSinMateria(String id) {
		Seccion seccion =null;
		try{
			
		
		Statement  stmt= conexion.createStatement();
		StringBuilder sb= new  StringBuilder("select * from seccion where codigo='"  ).append(id).append("'").append("and estatus= 'A' ");
		ResultSet rs =  stmt.executeQuery(sb.toString());
		while(rs.next()){
			seccion = new Seccion();
			MateriaDAO materiaDao= new MateriaDAO();
			ProfesorDAO profesorDao= new ProfesorDAO();
			seccion.setCodigo(rs.getString(1));
			Materia materia=materiaDao.buscar(rs.getString(2));
			seccion.setMateria(materia);
			Profesor profesor = profesorDao.buscar(rs.getString(3));
			seccion.setProfesor(profesor);
			
			//alumno.setSeccion(rs.getString(6));
			//alumno.setEstatus(rs.getString(7).toString());
			
		}
		}catch(SQLException e){
			e.printStackTrace();
			
		}
	
		
	
		
	return seccion;

	}

	@Override
	public void modificarE(Seccion seccion, String materia, String profesor) {
		
		Seccion seccionUpdate = new Seccion();
		
		if(seccionUpdate!= null){
			try{
			String insertTableSQL ="update seccion set materia=?, profesor=? where codigo=? and estatus= 'A'";
			PreparedStatement preparedStatement = conexion.prepareStatement(insertTableSQL);
			preparedStatement.setString(1, materia);
			preparedStatement.setString(2, profesor);
			preparedStatement.setString(3, seccion.getCodigo());
			
			preparedStatement.executeUpdate();

			}catch(SQLException e){
				
				e.printStackTrace();
				System.out.println("Error al Modificar");
			}
			
			
		}
		System.out.println("Actulizacion Exitosa");
	
		
		
	}
}


