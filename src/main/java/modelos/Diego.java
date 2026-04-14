package modelos;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Diego extends Nini {
    // --- ATRIBUTOS ---
    // --- CONSTRUCTOR ---
    public Diego(double columna, double fila, Pane root) {
        super(columna, fila, 100, 100, 10, "Animaciones/Ninis/DiegoEsperando.gif" , root);
    }

    // --- MÉTODOS ---
//    @Override
//    public void actualizar(double tiempoFrames, ArrayList<Cosa> cosas) {
//        if (hayZombieEnFila(cosas)) {
//            tiempoDelUltimoDisparo = tiempoDelUltimoDisparo + tiempoFrames;
//            if(tiempoDelUltimoDisparo > cooldownDisparo) {
//                tiempoDelUltimoDisparo = 0;
//                disparar(cosas);
//            }
//        }
//    }
//
//    @Override
//    public void disparar(ArrayList<Cosa> cosas) {
//        Nota nuevaNota = new Nota(fila,columna,root);
//    }
}
