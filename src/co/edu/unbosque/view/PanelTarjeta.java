package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.Entrenador;
import co.edu.unbosque.model.Equipo;
import co.edu.unbosque.model.Jugador;

public class PanelTarjeta extends JPanel {

	private JButton eliminar, actualizar;
	
	public PanelTarjeta(Jugador jugador, String rutaFondo, Properties prop) {
		setLayout(null);
		setPreferredSize(new java.awt.Dimension(640, 360));

		JLabel pfondo = new JLabel();
		try {
			BufferedImage fd = ImageIO.read(new File(rutaFondo));
			Image fdRedim = fd.getScaledInstance(640, 360, Image.SCALE_SMOOTH);
			pfondo.setIcon(new ImageIcon(fdRedim));
		} catch (IOException e) {
			System.err.println("Error cargando fondo del producto: " + e.getMessage());
		}
		pfondo.setBounds(0, 0, 640, 360);

		JLabel usuario = new JLabel(jugador.getNombre());
		usuario.setBounds(350, 115, 200, 30);
		usuario.setFont(new Font("Arial", Font.BOLD, 15));
		usuario.setForeground(Color.WHITE);
		add(usuario);

		JLabel pais = new JLabel(jugador.getPais());
		pais.setBounds(325, 163, 200, 30);
		pais.setFont(new Font("Arial", Font.BOLD, 15));
		pais.setForeground(Color.WHITE);
		add(pais);

		JLabel ciudad = new JLabel(jugador.getCiudad());
		ciudad.setBounds(340, 212, 200, 30);
		ciudad.setFont(new Font("Arial", Font.BOLD, 15));
		ciudad.setForeground(Color.WHITE);
		add(ciudad);

		JLabel equipo;
		try {
			equipo = new JLabel(jugador.getEquipo().getNombre());
		} catch (Exception e) {
			equipo = new JLabel("No pertenece a ningún equipo.");
		}
		equipo.setBounds(340, 260, 300, 30);
		equipo.setFont(new Font("Arial", Font.BOLD, 15));
		equipo.setForeground(Color.WHITE);
		add(equipo);

		JLabel lblImagen = new JLabel(asignarImagen(jugador));
		lblImagen.setBounds(70, 100, 150, 150);
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblImagen);
		add(pfondo);
	}

	public PanelTarjeta(Jugador jugador, String rutaFondo, Properties prop, Boolean a) {
		setLayout(null);
		setPreferredSize(new java.awt.Dimension(640, 360));

		JLabel pfondo = new JLabel();
		try {
			BufferedImage fd = ImageIO.read(new File(rutaFondo));
			Image fdRedim = fd.getScaledInstance(640, 360, Image.SCALE_SMOOTH);
			pfondo.setIcon(new ImageIcon(fdRedim));
		} catch (IOException e) {
			System.err.println("Error cargando fondo del producto: " + e.getMessage());
		}
		pfondo.setBounds(0, 0, 640, 360);

		JLabel usuario = new JLabel(jugador.getNombre());
		usuario.setBounds(350, 115, 200, 30);
		usuario.setFont(new Font("Arial", Font.BOLD, 15));
		usuario.setForeground(Color.WHITE);
		add(usuario);

		JLabel pais = new JLabel(jugador.getPais());
		pais.setBounds(325, 163, 200, 30);
		pais.setFont(new Font("Arial", Font.BOLD, 15));
		pais.setForeground(Color.WHITE);
		add(pais);

		JLabel ciudad = new JLabel(jugador.getCiudad());
		ciudad.setBounds(340, 212, 200, 30);
		ciudad.setFont(new Font("Arial", Font.BOLD, 15));
		ciudad.setForeground(Color.WHITE);
		add(ciudad);

		JLabel equipo;
		try {
			equipo = new JLabel(jugador.getEquipo().getNombre());
		} catch (Exception e) {
			equipo = new JLabel("No pertenece a ningún equipo.");
		}
		equipo.setBounds(340, 260, 300, 30);
		equipo.setFont(new Font("Arial", Font.BOLD, 15));
		equipo.setForeground(Color.WHITE);
		add(equipo);

		eliminar = new JButton();
		eliminar.setBounds(175, 275, 70, 20);
		eliminar.setFocusable(false);
		eliminar.setOpaque(false);
		eliminar.setBorderPainted(false);
		eliminar.setContentAreaFilled(false);
		eliminar.setBorder(null);
		add(eliminar);
		
		actualizar = new JButton();
		actualizar.setBounds(70, 275, 70, 20);
		actualizar.setFocusable(false);
		actualizar.setOpaque(false);
		actualizar.setBorderPainted(false);
		actualizar.setContentAreaFilled(false);
		actualizar.setBorder(null);
		add(actualizar);
		
		JLabel lblImagen = new JLabel(asignarImagen(jugador));
		lblImagen.setBounds(70, 100, 150, 150);
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblImagen);
		add(pfondo);
	}
	
	public PanelTarjeta(Entrenador entrenador, String rutaFondo, Properties prop, Boolean a) {
		setLayout(null);
		setPreferredSize(new java.awt.Dimension(640, 360));

		JLabel pfondo = new JLabel();
		try {
			BufferedImage fd = ImageIO.read(new File(rutaFondo));
			Image fdRedim = fd.getScaledInstance(640, 360, Image.SCALE_SMOOTH);
			pfondo.setIcon(new ImageIcon(fdRedim));
		} catch (IOException e) {
			System.err.println("Error cargando fondo del producto: " + e.getMessage());
		}
		pfondo.setBounds(0, 0, 640, 360);

		JLabel usuario = new JLabel(entrenador.getNombre());
		usuario.setBounds(350, 115, 200, 30);
		usuario.setFont(new Font("Arial", Font.BOLD, 15));
		usuario.setForeground(Color.WHITE);
		add(usuario);

		JLabel pais = new JLabel(entrenador.getPais());
		pais.setBounds(325, 163, 200, 30);
		pais.setFont(new Font("Arial", Font.BOLD, 15));
		pais.setForeground(Color.WHITE);
		add(pais);

		JLabel ciudad = new JLabel(entrenador.getCiudad());
		ciudad.setBounds(340, 212, 200, 30);
		ciudad.setFont(new Font("Arial", Font.BOLD, 15));
		ciudad.setForeground(Color.WHITE);
		add(ciudad);

		String txteq = "";
		for (Equipo equipo : entrenador.getEquipos()) {
			txteq += (equipo.getNombre() + ", ");
		}
		JLabel equipo;
		try {
			equipo = new JLabel(txteq);
		} catch (Exception e) {
			equipo = new JLabel("No pertenece a ningún equipo.");
		}
		equipo.setBounds(340, 260, 300, 30);
		equipo.setFont(new Font("Arial", Font.BOLD, 15));
		equipo.setForeground(Color.WHITE);
		add(equipo);

		eliminar = new JButton();
		eliminar.setBounds(175, 275, 70, 20);
		eliminar.setFocusable(false);
		eliminar.setOpaque(false);
		eliminar.setBorderPainted(false);
		eliminar.setContentAreaFilled(false);
		eliminar.setBorder(null);
		add(eliminar);
		
		actualizar = new JButton();
		actualizar.setBounds(70, 275, 70, 20);
		actualizar.setFocusable(false);
		actualizar.setOpaque(false);
		actualizar.setBorderPainted(false);
		actualizar.setContentAreaFilled(false);
		actualizar.setBorder(null);
		add(actualizar);
		
		JLabel lblImagen = new JLabel(asignarImagen(entrenador));
		lblImagen.setBounds(70, 100, 150, 150);
		lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
		add(lblImagen);
		add(pfondo);
	}
	
	public PanelTarjeta(Administrador admin, String rutaFondo, Properties prop) {
		setLayout(null);
		setPreferredSize(new java.awt.Dimension(640, 360));

		JLabel pfondo = new JLabel();
		try {
			BufferedImage fd = ImageIO.read(new File(rutaFondo));
			Image fdRedim = fd.getScaledInstance(640, 360, Image.SCALE_SMOOTH);
			pfondo.setIcon(new ImageIcon(fdRedim));
		} catch (IOException e) {
			System.err.println("Error cargando fondo del producto: " + e.getMessage());
		}
		pfondo.setBounds(0, 0, 640, 360);

		eliminar = new JButton();
		eliminar.setBounds(175, 275, 70, 20);
		eliminar.setFocusable(false);
		eliminar.setOpaque(false);
		eliminar.setBorderPainted(false);
		eliminar.setContentAreaFilled(false);
		eliminar.setBorder(null);
		add(eliminar);
		
		actualizar = new JButton();
		actualizar.setBounds(70, 275, 70, 20);
		actualizar.setFocusable(false);
		actualizar.setOpaque(false);
		actualizar.setBorderPainted(false);
		actualizar.setContentAreaFilled(false);
		actualizar.setBorder(null);
		add(actualizar);
		
		JLabel usuario = new JLabel(admin.getNombre());
		usuario.setBounds(350, 115, 200, 30);
		usuario.setFont(new Font("Arial", Font.BOLD, 15));
		usuario.setForeground(Color.WHITE);
		add(usuario);
		add(pfondo);
	}
	
	private ImageIcon asignarImagen(Jugador jugador) {
		try {
			String ruta = jugador.getImagen();
			ruta = ruta.replace("\\", "/"); // Convertir rutas Windows a formato válido
			BufferedImage fd = ImageIO.read(new File(ruta));
			Image fdRedim = fd.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
			return new ImageIcon(fdRedim);
		} catch (Exception e) {
			System.err.println("Error cargando imagen del jugador: " + e.getMessage());
			return null;
		}
	}
	
	private ImageIcon asignarImagen(Entrenador entrenador) {
		try {
			String ruta = entrenador.getImagen();
			ruta = ruta.replace("\\", "/"); // Convertir rutas Windows a formato válido
			BufferedImage fd = ImageIO.read(new File(ruta));
			Image fdRedim = fd.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
			return new ImageIcon(fdRedim);
		} catch (Exception e) {
			System.err.println("Error cargando imagen del jugador: " + e.getMessage());
			return null;
		}
	}

	public JButton getEliminar() {
		return eliminar;
	}

	public void setEliminar(JButton eliminar) {
		this.eliminar = eliminar;
	}

	public JButton getActualizar() {
		return actualizar;
	}

	public void setActualizar(JButton actualizar) {
		this.actualizar = actualizar;
	}
}