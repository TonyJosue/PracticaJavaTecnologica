package controlador;

import java.sql.SQLException;
import java.util.Scanner;

import Modelos.Materia;
import Modelos.Profesor;
import Modelos.Seccion;
import Vista.Vmatricula;
import dao.impl.MateriaDAO;
import dao.impl.ProfesorDAO;
import dao.impl.SeccionDAO;


public class ControladorSeccion extends ControladorMatricula {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Scanner sc = new Scanner(System.in);
	static SeccionDAO secciondao =new SeccionDAO();
	
	public static void registrarSeccion() {
		System.out.println("===================Registar Seccion===========================");
		String resp = "";
		do {
			System.out.println("Ingrese codigo");
			String codigo = sc.next().toUpperCase();
			Seccion seccion = new Seccion();
			seccion.setCodigo(codigo);

			try {
				if(validarSeccion(seccion)){
				secciondao.registrar(seccion);
				}else{
					System.out.println("Datos no correctos, por favor ingresar nuevamente los mismos");
					registrarSeccion();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Desea Registrar otra Seccion, (1) Si /  (0)  para regredar al menu ");
		} while (resp.equals("1"));
		String valor = "";
		valor = sc.next();
		if (valor.equals("0"))
			Vmatricula.imprimirMenuMatricula();

	}
	public static Seccion buscarSeccion(){
		System.out.println(new StringBuilder("Ingrese la codigo de la Seccion "));
		String codigo = sc.next();
		Seccion seccion = secciondao.buscar(codigo);
		System.out.println(new StringBuilder("Codigo:   ").append(seccion.getCodigo()));
		System.out.println(new StringBuilder("Materia:   ").append(seccion.getMateria()));
		System.out.println(new StringBuilder("Profesor:   ").append(seccion.getProfesor()));
		
 
	 return  seccion;
		
		
	}
	public static void eliminarSeccion(){
		Seccion seccionE= buscarSeccion();
        secciondao.eliminar(seccionE);
			
		
	}
	
	
	public static void prepararSeccion() {
		MateriaDAO materiadao = new MateriaDAO();
		ProfesorDAO profesordao = new ProfesorDAO();

		System.out.println("===================Praparar Seccion========================");
		System.out.println("Ingrese el codigo de la seccion  a preparar");
		String codigo = sc.next();
	//	Seccion seccion = secciondao.buscar(codigo);
		Seccion seccion= secciondao.buscarSeccionSinMateria(codigo);
		if (seccion != null) {
			System.out.println(new StringBuilder("codigo").append("").append(seccion.getCodigo()));

			System.out.println("============Lista de Materia Disponibles=================");
			int pos2 = 0;
			for (Materia s : materiadao.listar()) {
				pos2++;
				System.out.println(new StringBuilder("Codigo:").append(" ").append(s.getCodigo()).append(" ")
						.append("Nombre: ").append(s.getNombre()).append("  -").append(pos2));

			}
			System.out.println("Seleccion la materia que desea asignar a la seccion");
			int resp2 = 1;
			resp2 = sc.nextInt();
			String materiaSelect = materiadao.listar().get(resp2 - 1).getCodigo();

			System.out.println(materiaSelect);

			System.out.println("============Lista de Porfesores Disponibles=================");
			int pos3 = 0;
			for (Profesor f : profesordao.listar()) {
				pos3++;
				System.out.println(new StringBuilder("Codigo:").append(" ").append(f.getCedula()).append(" ")
						.append("Nombre: ").append(f.getNombre()).append("  -").append(pos3));

			}
			System.out.println("Seleccion el profesor que desea asignar a la seccion");
			int resp3 = 1;
			resp3 = sc.nextInt();
			String profesorSelect = profesordao.listar().get(resp3 - 1).getCedula();

			System.out.println(profesorSelect);

			secciondao.modificarE(seccion, materiaSelect, profesorSelect);

		} else
			System.err.println("No se encuentra una seccion con el codigo especificado!!");

	}
	

	public static boolean validarSeccion(Seccion seccionv){
		if(seccionv.getCodigo() instanceof String){
			return true;
		}if(seccionv.getMateria().getCodigo() instanceof String){
			return true;
		}if(seccionv.getProfesor().getCedula() instanceof String){
			return true;
		}

		return false;

	}
	

	

}
