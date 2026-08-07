package controladores;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.util.HashMap;

public class ControladorSonidos {
    // Sonidos generales
    private static Media mantenerBotonSonido = new Media(new File("src/main/resources/Sonidos/Genericos/MantenerBoton.mp3").toURI().toString());
    private static Media pulsarBotonSonido = new Media(new File("src/main/resources/Sonidos/Genericos/PulsarBoton.mp3").toURI().toString());
    private static Media unirseLlamada = new Media(new File("src/main/resources/Sonidos/Genericos/UnirseLLamada.mp3").toURI().toString());
    private static Media colgarLlamada = new Media(new File("src/main/resources/Sonidos/Genericos/ColgarLLamada.mp3").toURI().toString());

    // Sonidos items
    private static Media recogerButanitoSonido = new Media(new File("src/main/resources/Sonidos/Items/butanitoRecogido.mp3").toURI().toString());
    // Sonidos ninis
    private static Media notaBajoSonido = new Media(new File("src/main/resources/Sonidos/Ninis/notaBajo.mp3").toURI().toString());
    private static Media notaBajoImpactoSonido = new Media(new File("src/main/resources/Sonidos/Ninis/notaBajoImpacto.mp3").toURI().toString());
    // Sonidos cosas


    // Lista de sonidos
    private static HashMap<TipoSonido,Media> listaSonidos;
    // Para el reproductor
    private static MediaPlayer reproductor;
    private static double volumenAudio = 1;


    public ControladorSonidos() {
        listaSonidos = new HashMap<>();
        listaSonidos.put(TipoSonido.MANTENERBOTON,mantenerBotonSonido);
        listaSonidos.put(TipoSonido.PULSARBOTON,pulsarBotonSonido);
        listaSonidos.put(TipoSonido.UNIRSELLAMADA,unirseLlamada);
        listaSonidos.put(TipoSonido.COLGARLLAMADA,colgarLlamada);
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
