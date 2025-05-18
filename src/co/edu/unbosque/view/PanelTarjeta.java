package co.edu.unbosque.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Properties;
import java.text.SimpleDateFormat;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;

import co.edu.unbosque.model.Administrador;
import co.edu.unbosque.model.Entrenador;
import co.edu.unbosque.model.Equipo;
import co.edu.unbosque.model.Jugador;
import co.edu.unbosque.model.Partida;
import co.edu.unbosque.model.Torneo;

/**
 * Panel reutilizable para mostrar información de entidades como Jugador, Entrenador, Administrador, Equipo, Partida o Torneo.
 * Incluye botones de acción y componentes gráficos personalizados según el tipo de entidad.
 * Se utiliza en diferentes vistas para mostrar tarjetas de información y permitir acciones como eliminar, actualizar, ingresar, salir, confirmar o ver tabla.
 */
public class PanelTarjeta extends JPanel {

    /** Botón para eliminar la entidad mostrada en la tarjeta. */
    private JButton eliminar, actualizar, ingresar, salir, confirmar, verTabla;
    /** Referencia a la partida asociada (si aplica). */
    private Partida partida;
    /** Spinner para el puntaje del equipo A (si aplica). */
    private JSpinner e1;
    /** Spinner para el puntaje del equipo B (si aplica). */
    private JSpinner e2;

    /**
     * Crea una tarjeta para mostrar información de un jugador.
     * @param jugador Jugador a mostrar.
     * @param rutaFondo Ruta de la imagen de fondo.
     * @param prop Propiedades de configuración.
     */
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
            equipo = new JLabel(prop.getProperty("archivospropiedad.interfaz.noequipo"));
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

    /**
     * Crea una tarjeta para mostrar información de un jugador con botones de acción.
     * @param jugador Jugador a mostrar.
     * @param rutaFondo Ruta de la imagen de fondo.
     * @param prop Propiedades de configuración.
     * @param a Indica si se muestran botones de acción.
     */
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
            equipo = new JLabel(prop.getProperty("archivospropiedad.interfaz.noequipo"));
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

    /**
     * Crea una tarjeta para mostrar información de un entrenador con botones de acción.
     * @param entrenador Entrenador a mostrar.
     * @param rutaFondo Ruta de la imagen de fondo.
     * @param prop Propiedades de configuración.
     * @param a Indica si se muestran botones de acción.
     */
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
            equipo = new JLabel(prop.getProperty("archivospropiedad.interfaz.noequipo"));
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

    /**
     * Crea una tarjeta para mostrar información de un administrador con botones de acción.
     * @param admin Administrador a mostrar.
     * @param rutaFondo Ruta de la imagen de fondo.
     * @param prop Propiedades de configuración.
     */
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

        BufferedImage fd;
        try {
            fd = ImageIO.read(new File("src/Archivos/imagenperfil/adminIcon.png"));
            Image fdRedim = fd.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            ImageIcon ic = new ImageIcon(fdRedim);
            JLabel lblImagen = new JLabel(ic);
            lblImagen.setBounds(70, 100, 150, 150);
            lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
            add(lblImagen);
        } catch (IOException e) {
        }

