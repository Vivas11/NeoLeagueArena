package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando una cadena no contiene al menos una letra minúscula.
 */
public class SmallException extends Exception {

	/**
	 * Constructor de la excepción que muestra un mensaje indicando que debe contener al menos una minúscula.
	 */
	public SmallException() {
		super("Debe contener al menos una minuscula.");
	}
}
