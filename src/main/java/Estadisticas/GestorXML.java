package Estadisticas;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

public class GestorXML {

    public static void inicializarXML() {
        Path path = Paths.get("src/main/resources/Estadisticas/EstadisticasJugadores.xml");
        File ficheroXml = path.toFile();

        // Si no existe, crearlo con una raíz válida
        if (!ficheroXml.exists()) {
            try {
                // Escribir la etiqueta raíz mínima para que sea un XML válido
                try (FileWriter writer = new FileWriter(ficheroXml)) {
                    writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<jugadores>\n</jugadores>");
                }
                System.out.println("Archivo XML inicializado correctamente.");
            } catch (IOException e) {
                System.err.println("Error crítico al crear el archivo físico: " + e.getMessage());
                return;
            }
        }

        // LECTURA Y PROCESAMIENTO DEL XML
        try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();

            // Aquí Java LEE todo el XML y lo carga en la variable 'xml'
            Document xml = builder.parse(ficheroXml);
            xml.getDocumentElement().normalize();

            // Obtener todos los nodos
            NodeList listaJugadores = xml.getElementsByTagName("jugador");

            System.out.println("--- Lista de Jugadores Registrados ---");
            for (int i = 0; i < listaJugadores.getLength(); i++) {
                Element unJugador = (Element) listaJugadores.item(i);

                // Extraer el texto dentro de la etiqueta <nombre>
                NodeList nombres = unJugador.getElementsByTagName("nombre");
                if (nombres.getLength() > 0) {
                    String nombreJugador = nombres.item(0).getTextContent();
                    System.out.println("Jugador " + (i + 1) + ": " + nombreJugador);
                }
            }

        } catch (ParserConfigurationException | SAXException ex) {
            System.err.println("Error: El archivo XML tiene un formato inválido o corrupto.");
        } catch (IOException ioe) {
            System.err.println("Error de lectura/escritura en el archivo: " + ioe.getMessage());
        }
    }
}