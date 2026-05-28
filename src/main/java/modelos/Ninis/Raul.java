package modelos.Ninis;

import javafx.scene.layout.Pane;
import modelos.Celda;
import modelos.Cosas.Cosa;
import modelos.Proyectiles.Pikmin;
import modelos.Proyectiles.Proyectil;

import java.util.ArrayList;

public class Raul extends Nini {
    // --- ATRIBUTOS ---
    private ArrayList<Pikmin> pikminNuevos;
    // --- CONSTRUCTOR ---

    public Raul(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.RAUL, 75, 300, 3, 5, "Animaciones/Ninis/Raul_Idle.gif", root);
        pikminNuevos = new ArrayList<>();
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas) {
        super.actualizar(tiempoFrames, terreno, cosas);
        if (hayCosaEnMiFila(cosas) || hayZombieEnMiFilaInferior(cosas) || hayZombieEnMiFilaSuperior(cosas)) {
            tiempoDelUltimoDisparo = tiempoDelUltimoDisparo + tiempoFrames;
            if (tiempoDelUltimoDisparo > cooldownDisparo) {
                tiempoDelUltimoDisparo = 0;
                atacar(cosas);
            }
        }
    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {
        if (fila == 5) {
            pikminNuevos.add(new Pikmin(fila, columna, root));
            pikminNuevos.add(new Pikmin((fila + 100), columna, root));
        } else if (fila == 1) {
            pikminNuevos.add(new Pikmin(fila, columna, root));
            pikminNuevos.add(new Pikmin(fila - 100, columna, root));
        } else {
            pikminNuevos.add(new Pikmin(fila, columna, root));
            pikminNuevos.add(new Pikmin(fila + 100, columna, root));
            pikminNuevos.add(new Pikmin(fila - 100, columna, root));
        }

    }

    protected boolean hayZombieEnMiFilaSuperior(ArrayList<Cosa> cosas) {
        for (Cosa cosaAct : cosas) {
            if (cosaAct.getFila() + 1 == this.fila + 1) {
                return true;
            }
        }
        return false;
    }

    protected boolean hayZombieEnMiFilaInferior(ArrayList<Cosa> cosas) {
        for (Cosa cosaAct : cosas) {
            if (cosaAct.getFila() - 1 == this.fila - 1) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<Proyectil> getPikminNuevos() {
        ArrayList<Proyectil> copiaPikminNuevos = new ArrayList<>();
        for (Pikmin pikmin : pikminNuevos) {
            copiaPikminNuevos.add(pikmin);
        }
        pikminNuevos.clear();
        return copiaPikminNuevos;
    }
}
