package modelos.Ninis;

import javafx.scene.layout.Pane;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;

public class Dani extends Nini {
    // --- ATRIBUTOS ---

    // --- CONSTRUCTOR ---

    public Dani(double columna, double fila, Pane root) {
        super(columna, fila, 100, 300, 7, "Animaciones/Ninis/Dani_idle.gif", root);
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas){

    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {

    }
}
