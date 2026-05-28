package modelos.Cosas;
import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.scene.layout.Pane;
import javafx.util.Duration;
import modelos.GestorPuntos;
import modelos.Ninis.Nini;

/**
 * Representa un enemigo Angine
 * @author Diego
 * @author Luis
 * @version 1.0
 */
public class Bonitillo extends Cosa {
    // --- ATRIBUTOS ---

    // --- CONSTRUCTOR ---

    /**
     *Constructor de Bonitillo
     * @param root
     */
    public Bonitillo(Pane root) {
        super(167, 90, 10, 1, "Animaciones/Cosas/Bonitillo_Andando.gif", root);
        imagenCosa.setFitWidth(55);
        imagenCosa.setFitHeight(55);
        imagenCosa.setX(10);
        imagenCosa.setY(30);
    }

    /**
     * Mueve a Bonitillo segun pasa el tiempo
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     */
    @Override
    public void caminar(double tiempoFrames) {
        columna = (columna - pixelesPorSegundosActual * tiempoFrames);
        this.imagenCosa.setLayoutX(columna);
        this.hitbox.setX((columna + 20) - pixelesPorSegundosActual * tiempoFrames);
        this.imagenCongelado.setLayoutX(columna);
    }

    /**
     * Hace que Bonitillo ataque y haga daño a un nini
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     * @param niniAtacando Nini al que esta atacando la cosa
     */
    @Override
    public void atacar(double tiempoFrames, Nini niniAtacando) {
        if (!atacandoNini) {
            this.setImagenCosa("Animaciones/Cosas/Bonitillo_Ataque.gif");
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
            this.setImagenCosa("Animaciones/Cosas/Bonitillo_Andando.gif");
            atacandoNini = false;
            movimientoDeHitbox.stop();
            hitbox.setTranslateX(0);
        }
    }


    /**
     * Actualiza a Bonitillo
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     */
    @Override
    public void actualizar(double tiempoFrames) {
        caminar(tiempoFrames);

    }

    /**
     * Hace que la cosa sume puntos para las estadísticas
     */
    @Override
    public void darPuntos() {
        GestorPuntos gepun = GestorPuntos.getInstancia();
        gepun.añadirPuntos(4);
    }

}
