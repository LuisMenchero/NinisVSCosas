package modelos;

import javafx.scene.layout.Pane;

public class Lopez extends Nini {
    // --- ATRIBUTOS EXTRA ---

    // --- CONSTRUCTOR ---
    public Lopez(double columna, double fila, Pane root) {
        super(columna, fila, 100, 75, 9, "Animaciones/Ninis/LopezEsperando.gif", root);
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
//        Escupitajo nuevaNota = new Escupitajo(fila,columna,root);
//    }
}
