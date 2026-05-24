package modelos.Ninis;

import javafx.animation.PauseTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelos.Celda;
import modelos.Cosas.Cosa;
import modelos.Proyectiles.CabezaGuille;
import modelos.Proyectiles.Proyectil;

import java.util.ArrayList;

public class Guille extends Nini{
    // --- ATRIBUTOS ---
    private ArrayList<CabezaGuille> cabezasNuevas;
    private boolean haAtacado = false;
    // --- CONSTRUCTOR ---

    public Guille(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.GUILLE,125, 175, 2, 5,"Animaciones/Ninis/Guille_Idle.gif", root);
        cabezasNuevas = new ArrayList<>();
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas){
        PauseTransition pausa = new PauseTransition(Duration.seconds(2));
        pausa.setOnFinished(e -> {
            if(!haAtacado){
                atacar(cosas);
            }
        });
        pausa.play();
    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {
        this.setImagenNiniImage("Animaciones/Ninis/Guille_Atacando.gif");

        haAtacado = true;
        PauseTransition pausa = new PauseTransition(Duration.seconds(1));
        pausa.setOnFinished(evento -> {
            cabezasNuevas.add(new CabezaGuille(fila,columna,root));
            PauseTransition pausaPequeña = new PauseTransition(Duration.millis(10));
            pausaPequeña.setOnFinished(e -> {
                morir();
            });
            pausaPequeña.play();
        });
        pausa.play();

    }

    public ArrayList<Proyectil> getCabezasNuevas() {
        ArrayList<Proyectil> copiaCabezasNuevas = new ArrayList<>();
        for (CabezaGuille cabeza : cabezasNuevas) {
            copiaCabezasNuevas.add(cabeza);
        }
        cabezasNuevas.clear();
        return copiaCabezasNuevas;
    }
}
