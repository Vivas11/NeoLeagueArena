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

public class PanelInforme extends JPanel{
		private JLabel fondo;
		private Properties prop;
		
		public PanelInforme(Properties prop) {
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
}
