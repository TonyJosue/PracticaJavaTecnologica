package Vista;

import java.util.Scanner;

import controlador.ControladorMateria;
import controlador.ControladorProfesor;

public class VMateria {
	
	
	static Scanner sc = new Scanner(System.in);
	public static void imprimirMenuMateria(){
		
         
        
		System.out.println(new StringBuilder("================================ MATRICULA ============================="));
		System.out.println(new StringBuilder("=== 1.-Buscar Materia==============="));
		System.out.println(new StringBuilder("=== 2.-Registrar Materia============="));
    	System.out.println(new StringBuilder("=== 3.-Modificar Materia=============="));
    	System.out.println(new StringBuilder("=== 4.-Eliminar Materia=============="));
    	System.out.println(new StringBuilder("Por Favor Seleccione una opcion"));
    	String resp = sc.next();
    	switch (resp) {
		case "1": 
			ControladorMateria.buscarMateria();
			break;
		case "2":
			ControladorMateria.registrarMateria();
			break;
		case "3":
			ControladorMateria.modificarMateria();
		
			
			break;
		case "4":
			ControladorMateria.eliminarMateria();
			break;
			
		
		}
 }

}
