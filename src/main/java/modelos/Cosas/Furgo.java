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
 * Representa un enemigo Furgo
 * @author Diego
 * @author Luis
 * @version 1.0
 */
public class Furgo extends Cosa {
    // --- ATRIBUTOS ---
    private boolean niniRecogido = false;

    // --- CONSTRUCTOR ---

    /**
     * Constructor de Furgo
     * @param root Pane root de la escena en la que aparece la cosa
     */
    public Furgo(Pane root) {
        super(700, 75, 9999, 2, "Animaciones/Cosas/Furgo_Abierto.gif", root);
        ControladorSonidos.reproducirSonido(TipoSonido.FURGOARRANCANDO);
        pixelesPorSegundosActual = 0;
        PauseTransition pausa = new PauseTransition(Duration.seconds(1));
        pausa.setOnFinished(e -> {
            imagenCosa.setFitWidth(175);
            imagenCosa.setFitHeight(175);
            imagenCosa.setX(-20);
            imagenCosa.setY(-30);
            hitbox.setWidth(120);
            pixelesPorSegundosActual = pixelesPorSegundo;
            ControladorSonidos.reproducirSonido(TipoSonido.FURGOADELANTE);
            ControladorSonidos.reproducirSonido(TipoSonido.FURGOATRAS);
        });
        pausa.play();
    }

    /**
     * Mueve a Furgo segun pasa el tiempo
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     */
    @Override
    public void caminar(double tiempoFrames) {
        if (!niniRecogido) {
            columna = (columna - pixelesPorSegundosActual * tiempoFrames);
            this.imagenCosa.setLayoutX(columna);
            this.hitbox.setX((columna + 20) - pixelesPorSegundosActual * tiempoFrames);
        } else {
            columna = (columna + pixelesPorSegundosActual * tiempoFrames);
            this.imagenCosa.setLayoutX(columna);
            this.hitbox.setX((columna + 20) + pixelesPorSegundosActual * tiempoFrames);
        }
        this.imagenCongelado.setLayoutX(columna);
    }

    /**
     * Hace que Furgo ataque y haga daño a un nini
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     * @param niniAtacando Nini al que esta atacando la cosa
     */
    @Override
    public void atacar(double tiempoFrames, Nini niniAtacando) {
        if (!niniRecogido) {
            if (!atacandoNini) {
                this.setImagenCosa("Animaciones/Cosas/Furgo_Cerrado.gif");
                atacandoNini = true;
                movimientoDeHitbox.play();
            }

            tiempoUltimoGolpe = tiempoUltimoGolpe + tiempoFrames;
            if (tiempoUltimoGolpe > cooldownAtaque && pixelesPorSegundosActual == 0) {
                tiempoUltimoGolpe = 0;
                ControladorSonidos.reproducirSonido(TipoSonido.FURGOATAQUE);
                niniAtacando.recibirDaño(daño);
                System.out.println("vida nini : " + niniAtacando.getSalud());
            }

            if (niniAtacando.isEstaMuerto()) {
                atacandoNini = false;
                movimientoDeHitbox.stop();
                hitbox.setTranslateX(0);
                niniRecogido = true;
                root.getChildren().remove(hitbox);
            }
        }
    }

    /**
     * Actualiza a furgo
     * @param tiempoFrames Variable del reloj del tiempo que pasa
     */
    @Override
    public void actualizar(double tiempoFrames) {
        caminar(tiempoFrames);
        if (pixelesPorSegundosActual != 0) {
            tiempoUltimoSonido = tiempoUltimoSonido + tiempoFrames;
            if (tiempoUltimoSonido > 2) {
                tiempoUltimoSonido = 0;
                if (!niniRecogido) {
                    ControladorSonidos.reproducirSonido(TipoSonido.FURGOATRAS);
                }
                ControladorSonidos.reproducirSonido(TipoSonido.FURGOADELANTE);
            }
        }
        if (niniRecogido && !estaMuerto) {
            if (imagenCosa.getLayoutX() >= 1800) {
                morir();
            }
        }
    }

    @Override
    public void recibirDaño(int daño) {
        super.recibirDaño(daño);
        ControladorSonidos.reproducirSonido(TipoSonido.FURGORECIBEDAÑO);
    }

    /**
     * Hace que la cosa sume puntos para las estadísticas
     */
    @Override
    public void darPuntos() {
        GestorPuntos gepun = GestorPuntos.getInstancia();
        gepun.añadirPuntos(100);
    }

    /**
     * Mata a la cosa, añadiendole previamente una animación de muerte
     */
    @Override
    public void morir() {
        estaMuerto = true;
        this.setImagenCosa("Animaciones/Cosas/Furgo_Muerte.gif");
        setPixelesPorSegundosActual(0);
        ControladorSonidos.reproducirSonido(TipoSonido.FURGOMUERTE);
        PauseTransition pausa = new PauseTransition(Duration.seconds(1.5));
        pausa.setOnFinished(e -> {
            super.morir();
        });
        pausa.play();
    }

    public boolean isNiniRecogido() {
        return niniRecogido;
    }
}
