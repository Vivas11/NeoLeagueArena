package co.edu.unbosque.util.exception;

/**
 * Excepción personalizada que se lanza cuando un valor no es potencia de dos.
 * Utilizada para validar restricciones en la cantidad de elementos (por ejemplo, equipos en un torneo).
 * 
 */
public class PowerOfTwoException extends Exception {

    /**
     * Constructor de la excepción que muestra un mensaje indicando que el valor debe ser potencia de dos.
     */
    public PowerOfTwoException() {
        super("Debe ser potencia de dos.");
    }

}
