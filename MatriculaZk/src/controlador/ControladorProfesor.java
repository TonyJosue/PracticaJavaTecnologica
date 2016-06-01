package controlador;

import java.sql.SQLException;
import java.util.Scanner;

import Modelos.Alumno;
import Modelos.Materia;
import Modelos.Profesor;
import Vista.VAlumno;
import Vista.VProfesor;
import Vista.Vmatricula;
import dao.impl.ProfesorDAO;

public class ControladorProfesor {
	static Scanner sc = new Scanner(System.in);
	static ProfesorDAO profesordao= new ProfesorDAO();
	
	public static void registrarProfesor(){
		System.out.println("===================Registar Profesor============================");
		String resp= "";
		do{
			System.out.println("Ingrese Cedula");
			String cedula= sc.next();
			System.out.println("Ingrese Nombre");
			String nombre = sc.next();
			System.out.println("Ingrese Sexo");
			String sexo =sc.next();
			System.out.println("Ingrese Edad");
			int edad= sc.nextInt();
			Profesor profesor= new Profesor();
			profesor.setCedula(cedula);
			profesor.setNombre(nombre);
			profesor.setSexo(sexo);
			profesor.setEdad(edad);
			try {
				if(validarProfesor(profesor)==true){
				profesordao.registrar(profesor);
				}
				else{
					System.out.println("Datos no correctos, por favor ingresar nuevamente los mismos");
					registrarProfesor();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.println("Desea Registrar otro Alumno, presiones S si es Si o N para regredar al menu ");
		}while(resp.toUpperCase().equals("S"));
		
		Vmatricula.imprimirMenuMatricula();

		
	}
	public static Profesor buscarProfesor(){
		
		System.out.println(new StringBuilder("Ingrese la cedula del profesor "));
		String cedula = sc.next();
		Profesor profesor = profesordao.buscar(cedula);
	
		System.out.println(new StringBuilder("Cedula:   ").append(profesor.getCedula()));
		System.out.println(new StringBuilder("Nombre:   ").append(profesor.getNombre()));
		System.out.println(new StringBuilder("Sexo:    ").append(profesor.getSexo()));
		System.out.println(new StringBuilder("Edad:     ").append(profesor.getEdad()));
		System.out.println(new StringBuilder("Seccion:    ").append(profesor.getSeccion()));
	
		 
		 
	 return  profesor;

	}
	
	
	public static void modificarProfesor(){
		   Profesor profesorm =buscarProfesor();	    
		    System.out.println("Ingrese los datos que desea modificar");
	    	System.out.println("Ingrese Nombre");
			String nombre = sc.next();
			System.out.println("Ingrese Sexo");
			String sexos =sc.next();
			System.out.println("Ingrese Edad");
			int edads= sc.nextInt();
			profesorm.setNombre(nombre);
			profesorm.setSexo(sexos);
			profesorm.setEdad(edads);
			profesordao.modificar(profesorm);
			System.out.println("Modificacion Exitosa");
	
		
	}
	
	public static void eliminarProfesor(){
		Profesor profesorE= buscarProfesor();
		profesordao.eliminar(profesorE);
			
	}
	
	public static boolean validarProfesor(Profesor profesorv){
		if(profesorv.getCedula() instanceof String){
			return true;
		}if(profesorv.getNombre() instanceof String){
			return true;
		}if(profesorv.getSeccion().getCodigo() instanceof String){
			return true;
		}if(profesorv.getSexo() instanceof String){
			return true;
		}if(profesorv.getEdad() instanceof Integer){
			return true;
		}else{

		return false;

	}
	}
	
	
	
}

