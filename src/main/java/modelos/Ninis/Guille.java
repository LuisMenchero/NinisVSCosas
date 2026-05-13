package modelos.Ninis;

import javafx.scene.layout.Pane;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;

public class Guille extends Nini{
    // --- ATRIBUTOS ---

    // --- CONSTRUCTOR ---

    public Guille(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.GUILLE,125, 175, 0, 5,"Animaciones/Ninis/Guille_Idle.gif", root);
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas){

    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {

    }
}
