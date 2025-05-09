package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.OverlayLayout;

import co.edu.unbosque.model.Jugador;

public class PanelJugador extends JPanel {
	/** Scroll que es usado para navegar en los productos del carrito. */
	private JScrollPane scrollPane;
	/** Panel en el que se guardan todos los productos del carrito. */
	private JPanel panelContenido;

	private JLabel fondo;
	private JButton btnVolverJugador;
	private Properties prop;

	public PanelJugador(Properties prop) throws IOException {
		this.prop = prop;

		setBounds(0, 0, 1280, 720);
		setLayout(null);

		fondo = new JLabel();
		BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.jugadores")));
		ImageIcon imagenFondo = new ImageIcon(fd);
		Image fdRedim = fd.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
		fondo.setIcon(new ImageIcon(fdRedim));
		fondo.setBounds(0, 0, 1280, 720);

		btnVolverJugador = new JButton();
		btnVolverJugador.setBounds(1070, 45, 150, 60);
		btnVolverJugador.setFocusable(false);
		btnVolverJugador.setForeground(Color.black);
		btnVolverJugador.setBackground(new Color(0, 0, 0, 0));
		btnVolverJugador.setOpaque(false);
		btnVolverJugador.setBorderPainted(false);
		btnVolverJugador.setContentAreaFilled(false);
		btnVolverJugador.setBorder(null);
		btnVolverJugador.setFont(new Font("Baloo", Font.BOLD, 26));

		// Cambiar a BoxLayout para apilar los paneles verticalmente
		panelContenido = new JPanel();
		panelContenido.setBackground(new Color(198, 195, 195));
		panelContenido.setLayout(new BoxLayout(panelContenido, BoxLayout.Y_AXIS));

		agregarProducto(-1, new ArrayList<>());

		scrollPane = new JScrollPane(panelContenido);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setBounds(50, 200, 660, 360);

		add(scrollPane);
		add(btnVolverJugador);
		add(fondo);
	}

	/**
	 * Agrega productos con sus botones correspondientes al panel.
	 * 
	 * @param cantidad   Cantidad de productos a agregar.
	 * @param listaDatos Lista con la información de cada producto.
	 */
	public void agregarProducto(int cantidad, ArrayList<Jugador> listaDatos) {
		if (cantidad == -1) {
			return;
		}

		// Limpiar el contenido previo
		panelContenido.removeAll();

		// Ruta del fondo de las tarjetas
		String rutaFondo = prop.getProperty("archivospropiedad.fondo.tarjeta");

		for (int i = 0; i < cantidad; i++) {
			// Crear una nueva tarjeta para cada jugador
			PanelTarjeta tarjeta = new PanelTarjeta(listaDatos.get(i), rutaFondo, prop);
			panelContenido.add(tarjeta); // Añadir la tarjeta al panelContenido
		}

		// Ajustar el tamaño preferido del panelContenido
		panelContenido.setPreferredSize(new java.awt.Dimension(640, 360 * cantidad));

		// Actualizar el layout
		panelContenido.revalidate();
		panelContenido.repaint();
	}

	/**
	 * Asigna una imagen a un producto.
	 * 
	 * @param obj Producto al que se le asignará la imagen.
	 * @return Icono de la imagen asignada.
	 */
	private ImageIcon asignarImagen(Jugador obj) {
		try {
			String ruta = obj.getImagen();

			// Convertir rutas Windows a formato válido
			ruta = ruta.replace("\\", "/");

			BufferedImage fd = ImageIO.read(new File(ruta));

			ImageIcon imagen = new ImageIcon(fd);

			Image fdRedim = fd.getScaledInstance(300, 190, Image.SCALE_SMOOTH);
			return new ImageIcon(fdRedim);

		} catch (Exception e) {
			System.err.println("Error cargando imagen: " + e.getMessage());
			return null;
		}
	}

	/**
	 * Actualiza la información mostrada en el panel.
	 * 
	 * @param listaDatos Lista con la nueva información de los productos.
	 */
	public void actualizarInfo(ArrayList<Jugador> listaDatos) {
		panelContenido.removeAll();
		agregarProducto(listaDatos.size(), listaDatos);
		revalidate();
		repaint();
	}

	public JLabel getFondo() {
		return fondo;
	}

	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	public JButton getBtnVolverJugadore() {
		return btnVolverJugador;
	}

	public void setBtnVolverJugadore(JButton btnVolverJugador) {
		this.btnVolverJugador = btnVolverJugador;
	}

	public Properties getProp() {
		return prop;
	}

	public void setProp(Properties prop) {
		this.prop = prop;
	}
}
