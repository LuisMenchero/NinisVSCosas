package controladores;

import escenas.EscenaJuego;
import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.util.Duration;
import modelos.Cosas.Cosa;
import modelos.Cuadricula;
import modelos.Ninis.Diego;
import modelos.Ninis.Guevara;
import modelos.Ninis.Lopez;
import modelos.Ninis.Nini;
import modelos.Proyectiles.Escupitajo;
import modelos.Proyectiles.Nota;
import modelos.Proyectiles.Proyectil;

import java.util.ArrayList;

public class ControladorReloj {

//esta clase sirve para que el juego funcione en si
// de lo que se encarga es de dar "tiempoFrames" que es el tiempo que ha pasado desde el ultimo frame"
// esto lo hemos investigado y sirve en general para que el funcionamiento de la logica no se vea ligada a los frames a los que te vaya el juego


    private AnimationTimer temporizador;
    private double tiempoFrames;
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

                tiempoFrames = (now - ultimoTiempo) / 1000000000.0;
                ultimoTiempo = now;


                // lo hemos hecho de forma que sea una pila de llamadas pero nos hemos debatido que fuera un getter
                actualizar();

            }
        };

        temporizador.start();

    }

    public void registrarNini(Nini nini) {
        ninis.add(nini);
    }
    public void registrarCosa(Cosa cosa) {
        cosas.add(cosa);
    }

    public static boolean detectarGuevara() {
        for (Nini nini : ninis) {
            if (nini instanceof Guevara) {
                return true;
            }
        }
        return false;
    }

    public void actualizar() {
        //aqui van las cosas que requieren ser actualizadas que reciban tiempoFrames
        for (Nini nini : ninis) {
            nini.actualizar(tiempoFrames, EscenaJuego.getTerreno(), cosas);
            if (nini instanceof Diego) {
                ArrayList<Proyectil> notasNuevas = ((Diego) nini).getNotasNuevas();
                if (!notasNuevas.isEmpty()) {
                    proyectiles.addAll(notasNuevas);
                }
            } else if (nini instanceof Lopez) {
                ArrayList<Proyectil> escupitajosNuevos = ((Lopez) nini).getEscupitajosNuevos();
                if (!escupitajosNuevos.isEmpty()) {
                    proyectiles.addAll(escupitajosNuevos);
                }
            }
        }

        for (Proyectil proyectil : proyectiles) {
            if (proyectil instanceof Nota) {
                ((Nota) proyectil).actualizar(tiempoFrames);
            } else if (proyectil instanceof Escupitajo) {
                ((Escupitajo) proyectil).actualizar(tiempoFrames);
            }
        }

        for (Cosa cosa : cosas) {
            cosa.actualizar(tiempoFrames);
        }

        comprobarColisiones();

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

    public static void reiniciar() {
        ninis.clear();
        cosas.clear();
        proyectiles.clear();
    }

    private void comprobarColisiones() {

    for (Proyectil proyectil : proyectiles) {
        for (Cosa cosa : cosas) {
            if (proyectil.getHitbox().getBoundsInParent().intersects(cosa.getHitbox().getBoundsInParent())) {
                cosa.recibirDaño(proyectil.getDaño());
                proyectil.impactar();
                break;
            }

        }
    }


    for (Nini nini : ninis) {
        for (Cosa cosa : cosas) {
            if (nini.getHitbox().getBoundsInParent().intersects(cosa.getHitbox().getBoundsInParent())) {
                cosa.setPixelesPorSegundosActual(1);
                cosa.atacar(tiempoFrames, nini);
                if (nini.isEstaMuerto()) {
                    EscenaJuego.getTerreno()[Cuadricula.convertirAFila(nini.getFila())][Cuadricula.convertirAColumna(nini.getColumna())].setNini(null);
                    EscenaJuego.getTerreno()[Cuadricula.convertirAFila(nini.getFila())][Cuadricula.convertirAColumna(nini.getColumna())].setHayPlanta(false);
                    cosa.setPixelesPorSegundosActual(cosa.getPixelesPorSegundo());
                }
            }
        }
    }


    for (Cosa cosa : cosas) {
        if (cosa.getHitbox().getBoundsInParent().intersects(EscenaJuego.getHitboxCasa().getBoundsInParent())) {
            EscenaJuego.getReloj().pausa();
            ControladorJuego.terminarPartida();
        }
    }

    }


    public boolean isPausado() {
        return pausado;
    }

    public static ArrayList<Cosa> getCosas() {
        return cosas;
    }

    public static ArrayList<Nini> getNinis() {
        return ninis;
    }

    public static ArrayList<Proyectil> getProyectiles() {
        return proyectiles;
    }
}