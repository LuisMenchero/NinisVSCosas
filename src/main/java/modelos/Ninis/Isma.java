package modelos.Ninis;

import javafx.scene.layout.Pane;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;

public class Isma extends Nini {
    // --- ATRIBUTOS ---

    // --- CONSTRUCTOR ---

    public Isma(double columna, double fila, Pane root) {
        super(columna, fila, 50, 150, 0, "Animaciones/Ninis/Isma_Idle.gif", root);
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas){

    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {

    }

}
