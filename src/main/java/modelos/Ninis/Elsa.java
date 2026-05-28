package modelos.Ninis;

import javafx.animation.PauseTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;

/**
 * Representa a una Elsa
 *
 * @author Diego
 * @author Luis
 * @version 1.0
 */
public class Elsa extends Nini {
    // --- ATRIBUTOS ---
    private int tiempoEnDesaparecer = 4;
    private double tiempoParaDesaparecer = 0;
    // --- CONSTRUCTOR ---
    /**
     * Constructor de Elsa
     *
     * @param columna lugar de las columnas en la que se encuentra
     * @param fila lugar de las filas en la que se encuentra
     * @param root Pane root de la escena en la que aparece
     */
    public Elsa(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.ELSA, 125, 0, 0, 200, "Animaciones/Ninis/Elsa_Idle.gif", root);
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
            atacar(cosas);
            morir();
        }
    }

    /**
     * Metodo que hace que Elsa ataque a una cosa
     *
     * @param cosas es el array de todas las cosas que hay en el mapa
     */
    @Override
    public void atacar(ArrayList<Cosa> cosas) {
        for (Cosa cosa : cosas) {
            cosa.congelar();
        }
        PauseTransition pause = new PauseTransition(Duration.seconds(4));
        pause.setOnFinished(e -> {
            for (Cosa cosa : cosas) {
                cosa.descongelar();
            }
        });
        pause.play();
    }
}
