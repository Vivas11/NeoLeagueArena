package co.edu.unbosque.view;

import javax.swing.JOptionPane;

/**
 * Clase que representa una ventana emergente para interactuar con el usuario.
 */
public class VentanaEmergente {

    /**
     * Constructor vacío de la clase VentanaEmergente.
     */
    public VentanaEmergente() {
        // Constructor vacío
    }

    /**
     * Muestra una ventana emergente con un mensaje.
     * 
     * @param mensaje Mensaje a mostrar en la ventana emergente.
     */
    public void mostrar(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    /**
     * Muestra una ventana emergente solicitando un número entero al usuario.
     * 
     * @param mensaje Mensaje a mostrar en la ventana emergente.
     * @return Número entero ingresado por el usuario.
     */
    public int leerInt(String mensaje) {
        String aux = JOptionPane.showInputDialog(mensaje);
        int dato = Integer.parseInt(aux);
        return dato;
    }

    /**
     * Muestra una ventana emergente solicitando un texto al usuario.
     * 
     * @param mensaje Mensaje a mostrar en la ventana emergente.
     * @return Texto ingresado por el usuario.
     */
    public String leerTexto(String mensaje) {
        String dato = JOptionPane.showInputDialog(mensaje);
        return dato;
    }

    /**
     * Muestra una ventana emergente solicitando un valor booleano al usuario.
     * El valor se define con la palabra "si".
     * 
     * @param mensaje Mensaje a mostrar en la ventana emergente.
     * @return Valor booleano ingresado por el usuario.
     */
    public boolean leerBoleano(String mensaje) {
        String entrada = JOptionPane.showInputDialog(mensaje).toLowerCase();
        if (entrada.contains("si")) {
            return true;
        } else {
            return false;
        }
    }
}