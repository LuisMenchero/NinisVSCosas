package modelos.Ninis;

import javafx.scene.layout.Pane;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;

public class Lorena extends Nini {
    // --- ATRIBUTOS ---
    private int tiempoEnDesaparecer = 4;
    private double tiempoParaDesaparecer = 0;
    // --- CONSTRUCTOR ---

    public Lorena(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.LORENA, 500, 25, 0, 5, "Animaciones/Ninis/Lorena_Idle.gif", root);
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas) {
        super.actualizar(tiempoFrames, terreno, cosas);
        tiempoParaDesaparecer = tiempoParaDesaparecer + tiempoFrames;
        if (tiempoParaDesaparecer > tiempoEnDesaparecer) {
            morir();
        }
    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {

    }
}
