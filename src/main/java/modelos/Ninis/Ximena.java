package modelos.Ninis;

import javafx.scene.layout.Pane;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;

public class Ximena extends Nini {
    // --- ATRIBUTOS ---

    // --- CONSTRUCTOR ---

    public Ximena(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.XIMENA, 50, 50, 0, 5, "Animaciones/Ninis/Ximena_idle.gif", root);
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas) {
        super.actualizar(tiempoFrames, terreno, cosas);
    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {

    }


}
