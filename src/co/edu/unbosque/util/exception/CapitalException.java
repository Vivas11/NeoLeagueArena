package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando una cadena no contiene al menos una letra mayúscula.
 */
public class CapitalException extends Exception {

	/**
	 * Constructor de la excepción que muestra un mensaje indicando que debe contener una mayúscula.
	 */
	public CapitalException() {
		super("Debe contener una mayuscula.");
	}
}
