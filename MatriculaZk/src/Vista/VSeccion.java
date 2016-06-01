package Vista;



import java.util.Scanner;

import controlador.ControladorMateria;
import controlador.ControladorSeccion;


public class VSeccion {
	static Scanner sc = new Scanner(System.in);  
	
	public static void imprimirMenuSeccion(){
	System.out.println(new StringBuilder("================================ Registro de Seccion ============================="));
	System.out.println(new StringBuilder("=== 1.-Buscar Seccion==============="));
	System.out.println(new StringBuilder("=== 2.-Registrar Seccion============="));
	System.out.println(new StringBuilder("=== 3.-Eliminar Seccion============="));
	System.out.println(new StringBuilder("===4.Preparar Seccion==============="));
	System.out.println(new StringBuilder("Por Favor Seleccione una opcion"));
	String resp = sc.next();
	switch (resp) {
	case "1": 
		ControladorSeccion.buscarSeccion();
		break;
	case "2":
		ControladorSeccion.registrarSeccion();
		break;
	case "3":
		ControladorSeccion.eliminarSeccion();
		break;
	case "4":
		ControladorSeccion.prepararSeccion();
		
		
}

}
}
