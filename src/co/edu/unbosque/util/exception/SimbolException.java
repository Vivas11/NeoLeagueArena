package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando una cadena no contiene al menos un símbolo.
 */
public class SimbolException extends Exception {

	/**
	 * Constructor de la excepción que muestra un mensaje indicando que debe contener al menos un símbolo.
	 */
	public SimbolException() {
		super("Debe contener al menos un simbolo.");
	}

}
