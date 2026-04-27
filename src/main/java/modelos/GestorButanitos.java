package modelos;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import modelos.Items.Butanito;

import java.util.ArrayList;

public class GestorButanitos {
    // --- ATRIBUTOS ---
    public static GestorButanitos instancia;
    private ArrayList<Butanito> butanitos;
    private static int contadorButanitos = 500;
    private Text textoContador;
    // --- CONSTRUCTOR ---



    private GestorButanitos() {
        this.butanitos = new ArrayList<>();
    }

    public static GestorButanitos getInstancia() {
        if (instancia == null) {
            instancia = new GestorButanitos();
        }
        return instancia;
    }


    // --- MÉTODOS ---
    public void añadirButanito(Butanito butanito) {
        butanitos.add(butanito);
    }

    public void aniquilarButanito(Butanito butanito) {
        for (Butanito butanitoAct : butanitos) {
            if (butanitoAct == butanito) {
                butanitos.remove(butanitoAct);
//                butanitoAct.setImagenButanito(null);
                return;
            }
        }
    }


public void setTextoContador (Text texto){
        this.textoContador = texto;
        actualizarTextoContador();
}

private void actualizarTextoContador (){
        if (textoContador != null) {
            textoContador.setText(String.valueOf(contadorButanitos));
        }
}

    public void sumarButanitos(int nuevosButanitos) {
        contadorButanitos = contadorButanitos + nuevosButanitos;
        System.out.println(contadorButanitos);
        actualizarTextoContador();
    }

    public void restarButanitos(int costeButanitos) {
        contadorButanitos = contadorButanitos - costeButanitos;
        actualizarTextoContador();
    }

    public int getContadorButanitos() {
        return contadorButanitos;
    }
}
