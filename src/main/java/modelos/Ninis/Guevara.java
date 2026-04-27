package modelos.Ninis;

import javafx.scene.layout.Pane;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;

public class Guevara extends Nini {
    // --- ATRIBUTOS EXTRA ---
    private boolean haPotenciadoNinis = false;
    // --- CONSTRUCTOR ---
    public Guevara(double columna, double fila, Pane root) {
        super(columna, fila, 500, 0, 0, "Animaciones/Ninis/Guevara_Idle.gif", root);

    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas) {
        //potenciarNinis();
//        potenciar();


//    , ArrayList<Cosa> cosas
    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {
    }

}
