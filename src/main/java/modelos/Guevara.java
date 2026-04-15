package modelos;

import escenas.EscenaJuego;
import javafx.scene.layout.Pane;

public class Guevara extends Nini {
    // --- ATRIBUTOS EXTRA ---
    private boolean haPotenciadoNinis = false;
    // --- CONSTRUCTOR ---
    public Guevara(double columna, double fila, Pane root, Celda[][] terreno) {
        super(columna, fila, 500, 0, 0, "Animaciones/Ninis/Guevara_Idle.gif", root);

    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno) {
        //potenciarNinis();
//        potenciar();


//    , ArrayList<Cosa> cosas
    }

//    @Override
//    public void disparar(ArrayList<Cosa> cosas) {
//    }

}
