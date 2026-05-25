package modelos.Ninis;

import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import modelos.Celda;
import modelos.Cosas.Cosa;
import modelos.Proyectiles.Proyectil;

import java.util.ArrayList;

public class Jud extends Nini{
    // --- ATRIBUTOS ---

    // --- CONSTRUCTOR ---

    public Jud(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.JUD,125, 175, 0, 5,"Animaciones/Ninis/Jud_Idle.gif", root);

    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas){
        potenciar();
        curar();
    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {

    }

    public void quemarProyectil(Proyectil proyectil) {
        proyectil.setDaño(proyectil.getDaño()*2);
        proyectil.getImagenProyectilQuemado().setVisible(true);
        proyectil.setEstaQuemado(true);
    }
}
