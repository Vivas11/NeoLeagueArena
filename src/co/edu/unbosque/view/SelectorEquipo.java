package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;

import co.edu.unbosque.model.Equipo;

/**
 * Ventana para seleccionar equipos de una lista disponible.
 * Permite al usuario seleccionar equipos de un JComboBox y agregarlos a una lista visual.
 * Incluye controles para agregar equipos y visualizar los seleccionados.
 */
public class SelectorEquipo extends JFrame {
    /** Propiedades de configuración utilizadas para cargar textos y recursos. */
    private Properties prop;
    /** ComboBox para seleccionar equipos disponibles. */
    private JComboBox<String> comboEquipos;
    /** Botón para agregar el equipo seleccionado a la lista. */
    private JButton btnAgregar;
    /** Modelo de lista para mostrar los equipos seleccionados. */
    private DefaultListModel<String> modeloLista;
    /** Lista visual de equipos seleccionados. */
    private JList<String> listaEquiposTexto;
    /** Lista interna de nombres de equipos seleccionados. */
    private ArrayList<String> listaEquipos;
    /** Scroll para la lista de equipos seleccionados. */
    private JScrollPane scrollPane;

    /**
     * Constructor de la ventana de selección de equipos.
     * 
     * @param equipos  Lista de equipos disponibles.
     * @param cantidad Cantidad máxima de equipos a seleccionar (no usado en la lógica actual).
     * @param prop     Propiedades de configuración para textos y recursos.
     */
    public SelectorEquipo(ArrayList<Equipo> equipos, int cantidad, Properties prop) {
        this.prop = prop;
        setLayout(null);
        setBounds(0, 0, 400, 300);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setResizable(false);

        JLabel lblSeleccionarEquipo = new JLabel(prop.getProperty("archivospropiedad.interfaz.seleccionarequipo"));
        lblSeleccionarEquipo.setFont(new Font("Arial", Font.BOLD, 14));
        lblSeleccionarEquipo.setBounds(20, 20, 150, 30);
        add(lblSeleccionarEquipo);

        comboEquipos = new JComboBox<>();
        for (Equipo equipo : equipos) {
            comboEquipos.addItem(equipo.getNombre());
        }
        comboEquipos.setBounds(20, 60, 200, 30);
        add(comboEquipos);

        btnAgregar = new JButton(prop.getProperty("archivospropiedad.interfaz.agregar"));
        btnAgregar.setBounds(240, 60, 100, 30);
        add(btnAgregar);

        modeloLista = new DefaultListModel<>();
        listaEquiposTexto = new JList<>(modeloLista);
        scrollPane = new JScrollPane(listaEquiposTexto);
        scrollPane.setBounds(20, 110, 320, 150);
        add(scrollPane);

        listaEquipos = new ArrayList<>();

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String equipoSeleccionado = (String) comboEquipos.getSelectedItem();
                if (equipoSeleccionado != null && !modeloLista.contains(equipoSeleccionado)) {
                    listaEquipos.add(equipoSeleccionado);
                    modeloLista.addElement(equipoSeleccionado);
                } else {
                    JOptionPane.showMessageDialog(null, prop.getProperty("archivospropiedad.emergente.equiponovalido"), "Advertencia", JOptionPane.WARNING_MESSAGE);
                }
            }
        });
        setVisible(true);
    }

    /**
     * Devuelve la lista de equipos seleccionados.
     * 
     * @return Lista de equipos seleccionados.
     */
    public ArrayList<String> getEquiposSeleccionados() {
        return this.listaEquipos;
    }

    public Properties getProp() {
        return prop;
    }

    public void setProp(Properties prop) {
        this.prop = prop;
    }

    public JComboBox<String> getComboEquipos() {
        return comboEquipos;
    }

    public void setComboEquipos(JComboBox<String> comboEquipos) {
        this.comboEquipos = comboEquipos;
    }

    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    public DefaultListModel<String> getModeloLista() {
        return modeloLista;
    }

    public void setModeloLista(DefaultListModel<String> modeloLista) {
        this.modeloLista = modeloLista;
    }

    public JList<String> getListaEquiposTexto() {
        return listaEquiposTexto;
    }

    public void setListaEquiposTexto(JList<String> listaEquiposTexto) {
        this.listaEquiposTexto = listaEquiposTexto;
    }

    public ArrayList<String> getListaEquipos() {
        return listaEquipos;
    }

    public void setListaEquipos(ArrayList<String> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }
}