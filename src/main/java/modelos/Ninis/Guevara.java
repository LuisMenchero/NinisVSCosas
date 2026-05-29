package modelos.Ninis;

import javafx.scene.layout.Pane;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;

/**
 * Representa a un Guevara
 *
 * @author Diego
 * @author Luis
 * @version 1.0
 */
public class Guevara extends Nini {
    // --- ATRIBUTOS EXTRA ---
    private double multiplicadorDaño = 1.5;
    private int tiempoEnDesaparecer = 5;
    private double tiempoParaDesaparecer = 0;

    // --- CONSTRUCTOR ---
    /**
     * Constructor de Guevara
     *
     * @param columna lugar de las columnas en la que se encuentra
     * @param fila lugar de las filas en la que se encuentra
     * @param root Pane root de la escena en la que aparece
     */
    public Guevara(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.GUEVARA, 500, 25, 0, 300, "Animaciones/Ninis/Guevara_Idle.gif", root);
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
        tiempoParaDesaparecer = tiempoParaDesaparecer + tiempoFrames;
        if (tiempoParaDesaparecer > tiempoEnDesaparecer) {
            morir();
        }
    }

    /**
     * Metodo que hace que Guevara ataque a una cosa
     *
     * @param cosas es el array de todas las cosas que hay en el mapa
     */
    @Override
    public void atacar(ArrayList<Cosa> cosas) {
    }


    public double getMultiplicadorDaño() {
        return multiplicadorDaño;
    }
}
