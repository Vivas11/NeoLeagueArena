package co.edu.unbosque.util.pdf;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import java.util.List;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

/**
 * Clase utilitaria para la generación de archivos PDF en la aplicación NeoLeagueArena.
 * Utiliza la librería iText para crear documentos PDF a partir de una lista de líneas de texto.
 * 
 */
public class PdfManager {
    
    /**
     * Genera un archivo PDF en la ruta especificada con el contenido de las líneas proporcionadas.
     *
     * @param rutaArchivo Ruta donde se guardará el archivo PDF.
     * @param lineas Lista de líneas de texto que se agregarán al PDF.
     */
    public static void generarPDF(String rutaArchivo, List<String> lineas) {
        Document documento = new Document();

        try {
            PdfWriter.getInstance(documento, new FileOutputStream(rutaArchivo));
            documento.open();

            for (String linea : lineas) {
                documento.add(new Paragraph(linea));
            }

            documento.close();
            System.out.println("PDF generado en: " + rutaArchivo);
        } catch (DocumentException | IOException e) {
            e.printStackTrace();
        }
    }
    
}
