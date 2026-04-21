package modelos;

import javafx.scene.image.ImageView;
import modelos.Ninis.Nini;

public class GestorInventario {

    public static GestorInventario instancia;  ;
    private ImageView[] inventario = new ImageView[8];


    public static GestorInventario getInstancia() {
        if (instancia == null) {
            instancia = new GestorInventario();
        }
        return instancia;
    }


    public int añadirNiniInventario(ImageView nini) {
        int posicion = 100;
        for (int i = 0; i < 8; i++) {
            if (inventario[i] == null) {
                inventario[i] = nini;
                posicion = i;
                return posicion;
            }
        }
        return posicion;
    }

    public void eliminarNiniInventario(ImageView nini) {
    for (int i = 0; i < 8; i++) {
        if (inventario[i] == nini) {
            inventario[i] = null;
        }
    }
    }


    public ImageView[] getInventario() {
        return inventario;
    }
}
