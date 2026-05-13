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
        super(columna, fila, TipoNini.DIEGO,100, 100, 3, 5,"Animaciones/Ninis/DiegoEsperando.gif" , root);
        notasNuevas = new ArrayList<>();
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas) {
        potenciar();
        if (hayZombieEnMiFila(cosas)) {
            tiempoDelUltimoDisparo = tiempoDelUltimoDisparo + tiempoFrames;
            if(tiempoDelUltimoDisparo > cooldownDisparo) {
                tiempoDelUltimoDisparo = 0;
                atacar(cosas);
            }
        }
    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {
        this.setImagenNiniImage("Animaciones/Ninis/DiegoDisparando.gif");
        PauseTransition pausa = new PauseTransition(Duration.seconds(1.2));
        pausa.setOnFinished(evento -> {
            notasNuevas.add(new Nota(fila,columna,root));
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
