package modelos.Cosas;

import javafx.animation.PauseTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import modelos.Ninis.Nini;

/**
 * Representa a un enemigo Ordenador
 * @author Diego
 * @author Luis
 * @version 1.0
 */
public class Ordenador extends Cosa{

    // --- ATRIBUTOS ---

    private boolean explotar = false;
    private ImageView explosion;
    private Rectangle hitboxExplosion;
    private boolean hayContacto;

    // --- CONSTRUCTOR ---
    /**
     * Constructor de Ordenador
     * @param root Pane root de la escena en la que aparece la cosa
     */
    public Ordenador(Pane root) {
        super(350, 25, 200, 1, "Animaciones/Cosas/Computador.gif", root);
    }

    /**
     * Mueve a Ordenador segun pasa el tiempo
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     */
    @Override
    public void caminar(double tiempoFrames) {
        if (!explotar) {
            columna = (columna - pixelesPorSegundosActual * tiempoFrames);
            this.imagenCosa.setLayoutX(columna);
            this.hitbox.setX((columna + 20) - pixelesPorSegundosActual * tiempoFrames);
            this.imagenCongelado.setLayoutX(columna);
        }
    }

    /**
     * Hace que Ordenador ataque y haga daño a un nini
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     * @param niniAtacando Nini al que esta atacando la cosa
     */
    @Override
    public void atacar(double tiempoFrames, Nini niniAtacando) {

        if (!explotar) {
            explotar = true;
            this.imagenCosa.setVisible(false);

            explosion = new ImageView("Animaciones/Ninis/boom-explosion.gif");
            hitboxExplosion = new Rectangle(columna - 50, fila - 50, 180, 180);
            hitboxExplosion.setFill(Color.RED);
            hitboxExplosion.setOpacity(0.5);
            hitboxExplosion.setVisible(true);
            explosion.setFitWidth(200);
            explosion.setFitHeight(200);
            explosion.setX(columna - 50);
            explosion.setY(fila - 50);
            root.getChildren().addAll(explosion, hitboxExplosion);

            niniAtacando.recibirDaño(daño);
            PauseTransition pausa  = new PauseTransition(Duration.seconds(0.5));
            pausa.setOnFinished(evento -> {
                root.getChildren().remove(explosion);
                root.getChildren().remove(hitboxExplosion);
                root.getChildren().remove(imagenCosa);
                root.getChildren().remove(imagenCongelado);
                root.getChildren().remove(hitbox);

            });

            pausa.play();

        }


    }

    /**
     * Actualiza a Ordenador
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     */
    @Override
    public void actualizar(double tiempoFrames) {
        if (!explotar) {
            caminar(tiempoFrames);
        }

    }

}
