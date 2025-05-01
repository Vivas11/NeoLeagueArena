package co.edu.unbosque.util.exception;

public class MailException extends Exception{
	/**
	 * Constructor de la excepción que muestra un mensaje indicando que las contraseñas deben coincidir.
	 */
	public MailException() {
		super("El Email debe ser valido.");
	}
}
