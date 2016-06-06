package controlador;

import java.sql.SQLException;
import java.util.Scanner;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.Button;
import org.zkoss.zul.Combobox;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;

import com.sun.xml.internal.bind.v2.schemagen.xmlschema.List;

import Modelos.Alumno;
import Modelos.Seccion;
import Vista.VAlumno;
import Vista.Vmatricula;
import dao.impl.AlumnoDAO;
import dao.impl.SeccionDAO;

public class ControladorAlumno extends ControladorMatricula{
    
	static Scanner sc = new Scanner(System.in);
	static AlumnoDAO alumnodao= new AlumnoDAO();
	 static Alumno alumnov = new Alumno();
	 static SeccionDAO secciondao= new SeccionDAO();

	public static void registrarAlumno(){
		System.out.println("===================Registar Alumno============================");
		String resp= "";
		do{
		
			System.out.println("Ingrese Cedula");
			String cedula= sc.next();
			System.out.println("Ingrese Nombre");
			String nombre = sc.next();
			System.out.println("Ingrese Sexo");
			
			String sexo =sc.next();
			System.out.println("Ingrese Edad");
			Integer edad= Integer.valueOf(sc.nextInt());
			
		    
			System.out.println("Ingrese Grado");
			String grado=sc.next();
			Alumno alumno = new Alumno();
			
			alumno.setCedula(cedula);
			alumno.setNombre(nombre);
			alumno.setSexo(sexo);
			alumno.setEdad(edad);
			alumno.setGrado(grado);
			
			try {
				if(validarAlumno(alumno)==true){
				alumnodao.registrar(alumno);
				}else{
					System.out.println("Datos errados, por favor ingresar los datos correctos");
				    registrarAlumno();
			}
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		System.out.println("Desea Registrar otro Alumno, presiones 1 si es Si o 0 para regredar al menu ");
		}while(resp.toUpperCase().equals("S"));
		 String valor="";
		 valor= sc.next();
		 if(valor.equals("0")){
			 VAlumno.imprimirMenuAlumno();
		
		 }
		
	}
	public static Alumno buscarAlumno(){
		System.out.println(new StringBuilder("Ingrese la cedula del alumno "));
		String cedula = sc.next();
		Alumno alumno = alumnodao.buscar(cedula);
	
		System.out.println(new StringBuilder("Cedula:   ").append(alumno.getCedula()));
		System.out.println(new StringBuilder("Nombre:   ").append(alumno.getNombre()));
		System.out.println(new StringBuilder("Sexo:    ").append(alumno.getSexo()));
		System.out.println(new StringBuilder("Edad:     ").append(alumno.getEdad()));
		System.out.println(new StringBuilder("grado:     ").append(alumno.getGrado()));
		System.out.println(new StringBuilder("Seccion:    ").append(alumno.getSeccion()));
	//	System.out.println(new StringBuilder("Estatus:    ").append(alumno.getEstatus()));
		 String valor="";
		 System.out.println("Si Desea Buscar Otro Alumno marque (1) sino marque (2)");
		 valor= sc.next();
		 if(valor.equals("1")){
			buscarAlumno();
			
		 }else
		 VAlumno.imprimirMenuAlumno();
		 
	 return  alumno;
	
	 
		
		
	
	}
	
	
	public static void modificarAlumno() {
	    Alumno alumnom =buscarAlumno();
	    
		System.out.println("Ingrese los datos que desea modificar");
    	System.out.println("Ingrese Nombre");
		String nombre = sc.next();
		System.out.println("Ingrese Sexo");
		String sexos =sc.next();
		System.out.println("Ingrese Edad");
		int edads= sc.nextInt();
		System.out.println("Ingrese Grado");
		String grados=sc.next();
		alumnom.setNombre(nombre);
		alumnom.setSexo(sexos);
		alumnom.setEdad(edads);
		alumnom.setGrado(grados);
		alumnodao.modificar(alumnom);
	}
	
	public static void eliminarAlumno(){
		Alumno alumnoE= buscarAlumno();
		alumnodao.eliminar(alumnoE);
			
	}
		
	
	
	public static void menuInscribirEstudiante(){
		System.out.println("============================PROCESO DE INSCRIPCION==========================");
		System.out.println("Buscar el Estudiante a inscribir");
		String cedula = sc.next();
		Alumno alumno = alumnodao.buscar(cedula);
		
		
		
		System.out.println("===========Lista de Secciones Disponible==============");
        int pos=0;
        int resp=1;
		for(Seccion s: secciondao.listar()){
			pos++;
			System.out.println(new StringBuilder("Codigo:").append(" ").append(s.getCodigo()).append(" ").
					                     append("Materia: ").append(" ").append(s.getMateria()!=null?s.getMateria().getCodigo():null).append(" ").
					                     append("Profesor: ").append(" ").append(s.getProfesor()!=null?s.getProfesor().getCedula():null).append(" ").
			                             append(pos));
		
	
		}   
		    System.out.println("Seleccion la seccion a inscribir al estudiante");
		    resp= sc.nextInt();
		    String profesorSelect = secciondao.listar().get(resp-1).getCodigo();
		    System.out.println(new StringBuilder("La seccion seleccionada es: ").append(profesorSelect));
		
		    alumnodao.inscribirAlumno(alumno, profesorSelect);
			
		}
	
	
	public static boolean validarAlumno(Alumno alumv){
		if(alumv.getEdad()< 120){
			return true;
		}if(alumv.getCedula() instanceof String){
			return true;
					
		}if(alumv.getNombre() instanceof String){
			return true;
			
		}if (alumv.getSexo() instanceof String){
			return true;
			
		}if(alumv.getGrado() instanceof String){
			return true;
		}if(Integer.valueOf(alumv.getEdad()) instanceof Integer){
			return true;
		}
		
		return false;

	}
	
	//Métodos aplicados en ZK
	@Wire
	private Combobox cmbSeccionAlumno;
	
	@Wire
	private Button btnGuardarAlumno;
	
	@Listen("onCreate=#cmbSeccionAlumno")
	public void mostrarSeccion(){
		SeccionDAO secciondao = new SeccionDAO();
		ListModelList<Seccion> listaSeccion = new ListModelList<>();
		listaSeccion.addAll(secciondao.listar());
		System.out.println(listaSeccion);
		cmbSeccionAlumno.setModel(listaSeccion);
		
	}
	@Listen("OnClick=#btnGuardarAlumno")
	public void guardarAlumno(){
		Messagebox.show("hOLA Soy yo");	
	}

 
}

	
	

