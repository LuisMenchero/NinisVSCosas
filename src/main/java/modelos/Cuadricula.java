package modelos;

/**
 * Representa una cuadricula
 * @author Diego
 * @author Luis
 * @version 1.0
 */
public class Cuadricula {
    // --- ATRIBUTOS ---
    public static int columnas = 10;
    public static int filas = 5;
        // indica el inicio de la cuadricula en la imagen
    public static double cordX = 250;
    public static double cordY = 175;
        // tamaño de las celdas
    public static double anchoCelda = 80;
    public static double altoCelda = 95;

    // --- MÉTODOS ---
    /**
     * Busca mitad de una celda de una columna especifica en el eje X
     * @param columna columna a buscar su mitad
     * @return la mitad de la celda especificada
     */
    public static double buscarMitadCeldaEjeX(int columna) {
        return cordX + columna * anchoCelda;
    }

    /**
     * Busca mitad de una celda de una fila especifica en el eje Y
     * @param fila fila a buscar su mitad
     * @return la mitad de la celda especificada
     */
    public static double buscarMitadCeldaEjeY(int fila) {
        return cordY + fila * altoCelda;
    }

    /**
     * Convierte coordenada en columna
     * @param x Coordenadas X
     * @return Fila
     */
    public static int convertirAColumna(double x) {
        return (int) ((x - cordX) / (anchoCelda));
    }
    // Nos sirve para convertir los pixeles a columna/fila al hacer clic con raton

    /**
     * Convierte coordenada en fila
     * @param y Coordenadas Y
     * @return Fila
     */
    public static int convertirAFila(double y) {
        return (int) ((y - cordY) / (altoCelda));
    }
}
