package modelos.Cosas;
import controladores.ControladorSonidos;
import controladores.TipoSonido;
import javafx.animation.Animation;
import javafx.animation.PauseTransition;
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
public class Angine extends Cosa {
    // --- ATRIBUTOS ---

    // --- CONSTRUCTOR ---

    /**
     * Constructor de Angine
     * @param root Pane root de la escena en la que aparece la cosa
     */
    public Angine(Pane root) {
        super(1200, 5, 999999, 0, "Animaciones/Cosas/Angine_de_poitrine.gif", root);
        ControladorSonidos.reproducirSonido(TipoSonido.ANGINESPAWN);
    }

    /**
     * Mueve a Angine segun pasa el tiempo
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
     * Hace que Angine ataque y haga daño a un nini
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     * @param niniAtacando Nini al que esta atacando la cosa
     */
    @Override
    public void atacar(double tiempoFrames, Nini niniAtacando) {
        if (!atacandoNini) {
            atacandoNini = true;
            movimientoDeHitbox.play();
        }

        tiempoUltimoGolpe = tiempoUltimoGolpe + tiempoFrames;
        if (tiempoUltimoGolpe > cooldownAtaque && pixelesPorSegundosActual == 0) {
            tiempoUltimoGolpe = 0;
            ControladorSonidos.reproducirSonido(TipoSonido.ANGINEATAQUE);
            niniAtacando.recibirDaño(daño);
            System.out.println("vida nini : " + niniAtacando.getSalud());
        }

        if (niniAtacando.isEstaMuerto()) {
            atacandoNini = false;
            movimientoDeHitbox.stop();
            hitbox.setTranslateX(0);
        }
    }

    /**
     * Actualiza a Angine
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     */
    @Override
    public void actualizar(double tiempoFrames) {
        caminar(tiempoFrames);
        if (pixelesPorSegundosActual != 0) {
            tiempoUltimoSonido = tiempoUltimoSonido + tiempoFrames;
            if (tiempoUltimoSonido > 10) {
                tiempoUltimoSonido = 0;
                ControladorSonidos.reproducirSonido(TipoSonido.ANGINEBASE);
            }
        }
    }

    @Override
    public void recibirDaño(int daño) {
        super.recibirDaño(daño);
        ControladorSonidos.reproducirSonido(TipoSonido.ANGINERECIBADAÑO);
    }

    /**
     * Hace que la cosa sume puntos para las estadísticas
     */
    @Override
    public void darPuntos() {
        GestorPuntos gepun = GestorPuntos.getInstancia();
        gepun.añadirPuntos(25);
    }

    /**
     * Mata a la cosa, añadiendole previamente una animación de muerte
     */
    @Override
    public void morir() {
        setPixelesPorSegundosActual(0);
        ControladorSonidos.reproducirSonido(TipoSonido.ANGINEMUERTE);
        PauseTransition pausa = new PauseTransition(Duration.seconds(1));
        pausa.setOnFinished(e -> {
            super.morir();
        });
        pausa.play();
    }

}
