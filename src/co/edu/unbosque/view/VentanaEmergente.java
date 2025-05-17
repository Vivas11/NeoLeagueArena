package co.edu.unbosque.view;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que representa una ventana emergente para interactuar con el usuario.
 */
public class VentanaEmergente {
	/*
	 * Constgructor vacio.
	 */
	public VentanaEmergente() {
	}

	/*
	 * metodo donde se muestra una ventana emergente la cual tiene como parametro un
	 * String.
	 */
	public void mostrar(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje);
	}

	/*
	 * metodo donde se muestra una ventana emergente solicitando un numero entero al
	 * usuario la cual tiene como parametro un String. y retorna el valor asignado.
	 */
	public int leerInt(String mensaje) {
		String aux = JOptionPane.showInputDialog(mensaje);
		int dato = Integer.parseInt(aux);
		return dato;
	}

	/*
	 * Metodo el cual atravez de una ventana socilita un texto recibe un parametro
	 * String y retorna el dato del usuario.
	 * 
	 */
	public String leerTexto(String mensaje) {
		String dato = JOptionPane.showInputDialog(mensaje);
		return dato;
	}

	/*
	 * Metodo el cual emite una ventana emergente solicitando un boolean. definido
	 * con la palabra si.
	 */

	public boolean leerBoleano(String mensaje) {
		Object[] opciones = { "Sí", "No" };
		int respuesta = JOptionPane.showOptionDialog(null, mensaje, "Verdadero o falso", JOptionPane.YES_NO_OPTION,
				JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
		return respuesta == 0;
	}

	public File seleccionarArchivo() {
		JFileChooser fileChooser = new JFileChooser();
		int result = fileChooser.showOpenDialog(null);
		if (result == JFileChooser.APPROVE_OPTION) {
			return fileChooser.getSelectedFile();
		}
		return null;
	}

	public void mostrarError(String mensaje) {
		JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
	}

	/*
	 * Metodo el cual solicita una fecha al usuario en formato dd/MM/yyyy HH.
	 */
	public Date leerFecha(String mensaje) {
		String input = JOptionPane.showInputDialog(null, mensaje + " (dd/MM/yyyy HH)");
		if (input == null) return null;

		try {
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH");
			sdf.setLenient(false);
			return sdf.parse(input);
		} catch (Exception e) {
			mostrarError("Use el formato dd/MM/yyyy HH (ej: 16/05/2025 14).");
			return null;
		}
	}
}