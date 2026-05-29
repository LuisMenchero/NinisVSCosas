package controladores;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

/**
 * Representa el controlador de musica, reproduce la musica del juego
 * @author Diego
 * @author Luis
 * @version 1.0
 */
public class ControladorMusica {

    private static Media sherpa = new Media(new File("src/main/resources/Musica/Sherpa.mp3").toURI().toString());
    private static Media sarniezz = new Media(new File("src/main/resources/Musica/Sarniezz.mp3").toURI().toString());
    private static Media fabienk = new Media(new File("src/main/resources/Musica/Fabienk.mp3").toURI().toString());
    private static Media matazyklek = new Media(new File("src/main/resources/Musica/Mata Zyklek.mp3").toURI().toString());
    private static Media tohogd = new Media(new File("src/main/resources/Musica/Tohogd.mp3").toURI().toString());

//Hay que hacer pruebas con el boton de siguiente e implementar los del volumen

    private static Media[] canciones = new Media[]{sarniezz, fabienk, sherpa, matazyklek, tohogd};
    private static MediaPlayer reproductor;
    private static int contador = 0;

    /**
     * Reproduce la musica
     */
    public static void reproducirMusicaJuego () {
        reproductor = new MediaPlayer(canciones[contador]);
        reproductor.play();
        reproductor.setVolume(0.5);
        reproductor.setOnEndOfMedia(() -> siguienteCancion());
    }

    /**
     * Para completamente la musica
     */
    public static void pararMusicaJuego () {
        reproductor.stop();
    }

    /**
     * Pausa la reproduccion de la musica
     */
    public static void pausarMusicaJuego () {
        reproductor.pause();
    }

    /**
     * Vuelve a reproducir la musica
     */
    public static void despausarMusicaJuego () {
        reproductor.play();
    }

    /**
     * Cambia a la siguiente cancion
     */
    public static void siguienteCancion () {
    reproductor.stop();
    contador++;
    if (contador >=  canciones.length) { contador = 0; }
    reproducirMusicaJuego();
    }

    /**
     * Le baja el volumen a 0 a la musica
     */
    public static void mutearVolumen () {
        reproductor.setVolume(0);
    }

    /**
     * Vuelve a subir el volumen a 1 a la musica
     */
    public static void desmutearVolumen () {
        reproductor.setVolume(1);
    }

}
