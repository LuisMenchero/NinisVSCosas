package modelos;

import javafx.scene.text.Text;

public class GestorPuntos {
    // ATRIBUTOS
    private static int contadorPuntosTotales;
    public static GestorPuntos instancia;
    private Text textoContador;

    // CONSTRUCTOR
    /**
     *Constructor del gestor de butanitos (inicia arraylist)
     */
    private GestorPuntos() {
        contadorPuntosTotales = 0;
    }

    /**
     * Da la instancia del Singletone de modelos.GestorPuntos si existe y si no, la crea
     * @return instancia
     */
    public static GestorPuntos getInstancia() {
        if (instancia == null) {
            instancia = new GestorPuntos();
        }
        return instancia;
    }

    // METODOS

    /**
     * Recoge la nueva cantidad que tiene el contador de puntos y lo settea
     */
    private void actualizarTextoContador (){
        if (textoContador != null) {
            textoContador.setText(String.valueOf(contadorPuntosTotales));
        }
    }

    /**
     * Añade puntos al contador total de puntos
     * @param puntos la cantidad de puntos a añadir
     */
    public void añadirPuntos(int puntos) {
        contadorPuntosTotales = contadorPuntosTotales + puntos;
        actualizarTextoContador();
    }

    /**
     * Elimina puntos al contador total de puntos
     * @param puntos la cantidad de puntos a eliminar
     */
    public void eliminarPuntos(int puntos) {
        contadorPuntosTotales = contadorPuntosTotales - puntos;
        actualizarTextoContador();
    }

    /**
     * Reinicia el contador de puntos (Usado al salir)
     */
    public static void reiniciar () {
        contadorPuntosTotales = 0;
        instancia = null;
    }

    // GETTERS Y SETTERS

    public int getContadorPuntosTotales() {
        return contadorPuntosTotales;
    }

    public void setTextoContador(Text textoContador) {
        this.textoContador = textoContador;
        actualizarTextoContador();
    }
}
