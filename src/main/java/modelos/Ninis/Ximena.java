package modelos.Ninis;

import javafx.animation.PauseTransition;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;
import modelos.Celda;
import modelos.Cosas.Cosa;

import java.util.ArrayList;

public class Ximena extends Nini {
    // --- ATRIBUTOS ---
    private boolean hayContacto = false;
    private ImageView imagenFoca;
    private Rectangle hitboxFoca;
    // --- CONSTRUCTOR ---

    public Ximena(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.XIMENA, 500, 50, 0, 5, "Animaciones/Ninis/Ximena_idle.gif", root);
        hitboxFoca = new Rectangle(
                columna + 55,
                fila + 20,
                70, 60);
        hitboxFoca.setFill(Color.BLUE);
        hitboxFoca.setOpacity(0.5);
        hitboxFoca.setVisible(true);
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas) {
        super.actualizar(tiempoFrames, terreno, cosas);
        if (!hayContacto) {
            for (Cosa cosa : cosas) {
                if (cosa.getHitbox().getBoundsInParent().intersects(this.getHitbox().getBoundsInParent())) {
                    atacar(cosas);
                }
            }
        }
    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {
        hayContacto = true;
        this.setImagenNiniImage("Animaciones/Ninis/Ximena_ataque.gif");
        PauseTransition pausa = new PauseTransition(Duration.seconds(1));
        pausa.setOnFinished(e -> {
            imagenFoca = new ImageView("Animaciones/Ninis/Foca_Baikal.gif");
            imagenFoca.setFitWidth(ancho + 10);
            imagenFoca.setFitHeight(alto + 10);
            imagenFoca.setX(columna + 55);
            imagenFoca.setY(fila);
            root.getChildren().addAll(imagenFoca,hitboxFoca);
            this.setImagenNiniImage("Animaciones/Ninis/Bomba_Humo_Ximena.gif");
            PauseTransition pausa2 = new PauseTransition(Duration.seconds(1));
            pausa2.setOnFinished(e2 -> {
                root.getChildren().removeAll(imagenFoca,hitboxFoca);
                morir();
            });
            pausa2.play();
        });
        pausa.play();

    }


    public Rectangle getHitboxFoca() {
        return hitboxFoca;
    }

    public boolean hayContacto() {
        return hayContacto;
    }

}
