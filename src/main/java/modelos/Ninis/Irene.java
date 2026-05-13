package modelos.Ninis;

import javafx.scene.layout.Pane;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;

public class Irene extends Nini {
    // --- ATRIBUTOS ---

    // --- CONSTRUCTOR ---

    public Irene(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.IRENE,125, 0, 0, 5,"Animaciones/Ninis/Irene_Idle.gif", root);
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas){

    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {

    }
}
