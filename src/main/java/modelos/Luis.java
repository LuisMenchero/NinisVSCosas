package modelos;

import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class Luis extends Nini {
    // --- ATRIBUTOS EXTRA ---
    private double tiempoProduccionButanito = 0;
    private double tiempoGeneracionButanito = 20;
    private GestorButanitos gestorButanitos;

    // --- CONSTRUCTOR ---

    public Luis(double columna, double fila, Pane root, GestorButanitos gestorButanitos) {
        super(columna, fila, 75, 50, 0, "Animaciones/Ninis/Lis.gif", root);
        this.gestorButanitos = gestorButanitos;
    }

    // --- MÉTODOS ---
//    @Override
//    public void actualizar(double tiempoFrames, ArrayList<Cosa> cosas){
//        tiempoProduccionButanito = tiempoProduccionButanito + tiempoFrames;
//        if (tiempoProduccionButanito >= tiempoGeneracionButanito) {
//            tiempoProduccionButanito = 0;
//            gestorButanitos.añadirButanitos(25);
//        }
//    }

//    @Override
//    public void disparar(ArrayList<Cosa> cosas){
//    }
}
