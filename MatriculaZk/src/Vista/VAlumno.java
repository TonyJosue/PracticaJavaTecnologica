package Vista;

import java.sql.SQLException;
import java.util.Scanner;

import controlador.ControladorAlumno;

public class VAlumno {
	static Scanner sc = new Scanner(System.in);
	public static void imprimirMenuAlumno(){
		
         
        
		System.out.println(new StringBuilder("================================ MATRICULA ============================="));
		System.out.println(new StringBuilder("=== 1.-Buscar Alumno==============="));
		System.out.println(new StringBuilder("=== 2.-Registrar Alumno============="));
    	System.out.println(new StringBuilder("=== 3.-Modificar Alumno=============="));
    	System.out.println(new StringBuilder("=== 4.-Eliminar Alumno=============="));
    	System.out.println(new StringBuilder("Por Favor Seleccione una opcion"));
    	String resp = sc.next();
    	switch (resp) {
		case "1": 
			ControladorAlumno.buscarAlumno();
			break;
		case "2":
			ControladorAlumno.registrarAlumno();
			break;
		case "3":
			ControladorAlumno.modificarAlumno();
			break;
		case "4":
			ControladorAlumno.eliminarAlumno();
			break;
			
		
		}
 }

}
