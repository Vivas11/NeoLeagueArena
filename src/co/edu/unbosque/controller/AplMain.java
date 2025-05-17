package co.edu.unbosque.controller;

import java.io.IOException;

/**
 * Clase principal que inicia la aplicación NeoLeagueArena.
 */
public class AplMain {

    /**
     * Método principal que ejecuta la aplicación.
     * @param args Argumentos de línea de comandos.
     * @throws IOException Si ocurre un error al iniciar el controlador.
     */
    public static void main(String[] args) throws IOException {
        Controller ctrl = new Controller();
        ctrl.run();
    }
}
