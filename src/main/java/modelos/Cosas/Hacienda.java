package modelos.Cosas;

import javafx.animation.PauseTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelos.GestorButanitos;
import modelos.Ninis.Nini;

public class Hacienda extends Cosa {
    // --- ATRIBUTOS ---
    protected double tiempoDelUltimaResta;
    protected double cooldownResta;
    //El gestor de butanitos lo pillo en este para que pueda descontarlos
    private GestorButanitos gb = GestorButanitos.getInstancia();
    private boolean estaRestando = false;

    // --- CONSTRUCTOR ---
    public Hacienda(Pane root) {
        super(200, 20, 60, 2, "Animaciones/Cosas/Hacienda_Andando.gif", root);
        cooldownResta = 5;
    }

    @Override
    public void caminar(double tiempoFrames) {
        columna = (columna - pixelesPorSegundosActual * tiempoFrames);
        this.imagenCosa.setLayoutX(columna);
        this.hitbox.setX((columna + 20) - pixelesPorSegundosActual * tiempoFrames);
    }

    @Override
    public void atacar(double tiempoFrames, Nini niniAtacando) {
        if (!atacandoNini) {
            this.setImagenCosa("Animaciones/Cosas/Hacienda_Ataque.gif");
            atacandoNini = true;
            movimientoDeHitbox.play();
        }

        tiempoUltimoGolpe = tiempoUltimoGolpe + tiempoFrames;
        if (tiempoUltimoGolpe > cooldownAtaque && pixelesPorSegundosActual == 0) {
            tiempoUltimoGolpe = 0;
            niniAtacando.recibirDaño(daño);
            System.out.println("vida nini : " + niniAtacando.getSalud());
        }

        if (niniAtacando.isEstaMuerto()) {
            this.setImagenCosa("Animaciones/Cosas/Hacienda_Andando.gif");
            atacandoNini = false;
            movimientoDeHitbox.stop();
            hitbox.setTranslateX(0);
        }
    }

    public void descontar () {
        estaRestando = true;
        this.setImagenCosa("Animaciones/Cosas/Hacienda_Descontar.gif");
        pixelesPorSegundosActual = 0;
        if (gb.getContadorButanitos()<=0) {
            gb.setContadorButanitos(0);
        } else {
            gb.restarButanitos(100);
        }
        PauseTransition pausa = new PauseTransition(Duration.seconds(1));
        pausa.setOnFinished(e -> {
            this.setImagenCosa("Animaciones/Cosas/Hacienda_Andando.gif");
            pixelesPorSegundosActual = pixelesPorSegundo;
            estaRestando = false;
        });
        pausa.play();
    }


    @Override
    public void actualizar(double tiempoFrames) {
        caminar(tiempoFrames);
        tiempoDelUltimaResta = tiempoDelUltimaResta + tiempoFrames;
        if(tiempoDelUltimaResta > cooldownResta) {
            tiempoDelUltimaResta = 0;
            if (!estaRestando) {
                descontar();
            }
        }





    }

}

