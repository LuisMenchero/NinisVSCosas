package modelos;

import javafx.scene.layout.Pane;

public class Guevara extends Nini {
    // --- ATRIBUTOS EXTRA ---

    // --- CONSTRUCTOR ---
    public Guevara(double columna, double fila, Pane root, Celda[][] terreno) {
        super(columna, fila, 500, 0, 0, "Animaciones/Ninis/Guevara_Idle.gif", root);
        potenciarNinis(terreno);
    }

    // --- MÉTODOS ---
//        @Override
//    public void actualizar(double tiempoFrames, Celda[][] terreno) {
//    potenciarNinis(terreno);
//    , ArrayList<Cosa> cosas
//    }
//
//    @Override
//    public void disparar(ArrayList<Cosa> cosas) {
//    }

    public void potenciarNinis(Celda[][] terreno) {
        for (int i = 0; i < Cuadricula.columnas; i++) {
            for (int j = 0; j < Cuadricula.filas; j++) {
                if (terreno[i][j].getNini() != null) {
                    terreno[i][j].getNini().setPotenciado(true);
                }
            }
        }
    }
}
