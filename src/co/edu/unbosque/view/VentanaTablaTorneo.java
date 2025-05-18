package co.edu.unbosque.view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import co.edu.unbosque.model.*;

/**
 * Ventana para visualizar la tabla de posiciones o el cuadro de llaves de un torneo.
 * Muestra una tabla ordenada por puntos para torneos tipo liga, o el árbol de enfrentamientos para torneos tipo llave.
 */
public class VentanaTablaTorneo extends JFrame {

    /**
     * Constructor de la ventana que recibe un torneo y muestra la información correspondiente.
     * 
     * @param torneo Torneo a visualizar (puede ser tipo liga o llave).
     */
    public VentanaTablaTorneo(Torneo torneo) {
        setTitle("Tabla del Torneo");
        setSize(600, 400);
        setLocationRelativeTo(null);
        setResizable(false);

        if (torneo instanceof co.edu.unbosque.model.TorneoLiga) {
            mostrarTablaLiga((TorneoLiga) torneo);
        } else if (torneo instanceof co.edu.unbosque.model.TorneoLlave) {
            mostrarLlave((TorneoLlave) torneo);
        } else {
            add(new JLabel("Tipo de torneo no soportado."), BorderLayout.CENTER);
        }
        setVisible(true);
    }

    /**
     * Muestra la tabla de posiciones para un torneo tipo liga.
     * Ordena los equipos por puntos de mayor a menor y los muestra en una tabla.
     * 
     * @param liga Torneo de tipo liga.
     */
    public void mostrarTablaLiga(TorneoLiga liga) {
        Map<Equipo, Integer> puntos = liga.getPuntos();
        List<Map.Entry<Equipo, Integer>> lista = new ArrayList<>(puntos.entrySet());

        // Ordenar por puntos descendente
        for (int i = 0; i < lista.size() - 1; i++) {
            for (int j = 0; j < lista.size() - 1 - i; j++) {
                int puntosActual = lista.get(j).getValue();
                int puntosSiguiente = lista.get(j + 1).getValue();

                if (puntosActual < puntosSiguiente) {
                    // Intercambiar posiciones
                    Map.Entry<Equipo, Integer> temp = lista.get(j);
                    lista.set(j, lista.get(j + 1));
                    lista.set(j + 1, temp);
                }
            }
        }

        String[] columnas = { "Posición", "Equipo", "Puntos" };
        DefaultTableModel model = new DefaultTableModel(columnas, 0);

        int pos = 1;
        for (Map.Entry<Equipo, Integer> entry : lista) {
            model.addRow(new Object[] { pos++, entry.getKey().getNombre(), entry.getValue() });
        }

        JTable tabla = new JTable(model);
        JScrollPane scroll = new JScrollPane(tabla);
        add(scroll, BorderLayout.CENTER);
    }

    /**
     * Muestra el cuadro de llaves para un torneo tipo llave.
     * Presenta las fases y los enfrentamientos con sus resultados y fechas.
     * 
     * @param llave Torneo de tipo llave.
     */
    public void mostrarLlave(TorneoLlave llave) {
        JTextArea area = new JTextArea();
        area.setEditable(false);

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH");

        int equipo = llave.getEquipos().size();
        int faseMax = (int) (Math.log(equipo) / Math.log(2));
        List<Partida> partidas = llave.getPartidas();

        int partidaIndex = 0; // índice para recorrer partidas
        int partidosEnFase = equipo / 2; // cantidad de partidos en la primera fase

        for (int f = 1; f <= faseMax; f++) {
            area.append("Fase " + f + ":\n");

            for (int i = 0; i < partidosEnFase && partidaIndex < partidas.size(); i++) {
                Partida p = partidas.get(partidaIndex++);

                String eqA = p.getEquipoA().getNombre();
                String eqB = p.getEquipoB().getNombre();
                String score = (p.getPuntajeEquipoA() == -1 || p.getPuntajeEquipoB() == -1) ? "Pendiente"
                        : p.getPuntajeEquipoA() + " - " + p.getPuntajeEquipoB();
                String fecha = p.getFecha() != null ? sdf.format(p.getFecha()) + ":00[America/Bogota]" : "Sin fecha";
                area.append("  " + eqA + " vs " + eqB + " | " + score + " | " + fecha + "\n");
            }

            partidosEnFase /= 2;
            area.append("\n");
        }

        JScrollPane scroll = new JScrollPane(area);
        scroll.setPreferredSize(new Dimension(550, 350));
        add(scroll, BorderLayout.CENTER);
    }
}