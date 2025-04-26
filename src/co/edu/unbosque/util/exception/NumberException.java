package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando una cadena no contiene al menos un número.
 */
public class NumberException extends Exception {

	/**
	 * Constructor de la excepción que muestra un mensaje indicando que debe contener al menos un número.
	 */
	public NumberException() {
		super("Debe contener al menos un numero");
	}
}
