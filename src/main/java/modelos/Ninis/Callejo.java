package modelos.Ninis;

import javafx.scene.layout.Pane;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;

public class Callejo extends Nini {
    // --- ATRIBUTOS EXTRA ---

    // --- CONSTRUCTOR ---
    public Callejo(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.CALLEJO, 200, 50, 0, 5, "Animaciones/Ninis/Callejo_idle.gif", root);
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
