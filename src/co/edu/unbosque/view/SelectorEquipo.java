package co.edu.unbosque.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Properties;

import co.edu.unbosque.model.Equipo;

public class SelectorEquipo extends JFrame {
	private Properties prop;
    private JComboBox<String> comboEquipos;
    private JButton btnAgregar;
    private DefaultListModel<String> modeloLista;
    private JList<String> listaEquiposTexto;
    private ArrayList<String> listaEquipos;
    private JScrollPane scrollPane;
    
    public SelectorEquipo(ArrayList<Equipo> equipos, int cantidad, Properties prop) {
    	this.prop = prop;
        setLayout(null);
        setBounds(0, 0, 400, 300);
		setDefaultCloseOperation(DISPOSE_ON_CLOSE);

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
}