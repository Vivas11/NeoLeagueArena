package co.edu.unbosque.util.exception;

public class CountryException extends Exception {

	/**
	 * Constructor de la excepción que muestra un mensaje indicando que las contraseñas deben coincidir.
	 */
	public CountryException() {
		super("El pais no es valido.");
	}
}
