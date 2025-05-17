package co.edu.unbosque.util.exception;

/**
 * Excepción personalizada que se lanza cuando el email proporcionado no es válido.
 * Utilizada para validar el formato o la validez de correos electrónicos en la aplicación.
 * 
 */
public class MailException extends Exception{
    /**
     * Constructor de la excepción que muestra un mensaje indicando que el email debe ser válido.
     */
    public MailException() {
        super("El Email debe ser valido.");
    }
}
