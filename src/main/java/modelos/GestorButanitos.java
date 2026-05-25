package modelos;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import modelos.Items.Butanito;

import java.util.ArrayList;

/**
 * Gestor de los butanitos (moneda)
 * @author Diego
 * @author Luis
 * @version 1.0
 */
public class GestorButanitos {
    // --- ATRIBUTOS ---
    public static GestorButanitos instancia;
    private ArrayList<Butanito> butanitos;
    private static int contadorButanitos = 5000;
    private Text textoContador;

    // --- CONSTRUCTOR ---

    /**
     *Constructor del gestor de butanitos (inicia arraylist)
     */
    private GestorButanitos() {
        this.butanitos = new ArrayList<>();
    }

    /**
     * Da la instancia del Singletone de GestorButanitos si existe y si no, la crea
     * @return instancia
     */
    public static GestorButanitos getInstancia() {
        if (instancia == null) {
            instancia = new GestorButanitos();
        }
        return instancia;
    }


    // --- MÉTODOS ---

    /**
     * Añade butanito al array de la cantidad de butanitos que has recogido
     * @param butanito objeto que representa la moneda del juego
     */
    public void añadirButanito(Butanito butanito) {
        butanitos.add(butanito);
    }

    /**
     * Elimina un butanito de la pantalla
     * @param butanito objeto que representa la moneda del juego
     */
    public void aniquilarButanito(Butanito butanito) {
        for (Butanito butanitoAct : butanitos) {
            if (butanitoAct == butanito) {
                butanitos.remove(butanitoAct);
//                butanitoAct.setImagenButanito(null);
                return;
            }
        }
    }

    /**
     * Recoge la nueva cantidad que tiene el contador de butanitos y lo settea
     */
    private void actualizarTextoContador (){
        if (textoContador != null) {
            textoContador.setText(String.valueOf(contadorButanitos));
        }
    }

    /**
     * Suma butanitos al contador y actualiza el texto
     * @param nuevosButanitos la cantidad nueva de butanitos que queremos añadir
     */
    public void sumarButanitos(int nuevosButanitos) {
        contadorButanitos = contadorButanitos + nuevosButanitos;
        System.out.println(contadorButanitos);
        actualizarTextoContador();
    }

    /**
     * Resta butanitos al contador y actualiza el texto
     * @param costeButanitos la cantidad de butanitos que queremos quitar
     */
    public void restarButanitos(int costeButanitos) {
        contadorButanitos = contadorButanitos - costeButanitos;
        actualizarTextoContador();
    }

    /**
     * Reinicia el contador de butanitos (Usado al salir)
     */
    public static void reiniciar () {
        contadorButanitos = 5000;
        instancia = null;
    }

    /**
     * Getter del contador de butanitos
     * @return contador de butanitos
     */
    public int getContadorButanitos() {
        return contadorButanitos;
    }

    public void setContadorButanitos(int contadorButanitos) {
        GestorButanitos.contadorButanitos = contadorButanitos;
    }

    /**
     * Cambia el texto del contador al que recibe
     * @param texto texto del contador
     */
    public void setTextoContador (Text texto){
        this.textoContador = texto;
        actualizarTextoContador();
    }
}
