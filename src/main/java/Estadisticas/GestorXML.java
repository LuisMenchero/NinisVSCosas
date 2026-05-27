package Estadisticas;

import modelos.GestorInventario;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

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
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            DocumentBuilder constructor = fabrica.newDocumentBuilder();

            // Aquí Java LEE todo el XML y lo carga en la variable 'xml'
            Document xml = constructor.parse(ficheroXml);
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


//    public static void registrarNuevoJugador(Scanner teclado) {
//        System.out.println("Nombre del jugador: ");
//        String nombreJugadorLeido = teclado.next();
//        try {
//            Path path = Paths.get("src/main/resources/Estadisticas/EstadisticasJugadores.xml");
//            File ficheroXml = path.toFile();
//            //Este crea la fabrica para construir XML,y configura como se leera, es decir , prepara el entorno
//            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
//            DocumentBuilder constructor    = fabrica.newDocumentBuilder();  // aquí puede fallar lanzando ParserConfigurationException
//
//
//            Document xml = constructor.parse(ficheroXml);
//            xml.getDocumentElement().normalize();
//
//
//            Element jugadoresElemento = xml.getDocumentElement();
//
//            //Busca de la lista jugadores , los modulos jugador
//            NodeList jugadores = xml.getElementsByTagName("jugador");
//            Element  entradaExistente = null;
//            int puntuacionRegistrado = 0;
//
//            for (int i = 0; i < jugadores.getLength(); i++) {
//                Element jugador = (Element) jugadores.item(i);
//
//                //Esto obtiene lo que hay dentro del xml en el nodo jugador , si es q existe alguno
//                String nombreGuardado = jugador.getElementsByTagName("nombre").item(0).getTextContent().trim();
//
//                // si el nombre se encuentra en el registro, guardamos el nombre jugador en element
//                //pillamos el tiempo y le colocamos el guardado si existe
//                if (nombreGuardado.equals(nombreJugadorLeido)) {
//                    entradaExistente = jugador;
//                    puntuacionRegistrado  = Integer.parseInt(jugador.getElementsByTagName("puntuacion").item(0).getTextContent().trim());
//                    break;
//                }
//            }
//
//            //Si ha pillado en entrada existene el elemento jugador
//            if (entradaExistente != null) {
//
//                //Comparamos tiempo de la ultima partida que se guardo en el registro
//                // , con el que el jugador tenia ya guardado en el XML
//
//
//
//
//                // ---------    CAMBIAAAAR A LA PUNTUACION DEL JUGADOR A PARTIR DE AQUI -------
//
//
//
//
//                // cambiar el 100 por .getPuntuacionDelJugador
//                if (100 <    puntuacionRegistrado) {
//                    entradaExistente.getElementsByTagName("puntuacion").item(0).setTextContent(String.valueOf(.getPuntuacionDelJugador));
//
//
//                    // actualizar también la fecha al mejorar
//                    entradaExistente.getElementsByTagName("fecha").item(0)
//                            .setTextContent(
//                                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
//                            );
//                } else {
//                    return;
//                }
//            } else {
//                // Si es jugador nuevo , entonces nueva entrada jugador
//
//                //Creamos el nodo jugador
//                Element nodoJugador = xml.createElement("jugador");
//                nodoJugador.setAttribute("id", String.valueOf(jugadores.getLength()));
//
//                //Creamos el nodo nombre
//                Element nodoNombre = xml.createElement("nombre");
//
//                //Le ponemos al nodo el nombre que tenemos guardado del registro
//                nodoNombre.setTextContent(nombreJugadorLeido);
//
//                //Hacemos que el nodo nombre se anide en nodo jugador
//                nodoJugador.appendChild(nodoNombre);
//
//
//
//                // Creamos el nodo ninisJugados y de 0 a 8 ninis dentro
//                Element nodoNinisJugados = xml.createElement("ninisJugados");
//                nodoJugador.appendChild(nodoNinisJugados);
//
//                GestorInventario gei = GestorInventario.getInstancia();
//                Element nodoNini;
//                for (int i = 0; i < gei.getInventario().length; i++) {
//                     nodoNini =  xml.createElement("nini");
//                    //Hacemos que el nodo nini se anide en nodo ninisJugados, dependiendo de cuantos ninis haya
//                    nodoNinisJugados.appendChild(nodoNini);
//
//                    Element nodoNombreNini = xml.createElement("nombre");
//                    nodoNombreNini.setTextContent(gei.getInventario()[i].);
//                    nodoNini.appendChild(nodoNombreNini);
//
//
//                }
//
//
//
//                Element nodoTiempo = xml.createElement("tiempo");
//
//                //Metemos el tiempo sin formatear , pero primero lo pasamos a String
//                nodoTiempo.setTextContent(String.valueOf(registro.getTiempoMs()));
//
//
//                nodoJugador.appendChild(nodoTiempo);
//
//                Element nodoFormato = xml.createElement("tiempoFormato");
//
//                //metemos el tiempoFormateado del metodo registro que ya lo da en string
//                nodoFormato.setTextContent(registro.getTiempoFormateado());
//                nodoJugador.appendChild(nodoFormato);
//
//                //fecha y hora de la partida se actualiza con un formato String
//                Element nodoFecha = xml.createElement("fecha");
//                nodoFecha.setTextContent(
//                        LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
//                );
//
//                nodoJugador.appendChild(nodoFecha);
//
//                //metemos el nodo del jugador en la raiz
//                jugadoresElemento.appendChild(nodoJugador);
//                System.out.println("[GestorXml] Nuevo jugador guardado: "
//                        + registro.getNombre() + " — " + registro.getTiempoFormateado());
//            }
//
//            // Escribir el documento o lo que tenemos en memoria actualizado en disco
//            Transformer transformador = TransformerFactory.newInstance().newTransformer();
//
//            //Esto nos permite la indentacion ,es decir, organizar el XML para que no salga en una sola linea
//            transformador.setOutputProperty(OutputKeys.INDENT, "yes");
//
//            //Esto nos permite crear dos espacios para separar cada nivel
//            //El enlace pilla la propiedad especifica del XML Apache
//            //Identificamos quien define la propiedad ,pillamos el nombre real de la propiedad y seleccionamos
//            transformador.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");
//
//            //Convierte el DOM XML en texto XML y lo escribe en el archivo.
//            //Toma el XML en la memoria y lo guarda formateado en archivo, en disco.
//            //Memoria significa que el programa lo guarda , no esta en ningun archivo
//            transformador.transform(new DOMSource(xml), new StreamResult(archivo));  // aquí puede fallar lanzando TransformerException
//
//        }catch (ParserConfigurationException ex) {
//            //Suele ocurrir cuando la configuración del DocumentBuilderFactory es incorrecta o problemas internas del parse
//            System.err.println("[GestorXml] Error al crear el parser XML: " + ex.getMessage());
//        } catch (org.xml.sax.SAXException ex) {
//            //Por error al leer o interpretar el XML (xml mal formados o estructura incorrecta)
//            System.err.println("[GestorXml] Error al parsear el XML existente: " + ex.getMessage());
//        } catch (java.io.IOException ex) {
//            //el archivo no existe, no tiene permisos o ruta incorrecta. No podria llegar a ser por
//            //archivo inexistente , ya que nos aseguramos de crearlo si no existe
//            System.err.println("[GestorXml] Error de lectura/escritura del archivo: " + ex.getMessage());
//        } catch (TransformerException ex) {
//            //error al guardar  o escribir el archivo, es decir, al convertir el DOM a XML y escribirlo en disco ( transformarlo)
//            System.err.println("[GestorXml] Error al escribir el XML actualizado: " + ex.getMessage());
//        }
//
//    }

}