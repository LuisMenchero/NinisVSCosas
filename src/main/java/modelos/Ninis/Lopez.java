package modelos.Ninis;

import javafx.animation.PauseTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelos.Celda;
import modelos.Cosas.Cosa;
import modelos.Proyectiles.Escupitajo;
import modelos.Proyectiles.Proyectil;

import java.util.ArrayList;

public class Lopez extends Nini {
    // --- ATRIBUTOS EXTRA ---
    private ArrayList<Escupitajo> escupitajosNuevos;
    // --- CONSTRUCTOR ---
    public Lopez(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.LOPEZ,100, 75, 4, 5,"Animaciones/Ninis/LopezEsperando.gif", root);
        escupitajosNuevos = new ArrayList<>();
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
        this.setImagenNiniImage("Animaciones/Ninis/Lopez_escupitajo.gif");

        PauseTransition pausa = new PauseTransition(Duration.seconds(0.7));
        pausa.setOnFinished(evento -> {
            escupitajosNuevos.add(new Escupitajo(fila,columna,root));
            this.setImagenNiniImage("Animaciones/Ninis/LopezEsperando.gif");
        });
        pausa.play();
    }

    public ArrayList<Proyectil> getEscupitajosNuevos() {
        ArrayList<Proyectil> copiaEscupitajosNuevos = new ArrayList<>();
        for (Escupitajo escupitajo : escupitajosNuevos) {
            copiaEscupitajosNuevos.add(escupitajo);
        }
        escupitajosNuevos.clear();
        return copiaEscupitajosNuevos;
    }
}
