package controladores;

import escenas.EscenaJuego;
import javafx.animation.PauseTransition;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import modelos.Cosas.*;
import modelos.Ninis.Nini;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class ControladorJuego {

    //voy a hacer la parte del spawn de cosas (los he llamado enemigos porque si no me hago un lio)
    public static double tiempoUltimoEnemigo = 0;
    public static double tiempoEnSpawnear = 25;
    private static int ronda = 0;
    private static int tipo;
    public static double tiempoPartida = 0;


    public static void spawnEnemigos (){
        if (tiempoUltimoEnemigo >= tiempoEnSpawnear){
            tiempoUltimoEnemigo = 0;
            System.out.println(tiempoPartida);

            controladorOleadas();

            if (ronda == 0){
                Cosa enemigoNuevo = null;
                enemigoNuevo = new Cv(EscenaJuego.panelespecificoparacontroladorjuego);
                EscenaJuego.getReloj().registrarCosa(enemigoNuevo);
            }

            if (ronda == 1){
                tiempoEnSpawnear = 15;
                Cosa enemigoNuevo = null;
                enemigoNuevo = new Cv(EscenaJuego.panelespecificoparacontroladorjuego);
                EscenaJuego.getReloj().registrarCosa(enemigoNuevo);
            }

            if (ronda == 2){
                tiempoEnSpawnear = 10;
                tipo = (int) (Math.random()*2);
                Cosa enemigoNuevo = null;
                if (tipo == 0){
                    enemigoNuevo = new Cv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 1){
                    enemigoNuevo = new ConoCv(EscenaJuego.panelespecificoparacontroladorjuego);
                }

                EscenaJuego.getReloj().registrarCosa(enemigoNuevo);

            }

            if (ronda == 3){
                tipo = (int) (Math.random()*4);
                Cosa enemigoNuevo = null;
                if (tipo == 0){
                    enemigoNuevo = new Cv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 1){
                    enemigoNuevo = new ConoCv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 2){
                    enemigoNuevo = new CascoCv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 3){
                    enemigoNuevo = new PalaCv(EscenaJuego.panelespecificoparacontroladorjuego);
                }

                EscenaJuego.getReloj().registrarCosa(enemigoNuevo);

            }

            if (ronda == 4){
                tiempoEnSpawnear = 8;
                tipo = (int) (Math.random()*5);
                Cosa enemigoNuevo = null;
                if (tipo == 0){
                    enemigoNuevo = new Cv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 1){
                    enemigoNuevo = new ConoCv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 2){
                    enemigoNuevo = new CascoCv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 3){
                    enemigoNuevo = new PalaCv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 4){
                    enemigoNuevo = new Bonitillo(EscenaJuego.panelespecificoparacontroladorjuego);
                }

                EscenaJuego.getReloj().registrarCosa(enemigoNuevo);

            }

            if (ronda == 5){
                tiempoEnSpawnear = 7;
                tipo = (int) (Math.random()*6);
                Cosa enemigoNuevo = null;
                if (tipo == 0){
                    enemigoNuevo = new Cv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 1){
                    enemigoNuevo = new ConoCv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 2){
                    enemigoNuevo = new CascoCv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 3){
                    enemigoNuevo = new PalaCv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 4){
                    enemigoNuevo = new Bonitillo(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 5){
                    enemigoNuevo = new Jamiroquai(EscenaJuego.panelespecificoparacontroladorjuego);
                }

                EscenaJuego.getReloj().registrarCosa(enemigoNuevo);

            }

            if (ronda == 6){
                tiempoEnSpawnear = 6;
                tipo = (int) (Math.random()*7);
                Cosa enemigoNuevo = null;
                if (tipo == 0){
                    enemigoNuevo = new Cv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 1){
                    enemigoNuevo = new ConoCv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 2){
                    enemigoNuevo = new CascoCv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 3){
                    enemigoNuevo = new PalaCv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 4){
                    enemigoNuevo = new Bonitillo(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 5){
                    enemigoNuevo = new Jamiroquai(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 6){
                    enemigoNuevo = new Hacienda(EscenaJuego.panelespecificoparacontroladorjuego);
                }

                EscenaJuego.getReloj().registrarCosa(enemigoNuevo);

            }

            if (ronda == 7){
                tiempoEnSpawnear = 5;
                tipo = (int) (Math.random()*7);
                Cosa enemigoNuevo = null;
                if (tipo == 0){
                    enemigoNuevo = new Cv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 1){
                    enemigoNuevo = new ConoCv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 2){
                    enemigoNuevo = new CascoCv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 3){
                    enemigoNuevo = new PalaCv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 4){
                    enemigoNuevo = new Bonitillo(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 5){
                    enemigoNuevo = new Jamiroquai(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 6){
                    enemigoNuevo = new Hacienda(EscenaJuego.panelespecificoparacontroladorjuego);
                }

                EscenaJuego.getReloj().registrarCosa(enemigoNuevo);

            }

            if (ronda == 8){
                tiempoEnSpawnear = 4;
                tipo = (int) (Math.random()*8);
                Cosa enemigoNuevo = null;
                if (tipo == 0){
                    enemigoNuevo = new Cv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 1){
                    enemigoNuevo = new ConoCv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 2){
                    enemigoNuevo = new CascoCv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 3){
                    enemigoNuevo = new PalaCv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 4){
                    enemigoNuevo = new Bonitillo(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 5){
                    enemigoNuevo = new Jamiroquai(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 6){
                    enemigoNuevo = new Hacienda(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 7){
                    enemigoNuevo = new Angine(EscenaJuego.panelespecificoparacontroladorjuego);
                }


                EscenaJuego.getReloj().registrarCosa(enemigoNuevo);

            }

            if (ronda == 9){
                tiempoEnSpawnear = 3;
                tipo = (int) (Math.random()*9);
                Cosa enemigoNuevo = null;
                if (tipo == 0){
                    enemigoNuevo = new Cv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 1){
                    enemigoNuevo = new ConoCv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 2){
                    enemigoNuevo = new CascoCv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 3){
                    enemigoNuevo = new PalaCv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 4){
                    enemigoNuevo = new Bonitillo(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 5){
                    enemigoNuevo = new Jamiroquai(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 6){
                    enemigoNuevo = new Hacienda(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 7){
                    enemigoNuevo = new Angine(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 8){
                    //enemigoNuevo = new Ordenador(EscenaJuego.panelespecificoparacontroladorjuego);
                }


                EscenaJuego.getReloj().registrarCosa(enemigoNuevo);

            }

            if (ronda == 10){
                tiempoEnSpawnear = 1;
                tipo = (int) (Math.random()*10);
                Cosa enemigoNuevo = null;
                if (tipo == 0){
                    enemigoNuevo = new Cv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 1){
                    enemigoNuevo = new ConoCv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 2){
                    enemigoNuevo = new CascoCv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 3){
                    enemigoNuevo = new PalaCv(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 4){
                    enemigoNuevo = new Bonitillo(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 5){
                    enemigoNuevo = new Jamiroquai(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 6){
                    enemigoNuevo = new Hacienda(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 7){
                    enemigoNuevo = new Angine(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 8){
                    //enemigoNuevo = new Ordenador(EscenaJuego.panelespecificoparacontroladorjuego);
                }
                if (tipo == 9){
                    enemigoNuevo = new Furgo(EscenaJuego.panelespecificoparacontroladorjuego);
                }

                EscenaJuego.getReloj().registrarCosa(enemigoNuevo);

            }


        }
    }

    private static void controladorOleadas (){
        if (tiempoPartida > 25){
            ronda = 1;
        }
        if (tiempoPartida > 115){
            ronda = 2;
        }
        if (tiempoPartida > 230) {
            ronda = 3;
        }
        if (tiempoPartida > 350) {
            ronda = 4;
        }
        if (tiempoPartida > 440) {
            ronda = 5;
        }
        if (tiempoPartida > 500) {
            ronda = 6;
        }
        if (tiempoPartida > 590) {
            ronda = 7;
        }
        if (tiempoPartida > 710) {
            ronda = 8;
        }
        if (tiempoPartida > 800) {
            ronda = 9;
        }
        if (tiempoPartida > 900) {
            ronda = 10;
        }
    }

    public static void terminarPartida(){
//        EscenaJuego.getReloj().pausa();
        EscenaJuego.getReloj().terminar();
        EscenaJuego.getPanelPartidaTerminada().setVisible(true);
        EscenaJuego.getPanelPartidaTerminada().toFront();
    }


    public static void bloquearNini (int tiempoCooldownPlantar, int posicionBloqueoX, int posicionBloqueoY ,Pane root) {
        // PARA LAS FOTOS DE BLOQUEO POR COOLDOWN
        ImageView bloqueo = new ImageView("Imagenes/CooldownNini.png");

        bloqueo.setVisible(true);
        bloqueo.setFitWidth(50);
        bloqueo.setFitHeight(50);
        bloqueo.setLayoutX(posicionBloqueoX);
        bloqueo.setLayoutY(posicionBloqueoY);

        root.getChildren().add(bloqueo);
        PauseTransition pause = new PauseTransition(Duration.seconds(tiempoCooldownPlantar));
        pause.setOnFinished(event -> {
            bloqueo.setVisible(false);
        });
        pause.play();
    }

    public static void crearBarraCooldownNini (int tiempoCooldownPlantar, int posicionBarraX, int posicionBarraY ,Pane root) {
        // para pasar los segundos a milisegundos, debe ser final para poder pasarselo al servicio de abajo.
        final int cooldownEnMlSegs = tiempoCooldownPlantar * 100;

        // se coloca final para poder pasarselo al servicio tambien
        final ProgressBar barraCooldown = new ProgressBar();

        // Las siguientes lineas las hemos tenido que buscar y entender.
        // Básicamente sirve para que se actualice la barra (decreciente en este caso)
        // Lo hace con un bucle el cual va actualizando poco a poco la barra.
        Service thread = new Service<Integer>() {
            @Override
            public Task createTask() {
                return new Task<Integer>() {
                    @Override
                    protected Integer call() throws Exception {
                        int i;
                        for (i = cooldownEnMlSegs; i > 0; i--) {
                            updateProgress(i, cooldownEnMlSegs);
                            Thread.sleep(9);
                            // Linea añadida por nosotros para comprobar los segundos
                            if (i % 100 == 0) {
                                System.out.println("Segundos restantes " + (i/100));
                            }
                            if (i == 1) {
                                System.out.println("Se acabo");
                                barraCooldown.setVisible(false);
                            }
                        }
                        return i;
                    }
                };
            }
        };

        barraCooldown.setPrefSize(30, 13);
        barraCooldown.setLayoutX(posicionBarraX);
        barraCooldown.setLayoutY(posicionBarraY);
        barraCooldown.setStyle("-fx-accent: #002366; -fx-background-radius: 0; -fx-padding: 0;");
        thread.start();
        barraCooldown.setVisible(true);
        barraCooldown.progressProperty().bind(thread.progressProperty());

        root.getChildren().add(barraCooldown);

    }
}
