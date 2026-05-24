package modelos.Ninis;

import javafx.scene.layout.Pane;
import modelos.Celda;
import modelos.Cosas.Cosa;
import modelos.Items.Butanito;

import java.util.ArrayList;

public class Irene extends Nini {
    // --- ATRIBUTOS ---
    private double tiempoProduccionButanito = 0;
    private double tiempoGeneracionButanito = 0.75;
    private int tiempoEnDesaparecer = 4;
    private double tiempoParaDesaparecer = 0;
    // --- CONSTRUCTOR ---

    public Irene(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.IRENE,125, 0, 0, 200,"Animaciones/Ninis/Irene_Idle.gif", root);
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas){
        potenciar();
        curar();
        tiempoProduccionButanito = tiempoProduccionButanito + tiempoFrames;
        if (tiempoProduccionButanito >= tiempoGeneracionButanito) {
            tiempoProduccionButanito = 0;
            System.out.println("butanito generado");
            Butanito nuevoButanito = new Butanito(columna,fila,root,"Animaciones/Items/Butanito.gif");
        }
        tiempoParaDesaparecer = tiempoParaDesaparecer + tiempoFrames;
        if(tiempoParaDesaparecer > tiempoEnDesaparecer) {
            morir();
        }
    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {

    }
}
