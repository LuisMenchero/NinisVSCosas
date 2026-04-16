package modelos;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Callejo extends Nini {
    // --- ATRIBUTOS EXTRA ---

    // --- CONSTRUCTOR ---
    public Callejo(double columna, double fila, Pane root) {
        super(columna, fila, 200, 50, 0, "Animaciones/Ninis/Callejo_idle.gif", root);
    }

    // --- MÉTODOS ---
        @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas) {
            potenciar();
    }

    @Override
    public void disparar(ArrayList<Cosa> cosas) {
    }
}
