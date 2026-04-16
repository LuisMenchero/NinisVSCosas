package modelos;

import controladores.ControladorReloj;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.Timeline;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;

import java.awt.*;
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
        notasNuevas.add(new Nota(fila,columna,root));
        System.out.println("disparo");
        this.setImagenNiniImage("Animaciones/Ninis/DiegoDisparando.gif");
        PauseTransition pausa = new PauseTransition(Duration.seconds(1.5));
        pausa.setOnFinished(evento -> {
            this.setImagenNiniImage("Animaciones/Ninis/DiegoEsperando.gif");
        });
        pausa.play();
    }

    public ArrayList<Nota> getNotasNuevas() {
        ArrayList<Nota> copiaNotasNuevas = new ArrayList<>();
        notasNuevas.clear();
        return copiaNotasNuevas;
    }
}
