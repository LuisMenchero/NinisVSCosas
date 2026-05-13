package modelos.Ninis;

import javafx.scene.layout.Pane;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;

public class Alvaro extends Nini{
    // --- ATRIBUTOS ---

    // --- CONSTRUCTOR ---

    public Alvaro(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.ALVARO,125, 75, 0, 5, "Animaciones/Ninis/Alvaro_Idle.gif", root);
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas){

    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {

    }
}
