package modelos;

import javafx.scene.image.ImageView;
import modelos.Ninis.Nini;
import modelos.Ninis.TipoNini;

public class GestorInventario {

    public static GestorInventario instancia;  ;
    private TipoNini[] inventario = new TipoNini[8];


    public static GestorInventario getInstancia() {
        if (instancia == null) {
            instancia = new GestorInventario();
        }
        return instancia;
    }


    public int añadirNiniInventario(TipoNini tipoNini) {
        int posicion = 100;

        for (int i = 0; i < 8; i++) {
            if (inventario[i] == tipoNini) {
                return posicion;
            }
        }


        for (int i = 0; i < 8; i++) {
            if (inventario[i] == null) {
                inventario[i] = tipoNini;
                posicion = i;
                return posicion;
            }
        }
        return posicion;
    }

    public void eliminarNiniInventario(TipoNini tipoNini) {
    for (int i = 0; i < 8; i++) {
        if (inventario[i] == tipoNini) {
            inventario[i] = null;
        }
    }
    }


    public int getPosicionActual(TipoNini nombreNini) {
        for (int i = 0; i < 8; i++) {
            if (nombreNini.equals(inventario[i])) {
                return i;
            }
        }
        return 100;
    }


    public TipoNini[] getInventario() {
        return inventario;
    }
}
