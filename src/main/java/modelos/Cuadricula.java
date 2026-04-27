package modelos;

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
        // busca mitad de una celda de una columna especifica en el eje X
    public static double buscarMitadCeldaEjeX(int columna) {
        return cordX + columna * anchoCelda;
    }
        // busca mitad de una celda de una fila especifica en el eje Y
    public static double buscarMitadCeldaEjeY(int filas) {
        return cordY + filas * altoCelda;
    }

        // para convertir los pixeles a columna/fila al hacer clic con raton
    public static int convertirAColumna(double x) {
        return (int) ((x - cordX) / (anchoCelda));
    }

    public static int convertirAFila(double y) {
        return (int) ((y - cordY) / (altoCelda));
    }
}
