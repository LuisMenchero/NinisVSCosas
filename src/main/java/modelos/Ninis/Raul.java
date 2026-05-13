package modelos.Ninis;

import javafx.scene.layout.Pane;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;

public class Raul extends Nini{
    // --- ATRIBUTOS ---

    // --- CONSTRUCTOR ---

    public Raul(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.RAUL,75, 300, 3, 5,"Animaciones/Ninis/Raul_Idle.gif", root);
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas){

    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {

    }
}
