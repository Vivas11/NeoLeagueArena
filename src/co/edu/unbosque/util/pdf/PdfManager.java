package co.edu.unbosque.util.pdf;

import java.io.FileOutputStream;
import java.io.IOException;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import java.util.List;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;

public class PdfManager {
	
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
