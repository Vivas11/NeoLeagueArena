package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando una cadena no contiene al menos un símbolo.
 */
public class SymbolException extends Exception {

	/**
	 * Constructor de la excepción que muestra un mensaje indicando que debe contener al menos un símbolo.
	 */
	public SymbolException() {
		super("Debe contener al menos un simbolo.");
	}
}
