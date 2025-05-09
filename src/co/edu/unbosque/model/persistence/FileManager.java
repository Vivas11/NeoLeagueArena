package co.edu.unbosque.model.persistence;

import java.io.*;
import java.util.Scanner;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

/**
 * Clase que proporciona métodos para la gestión de archivos, incluyendo lectura
 * y escritura de archivos de texto y serializados, así como la creación de
 * carpetas.
 */
public class FileManager {

	/**
	 * Ruta de la carpeta donde se almacenarán los archivos.
	 */
	private static final String RUTA_CARPETA = "src/archivos";

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
	 * 
	 * @param nombreArchivo Nombre del archivo.
	 * @param contenido     Contenido a escribir en el archivo.
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
	 * 
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
	 * Escribe un objeto en un archivo serializado. Si el archivo no existe, lo
	 * crea.
	 * 
	 * @param nombreArchivo Nombre del archivo.
	 * @param contenido     Objeto a escribir en el archivo.
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
	 * 
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
	 * Guarda una imagen en el formato especificado.
	 *
	 * @param origen  Archivo de origen de la imagen.
	 * @param destino Archivo de destino donde se guardará la imagen.
	 * @throws IOException Si ocurre un error al leer o escribir la imagen.
	 */
	public static void guardarImagen(File origen, File destino) throws IOException {
		// Leer la imagen desde el archivo de origen
		BufferedImage imagen = ImageIO.read(origen);

		if (imagen == null) {
			throw new IOException("El archivo de origen no es una imagen válida.");
		}

		// Obtener la extensión del archivo de destino
		String extension = destino.getName().substring(destino.getName().lastIndexOf(".") + 1).toLowerCase();

		// Verificar si la extensión es compatible
		if (!extension.equals("jpg") && !extension.equals("jpeg") && !extension.equals("png")) {
			throw new IllegalArgumentException("Formato de imagen no soportado: " + extension);
		}

		// Guardar la imagen en el archivo de destino con la extensión correcta
		boolean guardado = ImageIO.write(imagen, extension, destino);
		if (!guardado) {
			throw new IOException("Error al guardar la imagen en formato: " + extension);
		}
	}
}
