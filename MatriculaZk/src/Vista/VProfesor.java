package Vista;

import java.util.Scanner;

import controlador.ControladorAlumno;
import controlador.ControladorProfesor;

public class VProfesor {
	
	static Scanner sc = new Scanner(System.in);
	public static void imprimirMenuProfesor(){
		
         
        
		System.out.println(new StringBuilder("================================ MATRICULA ============================="));
		System.out.println(new StringBuilder("=== 1.-Buscar Profesor==============="));
		System.out.println(new StringBuilder("=== 2.-Registrar Profesor============="));
    	System.out.println(new StringBuilder("=== 3.-Modificar Profesor=============="));
    	System.out.println(new StringBuilder("=== 4.-Eliminar Profesor=============="));
    	System.out.println(new StringBuilder("Por Favor Seleccione una opcion"));
    	String resp = sc.next();
    	switch (resp) {
		case "1": 
			ControladorProfesor.buscarProfesor();
			String valor="";
			 System.out.println("Si Desea Buscar Otro Alumno marque (1) sino marque (2)");
			 valor= sc.next();
			 if(valor.equals("1")){
				ControladorProfesor.buscarProfesor();
				
			 }else
			 VProfesor.imprimirMenuProfesor();
			break;
		case "2":
			ControladorProfesor.registrarProfesor();
			break;
		case "3":
			ControladorProfesor.modificarProfesor();
			
			break;
		case "4":
			ControladorProfesor.eliminarProfesor();
			break;
			
		
		}
 }


}
