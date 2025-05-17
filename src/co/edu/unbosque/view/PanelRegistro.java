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
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 * Clase que representa el panel para crear un usuario. Permite al usuario
 * ingresar un nombre de usuario y establecer una contraseña.
 */
public class PanelRegistro extends JPanel {
    /** Fondo del panel. */
    private JLabel fondo;
    /** Campo de texto para la primera contraseña. */
    private JPasswordField contrasena1;
    /** Campo de texto para la segunda contraseña (confirmación). */
    private JPasswordField contrasena2;
    /** Botón para volver al menú anterior. */
    private JButton btnVolver;
    /** Botón para confirmar la creación del usuario. */
    private JButton btnRegistrar;
    /** Checkbox para mostrar la primera contraseña. */
    private JCheckBox mostrarContrasena;
    /** Checkbox para mostrar la segunda contraseña. */
    private JCheckBox mostrarContrasena2;
    /** Propiedades para la configuración del panel. */
    private Properties prop;
    /** Campo de texto para el correo electrónico. */
    private JTextField txtCorreo;
    /** Campo de texto para el país. */
    private JTextField txtPais;
    /** Campo de texto para la ciudad. */
    private JTextField txtCiudad;
    /** Campo de texto para el nombre de usuario. */
    private JTextField nombreUsuario;
    /** ComboBox para seleccionar el tipo de usuario. */
    private JComboBox<String> cbxTipoUsuario;

    /**
     * Constructor que inicializa el panel para crear un usuario.
     * 
     * @param prop Propiedades para configurar el panel.
     * @throws IOException Si ocurre un error al cargar las imágenes.
     */
    public PanelRegistro(Properties prop) throws IOException {
        this.prop = prop;
        setBounds(0, 0, 1280, 720);
        setLayout(null);

        btnVolver = new JButton();
        btnVolver.setBounds(1070, 25, 150, 60);

        btnVolver.setFocusable(false);
        btnVolver.setForeground(Color.black);
        btnVolver.setBackground(new Color(0, 0, 0, 0));
        btnVolver.setOpaque(false);
        btnVolver.setBorderPainted(false);
        btnVolver.setContentAreaFilled(false);
        btnVolver.setBorder(null);
        btnVolver.setFont(new Font("Baloo", Font.BOLD, 26));
        add(btnVolver);

        btnRegistrar = new JButton();
        btnRegistrar.setBounds(305, 580, 150, 50);

        btnRegistrar.setFocusable(false);
        btnRegistrar.setContentAreaFilled(false);
        btnRegistrar.setForeground(Color.black);
        btnRegistrar.setBackground(new Color(00, 150, 50));
        btnRegistrar.setFont(new Font("Baloo", Font.BOLD, 26));
        btnRegistrar.setBorder(null);
        btnRegistrar.setBorderPainted(false);
        btnRegistrar.setOpaque(false);
        add(btnRegistrar);

        nombreUsuario = new JTextField();
        nombreUsuario.setBounds(250, 205, 400, 50);
        nombreUsuario.setFont(new Font("Baloo", Font.BOLD, 20));
        add(nombreUsuario);

        txtCiudad = new JTextField();
        txtCiudad.setBounds(250, 260, 400, 50);
        txtCiudad.setFont(new Font("Baloo", Font.BOLD, 20));
        add(txtCiudad);

        txtPais = new JTextField();
        txtPais.setBounds(250, 315, 400, 50);
        txtPais.setFont(new Font("Baloo", Font.BOLD, 20));
        add(txtPais);

        txtCorreo = new JTextField();
        txtCorreo.setBounds(250, 370, 400, 50);
        txtCorreo.setFont(new Font("Baloo", Font.BOLD, 20));
        add(txtCorreo);

        String[] usuario = { "Tipo de usuario", "Administrador", "Jugador", "Entrenador" };

        cbxTipoUsuario = new JComboBox<>(usuario);
        cbxTipoUsuario.setFont(new Font("Baloo", Font.BOLD, 20));
        cbxTipoUsuario.setBounds(250, 425, 400, 50);
        cbxTipoUsuario.setSelectedIndex(0);
        add(cbxTipoUsuario);

        contrasena1 = new JPasswordField();
        contrasena1.setBounds(250, 480, 400, 50);
        contrasena1.setFont(new Font("Baloo", Font.BOLD, 20));
        add(contrasena1);

        contrasena2 = new JPasswordField();
        contrasena2.setBounds(250, 535, 400, 50);
        contrasena2.setFont(new Font("Baloo", Font.BOLD, 20));
        add(contrasena2);

        mostrarContrasena = new JCheckBox();
        mostrarContrasena.setBounds(660, 500, 20, 20);
        mostrarContrasena.setOpaque(false);
        mostrarContrasena.setContentAreaFilled(false);
        mostrarContrasena.setBorderPainted(false);
        mostrarContrasena.setFocusPainted(false);
        add(mostrarContrasena);

        mostrarContrasena2 = new JCheckBox();
        mostrarContrasena2.setBounds(660, 555, 20, 20);
        mostrarContrasena2.setOpaque(false);
        mostrarContrasena2.setContentAreaFilled(false);
        mostrarContrasena2.setBorderPainted(false);
        mostrarContrasena2.setFocusPainted(false);
        add(mostrarContrasena2);

        fondo = new JLabel();
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.registro")));
        ImageIcon imagenFondo = new ImageIcon(fd);
        Image fdRedim = fd.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        fondo.setIcon(new ImageIcon(fdRedim));
        fondo.setBounds(0, 0, 1280, 720);
        add(fondo);
    }

