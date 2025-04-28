package co.edu.unbosque.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

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
		asignarLectores();
	}

	public void asignarLectores() {
		vf.getVp().getPnP().getBtnIniciarS().addActionListener(this);
		vf.getVp().getPnP().getBtnIniciarS().setActionCommand("btnPanelIniciarS");
		vf.getVp().getPnP().getBtnRegistrarse().addActionListener(this);
		vf.getVp().getPnP().getBtnRegistrarse().setActionCommand("btnPanelRegistrarse");
		vf.getVp().getPnP().getBtnVerE().addActionListener(this);
		vf.getVp().getPnP().getBtnVerE().setActionCommand("btnVerE");

		vf.getVp().getPnlIniciarS().getBtnVolver().addActionListener(this);
		vf.getVp().getPnlIniciarS().getBtnVolver().setActionCommand("btnVolverAInicio");

		vf.getVp().getPnlRegistroEntrenador().getBtnVolver().addActionListener(this);
		vf.getVp().getPnlRegistroEntrenador().getBtnVolver().setActionCommand("btnVolverAInicioR");
		vf.getVp().getPnlRegistroAdministrador().getBtnVolver().addActionListener(this);
		vf.getVp().getPnlRegistroAdministrador().getBtnVolver().setActionCommand("btnVolverAInicioR");
		vf.getVp().getPnlRegistroJugador().getBtnVolver().addActionListener(this);
		vf.getVp().getPnlRegistroJugador().getBtnVolver().setActionCommand("btnVolverAInicioR");

		vf.getVp().getPnE().getBtnVolver().addActionListener(this);
		vf.getVp().getPnE().getBtnVolver().setActionCommand("btnVolver");

		vf.getVp().getPnlRegistroEntrenador().getCbxTipoUsuario().addActionListener(this);
		vf.getVp().getPnlRegistroEntrenador().getCbxTipoUsuario().setActionCommand("SeleccionCBXRegistroEntrenador");

	}

	/**
	 * Método que gestiona las acciones realizadas por el usuario en la interfaz
	 * gráfica.
	 * 
	 * @param e Evento de acción generado por el usuario.
	 */
	public void actionPerformed(ActionEvent e) {

		switch (e.getActionCommand()) {

		case "btnPanelIniciarS": {
			vf.getVp().getPnP().setVisible(false);
			vf.getVp().getPnlIniciarS().setVisible(true);
			break;
		}

		case "btnVolverAInicio": {
			vf.getVp().getPnlIniciarS().setVisible(false);
			vf.getVp().getPnP().setVisible(true);
			break;
		}

		case "btnVolverAInicioR": {
			ocultarPanelesDeRegistro();
			vf.getVp().getPnP().setVisible(true);
			break;
		}
		case "btnPanelRegistrarse": {
			vf.getVp().getPnP().setVisible(false);
			vf.getVp().getPnlRegistroEntrenador().setVisible(true);
			break;
		}

		case "SeleccionCBXRegistroEntrenador": {
			if (e.getSource() == vf.getVp().getPnlRegistroEntrenador().getCbxTipoUsuario()) {
				String seleccion = (String) vf.getVp().getPnlRegistroEntrenador().getCbxTipoUsuario().getSelectedItem();

				ocultarPanelesDeRegistro();
				if (seleccion.equals("Administrador")) {
					vf.getVp().getPnlRegistroAdministrador().setVisible(true);
				} else if (seleccion.equals("Jugador")) {
					vf.getVp().getPnlRegistroJugador().setVisible(true);
				} else if (seleccion.equals("Entrenador")) {
					vf.getVp().getPnlRegistroEntrenador().setVisible(true);

				}
			}

			break;
		}
		case "btnVerE": {
			vf.getVp().getPnP().setVisible(false);
			vf.getVp().getPnE().setVisible(true);
			break;
		}
		case "btnVolver": {
			vf.getVp().getPnE().setVisible(false);
			vf.getVp().getPnP().setVisible(true);
			break;
		}
		}
	}

	public void ocultarPanelesDeRegistro() {
		vf.getVp().getPnlRegistroAdministrador().setVisible(false);
		vf.getVp().getPnlRegistroJugador().setVisible(false);
		vf.getVp().getPnlRegistroEntrenador().setVisible(false);
	}
}
