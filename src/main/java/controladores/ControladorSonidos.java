package controladores;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import modelos.Cosas.Ordenador;

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

    // Sonidos proyectiles
    private static Media notaBajoSonido = new Media(new File("src/main/resources/Sonidos/Ninis/notaBajo.mp3").toURI().toString());
    private static Media notaBajoImpactoSonido = new Media(new File("src/main/resources/Sonidos/Ninis/notaBajoImpacto.mp3").toURI().toString());
//    private static Media pikminSonido = new Media(new File("").toURI().toString());
//    private static Media pikminImpactoSonido = new Media(new File("").toURI().toString());
//    private static Media pelotaSonido = new Media(new File("").toURI().toString());
//    private static Media pelotaImpactoSonido = new Media(new File("").toURI().toString());
//    private static Media cabezaGuilleSonido = new Media(new File("").toURI().toString());
//    private static Media cabezaGuilleImpactoSonido = new Media(new File("").toURI().toString());
//    private static Media alvaroDeslizandoSonido = new Media(new File("").toURI().toString());
//    private static Media alvaroImpactoSonido = new Media(new File("").toURI().toString());

    // Sonidos Ninis
//    private static Media j = new Media(new File("").toURI().toString());
//    private static Media ju = new Media(new File("").toURI().toString());
//    private static Media jud = new Media(new File("").toURI().toString());


    // Sonidos Cosas
    private static Media cvsSonidoBase = new Media(new File("src/main/resources/Sonidos/Cosas/caminarCv.mp3").toURI().toString());
    private static Media cvAtaqueSonido = new Media(new File("src/main/resources/Sonidos/Cosas/CvAtaque.mp3").toURI().toString());
    private static Media cvRecibeDañoSonido = new Media(new File("src/main/resources/Sonidos/Cosas/CvDañoRecibido.mp3").toURI().toString());
    private static Media cvConoRecibeDañoSonido = new Media(new File("src/main/resources/Sonidos/Cosas/CvConoDañoRecibido.mp3").toURI().toString());
    private static Media cvCascoRecibeDañoSonido = new Media(new File("src/main/resources/Sonidos/Cosas/CvCascoDañoRecibido.mp3").toURI().toString());
    private static Media cvPalaAtaqueSonido = new Media(new File("src/main/resources/Sonidos/Cosas/CvPalaAtaque.mp3").toURI().toString());
    private static Media cvPalaRecibeDañoSonido = new Media(new File("src/main/resources/Sonidos/Cosas/CvPalaDañoRecibido.mp3").toURI().toString());
    private static Media cvsSonidoMuerte = new Media(new File("src/main/resources/Sonidos/Cosas/CvMuerte.mp3").toURI().toString());

    private static Media bonitilloSonidoBase = new Media(new File("src/main/resources/Sonidos/Cosas/bonitilloBase.mp3").toURI().toString());
    private static Media bonitilloAtaqueSonido = new Media(new File("src/main/resources/Sonidos/Cosas/bonitilloAtaque.mp3").toURI().toString());
    private static Media bonitilloRecibeDañoSonido = new Media(new File("src/main/resources/Sonidos/Cosas/bonitilloDañoRecibido.mp3").toURI().toString());
    private static Media bonitilloSonidoMuerte = new Media(new File("src/main/resources/Sonidos/Cosas/bonitilloMuerte.mp3").toURI().toString());
//
//    private static Media jamiroquaiSonidoBase = new Media(new File("").toURI().toString());
//    private static Media jamiroquaiAtaqueSonido = new Media(new File("").toURI().toString());
//    private static Media jamiroquaiRecibeDañoSonido = new Media(new File("").toURI().toString());
//    private static Media jamiroquaiSonidoMuerte = new Media(new File("").toURI().toString());
//
//    private static Media haciendaSonidoBase = new Media(new File("").toURI().toString());
//    private static Media haciendaAtaqueSonido = new Media(new File("").toURI().toString());
//    private static Media haciendaRecibeDañoSonido = new Media(new File("").toURI().toString());
//    private static Media haciendaSonidoMuerte = new Media(new File("").toURI().toString());
//
    private static Media ordenadorSonidoBase = new Media(new File("src/main/resources/Sonidos/Cosas/OrdenadorBase.mp3").toURI().toString());
    private static Media ordenadorAtaqueSonido = new Media(new File("src/main/resources/Sonidos/Cosas/OrdenadorAtaque.mp3").toURI().toString());
    private static Media ordenadorRecibeDañoSonido = new Media(new File("src/main/resources/Sonidos/Cosas/OrdenadorRecibeDaño.mp3").toURI().toString());
    private static Media ordenadorSonidoMuerte = new Media(new File("src/main/resources/Sonidos/Cosas/OrdenadorMuerte.mp3").toURI().toString());
