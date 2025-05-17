package co.edu.unbosque.view;

import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Clase que representa una ventana emergente para interactuar con el usuario.
 * Permite mostrar mensajes, leer datos de diferentes tipos y seleccionar archivos.
 */
public class VentanaEmergente {
    /**
     * Constructor vacío.
     */
    public VentanaEmergente() {
    }

    /**
     * Muestra una ventana emergente con un mensaje.
     * @param mensaje Mensaje a mostrar.
     */
    public void mostrar(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    /**
     * Muestra una ventana emergente solicitando un número entero al usuario.
     * @param mensaje Mensaje a mostrar.
     * @return Valor entero ingresado por el usuario.
     */
    public int leerInt(String mensaje) {
        String aux = JOptionPane.showInputDialog(mensaje);
        int dato = Integer.parseInt(aux);
        return dato;
    }

    /**
     * Solicita un texto al usuario mediante una ventana emergente.
     * @param mensaje Mensaje a mostrar.
     * @return Texto ingresado por el usuario.
     */
    public String leerTexto(String mensaje) {
        String dato = JOptionPane.showInputDialog(mensaje);
        return dato;
    }

    /**
     * Solicita una respuesta booleana al usuario (Sí/No).
     * @param mensaje Mensaje a mostrar.
     * @return true si el usuario selecciona "Sí", false en caso contrario.
     */
    public boolean leerBoleano(String mensaje) {
        Object[] opciones = { "Sí", "No" };
        int respuesta = JOptionPane.showOptionDialog(null, mensaje, "Verdadero o falso", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE, null, opciones, opciones[0]);
        return respuesta == 0;
    }

    /**
     * Abre un selector de archivos para que el usuario elija un archivo.
     * @return Archivo seleccionado o null si se cancela.
     */
    public File seleccionarArchivo() {
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            return fileChooser.getSelectedFile();
        }
        return null;
    }

    /**
     * Muestra una ventana emergente de error con un mensaje.
     * @param mensaje Mensaje de error a mostrar.
     */
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje, "Error", JOptionPane.ERROR_MESSAGE);
    }

    /**
     * Solicita una fecha al usuario en formato dd/MM/yyyy HH.
     * @param mensaje Mensaje a mostrar.
     * @return Fecha ingresada por el usuario o null si es inválida o anterior a la fecha actual.
     */
    public Date leerFecha(String mensaje) {
        String input = JOptionPane.showInputDialog(null, mensaje + " (dd/MM/yyyy HH)");
        if (input == null) return null;

        try {
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH");
            sdf.setLenient(false);
            Date fecha = sdf.parse(input);
            Date hoy = new Date();
            if (fecha.before(hoy)) {
                return null;
            }
            return fecha;
        } catch (Exception e) {
            mostrarError("Use el formato dd/MM/yyyy HH (ej: 16/05/2025 14).");
            return null;
        }
    }
}