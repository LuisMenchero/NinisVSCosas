package controladores;

import escenas.EscenaJuego;
import javafx.animation.PauseTransition;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.util.Duration;


public class ControladorJuego {

    public static void terminarPartida(){
//        EscenaJuego.getReloj().pausa();
        EscenaJuego.getReloj().terminar();
        EscenaJuego.getPanelPartidaTerminada().setVisible(true);
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
