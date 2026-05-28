package modelos.Ninis;

import javafx.scene.layout.Pane;
import modelos.Celda;
import modelos.Cosas.Cosa;
import modelos.Proyectiles.Proyectil;

import java.util.ArrayList;
/**
 * Representa a una Jud
 *
 * @author Diego
 * @author Luis
 * @version 1.0
 */

public class Jud extends Nini {
    // --- ATRIBUTOS ---

    // --- CONSTRUCTOR ---
    /**
     * Constructor de Jud
     *
     * @param columna lugar de las columnas en la que se encuentra
     * @param fila lugar de las filas en la que se encuentra
     * @param root Pane root de la escena en la que aparece
     */
    public Jud(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.JUD, 125, 175, 0, 5, "Animaciones/Ninis/Jud_Idle.gif", root);

    }

    // --- MÉTODOS ---
    /**
     * Metodo que se encarga de actualizar las acciones
     *
     * @param tiempoFrames es el tiempo que recibe del reloj
     * @param terreno lugar de las filas y columnas en la que se encuentra
     * @param cosas es el array de todas las cosas que hay en el mapa
     */
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas) {
        super.actualizar(tiempoFrames, terreno, cosas);
    }

    /**
     * Metodo que hace que Jud ataque a una cosa
     *
     * @param cosas es el array de todas las cosas que hay en el mapa
     */
    @Override
    public void atacar(ArrayList<Cosa> cosas) {

    }

    /**
     * Metodo que hace que los proyectiles se quemen y hagan un x2 de daño
     *
     * @param proyectil es el proyectil que se debe quemar
     */
    public void quemarProyectil(Proyectil proyectil) {
        proyectil.setDaño(proyectil.getDaño() * 2);
        proyectil.getImagenProyectilQuemado().setVisible(true);
        proyectil.setEstaQuemado(true);
    }
}
