package modelos.Ninis;

import javafx.scene.layout.Pane;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;

public class Eliseo extends Nini{
    // --- ATRIBUTOS ---

    // --- CONSTRUCTOR ---

    public Eliseo(double columna, double fila, Pane root) {
        super(columna, fila, 75, 75, 3, "Animaciones/Ninis/Eliseo3bolas_Idle.gif", root);
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas){

    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {

    }
}