//
//    private static Media angineSonidoBase = new Media(new File("").toURI().toString());
//    private static Media angineAtaqueSonido = new Media(new File("").toURI().toString());
//    private static Media angineRecibeDañoSonido = new Media(new File("").toURI().toString());
//    private static Media angineSonidoMuerte = new Media(new File("").toURI().toString());

    private static Media furgoSonidoArrancando = new Media(new File("src/main/resources/Sonidos/Cosas/FurgoArranque.mp3").toURI().toString());
    private static Media furgoSonidoBaseAdelante = new Media(new File("src/main/resources/Sonidos/Cosas/FurgoBase.mp3").toURI().toString());
    private static Media furgoSonidoBaseAtras = new Media(new File("src/main/resources/Sonidos/Cosas/FurgoMarchaAtras.mp3").toURI().toString());
    private static Media furgoAtaqueSonido = new Media(new File("src/main/resources/Sonidos/Cosas/FurgoAtaque.mp3").toURI().toString());
    private static Media furgoRecibeDañoSonido = new Media(new File("src/main/resources/Sonidos/Cosas/FurgoDañoRecibido.mp3").toURI().toString());
    private static Media furgoSonidoRuedaPinchada = new Media(new File("src/main/resources/Sonidos/Cosas/FurgoRuedaPinchada.mp3").toURI().toString());
    private static Media furgoSonidoFuego = new Media(new File("src/main/resources/Sonidos/Cosas/FurgoFuego.mp3").toURI().toString());
    private static Media furgoSonidoMuerte = new Media(new File("src/main/resources/Sonidos/Cosas/FurgoMuerte.mp3").toURI().toString());


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

        listaSonidos.put(TipoSonido.CVBASE,cvsSonidoBase);
        listaSonidos.put(TipoSonido.CVATAQUE,cvAtaqueSonido);
        listaSonidos.put(TipoSonido.CVRECIBEDAÑO,cvRecibeDañoSonido);
        listaSonidos.put(TipoSonido.CVCONORECIBEDAÑO,cvConoRecibeDañoSonido);
        listaSonidos.put(TipoSonido.CVCASCORECIBEDAÑO,cvCascoRecibeDañoSonido);
        listaSonidos.put(TipoSonido.CVPALAATAQUE,cvPalaAtaqueSonido);
        listaSonidos.put(TipoSonido.CVPALARECIBEDAÑO,cvPalaRecibeDañoSonido);
        listaSonidos.put(TipoSonido.CVMUERTE,cvsSonidoMuerte);

        listaSonidos.put(TipoSonido.BONITILLOBASE,bonitilloSonidoBase);
        listaSonidos.put(TipoSonido.BONITILLODAÑO,bonitilloAtaqueSonido);
        listaSonidos.put(TipoSonido.BONITILLORECIBEDAÑO,bonitilloRecibeDañoSonido);
        listaSonidos.put(TipoSonido.BONITILLOMUERE,bonitilloSonidoMuerte);


        listaSonidos.put(TipoSonido.ORDENADORBASE, ordenadorSonidoBase);
        listaSonidos.put(TipoSonido.ORDENADORATAQUE, ordenadorAtaqueSonido);
        listaSonidos.put(TipoSonido.ORDENADORRECIBEDAÑO, ordenadorRecibeDañoSonido);
        listaSonidos.put(TipoSonido.ORDENADORMUERE, ordenadorSonidoMuerte);

        listaSonidos.put(TipoSonido.FURGOARRANCANDO, furgoSonidoArrancando);
        listaSonidos.put(TipoSonido.FURGOADELANTE, furgoSonidoBaseAdelante);
        listaSonidos.put(TipoSonido.FURGOATRAS, furgoSonidoBaseAtras);
        listaSonidos.put(TipoSonido.FURGOATAQUE, furgoAtaqueSonido);
        listaSonidos.put(TipoSonido.FURGORECIBEDAÑO, furgoRecibeDañoSonido);
        listaSonidos.put(TipoSonido.FURGORUEDAPINCHADA, furgoSonidoRuedaPinchada);
        listaSonidos.put(TipoSonido.FURGOFUEGO, furgoSonidoFuego);
        listaSonidos.put(TipoSonido.FURGOMUERTE, furgoSonidoMuerte);
    }

    public static void reproducirSonido(TipoSonido tipoSonido){
        reproductor = new MediaPlayer(listaSonidos.get(tipoSonido));
        reproductor.play();
        reproductor.setVolume(volumenAudio);
    }
}
