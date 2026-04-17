package controladores;

import escenas.EscenaJuego;
import javafx.animation.AnimationTimer;
import modelos.Cosas.Cosa;
import modelos.Ninis.Diego;
import modelos.Ninis.Guevara;
import modelos.Ninis.Nini;
import modelos.Proyectiles.Nota;
import modelos.Proyectiles.Proyectil;

import java.util.ArrayList;

public class ControladorReloj {

//esta clase sirve para que el juego funcione en si
// de lo que se encarga es de dar "tiempoFrames" que es el tiempo que ha pasado desde el ultimo frame"
// esto lo hemos investigado y sirve en general para que el funcionamiento de la logica no se vea ligada a los frames a los que te vaya el juego


    private AnimationTimer temporizador;
    private boolean pausado = false;
    private static ArrayList<Cosa> cosas = new ArrayList<>();
    private static ArrayList<Nini> ninis = new ArrayList<>();
    private static ArrayList<Proyectil> proyectiles = new ArrayList<>();


    public void iniciarReloj() {

        temporizador = new AnimationTimer() {
            private long ultimoTiempo = -1;
            //hemos usado long para que funcione porque si no se queda el juego capum

            @Override
            public void handle(long now) {
                if (ultimoTiempo < 0) {
                    ultimoTiempo = now;
                    return;
                }

                double tiempoFrames = (now - ultimoTiempo) / 1000000000.0;
                ultimoTiempo = now;


                // lo hemos hecho de forma que sea una pila de llamadas pero nos hemos debatido que fuera un getter
                actualizar(tiempoFrames);

            }
        };

        temporizador.start();

    }

    public void registrar(Nini nini) {
        ninis.add(nini);
    }

    public static boolean detectarGuevara() {
        for (Nini nini : ninis) {
            if (nini instanceof Guevara) {
                return true;
            }
        }
        return false;
    }

    public void actualizar(double tiempoFrames) {
        //aqui van las cosas que requieren ser actualizadas que reciban tiempoFrames
        for (Nini nini : ninis) {
            nini.actualizar(tiempoFrames, EscenaJuego.getTerreno(), cosas);
            if (nini instanceof Diego) {
                    //Esta parte deberá permanecer comentada porque si no las notas no se mueven jeje
//                if (((Diego) nini).getNotasNuevas().isEmpty()) {
//                    System.out.println("No tengo bolingas");
//                }
                ArrayList<Proyectil> notasNuevas = ((Diego) nini).getNotasNuevas();
                if (!notasNuevas.isEmpty()) {
                    proyectiles.addAll(notasNuevas);
                }
            }
        }

        for (Proyectil proyectil : proyectiles) {
            if (proyectil instanceof Nota) {
                ((Nota) proyectil).actualizar(tiempoFrames);
                System.out.println("hola funciono");
            }
        }

    }

    public void pausa() {

        if (pausado) {
            temporizador.start();
            pausado = false;
        } else {
            temporizador.stop();
            pausado = true;
        }

    }


    public boolean isPausado() {
        return pausado;
    }

}