    /**
     * Actualiza los componentes del panel con base en las propiedades.
     * 
     * @throws IOException Si ocurre un error al cargar las imágenes.
     */
    public void actualizarComp() throws IOException {
        BufferedImage fd = ImageIO.read(new File(prop.getProperty("archivospropiedad.fondo.registro")));
        ImageIcon imagenFondo = new ImageIcon(fd);
        Image fdRedim = fd.getScaledInstance(1280, 720, Image.SCALE_SMOOTH);
        fondo.setIcon(new ImageIcon(fdRedim));
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
     * Obtiene el correo electrónico ingresado.
     * 
     * @return Correo electrónico ingresado.
     */
    public String getTxtCorreo() {
        return txtCorreo.getText();
    }

    /**
     * Establece el campo de texto para el correo electrónico.
     * 
     * @param txtCorreo Campo de texto para el correo electrónico.
     */
    public void setTxtCorreo(JTextField txtCorreo) {
        this.txtCorreo = txtCorreo;
    }

    /**
     * Establece el botón para registrar usuario.
     * 
     * @param btnRegistrar Botón para registrar usuario.
     */
    public void setBtnRegistrar(JButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    /**
     * Obtiene el ComboBox para seleccionar el tipo de usuario.
     * 
     * @return ComboBox de tipo de usuario.
     */
    public JComboBox<String> getCbxTipoUsuario() {
        return cbxTipoUsuario;
    }

    /**
     * Establece el ComboBox para seleccionar el tipo de usuario.
     * 
     * @param cbxTipoUsuario ComboBox de tipo de usuario.
     */
    public void setCbxTipoUsuario(JComboBox<String> cbxTipoUsuario) {
        this.cbxTipoUsuario = cbxTipoUsuario;
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
     * Obtiene el nombre de usuario ingresado.
     * 
     * @return Nombre de usuario ingresado.
     */
    public String getNombreUsuario() {
        return nombreUsuario.getText();
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
     * Obtiene la primera contraseña ingresada como texto.
     * 
     * @return Primera contraseña ingresada.
     */
    public String getContrasena1() {
        char[] contrasena = contrasena1.getPassword();
        return new String(contrasena);
    }

    /**
     * Establece el campo de texto para la primera contraseña.
     * 
     * @param contrasena1 Campo de texto para la primera contraseña.
     */
    public void setContrasena1(JPasswordField contrasena1) {
        this.contrasena1 = contrasena1;
    }

    /**
     * Obtiene la segunda contraseña ingresada como texto.
     * 
     * @return Segunda contraseña ingresada.
     */
    public String getContrasena2() {
        char[] contrasena = contrasena2.getPassword();
        return new String(contrasena);
    }

    /**
     * Obtiene el campo de texto para la segunda contraseña.
     * 
     * @return Campo de texto para la segunda contraseña.
     */
    public JPasswordField getContrasena2F() {
        return this.contrasena2;
    }

    /**
     * Establece el campo de texto para la segunda contraseña.
     * 
     * @param contrasena2 Campo de texto para la segunda contraseña.
     */
    public void setContrasena2(JPasswordField contrasena2) {
        this.contrasena2 = contrasena2;
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
     * Obtiene el botón para confirmar la creación del usuario.
     * 
     * @return Botón para confirmar la creación del usuario.
     */
    public JButton getBtnRegistrar() {
        return btnRegistrar;
    }

    /**
     * Obtiene el campo de texto para la primera contraseña.
     * 
     * @return Campo de texto para la primera contraseña.
     */
    public JPasswordField getContrasena1F() {
        return this.contrasena1;
    }

    /**
     * Establece el botón para confirmar la creación del usuario.
     * 
     * @param btnRegistrar Botón para confirmar la creación del usuario.
     */
    public void setBtnResgistrar(JButton btnRegistrar) {
        this.btnRegistrar = btnRegistrar;
    }

    /**
     * Obtiene el checkbox para mostrar la primera contraseña.
     * 
     * @return Checkbox para mostrar la primera contraseña.
     */
    public JCheckBox getMostrarContrasena() {
        return mostrarContrasena;
    }

    /**
     * Establece el checkbox para mostrar la primera contraseña.
     * 
     * @param mostrarContrasena Checkbox para mostrar la primera contraseña.
     */
    public void setMostrarContrasena(JCheckBox mostrarContrasena) {
        this.mostrarContrasena = mostrarContrasena;
    }

    /**
     * Obtiene el checkbox para mostrar la segunda contraseña.
     * 
     * @return Checkbox para mostrar la segunda contraseña.
     */
    public JCheckBox getMostrarContrasena2() {
        return mostrarContrasena2;
    }

    /**
     * Obtiene el campo de texto para el país.
     * 
     * @return Campo de texto para el país.
     */
    public JTextField getTxtPais() {
        return txtPais;
    }

    /**
     * Establece el campo de texto para el país.
     * 
     * @param txtPais Campo de texto para el país.
     */
    public void setTxtPais(JTextField txtPais) {
        this.txtPais = txtPais;
    }

    /**
     * Obtiene el campo de texto para la ciudad.
     * 
     * @return Campo de texto para la ciudad.
     */
    public JTextField getTxtCiudad() {
        return txtCiudad;
    }

    /**
     * Establece el campo de texto para la ciudad.
     * 
     * @param txtCiudad Campo de texto para la ciudad.
     */
    public void setTxtCiudad(JTextField txtCiudad) {
        this.txtCiudad = txtCiudad;
    }

    /**
     * Establece el checkbox para mostrar la segunda contraseña.
     * 
     * @param mostrarContrasena2 Checkbox para mostrar la segunda contraseña.
     */
    public void setMostrarContrasena2(JCheckBox mostrarContrasena2) {
        this.mostrarContrasena2 = mostrarContrasena2;
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
