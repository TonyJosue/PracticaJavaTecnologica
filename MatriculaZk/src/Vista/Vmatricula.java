package Vista;

import java.awt.Menu;
import java.io.InputStream;
import java.util.Scanner;

import controlador.ControladorAlumno;
import controlador.ControladorConsultarMateria;
import controlador.ControladorMateria;
import controlador.ControladorMatricula;




public class Vmatricula {
	 static Scanner sc = new Scanner(System.in);
	 
	public static void imprimirMenuMatricula(){
        
		System.out.println(new StringBuilder("================================ MATRICULA ============================="));
		System.out.println(new StringBuilder("=== 1.-Gestionar Alumno==============="));
		System.out.println(new StringBuilder("=== 2.-Gestionar Profesor============="));
    	System.out.println(new StringBuilder("=== 3.-Gestionar Seccion=============="));
    	System.out.println(new StringBuilder("=== 4.-Gestionar Materia=============="));
      	System.out.println(new StringBuilder("=== 5.-Inscribir Alumno =============="));
    	System.out.println(new StringBuilder("Por Favor Seleccione una opcion"));
    	String resp = sc.next();
    	switch (resp) {
		case "1":
	        limpiar();
			VAlumno.imprimirMenuAlumno();
			
			break;
		case "2":
			VProfesor.imprimirMenuProfesor();
			break;
		case "3":
			VSeccion.imprimirMenuSeccion();
			
			break;
		case "4":
			VMateria.imprimirMenuMateria();
			break;
		case "5":
			ControladorAlumno.menuInscribirEstudiante();
		case "6":
			
			
			
			
		
		
		}
 }

	
	public static void limpiar(){
		for(int clear = 0; clear< 1000; clear++){
			System.out.println("\n");
		}
	}
	
	
		
		
	}


