package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando se intenta registrar un nombre de usuario repetido.
 */
public class UsernameException extends Exception {

	/**
	 * Constructor de la excepción que muestra un mensaje indicando que no se puede repetir el usuario.
	 */
	public UsernameException() {
		super("No se puede repetir usuario.");
	}
}
