package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Clase que representa el panel para iniciar sesión. Permite al usuario
 * ingresar su nombre de usuario y contraseña.
 */
public class PanelIniciarSesion extends JPanel {

	/** Fondo del panel. */
	private JLabel fondo;
	/** Campo de texto para el nombre de usuario. */
	private JTextField nombreUsuario;
	/** Campo de texto para la contraseña. */
	private JPasswordField contrasena;
	/** Botón para volver al menú anterior. */
	private JButton btnVolver;
	/** Botón para ingresar a la aplicación. */
	private JButton btnIngresar;
	/** Etiqueta para el texto del nombre de usuario. */
	private JLabel textNombre;
	/** Etiqueta para el texto de la contraseña. */
	private JLabel textContra;
	/** Checkbox para mostrar la contraseña. */
	private JCheckBox mostrarContrasena;
	/** Propiedades para la configuración del panel. */
	private Properties prop;
	
	private JButton btnRegistrarse;

	/**
	 * Constructor que inicializa el panel para iniciar sesión.
	 * 
	 * @param prop Propiedades para configurar el panel.
	 * @throws IOException Si ocurre un error al cargar las imágenes.
	 */
	public PanelIniciarSesion() {
		setBounds(0, 0, 1290, 750);
		setLayout(null);

		fondo = new JLabel();
		fondo.setBounds(0, 0, 1290, 750);

		btnVolver = new JButton();
		btnVolver.setBounds(1070, 45, 150, 60);
		
//		btnVolver.setText("volver");
		btnVolver.setFocusable(false);
		btnVolver.setForeground(Color.black);
		btnVolver.setBackground(new Color(0, 0, 0,0));
		btnVolver.setOpaque(false);
        btnVolver.setBorderPainted(false);
        btnVolver.setBorder(null);
		btnVolver.setFont(new Font("Baloo", Font.BOLD, 26));
		add(btnVolver);
		
		btnRegistrarse = new JButton();
		btnRegistrarse.setBounds(870, 45, 150, 60);
//		btnRegistrarse.setText("Registrarse");
		btnRegistrarse.setFocusable(false);
		btnRegistrarse.setForeground(Color.black);
		btnRegistrarse.setBackground(new Color(0, 0, 0,0));
		btnRegistrarse.setOpaque(false);
        btnRegistrarse.setBorderPainted(false);
        btnRegistrarse.setContentAreaFilled(false); 
        btnRegistrarse.setBorder(null);
		btnRegistrarse.setFont(new Font("Baloo", Font.BOLD, 26));
		add(btnRegistrarse);


		btnIngresar = new JButton();
		btnIngresar.setBounds(910, 505, 150, 50);
//		btnIngresar.setText("ingresar");
		btnIngresar.setFocusable(false);
		btnIngresar.setForeground(Color.black);
		btnIngresar.setBackground(new Color(0, 0, 0,0));
		btnIngresar.setOpaque(false);
        btnIngresar.setBorderPainted(false);
//        btnIngresar.setContentAreaFilled(false);  no borrar :)
        btnIngresar.setBorder(null);
		btnIngresar.setFont(new Font("Baloo", Font.BOLD, 26));
		add(btnIngresar);

		nombreUsuario = new JTextField();
		nombreUsuario.setBounds(850, 325, 350, 50);
		nombreUsuario.setFont(new Font("Baloo", Font.BOLD, 20));
		add(nombreUsuario);

		contrasena = new JPasswordField();
		contrasena.setBounds(850, 420, 350, 50);
		contrasena.setFont(new Font("Baloo", Font.BOLD, 20));
		mostrarContrasena = new JCheckBox();
		mostrarContrasena.setBounds(1200, 430, 20, 20);
		mostrarContrasena.setOpaque(false);
		mostrarContrasena.setContentAreaFilled(false);
		mostrarContrasena.setBorderPainted(false);
		mostrarContrasena.setFocusPainted(false);
		add(mostrarContrasena);
		add(contrasena);
	
		textNombre = new JLabel();
		textNombre.setBounds(340, 300, 400, 60);
//		textNombre.setText("usuario");
		textNombre.setFont(new Font("Baloo", Font.BOLD, 26));
		add(textNombre);

		textContra = new JLabel();
		textContra.setBounds(324, 400, 400, 60);
//		textContra.setText("contrasena");
		textContra.setFont(new Font("Baloo", Font.BOLD, 26));
		add(textContra);

		ImageIcon icono = new ImageIcon("images/iniciarS.png");
		Image imagen = icono.getImage().getScaledInstance(1290, 750, Image.SCALE_SMOOTH);
		fondo = new JLabel(new ImageIcon(imagen));
		fondo.setBounds(0, 0, 1290, 750);
		add(fondo);

	}

