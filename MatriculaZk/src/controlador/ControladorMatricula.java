package controlador;


import java.awt.MenuItem;

import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.Wire;

import org.zkoss.zul.Window;

public class ControladorMatricula extends SelectorComposer<Component>{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**Componente del menu Primcipal**/
	
	@Wire
	private MenuItem mItemRegistrarMateria,mItemConsultarMateria;
	
	
	
	
	
	
	@Listen("onClick=#mItemRegistrarMateria")
	public  void  abrirModal(Event e){
		 
		 Window window = (Window)Executions.createComponents("/Materia.zul", null, null);
		 window.doModal();
	     
		
		
	}
	
	@Listen("onClick=#mItemConsultarMateria")
	public void abrirModalConsultarMateria(Event e){
		
		Window window =  (Window)Executions.createComponents("/ConsultarMateria.zul", null, null);
		 window.doModal();
	
	}


	


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
		
		
	
	}
	
	

