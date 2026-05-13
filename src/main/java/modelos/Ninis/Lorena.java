package modelos.Ninis;

import javafx.scene.layout.Pane;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;

public class Lorena extends Nini{
    // --- ATRIBUTOS ---

    // --- CONSTRUCTOR ---

    public Lorena(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.LORENA,500, 25, 0, 5,"Animaciones/Ninis/Lorena_Idle.gif", root);
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas){

    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {

    }
}
