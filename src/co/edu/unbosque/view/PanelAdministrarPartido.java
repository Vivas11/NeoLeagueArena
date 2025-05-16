package co.edu.unbosque.view;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import co.edu.unbosque.model.Partida;

public class PanelAdministrarPartido extends JPanel{
	/** Scroll que es usado para navegar en los productos del carrito. */
	private JScrollPane scrollPane;
	/** Panel en el que se guardan todos los productos del carrito. */
	private JPanel panelContenido;
	private JLabel fondo;
	private Properties prop;
	
	public PanelAdministrarPartido(Properties prop) {
		// TODO Auto-generated constructor stub
	}
	/**
	 * Actualiza los componentes del panel con base en las propiedades.
	 * 
	 * @throws IOException Si ocurre un error al cargar las imágenes.
	 */
	public void actualizarComp() throws IOException {
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.administraru")));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
	}
	
	/**
     * Agrega productos con sus botones correspondientes al panel.
     * 
     * @param cantidad   Cantidad de productos a agregar.
     * @param listaDatos Lista con la información de cada producto.
     */
    public void agregarProducto(int cantidad, ArrayList<Partida> listaDatos) {
       
    }


    /**
     * Actualiza la información mostrada en el panel.
     * 
     * @param listaDatos Lista con la nueva información de los productos.
     */
    public void actualizarInfo(ArrayList<Partida> listaDatos) {
        panelContenido.removeAll();
        agregarProducto(listaDatos.size(), listaDatos);
        revalidate();
        repaint();
    }
}
