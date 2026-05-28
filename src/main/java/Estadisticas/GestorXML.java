package Estadisticas;

import escenas.EscenaMenu;
import modelos.GestorInventario;
import modelos.GestorPuntos;
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
import java.time.*;
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
                    writer.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<?xml-stylesheet href=\"EstadisticasJugadores.xsl\" type=\"text/xsl\"?><?xml-model href=\"EstadisticasJugadores.xsd\"?>\n<jugadores>\n</jugadores>");
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


                GestorPuntos gestorPuntos = GestorPuntos.getInstancia();


                if (gestorPuntos.getContadorPuntosTotales() <    puntuacionRegistrado) {
                    entradaExistente.getElementsByTagName("puntuacion").item(0).setTextContent(String.valueOf(gestorPuntos.getContadorPuntosTotales()));


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
                nodoJugador.setAttribute("id", String.valueOf(jugadores.getLength()+1));

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


                    String fotoNini = " ";
                    String nombreNini = " ";
                    String descNini = " ";
                    String costeNini = " ";
                    String vidaNini = " ";
                    String alcanceAtaque = " ";
                    String radioAtaque = " ";
                    String tipoProyectil = " ";
                    String dañoNini = " ";

                    if (tipoNini == TipoNini.LUIS) {
                        fotoNini= "../Animaciones/Ninis/Lis.gif";
                        nombreNini = "-- LUIS --";
                        descNini = " Luis es un hacker que consigue saltarse cualquier sistema de seguridad. Con el tiempo, consigue robar Butanitos y te los da para que los uses.";
                        costeNini = " - COSTE BUTANITOS - - 50 butanitos.";
                        vidaNini = " - SALUD - - 75 puntos de salud.";
                        alcanceAtaque = " - TIEMPO DE GENERACION DE BUTANITOS - - 25 segundos.";
                        radioAtaque = "";
                        tipoProyectil = "";
                        dañoNini = "";
                    } else if (tipoNini == TipoNini.DIEGO) {
                        fotoNini= "../Animaciones/Ninis/DiegoEsperando.gif";
                        nombreNini = "-- DIEGO --";
                        descNini = " Luis es un hacker que consigue saltarse cualquier sistema de seguridad. Con el tiempo, consigue robar Butanitos y te los da para que los uses.";
                        costeNini = " - COSTE BUTANITOS -  - 50 butanitos.";
                        vidaNini = " - SALUD -  - 75 puntos de salud.";
                        alcanceAtaque = " - TIEMPO DE GENERACION DE BUTANITOS - - 25 segundos.";
                        radioAtaque = "";
                        tipoProyectil = "";
                        dañoNini = "";
                    } else if (tipoNini == TipoNini.CALLEJO) {
                        fotoNini= "../Animaciones/Ninis/Callejo_idle.gif";
                        nombreNini = "-- CALLEJO --";
                        descNini = " Luis es un hacker que consigue saltarse cualquier sistema de seguridad. Con el tiempo, consigue robar Butanitos y te los da para que los uses.";
                        costeNini = " - COSTE BUTANITOS -  - 50 butanitos.";
                        vidaNini = " - SALUD -  - 75 puntos de salud.";
                        alcanceAtaque = " - TIEMPO DE GENERACION DE BUTANITOS - - 25 segundos.";
                        radioAtaque = "";
                        tipoProyectil = "";
                        dañoNini = "";
                    } else if (tipoNini == TipoNini.ADRIPAN) {
                        fotoNini= "../Animaciones/Ninis/AdripanEsperando.gif";
                        nombreNini = "-- ADRIPAN --";
                        descNini = " Luis es un hacker que consigue saltarse cualquier sistema de seguridad. Con el tiempo, consigue robar Butanitos y te los da para que los uses.";
                        costeNini = " - COSTE BUTANITOS -  - 50 butanitos.";
                        vidaNini = " - SALUD -  - 75 puntos de salud.";
                        alcanceAtaque = " - TIEMPO DE GENERACION DE BUTANITOS - - 25 segundos.";
                        radioAtaque = "";
                        tipoProyectil = "";
                        dañoNini = "";
                    } else if (tipoNini == TipoNini.GUEVARA) {
                        fotoNini= "../Animaciones/Ninis/Guevara_Idle.gif";
                        nombreNini = "-- GUEVARA --";
                        descNini = " Luis es un hacker que consigue saltarse cualquier sistema de seguridad. Con el tiempo, consigue robar Butanitos y te los da para que los uses.";
                        costeNini = " - COSTE BUTANITOS -  - 50 butanitos.";
                        vidaNini = " - SALUD -  - 75 puntos de salud.";
                        alcanceAtaque = " - TIEMPO DE GENERACION DE BUTANITOS - - 25 segundos.";
                        radioAtaque = "";
                        tipoProyectil = "";
                        dañoNini = "";
                    } else if (tipoNini == TipoNini.LOPEZ) {
                        fotoNini= "../Animaciones/Ninis/LopezEsperando.gif";
                        nombreNini = "-- LOPEZ --";
                        descNini = " Luis es un hacker que consigue saltarse cualquier sistema de seguridad. Con el tiempo, consigue robar Butanitos y te los da para que los uses.";
                        costeNini = " - COSTE BUTANITOS -  - 50 butanitos.";
                        vidaNini = " - SALUD -  - 75 puntos de salud.";
                        alcanceAtaque = " - TIEMPO DE GENERACION DE BUTANITOS - - 25 segundos.";
                        radioAtaque = "";
                        tipoProyectil = "";
                        dañoNini = "";
                    } else if (tipoNini == TipoNini.ISMA) {
                        fotoNini= "../Animaciones/Ninis/Isma_Idle.gif";
                        nombreNini = "-- ISMA --";
                        descNini = " Luis es un hacker que consigue saltarse cualquier sistema de seguridad. Con el tiempo, consigue robar Butanitos y te los da para que los uses.";
                        costeNini = " - COSTE BUTANITOS -  - 50 butanitos.";
                        vidaNini = " - SALUD -  - 75 puntos de salud.";
                        alcanceAtaque = " - TIEMPO DE GENERACION DE BUTANITOS - - 25 segundos.";
                        radioAtaque = "";
                        tipoProyectil = "";
                        dañoNini = "";
                    } else if (tipoNini == TipoNini.XIMENA) {
                        fotoNini= "../Animaciones/Ninis/Ximena_idle.gif";
                        nombreNini = "-- XIMENA --";
                        descNini = " Luis es un hacker que consigue saltarse cualquier sistema de seguridad. Con el tiempo, consigue robar Butanitos y te los da para que los uses.";
                        costeNini = " - COSTE BUTANITOS -  - 50 butanitos.";
                        vidaNini = " - SALUD -  - 75 puntos de salud.";
                        alcanceAtaque = " - TIEMPO DE GENERACION DE BUTANITOS - - 25 segundos.";
                        radioAtaque = "";
                        tipoProyectil = "";
                        dañoNini = "";
                    } else if (tipoNini == TipoNini.GUILLE) {
                        fotoNini= "../Animaciones/Ninis/Guille_Idle.gif";
                        nombreNini = "-- GUILLE --";
                        descNini = " Luis es un hacker que consigue saltarse cualquier sistema de seguridad. Con el tiempo, consigue robar Butanitos y te los da para que los uses.";
                        costeNini = " - COSTE BUTANITOS -  - 50 butanitos.";
                        vidaNini = " - SALUD -  - 75 puntos de salud.";
                        alcanceAtaque = " - TIEMPO DE GENERACION DE BUTANITOS - - 25 segundos.";
                        radioAtaque = "";
                        tipoProyectil = "";
                        dañoNini = "";
                    } else if (tipoNini == TipoNini.DANI) {
                        fotoNini= "../Animaciones/Ninis/Dani_idle.gif";
                        nombreNini = "-- DANI --";
                        descNini = " Luis es un hacker que consigue saltarse cualquier sistema de seguridad. Con el tiempo, consigue robar Butanitos y te los da para que los uses.";
                        costeNini = " - COSTE BUTANITOS -  - 50 butanitos.";
                        vidaNini = " - SALUD -  - 75 puntos de salud.";
                        alcanceAtaque = " - TIEMPO DE GENERACION DE BUTANITOS - - 25 segundos.";
                        radioAtaque = "";
                        tipoProyectil = "";
                        dañoNini = "";
                    } else if (tipoNini == TipoNini.KEKE) {
                        fotoNini= "../Animaciones/Ninis/Keke_Idle.gif";
                        nombreNini = "-- KEKE --";
                        descNini = " Luis es un hacker que consigue saltarse cualquier sistema de seguridad. Con el tiempo, consigue robar Butanitos y te los da para que los uses.";
                        costeNini = " - COSTE BUTANITOS -  - 50 butanitos.";
                        vidaNini = " - SALUD -  - 75 puntos de salud.";
                        alcanceAtaque = " - TIEMPO DE GENERACION DE BUTANITOS - - 25 segundos.";
                        radioAtaque = "";
                        tipoProyectil = "";
                        dañoNini = "";
                    } else if (tipoNini == TipoNini.LORENA) {
                        fotoNini= "../Animaciones/Ninis/Lorena_Idle.gif";
                        nombreNini = "-- LORENA --";
                        descNini = " Luis es un hacker que consigue saltarse cualquier sistema de seguridad. Con el tiempo, consigue robar Butanitos y te los da para que los uses.";
                        costeNini = " - COSTE BUTANITOS -  - 50 butanitos.";
                        vidaNini = " - SALUD -  - 75 puntos de salud.";
                        alcanceAtaque = " - TIEMPO DE GENERACION DE BUTANITOS - - 25 segundos.";
                        radioAtaque = "";
                        tipoProyectil = "";
                        dañoNini = "";
                    } else if (tipoNini == TipoNini.MARIA) {
                        fotoNini= "../Animaciones/Ninis/Maria_Idle.gif";
                        nombreNini = "-- MARIA --";
                        descNini = " Luis es un hacker que consigue saltarse cualquier sistema de seguridad. Con el tiempo, consigue robar Butanitos y te los da para que los uses.";
                        costeNini = " - COSTE BUTANITOS -  - 50 butanitos.";
                        vidaNini = " - SALUD -  - 75 puntos de salud.";
                        alcanceAtaque = " - TIEMPO DE GENERACION DE BUTANITOS - - 25 segundos.";
                        radioAtaque = "";
                        tipoProyectil = "";
                        dañoNini = "";
                    } else if (tipoNini == TipoNini.JUD) {
                        fotoNini= "../Animaciones/Ninis/Jud_Idle.gif";
                        nombreNini = "-- JUD --";
                        descNini = " Luis es un hacker que consigue saltarse cualquier sistema de seguridad. Con el tiempo, consigue robar Butanitos y te los da para que los uses.";
                        costeNini = " - COSTE BUTANITOS -  - 50 butanitos.";
                        vidaNini = " - SALUD -  - 75 puntos de salud.";
                        alcanceAtaque = " - TIEMPO DE GENERACION DE BUTANITOS - - 25 segundos.";
                        radioAtaque = "";
                        tipoProyectil = "";
                        dañoNini = "";
                    } else if (tipoNini == TipoNini.ELSA) {
                        fotoNini= "../Animaciones/Ninis/Elsa_Idle.gif";
                        nombreNini = "-- ELSA --";
                        descNini = " Luis es un hacker que consigue saltarse cualquier sistema de seguridad. Con el tiempo, consigue robar Butanitos y te los da para que los uses.";
                        costeNini = " - COSTE BUTANITOS -  - 50 butanitos.";
                        vidaNini = " - SALUD -  - 75 puntos de salud.";
                        alcanceAtaque = " - TIEMPO DE GENERACION DE BUTANITOS - - 25 segundos.";
                        radioAtaque = "";
                        tipoProyectil = "";
                        dañoNini = "";
                    } else if (tipoNini == TipoNini.ELISEO) {
                        fotoNini= "../Animaciones/Ninis/Eliseo_Empuje3bolas.gif";
                        nombreNini = "-- ELISEO --";
                        descNini = " Luis es un hacker que consigue saltarse cualquier sistema de seguridad. Con el tiempo, consigue robar Butanitos y te los da para que los uses.";
                        costeNini = " - COSTE BUTANITOS -  - 50 butanitos.";
                        vidaNini = " - SALUD -  - 75 puntos de salud.";
                        alcanceAtaque = " - TIEMPO DE GENERACION DE BUTANITOS - - 25 segundos.";
                        radioAtaque = "";
                        tipoProyectil = "";
                        dañoNini = "";
                    } else if (tipoNini == TipoNini.RAUL) {
                        fotoNini= "../Animaciones/Ninis/Raul_Idle.gif";
                        nombreNini = "-- RAUL --";
                        descNini = " Luis es un hacker que consigue saltarse cualquier sistema de seguridad. Con el tiempo, consigue robar Butanitos y te los da para que los uses.";
                        costeNini = " - COSTE BUTANITOS -  - 50 butanitos.";
                        vidaNini = " - SALUD -  - 75 puntos de salud.";
                        alcanceAtaque = " - TIEMPO DE GENERACION DE BUTANITOS - - 25 segundos.";
                        radioAtaque = "";
                        tipoProyectil = "";
                        dañoNini = "";
                    } else if (tipoNini == TipoNini.IRENE) {
                        fotoNini= "../Animaciones/Ninis/Irene_Idle.gif";
                        nombreNini = "-- IRENE --";
                        descNini = " Luis es un hacker que consigue saltarse cualquier sistema de seguridad. Con el tiempo, consigue robar Butanitos y te los da para que los uses.";
                        costeNini = " - COSTE BUTANITOS -  - 50 butanitos.";
                        vidaNini = " - SALUD -  - 75 puntos de salud.";
                        alcanceAtaque = " - TIEMPO DE GENERACION DE BUTANITOS - - 25 segundos.";
                        radioAtaque = "";
                        tipoProyectil = "";
                        dañoNini = "";
                    } else if (tipoNini == TipoNini.ALVARO) {
                        fotoNini= "../Animaciones/Ninis/Alvaro_Idle.gif";
                        nombreNini = "-- ALVARO --";
                        descNini = " Luis es un hacker que consigue saltarse cualquier sistema de seguridad. Con el tiempo, consigue robar Butanitos y te los da para que los uses.";
                        costeNini = " - COSTE BUTANITOS -  - 50 butanitos.";
                        vidaNini = " - SALUD -  - 75 puntos de salud.";
                        alcanceAtaque = " - TIEMPO DE GENERACION DE BUTANITOS - - 25 segundos.";
                        radioAtaque = "";
                        tipoProyectil = "";
                        dañoNini = "";
                    } else if (tipoNini == TipoNini.HAMIL) {
                        fotoNini= "../Animaciones/Ninis/Hamil_Idle.gif";
                        nombreNini = "-- HAMIL --";
                        descNini = " Luis es un hacker que consigue saltarse cualquier sistema de seguridad. Con el tiempo, consigue robar Butanitos y te los da para que los uses.";
                        costeNini = " - COSTE BUTANITOS -  - 50 butanitos.";
                        vidaNini = " - SALUD -  - 75 puntos de salud.";
                        alcanceAtaque = " - TIEMPO DE GENERACION DE BUTANITOS - - 25 segundos.";
                        radioAtaque = "";
                        tipoProyectil = "";
                        dañoNini = "";
                    }

                    nodoNini.setAttribute("imagen", fotoNini);


                    Element nodoNombreNini = xml.createElement("nombre");
                    nodoNombreNini.setTextContent(nombreNini);
                    nodoNini.appendChild(nodoNombreNini);

                    Element nodoDescripcionNini = xml.createElement("descripcion");
                    nodoDescripcionNini.setTextContent(descNini);
                    nodoNini.appendChild(nodoDescripcionNini);

                    Element nodoCosteNini = xml.createElement("coste");
                    nodoCosteNini.setTextContent(costeNini);
                    nodoNini.appendChild(nodoCosteNini);

                    Element nodoVidaNini = xml.createElement("vida");
                    nodoVidaNini.setTextContent(vidaNini);
                    nodoNini.appendChild(nodoVidaNini);

                    Element nodoAlcanceNini = xml.createElement("alcanceAtaque");
                    nodoAlcanceNini.setTextContent(alcanceAtaque);
                    nodoNini.appendChild(nodoAlcanceNini);

                    Element nodoRadioNini = xml.createElement("radioAtaque");
                    nodoRadioNini.setTextContent(radioAtaque);
                    nodoNini.appendChild(nodoRadioNini);

                    Element nodoTipoProyectilNini = xml.createElement("tipoProyectil");
                    nodoTipoProyectilNini.setTextContent(tipoProyectil);
                    nodoNini.appendChild(nodoTipoProyectilNini);

                    Element nodoDañoNini = xml.createElement("daño");
                    nodoDañoNini.setTextContent(dañoNini);
                    nodoNini.appendChild(nodoDañoNini);

                }

                // Para extraer la fecha en la que se realiza la partida
                LocalDate fechaActual = LocalDate.now();
                Element nodoFecha = xml.createElement("fecha");
                nodoJugador.appendChild(nodoFecha);

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
                Instant tiempoActual = Instant.now();

                Duration duracion = Duration.between(EscenaMenu.getInicioPartida(), tiempoActual);

                long horas = duracion.toHours();
                long minutos = duracion.toMinutes() % 60;
                long segundos = duracion.toSeconds() % 60;

                Element nodoTiempoJugado = xml.createElement("tiempoJugado");
                nodoJugador.appendChild(nodoTiempoJugado);

                Element nodoHoras = xml.createElement("horas");
                nodoTiempoJugado.appendChild(nodoHoras);
                nodoHoras.setTextContent(String.valueOf(horas));

                Element nodoMinutos = xml.createElement("minutos");
                nodoTiempoJugado.appendChild(nodoMinutos);
                nodoMinutos.setTextContent(String.valueOf(minutos));

                Element nodoSegundos = xml.createElement("segundos");
                nodoTiempoJugado.appendChild(nodoSegundos);
                nodoSegundos.setTextContent(String.valueOf(segundos));


                // Para conseguir los datos de recuentos (cosas matadas, ninis muertos...)
                Element nodoCosasMatadas = xml.createElement("cosasMatadas");
                nodoJugador.appendChild(nodoCosasMatadas);
                nodoCosasMatadas.setTextContent(String.valueOf(9999));

                Element nodoNinisMuertos = xml.createElement("ninisMuertos");
                nodoJugador.appendChild(nodoNinisMuertos);
                nodoNinisMuertos.setTextContent(String.valueOf(9999));

                Element nodoNinisEliminados = xml.createElement("ninisEliminados");
                nodoJugador.appendChild(nodoNinisEliminados);
                nodoNinisEliminados.setTextContent(String.valueOf(9999));

                Element nodoButanitosTotales = xml.createElement("butanitosTotales");
                nodoJugador.appendChild(nodoButanitosTotales);
                nodoButanitosTotales.setTextContent(String.valueOf(9999));

                Element nodoPuntuacionTotal =  xml.createElement("puntuaciónTotal");
                nodoJugador.appendChild(nodoPuntuacionTotal);
                nodoPuntuacionTotal.setTextContent(String.valueOf(9999));


                // Para los logros (CREAR LOS LOGROS)
                Element nodoLogros =  xml.createElement("logros");
                nodoJugador.appendChild(nodoLogros);

                for (int i = 0; i < EscenaMenu.getLogros().length; i++) {
                    Element nodoLogro = xml.createElement("logro");
                    nodoLogros.appendChild(nodoLogro);
                    nodoLogro.setAttribute("idLogro", String.valueOf(EscenaMenu.getLogros()[i].getIdLogro()));
                    nodoLogro.setAttribute("dificultad", String.valueOf(EscenaMenu.getLogros()[i].getTipoDificultad()));
                    nodoLogro.setAttribute("completado",String.valueOf(EscenaMenu.getLogros()[i].estaCompletado()));

                    Element nodoTituloLogro =  xml.createElement("titulo");
                    nodoLogro.appendChild(nodoTituloLogro);
                    nodoTituloLogro.setTextContent(String.valueOf(EscenaMenu.getLogros()[i].getTitulo()));

                    Element nodoMinutoLogro =  xml.createElement("minuto");
                    nodoLogro.appendChild(nodoMinutoLogro);
                    nodoMinutoLogro.setTextContent(String.valueOf(EscenaMenu.getLogros()[i].getMinuto()));

                    Element nodoMedallitaLogro =  xml.createElement("medallita");
                    nodoLogro.appendChild(nodoMedallitaLogro);


                    // Subelementos de la medalla
                    Element nodoTipoMedalla =  xml.createElement("tipoMedalla");
                    nodoMedallitaLogro.appendChild(nodoTipoMedalla);
                    nodoTipoMedalla.setTextContent(String.valueOf(EscenaMenu.getLogros()[i].getTipoMedalla()));

                    Element nodoPuntuacionLogro =  xml.createElement("puntuacionLogro");
                    nodoMedallitaLogro.appendChild(nodoPuntuacionLogro);
                    nodoPuntuacionLogro.setTextContent(String.valueOf(EscenaMenu.getLogros()[i].getPuntuacionLogro()));
                }
                jugadoresElemento.appendChild(nodoJugador);
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
           System.err.println("Error al crear el parser XML: " + pce.getMessage());
        } catch (org.xml.sax.SAXException sae) {
            //Por error al leer o interpretar el XML (xml mal formados o estructura incorrecta)
            System.err.println("Error al parsear el XML existente: " + sae.getMessage());
        } catch (java.io.IOException ioe) {
           //el archivo no existe, no tiene permisos o ruta incorrecta. No podria llegar a ser por
            //archivo inexistente , ya que nos aseguramos de crearlo si no existeSystem.err.println("[GestorXml] Error de lectura/escritura del archivo: " + ex.getMessage());
       } catch (TransformerException te) {
           //error al guardar  o escribir el archivo, es decir, al convertir el DOM a XML y escribirlo en disco ( transformarlo)
           System.err.println("Error al escribir el XML actualizado: " + te.getMessage());
        }
    }

}