        add(pfondo);
    }

    /**
     * Crea una tarjeta para mostrar información de un equipo con botones de ingresar y salir.
     * @param equipo Equipo a mostrar.
     * @param rutaFondo Ruta de la imagen de fondo.
     * @param prop Propiedades de configuración.
     */
    public PanelTarjeta(Equipo equipo, String rutaFondo, Properties prop) {
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

        JLabel lblImagen = new JLabel(asignarImagen(equipo));
        lblImagen.setBounds(70, 100, 150, 150);
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblImagen);

        JLabel nombre = new JLabel(equipo.getNombre());
        nombre.setBounds(370, 132, 200, 30);
        nombre.setFont(new Font("Arial", Font.BOLD, 15));
        nombre.setForeground(Color.WHITE);
        add(nombre);

        JLabel pais = new JLabel(equipo.getPais());
        pais.setBounds(325, 193, 200, 30);
        pais.setFont(new Font("Arial", Font.BOLD, 15));
        pais.setForeground(Color.WHITE);
        add(pais);

        JLabel entrenador;
        try {
            entrenador = new JLabel(equipo.getEntrenador().getNombre());
        } catch (Exception e) {
            entrenador = new JLabel(prop.getProperty("archivospropiedad.interfaz.noentrenador"));
        }
        entrenador.setBounds(375, 255, 300, 30);
        entrenador.setFont(new Font("Arial", Font.BOLD, 15));
        entrenador.setForeground(Color.WHITE);
        add(entrenador);

        ingresar = new JButton();
        ingresar.setBounds(70, 275, 70, 20);
        ingresar.setFocusable(false);
        ingresar.setOpaque(false);
        ingresar.setBorderPainted(false);
        ingresar.setContentAreaFilled(false);
        ingresar.setBorder(null);
        add(ingresar);

        salir = new JButton();
        salir.setBounds(175, 275, 70, 20);
        salir.setFocusable(false);
        salir.setOpaque(false);
        salir.setBorderPainted(false);
        salir.setContentAreaFilled(false);
        salir.setBorder(null);
        add(salir);

        add(pfondo);
    }

    /**
     * Crea una tarjeta para mostrar información de un equipo con botones de acción para administración.
     * @param equipo Equipo a mostrar.
     * @param rutaFondo Ruta de la imagen de fondo.
     * @param prop Propiedades de configuración.
     * @param admin Indica si se muestran botones de administración.
     */
    public PanelTarjeta(Equipo equipo, String rutaFondo, Properties prop, Boolean admin) {
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

        JLabel lblImagen = new JLabel(asignarImagen(equipo));
        lblImagen.setBounds(70, 100, 150, 150);
        lblImagen.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblImagen);

        JLabel nombre = new JLabel(equipo.getNombre());
        nombre.setBounds(370, 132, 200, 30);
        nombre.setFont(new Font("Arial", Font.BOLD, 15));
        nombre.setForeground(Color.WHITE);
        add(nombre);

        JLabel pais = new JLabel(equipo.getPais());
        pais.setBounds(325, 193, 200, 30);
        pais.setFont(new Font("Arial", Font.BOLD, 15));
        pais.setForeground(Color.WHITE);
        add(pais);

        JLabel entrenador;
        try {
            entrenador = new JLabel(equipo.getEntrenador().getNombre());
        } catch (Exception e) {
            entrenador = new JLabel(prop.getProperty("archivospropiedad.interfaz.noentrenador"));
        }
        entrenador.setBounds(375, 255, 300, 30);
        entrenador.setFont(new Font("Arial", Font.BOLD, 15));
        entrenador.setForeground(Color.WHITE);
        add(entrenador);

        actualizar = new JButton();
        actualizar.setBounds(70, 275, 70, 20);
        actualizar.setFocusable(false);
        actualizar.setOpaque(false);
        actualizar.setBorderPainted(false);
        actualizar.setContentAreaFilled(false);
        actualizar.setBorder(null);
        add(actualizar);

        eliminar = new JButton();
        eliminar.setBounds(175, 275, 70, 20);
        eliminar.setFocusable(false);
        eliminar.setOpaque(false);
        eliminar.setBorderPainted(false);
        eliminar.setContentAreaFilled(false);
        eliminar.setBorder(null);
        add(eliminar);

        add(pfondo);
    }

    /**
     * Crea una tarjeta para mostrar información de una partida con spinners para puntajes y botón de confirmar.
     * @param partida Partida a mostrar.
     * @param rutaFondo Ruta de la imagen de fondo.
     */
    public PanelTarjeta(Partida partida, String rutaFondo) {
        setLayout(null);
        setPreferredSize(new java.awt.Dimension(640, 360));
        this.partida = partida;

        JLabel pfondo = new JLabel();
        try {
            BufferedImage fd = ImageIO.read(new File(rutaFondo));
            Image fdRedim = fd.getScaledInstance(640, 360, Image.SCALE_SMOOTH);
            pfondo.setIcon(new ImageIcon(fdRedim));
        } catch (IOException e) {
            System.err.println("Error cargando fondo del producto: " + e.getMessage());
        }
        pfondo.setBounds(0, 0, 640, 360);

        JLabel lblTorneo = new JLabel(partida.getTor().getNombre());
        lblTorneo.setBounds(215, 205, 400, 25);
        lblTorneo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTorneo.setForeground(Color.WHITE);
        add(lblTorneo);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH");
        String fechaFormateada = sdf.format(partida.getFecha());
        JLabel lblFecha = new JLabel(fechaFormateada + ":00[America/Bogota]");
        lblFecha.setBounds(205, 158, 400, 25);
        lblFecha.setFont(new Font("Arial", Font.BOLD, 14));
        lblFecha.setForeground(Color.WHITE);
        add(lblFecha);

        JLabel equipoA = new JLabel(partida.getEquipoA().getNombre());
        equipoA.setBounds(220, 60, 200, 30);
        equipoA.setFont(new Font("Arial", Font.BOLD, 15));
        equipoA.setForeground(Color.WHITE);
        add(equipoA);

        JLabel equipoB = new JLabel(partida.getEquipoB().getNombre());
        equipoB.setBounds(220, 108, 200, 30);
        equipoB.setFont(new Font("Arial", Font.BOLD, 15));
        equipoB.setForeground(Color.WHITE);
        add(equipoB);

        int valorA = partida.getPuntajeEquipoA();
        boolean editableA = valorA == -1;
        e1 = new JSpinner(new SpinnerNumberModel(editableA ? 0 : valorA, 0, Integer.MAX_VALUE, 1));
        e1.setBounds(230, 300, 40, 20);
        e1.setFont(new Font("Arial", Font.BOLD, 15));
        e1.setEnabled(editableA);
        add(e1);

        int valorB = partida.getPuntajeEquipoB();
        boolean editableB = valorB == -1;
        e2 = new JSpinner(new SpinnerNumberModel(editableB ? 0 : valorB, 0, Integer.MAX_VALUE, 1));
        e2.setBounds(390, 300, 40, 20);
        e2.setFont(new Font("Arial", Font.BOLD, 15));
        e2.setEnabled(editableB);
        add(e2);

        confirmar = new JButton();
        confirmar.setBounds(280, 320, 85, 25);
        confirmar.setFocusable(false);
        confirmar.setOpaque(false);
        confirmar.setBorderPainted(false);
        confirmar.setContentAreaFilled(false);
        confirmar.setBorder(null);
        add(confirmar);

        add(pfondo);
    }

    /**
     * Crea una tarjeta para mostrar información de una partida con botones de acción para administración.
     * @param partida Partida a mostrar.
     * @param rutaFondo Ruta de la imagen de fondo.
     * @param prop Propiedades de configuración.
     * @param a Indica si se muestran botones de acción.
     */
    public PanelTarjeta(Partida partida, String rutaFondo, Properties prop, Boolean a) {
        setLayout(null);
        setPreferredSize(new java.awt.Dimension(640, 360));
        this.partida = partida;

        JLabel pfondo = new JLabel();
        try {
            BufferedImage fd = ImageIO.read(new File(rutaFondo));
            Image fdRedim = fd.getScaledInstance(640, 360, Image.SCALE_SMOOTH);
            pfondo.setIcon(new ImageIcon(fdRedim));
        } catch (IOException e) {
            System.err.println("Error cargando fondo del producto: " + e.getMessage());
        }
        pfondo.setBounds(0, 0, 640, 360);

        JLabel lblTorneo = new JLabel(partida.getTor().getNombre());
        lblTorneo.setBounds(215, 205, 400, 25);
        lblTorneo.setFont(new Font("Arial", Font.BOLD, 16));
        lblTorneo.setForeground(Color.WHITE);
        add(lblTorneo);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH");
        String fechaFormateada = sdf.format(partida.getFecha());
        JLabel lblFecha = new JLabel(fechaFormateada + ":00[America/Bogota]");
        lblFecha.setBounds(205, 158, 400, 25);
        lblFecha.setFont(new Font("Arial", Font.BOLD, 14));
        lblFecha.setForeground(Color.WHITE);
        add(lblFecha);

        JLabel equipoA = new JLabel(partida.getEquipoA().getNombre());
        equipoA.setBounds(220, 60, 200, 30);
        equipoA.setFont(new Font("Arial", Font.BOLD, 15));
        equipoA.setForeground(Color.WHITE);
        add(equipoA);

        JLabel equipoB = new JLabel(partida.getEquipoB().getNombre());
        equipoB.setBounds(220, 108, 200, 30);
        equipoB.setFont(new Font("Arial", Font.BOLD, 15));
        equipoB.setForeground(Color.WHITE);
        add(equipoB);

        int valorA = partida.getPuntajeEquipoA();
        boolean editableA = valorA == -1;
        e1 = new JSpinner(new SpinnerNumberModel(editableA ? 0 : valorA, 0, Integer.MAX_VALUE, 1));
        e1.setBounds(230, 300, 40, 20);
        e1.setFont(new Font("Arial", Font.BOLD, 15));
        e1.setEnabled(false);
        add(e1);

        int valorB = partida.getPuntajeEquipoB();
        boolean editableB = valorB == -1;
        e2 = new JSpinner(new SpinnerNumberModel(editableB ? 0 : valorB, 0, Integer.MAX_VALUE, 1));
        e2.setBounds(390, 300, 40, 20);
        e2.setFont(new Font("Arial", Font.BOLD, 15));
        e2.setEnabled(false);
        add(e2);

        actualizar = new JButton();
        actualizar.setBounds(280, 320, 85, 25);
        actualizar.setFocusable(false);
        actualizar.setOpaque(false);
        actualizar.setBorderPainted(false);
        actualizar.setContentAreaFilled(false);
        actualizar.setBorder(null);
        add(actualizar);

        eliminar = new JButton();
        eliminar.setBounds(280, 280, 85, 25);
        eliminar.setFocusable(false);
        eliminar.setOpaque(false);
        eliminar.setBorderPainted(false);
        eliminar.setContentAreaFilled(false);
        eliminar.setBorder(null);
        add(eliminar);

        add(pfondo);
    }

    /**
     * Crea una tarjeta para mostrar información de un torneo con botón para ver tabla.
     * @param torneo Torneo a mostrar.
     * @param rutaFondo Ruta de la imagen de fondo.
     * @param prop Propiedades de configuración.
     */
    public PanelTarjeta(Torneo torneo, String rutaFondo, Properties prop) {
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

        JLabel lblNombre = new JLabel(torneo.getNombre());
        lblNombre.setBounds(125, 35, 400, 30);
        lblNombre.setFont(new Font("Arial", Font.BOLD, 18));
        lblNombre.setForeground(Color.WHITE);
        add(lblNombre);

        JLabel lblJuego = new JLabel(torneo.getJuego());
        lblJuego.setBounds(115, 85, 400, 25);
        lblJuego.setFont(new Font("Arial", Font.BOLD, 15));
        lblJuego.setForeground(Color.WHITE);
        add(lblJuego);

        String ganador = (torneo.getGanador() != null) ? torneo.getGanador().getNombre() : prop.getProperty("archivospropiedad.interfaz.torneocurso");
        JLabel lblGanador = new JLabel(ganador);
        lblGanador.setBounds(130, 130, 400, 25);
        lblGanador.setFont(new Font("Arial", Font.BOLD, 15));
        lblGanador.setForeground(Color.WHITE);
        add(lblGanador);

        String tipo = (torneo instanceof co.edu.unbosque.model.TorneoLiga) ? prop.getProperty("archivospropiedad.interfaz.liga") : prop.getProperty("archivospropiedad.interfaz.eliminaciondirecta");
        JLabel lblTipo = new JLabel(tipo);
        lblTipo.setBounds(120, 180, 400, 25);
        lblTipo.setFont(new Font("Arial", Font.BOLD, 15));
        lblTipo.setForeground(Color.WHITE);
        add(lblTipo);

        JLabel lblEquipos = new JLabel(torneo.getEquipos().size() + "");
        lblEquipos.setBounds(125, 230, 550, 25);
        lblEquipos.setFont(new Font("Arial", Font.BOLD, 15));
        lblEquipos.setForeground(Color.WHITE);
        add(lblEquipos);

        verTabla = new JButton();
        verTabla.setBounds(450, 130, 150, 40);
        verTabla.setFocusable(false);
        verTabla.setOpaque(false);
        verTabla.setBorderPainted(false);
        verTabla.setContentAreaFilled(false);
        verTabla.setBorder(null);
        add(verTabla);

        add(pfondo);
    }

    /**
     * Crea una tarjeta para mostrar información de un torneo con botón para eliminar (administración).
     * @param torneo Torneo a mostrar.
     * @param rutaFondo Ruta de la imagen de fondo.
     * @param prop Propiedades de configuración.
     * @param admin Indica si se muestran botones de administración.
     */
    public PanelTarjeta(Torneo torneo, String rutaFondo, Properties prop, boolean admin) {
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

        JLabel lblNombre = new JLabel(torneo.getNombre());
        lblNombre.setBounds(125, 35, 400, 30);
        lblNombre.setFont(new Font("Arial", Font.BOLD, 18));
        lblNombre.setForeground(Color.WHITE);
        add(lblNombre);

        JLabel lblJuego = new JLabel(torneo.getJuego());
        lblJuego.setBounds(115, 85, 400, 25);
        lblJuego.setFont(new Font("Arial", Font.PLAIN, 15));
        lblJuego.setForeground(Color.WHITE);
        add(lblJuego);

        String ganador = (torneo.getGanador() != null) ? torneo.getGanador().getNombre() : prop.getProperty("archivospropiedad.interfaz.torneocurso");
        JLabel lblGanador = new JLabel(ganador);
        lblGanador.setBounds(130, 133, 400, 25);
        lblGanador.setFont(new Font("Arial", Font.PLAIN, 15));
        lblGanador.setForeground(Color.WHITE);
        add(lblGanador);

        String tipo = (torneo instanceof co.edu.unbosque.model.TorneoLiga) ? prop.getProperty("archivospropiedad.interfaz.liga") : prop.getProperty("archivospropiedad.interfaz.eliminaciondirecta");
        JLabel lblTipo = new JLabel(tipo);
        lblTipo.setBounds(115, 182, 400, 25);
        lblTipo.setFont(new Font("Arial", Font.PLAIN, 15));
        lblTipo.setForeground(Color.WHITE);
        add(lblTipo);

        JLabel lblEquipos = new JLabel(torneo.getEquipos().size() + "");
        lblEquipos.setBounds(125, 230, 550, 25);
        lblEquipos.setFont(new Font("Arial", Font.PLAIN, 15));
        lblEquipos.setForeground(Color.WHITE);
        add(lblEquipos);

        eliminar = new JButton();
        eliminar.setBounds(450, 130, 150, 40);
        eliminar.setFocusable(false);
        eliminar.setOpaque(false);
        eliminar.setBorderPainted(false);
        eliminar.setContentAreaFilled(false);
        eliminar.setBorder(null);
        add(eliminar);

        add(pfondo);
    }

    /**
     * Asigna la imagen de perfil a un jugador.
     * @param jugador Jugador del que se obtiene la imagen.
     * @return ImageIcon de la imagen asignada.
     */
    public ImageIcon asignarImagen(Jugador jugador) {
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

    /**
     * Asigna la imagen de perfil a un entrenador.
     * @param entrenador Entrenador del que se obtiene la imagen.
     * @return ImageIcon de la imagen asignada.
     */
    public ImageIcon asignarImagen(Entrenador entrenador) {
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

    /**
     * Asigna la imagen de perfil a un equipo.
     * @param equipo Equipo del que se obtiene la imagen.
     * @return ImageIcon de la imagen asignada.
     */
    public ImageIcon asignarImagen(Equipo equipo) {
        try {
            String ruta = equipo.getImagen();
            ruta = ruta.replace("\\", "/"); // Convertir rutas Windows a formato válido
            BufferedImage fd = ImageIO.read(new File(ruta));
            Image fdRedim = fd.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
            return new ImageIcon(fdRedim);
        } catch (Exception e) {
            System.err.println("Error cargando imagen del equipo: " + e.getMessage());
            return null;
        }
    }

    /**
     * Obtiene el botón para eliminar la entidad.
     * @return JButton de eliminar.
     */
    public JButton getEliminar() {
        return eliminar;
    }

    /**
     * Establece el botón para eliminar la entidad.
     * @param eliminar JButton a establecer.
     */
    public void setEliminar(JButton eliminar) {
        this.eliminar = eliminar;
    }

    /**
     * Obtiene el botón para actualizar la entidad.
     * @return JButton de actualizar.
     */
    public JButton getActualizar() {
        return actualizar;
    }

    /**
     * Establece el botón para actualizar la entidad.
     * @param actualizar JButton a establecer.
     */
    public void setActualizar(JButton actualizar) {
        this.actualizar = actualizar;
    }

    /**
     * Obtiene el botón para ingresar a un equipo.
     * @return JButton de ingresar.
     */
    public JButton getIngresar() {
        return ingresar;
    }

    /**
     * Establece el botón para ingresar a un equipo.
     * @param ingresar JButton a establecer.
     */
    public void setIngresar(JButton ingresar) {
        this.ingresar = ingresar;
    }

    /**
     * Obtiene el botón para salir de un equipo.
     * @return JButton de salir.
     */
    public JButton getSalir() {
        return salir;
    }

    /**
     * Establece el botón para salir de un equipo.
     * @param salir JButton a establecer.
     */
    public void setSalir(JButton salir) {
        this.salir = salir;
    }

    /**
     * Obtiene el botón para confirmar el resultado de una partida.
     * @return JButton de confirmar.
     */
    public JButton getConfirmar() {
        return confirmar;
    }

    /**
     * Establece el botón para confirmar el resultado de una partida.
     * @param confirmar JButton a establecer.
     */
    public void setConfirmar(JButton confirmar) {
        this.confirmar = confirmar;
    }

    /**
     * Obtiene la partida asociada a la tarjeta.
     * @return Partida asociada.
     */
    public Partida getPartida() {
        return partida;
    }

    /**
     * Establece la partida asociada a la tarjeta.
     * @param partida Partida a establecer.
     */
    public void setPartida(Partida partida) {
        this.partida = partida;
    }

    /**
     * Obtiene el spinner para el puntaje del equipo A.
     * @return JSpinner para equipo A.
     */
    public JSpinner getE1() {
        return e1;
    }

    /**
     * Establece el spinner para el puntaje del equipo A.
     * @param e1 JSpinner a establecer.
     */
    public void setE1(JSpinner e1) {
        this.e1 = e1;
    }

    /**
     * Obtiene el spinner para el puntaje del equipo B.
     * @return JSpinner para equipo B.
     */
    public JSpinner getE2() {
        return e2;
    }

    /**
     * Establece el spinner para el puntaje del equipo B.
     * @param e2 JSpinner a establecer.
     */
    public void setE2(JSpinner e2) {
        this.e2 = e2;
    }

    /**
     * Obtiene el botón para ver la tabla del torneo.
     * @return JButton de ver tabla.
     */
    public JButton getVerTabla() {
        return verTabla;
    }

    /**
     * Establece el botón para ver la tabla del torneo.
     * @param verTabla JButton a establecer.
     */
    public void setVerTabla(JButton verTabla) {
        this.verTabla = verTabla;
    }
}