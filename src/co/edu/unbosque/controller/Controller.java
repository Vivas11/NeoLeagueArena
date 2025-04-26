package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import co.edu.unbosque.model.ModelFacade;
import co.edu.unbosque.view.ViewFacade;

/**
 * Clase Controlador que maneja la interacción entre el modelo y la vista.
 * Implementa ActionListener para gestionar las acciones del usuario.
 */
public class Controller implements ActionListener {
	
	/** Facade para gestionar la capa del modelo. */
	private ModelFacade mf;

	/** Facade para gestionar la capa de la vista. */
	private ViewFacade vf;

	public Controller() {
		mf = new ModelFacade();
		vf = new ViewFacade();
	}
	
	public void run() {
		vf.getVp().setVisible(true);
	}
	
	public void asignarLectores() {
		vf.getVp().getPnP().getBtnIniciarS().addActionListener(this);;
		vf.getVp().getPnP().getBtnIniciarS().setActionCommand("btnIniciarS");
	}
	/**
	 * Método que gestiona las acciones realizadas por el usuario en la interfaz gráfica.
	 * 
	 * @param e Evento de acción generado por el usuario.
	 */
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {
		
		case "btnIniciarS":{
			vf.getVp().getPnP().setVisible(false);
			vf.getVp().getPnlIniciarS().setVisible(true);
			
			break;
		}
		}
	}
}
