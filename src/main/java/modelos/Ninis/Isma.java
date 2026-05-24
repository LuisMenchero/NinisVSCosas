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

public class Isma extends Nini {
    // --- ATRIBUTOS ---
    private boolean explotar = false;
    private ImageView explosion;
    private Rectangle hitboxExplosion;
    // --- CONSTRUCTOR ---

    public Isma(double columna, double fila, Pane root) {
        super(columna, fila, TipoNini.ISMA,50, 150, 0, 5,"Animaciones/Ninis/Isma_Idle.gif", root);
    }

    // --- MÉTODOS ---
    @Override
    public void actualizar(double tiempoFrames, Celda[][] terreno, ArrayList<Cosa> cosas){
        potenciar();
        curar();
        PauseTransition pause = new PauseTransition(Duration.seconds(5));
        pause.setOnFinished(e1 -> {
            if(!explotar){
                atacar(cosas);
            }
            PauseTransition pause2 = new PauseTransition(Duration.seconds(0.5));
            pause2.setOnFinished(e2 -> {
                morir();
                root.getChildren().remove(explosion);
                root.getChildren().remove(hitboxExplosion);
            });
            pause2.play();
        });
        pause.play();
    }

    @Override
    public void atacar(ArrayList<Cosa> cosas) {
        explotar = true;
        explosion = new ImageView("Animaciones/Ninis/boom-explosion.gif");
        hitboxExplosion = new Rectangle(columna-50,fila-50,180,180);
        hitboxExplosion.setFill(Color.RED);
        hitboxExplosion.setOpacity(0.5);
        hitboxExplosion.setVisible(true);
        explosion.setFitWidth(200);
        explosion.setFitHeight(200);
        explosion.setX(columna-50);
        explosion.setY(fila-50);
        root.getChildren().addAll(explosion,hitboxExplosion);
    }

    public boolean isExplotar() {
        return explotar;
    }

    public Rectangle getHitboxExplosion() {
        return hitboxExplosion;
    }
}
