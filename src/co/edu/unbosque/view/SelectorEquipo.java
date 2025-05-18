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

    /**
     * Obtiene las propiedades de configuración.
     * @return Properties utilizadas por la ventana.
     */
    public Properties getProp() {
        return prop;
    }

    /**
     * Establece las propiedades de configuración.
     * @param prop Properties a establecer.
     */
    public void setProp(Properties prop) {
        this.prop = prop;
    }

    /**
     * Obtiene el ComboBox de equipos.
     * @return JComboBox de equipos.
     */
    public JComboBox<String> getComboEquipos() {
        return comboEquipos;
    }

    /**
     * Establece el ComboBox de equipos.
     * @param comboEquipos JComboBox a establecer.
     */
    public void setComboEquipos(JComboBox<String> comboEquipos) {
        this.comboEquipos = comboEquipos;
    }

    /**
     * Obtiene el botón para agregar equipos.
     * @return JButton de agregar.
     */
    public JButton getBtnAgregar() {
        return btnAgregar;
    }

    /**
     * Establece el botón para agregar equipos.
     * @param btnAgregar JButton a establecer.
     */
    public void setBtnAgregar(JButton btnAgregar) {
        this.btnAgregar = btnAgregar;
    }

    /**
     * Obtiene el modelo de la lista de equipos seleccionados.
     * @return DefaultListModel de la lista.
     */
    public DefaultListModel<String> getModeloLista() {
        return modeloLista;
    }

    /**
     * Establece el modelo de la lista de equipos seleccionados.
     * @param modeloLista DefaultListModel a establecer.
     */
    public void setModeloLista(DefaultListModel<String> modeloLista) {
        this.modeloLista = modeloLista;
    }

    /**
     * Obtiene la lista visual de equipos seleccionados.
     * @return JList de equipos seleccionados.
     */
    public JList<String> getListaEquiposTexto() {
        return listaEquiposTexto;
    }

    /**
     * Establece la lista visual de equipos seleccionados.
     * @param listaEquiposTexto JList a establecer.
     */
    public void setListaEquiposTexto(JList<String> listaEquiposTexto) {
        this.listaEquiposTexto = listaEquiposTexto;
    }

    /**
     * Obtiene la lista interna de nombres de equipos seleccionados.
     * @return ArrayList de nombres de equipos.
     */
    public ArrayList<String> getListaEquipos() {
        return listaEquipos;
    }

    /**
     * Establece la lista interna de nombres de equipos seleccionados.
     * @param listaEquipos ArrayList a establecer.
     */
    public void setListaEquipos(ArrayList<String> listaEquipos) {
        this.listaEquipos = listaEquipos;
    }

    /**
     * Obtiene el scroll de la lista de equipos seleccionados.
     * @return JScrollPane de la lista.
     */
    public JScrollPane getScrollPane() {
        return scrollPane;
    }

    /**
     * Establece el scroll de la lista de equipos seleccionados.
     * @param scrollPane JScrollPane a establecer.
     */
    public void setScrollPane(JScrollPane scrollPane) {
        this.scrollPane = scrollPane;
    }
}