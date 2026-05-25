package modelos.Ninis;

import javafx.animation.PauseTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;

public class Elsa extends Nini {
    // --- ATRIBUTOS ---
    private int tiempoEnDesaparecer = 4;
    private double tiempoParaDesaparecer = 0;
    // --- CONSTRUCTOR ---

    public Elsa(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.ELSA,125, 0, 0, 200,"Animaciones/Ninis/Elsa_Idle.gif", root);
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas){
        tiempoParaDesaparecer = tiempoParaDesaparecer + tiempoFrames;
        if(tiempoParaDesaparecer > tiempoEnDesaparecer) {
            atacar(cosas);
            morir();
        }
    }

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
