package Estadisticas;

import javafx.scene.image.Image;
import modelos.Cuadricula;
import modelos.GestorInventario;
import modelos.Ninis.*;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
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


    public static void registrarNuevoJugador(Scanner teclado) {
        System.out.println("Nombre del jugador: ");
        String nombreJugadorLeido = teclado.next();
        try {
            Path path = Paths.get("src/main/resources/Estadisticas/EstadisticasJugadores.xml");
            File ficheroXml = path.toFile();
            //Este crea la fabrica para construir XML,y configura como se leera, es decir , prepara el entorno
            DocumentBuilderFactory fabrica = DocumentBuilderFactory.newInstance();
            DocumentBuilder constructor    = fabrica.newDocumentBuilder();  // aquí puede fallar lanzando ParserConfigurationException


            Document xml = constructor.parse(ficheroXml);
            xml.getDocumentElement().normalize();


            Element jugadoresElemento = xml.getDocumentElement();

            //Busca de la lista jugadores , los modulos jugador
            NodeList jugadores = xml.getElementsByTagName("jugador");
            Element  entradaExistente = null;
            int puntuacionRegistrado = 0;

            for (int i = 0; i < jugadores.getLength(); i++) {
                Element jugador = (Element) jugadores.item(i);

                //Esto obtiene lo que hay dentro del xml en el nodo jugador , si es q existe alguno
                String nombreGuardado = jugador.getElementsByTagName("nombre").item(0).getTextContent().trim();

                // si el nombre se encuentra en el registro, guardamos el nombre jugador en element
                //pillamos el tiempo y le colocamos el guardado si existe
                if (nombreGuardado.equals(nombreJugadorLeido)) {
                    entradaExistente = jugador;
                    puntuacionRegistrado  = Integer.parseInt(jugador.getElementsByTagName("puntuacion").item(0).getTextContent().trim());
                    break;
                }
            }

            //Si ha pillado en entrada existene el elemento jugador
            if (entradaExistente != null) {

                //Comparamos tiempo de la ultima partida que se guardo en el registro
                // , con el que el jugador tenia ya guardado en el XML




                // ---------    CAMBIAAAAR A LA PUNTUACION DEL JUGADOR A PARTIR DE AQUI -------




                // cambiar el 100 por .getPuntuacionDelJugador
                if (100 <    puntuacionRegistrado) {
                    entradaExistente.getElementsByTagName("puntuacion").item(0).setTextContent(String.valueOf(.getPuntuacionDelJugador));


                    // actualizar también la fecha al mejorar
                    entradaExistente.getElementsByTagName("fecha").item(0)
                            .setTextContent(
                                    LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"))
                            );
                } else {
                    return;
                }
            } else {
                // Si es jugador nuevo , entonces nueva entrada jugador

                //Creamos el nodo jugador
                Element nodoJugador = xml.createElement("jugador");
                nodoJugador.setAttribute("id", String.valueOf(jugadores.getLength()));

                //Creamos el nodo nombre
                Element nodoNombre = xml.createElement("nombre");

                //Le ponemos al nodo el nombre que tenemos guardado del registro
                nodoNombre.setTextContent(nombreJugadorLeido);

                //Hacemos que el nodo nombre se anide en nodo jugador
                nodoJugador.appendChild(nodoNombre);



                // Creamos el nodo ninisJugados y de 0 a 8 ninis dentro
                Element nodoNinisJugados = xml.createElement("ninisJugados");
                nodoJugador.appendChild(nodoNinisJugados);

                GestorInventario gei = GestorInventario.getInstancia();
                Element nodoNini;
                for (int i = 0; i < gei.getInventario().length; i++) {
                    nodoNini = xml.createElement("nini");
                    //Hacemos que el nodo nini se anide en nodo ninisJugados, dependiendo de cuantos ninis haya
                    nodoNinisJugados.appendChild(nodoNini);
                    TipoNini tipoNini = gei.getInventario()[i];
                    nodoNini.setAttribute("tipoNini", String.valueOf(tipoNini));


                    Nini niniNuevo = null;
                    if (tipoNini == TipoNini.LUIS) {
                        niniNuevo = new Luis(0,0,null);
                    } else if (tipoNini == TipoNini.DIEGO) {
                        niniNuevo = new Diego(0,0,null);
                    } else if (tipoNini == TipoNini.CALLEJO) {
                        niniNuevo = new Callejo(0,0,null);
                    } else if (tipoNini == TipoNini.ADRIPAN) {
                        niniNuevo = new Adripan(0,0,null);
                    } else if (tipoNini == TipoNini.GUEVARA) {
                        niniNuevo = new Guevara(0,0,null);
                    } else if (tipoNini == TipoNini.LOPEZ) {
                        niniNuevo = new Lopez(0,0,null);
                    } else if (tipoNini == TipoNini.ISMA) {
                        niniNuevo = new Isma(0,0,null);
                    } else if (tipoNini == TipoNini.XIMENA) {
                        niniNuevo = new Ximena(0,0,null);
                    } else if (tipoNini == TipoNini.GUILLE) {
                        niniNuevo = new Guille(0,0,null);
                    } else if (tipoNini == TipoNini.DANI) {
                        niniNuevo = new Dani(0,0,null);
                    } else if (tipoNini == TipoNini.KEKE) {
                        niniNuevo = new Keke(0,0,null);
                    } else if (tipoNini == TipoNini.LORENA) {
                        niniNuevo = new Lorena(0,0,null);
                    } else if (tipoNini == TipoNini.MARIA) {
                        niniNuevo = new Maria(0,0,null);
                    } else if (tipoNini == TipoNini.JUD) {
                        niniNuevo = new Jud(0,0,null);
                    } else if (tipoNini == TipoNini.ELSA) {
                        niniNuevo = new Elsa(0,0,null);
                    } else if (tipoNini == TipoNini.ELISEO) {
                        niniNuevo = new Eliseo(0,0,null);
                    } else if (tipoNini == TipoNini.RAUL) {
                        niniNuevo = new Raul(0,0,null);
                    } else if (tipoNini == TipoNini.IRENE) {
                        niniNuevo = new Irene(0,0,null);
                    } else if (tipoNini == TipoNini.ALVARO) {
                        niniNuevo = new Alvaro(0,0,null);
                    } else if (tipoNini == TipoNini.HAMIL) {
                        niniNuevo = new Hamil(0,0,null);
                    }

                    nodoNini.setAttribute("imagen", String.valueOf(niniNuevo.getImagenNini()));


                    Element nodoNombreNini = xml.createElement("nombre");
                    nodoNombreNini.setTextContent();
                    nodoNini.appendChild(nodoNombreNini);

                    Element nodoDescripcionNini = xml.createElement("descripcion");
                    nodoNombreNini.setTextContent();
                    nodoNini.appendChild(nodoDescripcionNini);

                    Element nodoCosteNini = xml.createElement("coste");
                    nodoNombreNini.setTextContent();
                    nodoNini.appendChild(nodoCosteNini);

                    Element nodoVidaNini = xml.createElement("vida");
                    nodoNombreNini.setTextContent();
                    nodoNini.appendChild(nodoVidaNini);

                    Element nodoAlcanceNini = xml.createElement("alcanceAtaque");
                    nodoNombreNini.setTextContent();
                    nodoNini.appendChild(nodoAlcanceNini);

                    Element nodoRadioNini = xml.createElement("radioAtaque");
                    nodoNombreNini.setTextContent();
                    nodoNini.appendChild(nodoRadioNini);

                    Element nodoTipoProyectilNini = xml.createElement("tipoProyectil");
                    nodoNombreNini.setTextContent();
                    nodoNini.appendChild(nodoTipoProyectilNini);

                    Element nodoDañoNini = xml.createElement("daño");
                    nodoNombreNini.setTextContent();
                    nodoNini.appendChild(nodoDañoNini);

                }

                // Para extraer la fecha en la que se realiza la partida
                LocalDate fechaActual = LocalDate.now();
                Element nodoFecha = xml.createElement("fecha");

                Element nodoDia = xml.createElement("dia");
                nodoFecha.appendChild(nodoDia);
                nodoDia.setTextContent(String.valueOf(fechaActual.getDayOfMonth()));

                Element nodoMes = xml.createElement("mes");
                nodoFecha.appendChild(nodoMes);
                nodoMes.setTextContent(String.valueOf(fechaActual.getMonth()));

                Element nodoAño = xml.createElement("año");
                nodoFecha.appendChild(nodoAño);
                nodoAño.setTextContent(String.valueOf(fechaActual.getYear()));


                // Para calcular y poner el tiempo que ha durado la partida
                LocalTime tiempoActual = LocalTime.now();


                LocalTime tiempoJugado =  tiempoActual.compareTo(tiempoInicioPartida);


                Element nodoTiempoJugado = xml.createElement("tiempoJugado");

                Element nodoHoras = xml.createElement("horas");
                nodoTiempoJugado.appendChild(nodoHoras);
                nodoDia.setTextContent(String.valueOf(tiempoJugado.getHour()));

                Element nodoMinutos = xml.createElement("minutos");
                nodoTiempoJugado.appendChild(nodoMinutos);
                nodoMes.setTextContent(String.valueOf(tiempoJugado.getMinute()));

                Element nodoSegundos = xml.createElement("segundos");
                nodoTiempoJugado.appendChild(nodoSegundos);
                nodoAño.setTextContent(String.valueOf(tiempoJugado.getSecond()));


                // Para conseguir los datos de recuentos (cosas matadas, ninis muertos...)
                Element nodoCosasMatadas = xml.createElement("cosasMatadas");
                nodoJugador.appendChild(nodoCosasMatadas);
                nodoJugador.setTextContent(String.valueOf());

                Element nodoNinisMuertos = xml.createElement("ninisMuertos");
                nodoJugador.appendChild(nodoNinisMuertos);
                nodoJugador.setTextContent(String.valueOf());

                Element nodoNinisEliminados = xml.createElement("ninisEliminados");
                nodoJugador.appendChild(nodoNinisEliminados);
                nodoJugador.setTextContent(String.valueOf());

                Element nodoButanitosTotales = xml.createElement("butanitosTotales");
                nodoJugador.appendChild(nodoButanitosTotales);
                nodoJugador.setTextContent(String.valueOf());

                Element nodoPuntuacionTotal =  xml.createElement("puntuaciónTotal");
                nodoJugador.appendChild(nodoPuntuacionTotal);
                nodoJugador.setTextContent(String.valueOf());


                // Para los logros (CREAR LOS LOGROS)
                Element nodoLogros =  xml.createElement("logros");
                nodoJugador.appendChild(nodoLogros);

                for (int i = 0; i < gelogr.getLogros().length; i++) {
                    Element nodoLogro = xml.createElement("logro");
                    nodoLogros.appendChild(nodoLogro);
                    nodoLogro.setAttribute("idLogro", .getIdLogro);
                    nodoLogro.setAttribute("dificultad", .getDificultad);
                    nodoLogro.setAttribute("completado", .getCompletado);

                    Element nodoTituloLogro =  xml.createElement("titulo");
                    nodoLogro.appendChild(nodoTituloLogro);
                    nodoTituloLogro.setTextContent(String.valueOf(.getTitulo));

                    Element nodoMinutoLogro =  xml.createElement("minuto");
                    nodoLogro.appendChild(nodoMinutoLogro);
                    nodoMinutoLogro.setTextContent(String.valueOf(.getMinuto));

                    Element nodoMedallitaLogro =  xml.createElement("medallita");
                    nodoLogro.appendChild(nodoMedallitaLogro);
                    nodoMedallitaLogro.setTextContent(String.valueOf(.getTitulo));

                    // Subelementos de la medalla
                    Element nodoTipoMedalla =  xml.createElement("tipoMedalla");
                    nodoMedallitaLogro.appendChild(nodoTipoMedalla);
                    nodoTipoMedalla.setTextContent(String.valueOf(.getTipoMedalla));

                    Element nodoPuntuacionLogro =  xml.createElement("puntuacionLogro");
                    nodoMedallitaLogro.appendChild(nodoPuntuacionLogro);
                    nodoPuntuacionLogro.setTextContent(String.valueOf(.getPuntuacionLogro));
                }
            }

            // Escribir el documento o lo que tenemos en memoria actualizado en disco
            Transformer transformador = TransformerFactory.newInstance().newTransformer();

            //Esto nos permite organizar el XML para que no salga en una sola linea
            transformador.setOutputProperty(OutputKeys.INDENT, "yes");

            //Esto nos permite crear dos espacios para separar cada nivel
            //El enlace pilla la propiedad especifica del XML Apache
            //Identificamos quien define la propiedad ,pillamos el nombre real de la propiedad y seleccionamos
            transformador.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "2");

            //Convierte el DOM XML en texto XML y lo escribe en el archivo.
            transformador.transform(new DOMSource(xml), new StreamResult("src/main/resources/Estadisticas/EstadisticasJugadores.xml"));

        }catch (ParserConfigurationException pce) {
            //Suele ocurrir cuando la configuración del DocumentBuilderFactory es incorrecta o problemas internas del parse
           System.err.println("[GestorXml] Error al crear el parser XML: " + pce.getMessage());
        } catch (org.xml.sax.SAXException sae) {
            //Por error al leer o interpretar el XML (xml mal formados o estructura incorrecta)
            System.err.println("[GestorXml] Error al parsear el XML existente: " + sae.getMessage());
        } catch (java.io.IOException ioe) {
           //el archivo no existe, no tiene permisos o ruta incorrecta. No podria llegar a ser por
            //archivo inexistente , ya que nos aseguramos de crearlo si no existeSystem.err.println("[GestorXml] Error de lectura/escritura del archivo: " + ex.getMessage());
       } catch (TransformerException te) {
           //error al guardar  o escribir el archivo, es decir, al convertir el DOM a XML y escribirlo en disco ( transformarlo)
           System.err.println("[GestorXml] Error al escribir el XML actualizado: " + te.getMessage());
        }
    }

}