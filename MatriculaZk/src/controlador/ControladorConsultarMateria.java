package controlador;

import java.awt.Button;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.postgresql.translation.messages_bg;
import org.zkoss.bind.annotation.AfterCompose;
import org.zkoss.bind.annotation.ContextParam;
import org.zkoss.bind.annotation.ContextType;
import org.zkoss.bind.annotation.Init;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.Selectors;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Messagebox;
import org.zkoss.zul.Window;

import com.sun.java.swing.plaf.windows.resources.windows;

import Modelos.Materia;
import dao.impl.MateriaDAO;

public class ControladorConsultarMateria extends SelectorComposer<Component> {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */
	
	/** COMPONENTES DE LA VISTA**/
	@Wire
	private Listbox listbConsultarMateria;
	@Wire
	private Button btnCerrarModalConsultaMateria;
	@Wire
	Window modalConsultarMateria;
	

	 MateriaDAO materiadao =  new MateriaDAO();
	private  ListModelList<Materia>aux;
	private HashSet<Materia> hmateria= new HashSet<Materia>();
	
	 	//@Init
	    //@ContextParam(ContextType.COMPONENT)Component comp
	@Wire("#modalConsultarMateria")
		public  void Inicializar(Window comp){
			
			System.out.println("holaaaa1!!!!!!");
			try {
			//4	super.doAfterCompose(comp);
				
			//	Selectors.wireComponents(comp, this, false);
			//	this.modalConsultarMateria = (Window)comp;
			
			 
			
				aux=new ListModelList<Materia>();
				aux.addAll(materiadao.listar());
				listbConsultarMateria.setModel(aux);
				
				//listarMateria();
				System.out.println("holaaaa2!!!!!!");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.out.println("problemas al cargar");
			}
		}
		
		
	/*	public void  listarMateria(){
			aux.addAll(materiadao.listar());
			listbConsultarMateria.setModel(aux);
			System.out.println(aux.getSize());
			
		}
		
			
	*/
		
		
		@Listen("onClick=#btnCerrarModalConsultaMateria")
		public void cerrarModalConsultaMateria(){
			modalConsultarMateria.detach();
			
		}
		@Listen("onSelect=#listbConsultarMateria")
		public void mostrarModal(Event e){
			Messagebox.show("hola2");
		Materia a= (Materia)listbConsultarMateria.getSelectedItem().getValue() ;
	    hmateria.add(a);
	
		System.out.println(hmateria);
		Window window = (Window) Executions.createComponents("/Materia.zul", null, null);
		window.doModal();
			
			
		}
		
		
	
  
	

}