	/**
	 * Obtiene el botón para registrarse .
	 * 
	 * @return Botón para resgistrarse.
	 */
	public JButton getBtnRegistrarse() {
		return btnRegistrarse;
	}
	/**
	 * Establece el botón para registrarse.
	 * 
	 * @param btnVolver Botón para registrarse.
	 */
	public void setBtnRegistrarse(JButton btnRegistrarse) {
		this.btnRegistrarse = btnRegistrarse;
	}

	/**
	 * Obtiene el fondo del panel.
	 * 
	 * @return Fondo del panel.
	 */
	public JLabel getFondo() {
		return fondo;
	}

	/**
	 * Establece el fondo del panel.
	 * 
	 * @param fondo Fondo del panel.
	 */
	public void setFondo(JLabel fondo) {
		this.fondo = fondo;
	}

	/**
	 * Obtiene el campo de texto para el nombre de usuario.
	 * 
	 * @return Campo de texto para el nombre de usuario.
	 */
	public JTextField getNombreUsuario() {
		return nombreUsuario;
	}

	/**
	 * Establece el campo de texto para el nombre de usuario.
	 * 
	 * @param nombreUsuario Campo de texto para el nombre de usuario.
	 */
	public void setNombreUsuario(JTextField nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	/**
	 * Obtiene la contraseña ingresada como texto.
	 * 
	 * @return Contraseña ingresada.
	 */
	public String getContrasena() {
		char[] con = contrasena.getPassword();
		return new String(con);
	}

	/**
	 * Obtiene el campo de texto para la contraseña.
	 * 
	 * @return Campo de texto para la contraseña.
	 */
	public JPasswordField getContrasenaF() {
		return this.contrasena;
	}

	/**
	 * Establece el campo de texto para la contraseña.
	 * 
	 * @param contrasena Campo de texto para la contraseña.
	 */
	public void setContrasena(JPasswordField contrasena) {
		this.contrasena = contrasena;
	}

	/**
	 * Obtiene el botón para volver al menú anterior.
	 * 
	 * @return Botón para volver al menú anterior.
	 */
	public JButton getBtnVolver() {
		return btnVolver;
	}

	/**
	 * Establece el botón para volver al menú anterior.
	 * 
	 * @param btnVolver Botón para volver al menú anterior.
	 */
	public void setBtnVolver(JButton btnVolver) {
		this.btnVolver = btnVolver;
	}

	/**
	 * Obtiene el botón para ingresar a la aplicación.
	 * 
	 * @return Botón para ingresar a la aplicación.
	 */
	public JButton getBtnIngresar() {
		return btnIngresar;
	}

	/**
	 * Establece el botón para ingresar a la aplicación.
	 * 
	 * @param btnIngresar Botón para ingresar a la aplicación.
	 */
	public void setBtnIngresar(JButton btnIngresar) {
		this.btnIngresar = btnIngresar;
	}

	/**
	 * Obtiene la etiqueta para el texto del nombre de usuario.
	 * 
	 * @return Etiqueta para el texto del nombre de usuario.
	 */
	public JLabel getTextNombre() {
		return textNombre;
	}

	/**
	 * Establece la etiqueta para el texto del nombre de usuario.
	 * 
	 * @param textNombre Etiqueta para el texto del nombre de usuario.
	 */
	public void setTextNombre(JLabel textNombre) {
		this.textNombre = textNombre;
	}

	/**
	 * Obtiene la etiqueta para el texto de la contraseña.
	 * 
	 * @return Etiqueta para el texto de la contraseña.
	 */
	public JLabel getTextContra() {
		return textContra;
	}

	/**
	 * Establece la etiqueta para el texto de la contraseña.
	 * 
	 * @param textContra Etiqueta para el texto de la contraseña.
	 */
	public void setTextContra(JLabel textContra) {
		this.textContra = textContra;
	}

	/**
	 * Obtiene el checkbox para mostrar la contraseña.
	 * 
	 * @return Checkbox para mostrar la contraseña.
	 */
	public JCheckBox getMostrarContrasena() {
		return mostrarContrasena;
	}

	/**
	 * Establece el checkbox para mostrar la contraseña.
	 * 
	 * @param mostrarContrasena Checkbox para mostrar la contraseña.
	 */
	public void setMostrarContrasena(JCheckBox mostrarContrasena) {
		this.mostrarContrasena = mostrarContrasena;
	}

	/**
	 * Obtiene las propiedades de configuración del panel.
	 * 
	 * @return Propiedades de configuración.
	 */
	public Properties getProp() {
		return prop;
	}

	/**
	 * Establece las propiedades de configuración del panel.
	 * 
	 * @param prop Propiedades de configuración.
	 */
	public void setProp(Properties prop) {
		this.prop = prop;
	}

}
