package co.edu.unbosque.util.exception;

/**
 * Excepción personalizada que se lanza cuando no se selecciona una imagen válida.
 * Utilizada para validar la selección de imágenes en la aplicación.
 * 
 */
public class ImageException extends Exception {
    /**
     * Constructor de la excepción que muestra un mensaje indicando que se debe seleccionar una imagen.
     */
    public ImageException() {
        super("Debe selecionar una imagen");
    }
}
