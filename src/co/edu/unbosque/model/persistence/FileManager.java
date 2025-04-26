package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.Scanner;

/**
 * Clase que proporciona métodos para la gestión de archivos, incluyendo lectura y escritura
 * de archivos de texto y serializados, así como la creación de carpetas.
 */
public class FileManager {

    /**
     * Ruta de la carpeta donde se almacenarán los archivos.
     */
    private static final String RUTA_CARPETA = "../archivos";

    // Variables para archivos de texto
    private static Scanner lectorArchivo;
    private static File archivo;
    private static PrintWriter escritorArchivo;

    // Variables para archivos serializados
    private static FileOutputStream fos;
    private static ObjectOutputStream oos;
    private static FileInputStream fis;
    private static ObjectInputStream ois;

    /**
     * Crea la carpeta donde se almacenarán los archivos si no existe.
     */
    public static void crearCarpeta() {
        archivo = new File(RUTA_CARPETA);
        if (!archivo.exists() || !archivo.isDirectory()) {
            archivo.mkdir();
        }
    }

    /**
     * Escribe contenido en un archivo de texto. Si el archivo no existe, lo crea.
     * @param nombreArchivo Nombre del archivo.
     * @param contenido Contenido a escribir en el archivo.
     */
    public static void escribirArchivoTexto(String nombreArchivo, String contenido) {
        try {
            archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            escritorArchivo = new PrintWriter(archivo);
            escritorArchivo.println(contenido);
            escritorArchivo.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo de texto.");
            e.printStackTrace();
        }
    }

    /**
     * Lee el contenido de un archivo de texto. Si el archivo no existe, lo crea.
     * @param nombreArchivo Nombre del archivo.
     * @return Contenido del archivo como una cadena de texto.
     */
    public static String leerArchivoTexto(String nombreArchivo) {
        try {
            archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            lectorArchivo = new Scanner(archivo);
            String contenido = "";
            while (lectorArchivo.hasNext()) {
                contenido += lectorArchivo.nextLine() + "\n";
            }
            lectorArchivo.close();
            return contenido;
        } catch (IOException e) {
            System.out.println("Error al leer el archivo de texto.");
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Escribe un objeto en un archivo serializado. Si el archivo no existe, lo crea.
     * @param nombreArchivo Nombre del archivo.
     * @param contenido Objeto a escribir en el archivo.
     */
    public static void escribirArchivoSerializado(String nombreArchivo, Object contenido) {
        try {
            archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            fos = new FileOutputStream(archivo);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(contenido);
            oos.close();
            fos.close();
        } catch (IOException e) {
            System.out.println("Error al escribir el archivo serializado.");
            e.printStackTrace();
        }
    }

    /**
     * Lee un objeto desde un archivo serializado.
     * @param nombreArchivo Nombre del archivo.
     * @return Objeto leído del archivo, o null si ocurre un error.
     */
    public static Object leerArchivoSerialziado(String nombreArchivo) {
        Object contenido = null;
        try {
            archivo = new File(RUTA_CARPETA + "/" + nombreArchivo);
            if (!archivo.exists()) {
                archivo.createNewFile();
            }
            fis = new FileInputStream(archivo);
            ois = new ObjectInputStream(fis);
            contenido = ois.readObject();
            ois.close();
            fis.close();
        } catch (IOException e) {
            System.out.println("Error al leer el archivo serializado.");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.out.println("Error en los datos del archivo serializado.");
            e.printStackTrace();
        }
        return contenido;
    }

    /**
     * Copia una imagen desde un archivo de origen a un archivo de destino.
     * @param origen Archivo de origen.
     * @param destino Archivo de destino.
     * @throws IOException Si ocurre un error durante la copia.
     */
    public static void guardarImagen(File origen, File destino) throws IOException {
        try (InputStream input = new FileInputStream(origen); OutputStream output = new FileOutputStream(destino)) {
            byte[] buf = new byte[1024];
            int a;
            while ((a = input.read(buf)) > 0) {
                output.write(buf, 0, a);
            }
        }
    }
}
