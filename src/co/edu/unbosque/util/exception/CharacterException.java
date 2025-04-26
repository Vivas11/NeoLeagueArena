package co.edu.unbosque.util.exception;

/**
 * Excepción que se lanza cuando una cadena no contiene más de 8 caracteres.
 */
public class CharacterException extends Exception {

	/**
	 * Constructor de la excepción que muestra un mensaje indicando que debe contener más de 8 caracteres.
	 */
	public CharacterException() {
		super("Debe contener mas de 8 caracteres.");
	}

}
