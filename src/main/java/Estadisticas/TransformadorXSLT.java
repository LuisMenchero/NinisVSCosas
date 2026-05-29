package Estadisticas;


import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * Sirve para transformar un xslt a html
 * @author Diego
 * @author Luis
 * @version 1.0
 */
public class TransformadorXSLT {

    /**
     * Genera un archivo html con el contenido modificado de un xslt
     */
    public static void transformarXML() {
        try {
            // 1. Rutas de tus archivos
            File archivoXSL = new File("src/main/resources/Estadisticas/EstadisticasJugadores.xsl");
            File archivoXML = new File("src/main/resources/Estadisticas/EstadisticasJugadores.xml");
            File archivoSalida = new File("src/main/resources/Estadisticas/resultadoEstadisticas.html");

            // 2. Crear la fábrica y el transformador
            TransformerFactory fabrica = TransformerFactory.newInstance();
            Transformer transformador = fabrica.newTransformer(new StreamSource(archivoXSL));

            // 3. Ejecutar la transformación
            transformador.transform(new StreamSource(archivoXML), new StreamResult(archivoSalida));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
