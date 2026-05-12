package modelos.Ninis;

import javafx.scene.layout.Pane;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;

public class Keke extends Nini {
    // --- ATRIBUTOS ---

    // --- CONSTRUCTOR ---

    public Keke(double columna, double fila, Pane root) {
        super(columna, fila, 125, 175, 0, "Animaciones/Ninis/Keke_Idle.gif", root);
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas){

    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {

    }
}
