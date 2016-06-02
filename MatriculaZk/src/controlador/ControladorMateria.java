package controlador;

import java.awt.Button;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.zkoss.bind.annotation.Init;
import org.zkoss.zhtml.Messagebox;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Groupbox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Textbox;
import org.zkoss.zul.Window;

import com.sun.org.apache.xpath.internal.operations.Div;

import Modelos.Alumno;
import Modelos.Materia;
import Modelos.Profesor;
import Modelos.Seccion;
import Vista.VMateria;
import Vista.Vmatricula;
import bsh.org.objectweb.asm.Label;
import dao.impl.MateriaDAO;
import sun.awt.ModalExclude;

public class ControladorMateria extends SelectorComposer<Component> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static MateriaDAO materiadao = new MateriaDAO();
	static Scanner sc = new Scanner(System.in);
	
	
	

	/** Elemento de las vistas **/
	@Wire
	private Groupbox groupMateria;
	@Wire
	private Div divMateria, divButtonMateria;
	@Wire
	private Listbox listbMateria;
	@Wire
	private Label lblCodigo, lblNombre;
	@Wire
	private Textbox txtbCodigo, txtbNombre;
	@Wire
	private Button btnGuardar, btnCancelar, btnCerrarModalMateria;
	@Wire
	Window modalRegistrarMateria;

	public static void registrarMateria() {
		System.out.println("===================Registar Materia============================");
		String resp = "";
		do {
			System.out.println("Ingrese codigo");
			String codigo = sc.next().toUpperCase();
			System.out.println("Ingrese Nombre");
			String nombre = sc.next();
			Materia materia = new Materia();
			materia.setCodigo(codigo);
			materia.setNombre(nombre);

			try {
				if (validarMateria(materia) == true) {
					materiadao.registrar(materia);
				} else {
					System.out.println("Datos errados, por favor ingresar nuevamente los datos");
					registrarMateria();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Desea Registrar otra Materia, presiones (1) si es Si o (0) para regredar al menu ");
		} while (resp.toUpperCase().equals("1"));
		String valor = sc.next();
		if (valor.equals("0"))
			Vmatricula.imprimirMenuMatricula();

	}

	public static Materia buscarMateria() {

		System.out.println(new StringBuilder("Ingrese la codigo de la Materia "));
		String codigo = sc.next();
		Materia materia = materiadao.buscar(codigo);
		System.out.println(new StringBuilder("Cedula:   ").append(materia.getCodigo()));
		System.out.println(new StringBuilder("Nombre:   ").append(materia.getNombre()));

		return materia;

	}

	public static void modificarMateria() {
		Materia materiam = buscarMateria();

		System.out.println("Ingrese los datos que desea modificar");
		System.out.println("Ingrese Nombre");
		String nombre = sc.next();
		materiam.setNombre(nombre);
		try {
			materiadao.modificar(materiam);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Actualizacion Exitosa");
		Vmatricula.imprimirMenuMatricula();

	}

	public static void eliminarMateria() {

		Materia materiaE = buscarMateria();
		materiadao.eliminar(materiaE);

	}

	public static Materia imprimirListaMateria() {

		System.out.println("============Lista de Seccion Disponibles=================");
		int pos = 0;
		for (Materia s : materiadao.listar()) {
			pos++;
			System.out.println(new StringBuilder("Codigo:").append(" ").append(s.getCodigo()).append(" ")
					.append("Nombre: ").append(s.getNombre()).append("  -").append(pos));

		}
		System.out.println("Seleccion la materia que desea asignar a la seccion");
		int resp = 1;
		resp = sc.nextInt();

		Materia materiaSelect = materiadao.listar().get(resp - 1);

		System.out.println(materiaSelect.getCodigo() + "  " + materiaSelect.getNombre());
		return materiaSelect;

	}

	public static boolean validarMateria(Materia materiav) {
		if (materiav.getCodigo() instanceof String) {
			return true;
		}
		if (materiav.getNombre() instanceof String) {
			return true;
		}

		return false;

	}
/*  REGISTRAR MATERIA*/
	@Listen("onClick=#btnGuardar")
	public void guardar() {
		if (!(txtbNombre.getValue().equals("")) && !(txtbCodigo.getValue().equals(""))) {
			Materia materia = new Materia();
			materia.setCodigo(txtbCodigo.getValue());
			materia.setNombre(txtbNombre.getValue());
			limpiarMateria();

			try {
				materiadao.registrar(materia);
				Messagebox.show("La Materia fue Registrada de manera exitosa");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	@Listen("onClick=#btnCancelar")
	public void cancelar() {
		txtbCodigo.setValue("");
		txtbNombre.setValue("");

	}

	@Listen("onClick=#btnCerrarModalMateria")
	public void cerrarModal(Event e) {
		modalRegistrarMateria.detach();

	}
	
	

	public void limpiarMateria() {
		txtbCodigo.setValue("");
		txtbNombre.setValue("");
	}

}
