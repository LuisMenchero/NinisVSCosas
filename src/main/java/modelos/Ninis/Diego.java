package modelos.Ninis;

import javafx.animation.PauseTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelos.Celda;
import modelos.Cosas.Cosa;
import modelos.Proyectiles.Nota;
import modelos.Proyectiles.Proyectil;

import java.util.ArrayList;

public class Diego extends Nini {
    // --- ATRIBUTOS ---
    private ArrayList<Nota> notasNuevas;

    // --- CONSTRUCTOR ---
    public Diego(double columna, double fila, Pane root) {
        super(columna, fila, 100, 100, 3, "Animaciones/Ninis/DiegoEsperando.gif" , root);
        notasNuevas = new ArrayList<>();
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas) {
        potenciar();
//        if (hayZombieEnFila(cosas)) {
            tiempoDelUltimoDisparo = tiempoDelUltimoDisparo + tiempoFrames;
            if(tiempoDelUltimoDisparo > cooldownDisparo) {
                tiempoDelUltimoDisparo = 0;
                disparar(cosas);
//            }
        }
    }

    @Override
    public void disparar(ArrayList<Cosa> cosas) {
        System.out.println("disparo");
        this.setImagenNiniImage("Animaciones/Ninis/DiegoDisparando.gif");
        notasNuevas.add(new Nota(fila,columna,root));
        PauseTransition pausa = new PauseTransition(Duration.seconds(1.5));
        pausa.setOnFinished(evento -> {
            this.setImagenNiniImage("Animaciones/Ninis/DiegoEsperando.gif");
        });
        pausa.play();
    }

    public ArrayList<Proyectil> getNotasNuevas() {
        ArrayList<Proyectil> copiaNotasNuevas = new ArrayList<>();
        for (Nota nota : notasNuevas) {
            copiaNotasNuevas.add(nota);
        }
        notasNuevas.clear();
        return copiaNotasNuevas;
    }
}
