package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando las contraseñas no coinciden.
 */
public class EqualPasswordException extends Exception {

	/**
	 * Constructor de la excepción que muestra un mensaje indicando que las contraseñas deben coincidir.
	 */
	public EqualPasswordException() {
		super("Las contraseñas deben coincidir.");
	}
}
