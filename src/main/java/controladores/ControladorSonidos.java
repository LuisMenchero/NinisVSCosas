package controladores;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.HashMap;

public class ControladorSonidos {
    // Sonidos
    private static Media recogerButanitoSonido = new Media(new File("src/main/resources/Sonidos/Items/butanitoRecogido.mp3").toURI().toString());
    private static Media notaBajoSonido = new Media(new File("src/main/resources/Sonidos/Ninis/notaBajo.mp3").toURI().toString());
    private static Media notaBajoImpactoSonido = new Media(new File("src/main/resources/Sonidos/Ninis/notaBajoImpacto.mp3").toURI().toString());
    // Lista de sonidos
    private static HashMap<TipoSonido,Media> listaSonidos;
    // Para el reproductor
    private static MediaPlayer reproductor;
    private static double volumenAudio = 1;


    public ControladorSonidos() {
        listaSonidos = new HashMap<>();
        listaSonidos.put(TipoSonido.RECOGERBUTANITO,recogerButanitoSonido);
        listaSonidos.put(TipoSonido.NOTABAJO,notaBajoSonido);
        listaSonidos.put(TipoSonido.NOTABAJOIMPACTO,notaBajoImpactoSonido);

    }

    public static void reproducirSonido(TipoSonido tipoSonido){
        reproductor = new MediaPlayer(listaSonidos.get(tipoSonido));
        reproductor.play();
        reproductor.setVolume(volumenAudio);
    }
}
