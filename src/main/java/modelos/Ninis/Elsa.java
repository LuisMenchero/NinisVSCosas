package modelos.Ninis;

import javafx.scene.layout.Pane;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;

public class Elsa extends Nini {
    // --- ATRIBUTOS ---

    // --- CONSTRUCTOR ---

    public Elsa(double columna, double fila, Pane root) {
        super(columna, fila, 125, 0, 0, "Animaciones/Ninis/Elsa_Idle.gif", root);
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas){

    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {

    }
}
