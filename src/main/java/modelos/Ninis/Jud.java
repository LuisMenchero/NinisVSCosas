package modelos.Ninis;

import javafx.scene.layout.Pane;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;

public class Jud extends Nini{
    // --- ATRIBUTOS ---

    // --- CONSTRUCTOR ---

    public Jud(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.JUD,125, 175, 0, 5,"Animaciones/Ninis/Jud_Idle.gif", root);
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas){

    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {

    }
}
