package controladores;

import Estadisticas.GestorXML;
import escenas.EscenaJuego;
import javafx.animation.Animation;
import javafx.animation.AnimationTimer;
import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.util.Duration;
import modelos.Cosas.Cosa;
import modelos.Cosas.Furgo;
import modelos.Cuadricula;
import modelos.Ninis.*;
import modelos.Proyectiles.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Representa el ControladorReloj
 *
 * @author Diego
 * @author Luis
 * @version 1.0
 */
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

    /**
     * Inicia un reloj para el juego
     */
    public void iniciarReloj() {
        if (temporizador != null) {
            temporizador.stop();
        }

        temporizador = new AnimationTimer() {

            private long ultimoTiempo = -1;
            //hemos usado long para que funcione porque si no se queda el juego capum

            @Override
            public void handle(long now) {

                //Esta parte lo que hace es que si está en pausa no haga nada del handle
                if (pausado) {
                    ultimoTiempo = -1;
                    return;
                }
                //Y lo hemos hecho asi para arreglar el bug de pausa, que lo que pasaba es que aunque parase el temporizador, el handle seguia acumulando y sumaba a todo despues de reanudar


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

    /**
     * Registra nini en en array
     *
     * @param nini objeto a agregar
     */
    public void registrarNini(Nini nini) {
        ninis.add(nini);
    }

    /**
     * Registra cosa en el array
     *
     * @param cosa objeto a agregar
     */
    public void registrarCosa(Cosa cosa) {
        cosas.add(cosa);
    }

    /**
     * Detecta si el nini Guevara esta en pantalla
     *
     * @return boolean
     */
    public static boolean detectarGuevara() {
        for (Nini nini : ninis) {
            if (nini instanceof Guevara) {
                return true;
            }
        }
        return false;
    }

    /**
     * Detecta si el nini Lorena esta en pantalla
     *
     * @return boolean
     */
    public static boolean detectarLorena() {
        for (Nini nini : ninis) {
            if (nini instanceof Lorena) {
                return true;
            }
        }
        return false;
    }

    /**
     * Actualiza metodos internos
     */
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
            } else if (nini instanceof Dani) {
                ArrayList<Proyectil> pelotasNuevas = ((Dani) nini).getPelotasNuevas();
                if (!pelotasNuevas.isEmpty()) {
                    proyectiles.addAll(pelotasNuevas);
                }
            } else if (nini instanceof Raul) {
                ArrayList<Proyectil> pikminNuevos = ((Raul) nini).getPikminNuevos();
                if (!pikminNuevos.isEmpty()) {
                    proyectiles.addAll(pikminNuevos);
                }
            } else if (nini instanceof Guille) {
                ArrayList<Proyectil> cabezasNuevas = ((Guille) nini).getCabezasNuevas();
                if (!cabezasNuevas.isEmpty()) {
                    proyectiles.addAll(cabezasNuevas);
                }
            } else if (nini instanceof Alvaro) {
                ArrayList<Proyectil> alvaroDeslizadosNuevos = ((Alvaro) nini).getAlvaroDeslizados();
                if (!alvaroDeslizadosNuevos.isEmpty()) {
                    proyectiles.addAll(alvaroDeslizadosNuevos);
                }
            }
        }

        for (Proyectil proyectil : proyectiles) {
            if (proyectil instanceof Nota) {
                ((Nota) proyectil).actualizar(tiempoFrames);
            } else if (proyectil instanceof Escupitajo) {
                ((Escupitajo) proyectil).actualizar(tiempoFrames);
            } else if (proyectil instanceof PelotaBaloncesto) {
                ((PelotaBaloncesto) proyectil).actualizar(tiempoFrames);
            } else if (proyectil instanceof Pikmin) {
                ((Pikmin) proyectil).actualizar(tiempoFrames);
            } else if (proyectil instanceof CabezaGuille) {
                ((CabezaGuille) proyectil).actualizar(tiempoFrames);
            } else if (proyectil instanceof AlvaroDeslizando) {
                ((AlvaroDeslizando) proyectil).actualizar(tiempoFrames);
            }
        }

        for (Cosa cosa : cosas) {
            cosa.actualizar(tiempoFrames);
        }

        comprobarColisiones();

        ControladorJuego.tiempoUltimoEnemigo = ControladorJuego.tiempoUltimoEnemigo + tiempoFrames;
        ControladorJuego.spawnEnemigos();
        ControladorJuego.tiempoPartida = ControladorJuego.tiempoPartida + tiempoFrames;
    }

    /**
     * Pausa el juego
     */
    public void pausa() {

        if (pausado) {
//            temporizador.start();
            pausado = false;
        } else {
//            temporizador.stop();
            pausado = true;
        }

    }

    /**
     * Reinicia el juego
     */
    public static void reiniciar() {
        ninis.clear();
        cosas.clear();
        proyectiles.clear();
    }

    /**
     * Termina el juego
     */
    public void terminar() {
        if (temporizador != null) {
            temporizador.stop();
        }
        pausado = false;
    }

    /**
     * Comprueba todas las colisiones del juego
     */
    private void comprobarColisiones() {

        // Para comprobar si colisiona un proyectil con la hitbox de Jud para quemar el proyectil
        for (Proyectil proyectil : proyectiles) {
            for (Nini nini : ninis) {
                if (nini instanceof Jud) {
                    if (!proyectil.estaQuemado()) {
                        if (proyectil instanceof Nota || proyectil instanceof Pikmin || proyectil instanceof PelotaBaloncesto) {
                            if (proyectil.getHitbox().getBoundsInParent().intersects(nini.getHitbox().getBoundsInParent())) {
                                ((Jud) nini).quemarProyectil(proyectil);
                            }
                        }
                    }
                }
            }
        }

        // Para impactos de proyectiles
        for (Proyectil proyectil : proyectiles) {
            if (!proyectil.isHaImpactado()) {
                for (Cosa cosa : cosas) {
                    if (proyectil.getHitbox().getBoundsInParent().intersects(cosa.getHitbox().getBoundsInParent())) {
                        cosa.recibirDaño(proyectil.getDaño());
                        proyectil.impactar();
                        if (proyectil instanceof AlvaroDeslizando && !cosa.estaRalentizado()) {
                            cosa.setPixelesPorSegundosActual(cosa.getPixelesPorSegundosActual() / 3);
                            cosa.setEstaRalentizado(true);
                            PauseTransition pause = new PauseTransition(Duration.seconds(3));
                            pause.setOnFinished(e -> {
                                cosa.setPixelesPorSegundosActual(cosa.getPixelesPorSegundo());
                            });
                            pause.play();
                        }
                        break;
                    }
                }
            }
        }

        // Para explosiones de algunos ninis y tambien comprueba los ataques cuerpo a cuerpo
        for (Nini nini : ninis) {
            for (Cosa cosa : cosas) {
                if (nini instanceof Isma && ((Isma) nini).isExplotar()) {
                    if (((Isma) nini).getHitboxExplosion().getBoundsInParent().intersects(cosa.getHitbox().getBoundsInParent())) {
                        cosa.recibirDaño(99999);
                    }
                } else if (nini instanceof Adripan && ((Adripan) nini).estaCargado()) {
                    if (nini.getHitbox().getBoundsInParent().intersects(cosa.getHitbox().getBoundsInParent())) {
                        ((Adripan) nini).setHayContacto(true);
                        if (((Adripan) nini).getHitboxExplosion().getBoundsInParent().intersects(cosa.getHitbox().getBoundsInParent())) {
                            cosa.recibirDaño(99999);
                        }
                    }
                } else if (nini instanceof Ximena && ((Ximena) nini).hayContacto()) {
                    if (nini.getHitbox().getBoundsInParent().intersects(cosa.getHitbox().getBoundsInParent())) {
                        PauseTransition pausa = new PauseTransition(Duration.seconds(2));
                        pausa.setOnFinished(e -> {
                            cosa.recibirDaño(99999);
                        });
                        pausa.play();
                    }
                } else if (nini instanceof Maria && ((Maria) nini).hayContacto()) {
                    if (nini.getHitbox().getBoundsInParent().intersects(cosa.getHitbox().getBoundsInParent())) {
                        if (!((Maria) nini).estaPeleando()) {
                            cosa.recibirDaño(99999);
                            ((Maria) nini).setEstaPeleando(true);
                        }
                    }
                } else if (nini instanceof Keke) {
                    if (nini.getHitbox().getBoundsInParent().intersects(cosa.getHitbox().getBoundsInParent())) {
                        ((Keke) nini).setTiempoUltimoGolpe(((Keke) nini).getTiempoUltimoGolpe() + tiempoFrames);
                        if (((Keke) nini).getTiempoUltimoGolpe() > ((Keke) nini).getCooldownAtaque()) {
                            ((Keke) nini).setTiempoUltimoGolpe(0);
                            ((Keke) nini).atacar(cosas);
                            cosa.recibirDaño(20);
                        }
                    }
                } else if (nini instanceof Hamil) {
                    if (nini.getHitbox().getBoundsInParent().intersects(cosa.getHitbox().getBoundsInParent())) {
                        ((Hamil) nini).setTiempoUltimoGolpe(((Hamil) nini).getTiempoUltimoGolpe() + tiempoFrames);
                        if (((Hamil) nini).getTiempoUltimoGolpe() > ((Hamil) nini).getCooldownAtaque()) {
                            ((Hamil) nini).setTiempoUltimoGolpe(0);
                            ((Hamil) nini).atacar(cosas);
                            cosa.recibirDaño(100);
                        }
                    }
                } else if (nini instanceof Eliseo && ((Eliseo) nini).getContadorEmpujones() > 0) {
                    if (nini.getHitbox().getBoundsInParent().intersects(cosa.getHitbox().getBoundsInParent())) {
                        ((Eliseo) nini).setTiempoUltimoGolpe(((Eliseo) nini).getTiempoUltimoGolpe() + tiempoFrames);
                        if (((Eliseo) nini).getTiempoUltimoGolpe() > ((Eliseo) nini).getCooldownAtaque()) {
                            ((Eliseo) nini).setTiempoUltimoGolpe(0);
                            cosa.setMovimientoDeHitbox(null);
                            ((Eliseo) nini).atacar(cosas);
                            PauseTransition pausa = new PauseTransition(Duration.millis(500));
                            pausa.setOnFinished(e -> {
                                TranslateTransition movimientoCosaEmpujada = new TranslateTransition(Duration.millis(100), cosa.getImagenCosa());
                                movimientoCosaEmpujada.setByX(cosa.getColumna() - 3);
                                movimientoCosaEmpujada.play();
                                TranslateTransition movimientoCosaEmpujadaHitbox = new TranslateTransition(Duration.millis(100), cosa.getHitbox());
                                movimientoCosaEmpujadaHitbox.setByX(cosa.getColumna() - 3);
                                movimientoCosaEmpujadaHitbox.play();
                                PauseTransition pausa2 = new PauseTransition(Duration.millis(10));
                                pausa2.setOnFinished(e2 -> {
                                    cosa.setColumna(cosa.getColumna() - 3);
                                    cosa.setMovimientoDeHitbox(new TranslateTransition(Duration.millis(100), cosa.getHitbox()));
                                });
                                pausa2.play();
                            });
                            pausa.play();
                        }
                    }
                }
            }
        }

        // Para ataques de las cosas
        for (Nini nini : ninis) {
            for (Cosa cosa : cosas) {
                if (cosa instanceof Furgo) {
                    if (!((Furgo) cosa).isNiniRecogido()) {
                        if (nini.getHitbox().getBoundsInParent().intersects(cosa.getHitbox().getBoundsInParent())) {
                            cosa.setPixelesPorSegundosActual(0);
                            cosa.atacar(tiempoFrames, nini);
                            if (nini.isEstaMuerto()) {
                                cosa.setPixelesPorSegundosActual(cosa.getPixelesPorSegundo());
                            }
                        }
                    }
                } else {
                    if (nini instanceof Eliseo && ((Eliseo) nini).getContadorEmpujones() > 0) {

                    } else {
                        if (nini.getHitbox().getBoundsInParent().intersects(cosa.getHitbox().getBoundsInParent())) {
                            cosa.setPixelesPorSegundosActual(0);
                            cosa.atacar(tiempoFrames, nini);
                            if (nini.isEstaMuerto()) {
                                cosa.setPixelesPorSegundosActual(cosa.getPixelesPorSegundo());
                            }
                        }
                    }
                }
            }
        }


        for (
                Cosa cosa : cosas) {
            if (cosa.getHitbox().getBoundsInParent().intersects(EscenaJuego.getHitboxCasa().getBoundsInParent())) {
                ControladorJuego.terminarPartida();
                Scanner teclado = new Scanner(System.in);
                GestorXML.inicializarXML();
                GestorXML.registrarNuevoJugador(teclado);
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

    public double getTiempoFrames() {
        return tiempoFrames;
    }
}