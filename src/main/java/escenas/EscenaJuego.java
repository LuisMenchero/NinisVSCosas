package escenas;
import Estadisticas.EstadisticasRecuento;
import controladores.ControladorJuego;
import controladores.ControladorMusica;
import controladores.ControladorReloj;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import modelos.*;
import modelos.Cosas.*;
import modelos.Ninis.*;

import java.util.HashMap;

/**
 * Representa la Escena principal del juego
 * @author Diego
 * @author Luis
 * @version 1.0
 */
public class EscenaJuego {

    private static ControladorReloj reloj = new ControladorReloj();
    private static Celda[][] terreno = new Celda[Cuadricula.filas][Cuadricula.columnas];
    private Pane panelPausa = new Pane();
    private static Pane panelPartidaTerminada = new Pane();
    private TipoNini niniSeleccionadoTipo;
    private static Rectangle hitboxCasa;
    private boolean modoColgarActivo = false;
    public static Pane panelespecificoparacontroladorjuego;
    public static String nombreJugadorLeido = "";

    /**
     * Construye la escena del juego y pone las cosas en sus sitios
     * @param stage ventana de la aplicacion
     * @return Scene
     */
    public Scene construir(Stage stage) {
        ImageView fondo = new ImageView("imagenes/fondoNvsW.png");
        fondo.setFitWidth(1280);
        fondo.setFitHeight(720);
        ControladorMusica.reproducirMusicaJuego();
        // Para crear e inicializar el tablero donde colocar las plantas/ninis
        for (int i = 0; i < Cuadricula.columnas; i++) {
            for (int j = 0; j < Cuadricula.filas; j++) {
                terreno[j][i] = new Celda();
            }
        }

        GestorButanitos geB = GestorButanitos.getInstancia();

        //Botón de pausa
        Button btnPausa = new Button("=");
        btnPausa.setLayoutX(1200);
        btnPausa.setLayoutY(20);
        btnPausa.setOnAction(evento -> {
            reloj.pausa();
            mostrarPanelPausa();
            ControladorMusica.pausarMusicaJuego();
        });
        btnPausa.setStyle("-fx-background-color: none; -fx-text-fill: #7289da; -fx-font-size: 35px;");
        btnPausa.setOnMouseEntered(evento -> {btnPausa.setStyle("-fx-background-color: none; -fx-text-fill: white; -fx-font-size: 35px;");});
        btnPausa.setOnMouseExited(evento -> {btnPausa.setStyle("-fx-background-color: none; -fx-text-fill: #7289da; -fx-font-size: 35px;");});


        //Iniciar el reloj interno del juego (game loop)
        reloj.iniciarReloj();


        ImageView menuPlantas = new ImageView("Imagenes/PlantasRN.png");
        menuPlantas.setFitWidth(450);
        menuPlantas.setFitHeight(75);
        menuPlantas.setLayoutX(50);
        menuPlantas.setLayoutY(20);


        int numeroButanitos = geB.getContadorButanitos();
        Text cantidadButanitos = new Text();
        cantidadButanitos.setLayoutX(1120);
        cantidadButanitos.setLayoutY(87);
        cantidadButanitos.setFill(Color.WHITE);
        cantidadButanitos.setFont(Font.font("Verdana", FontWeight.BOLD, 20));


        cantidadButanitos.setText(String.valueOf(numeroButanitos));
        geB.setTextoContador(cantidadButanitos);

        //Imagen de cantidad de butanitos
        ImageView cuadroButanos = new ImageView("Imagenes/Cuadro_Butanitos.png");
        cuadroButanos.setLayoutX(1110);
        cuadroButanos.setLayoutY(20);
        cuadroButanos.setFitWidth(75);
        cuadroButanos.setFitHeight(75);


        // para la barra de las plantas seleccionadas
        ImageView luis = new ImageView("Imagenes/Luis_Cuadricula.png");
        luis.setVisible(false);
        ImageView diego = new ImageView("Imagenes/Diegosaas_1.png");
        diego.setVisible(false);
        ImageView callejo = new ImageView("Imagenes/Callejones.png");
        callejo.setVisible(false);
        ImageView adripan = new ImageView("Imagenes/Adrinap.png");
        adripan.setVisible(false);
        ImageView isma = new ImageView("Imagenes/Ismahil.png");
        isma.setVisible(false);
        ImageView ximena = new ImageView("Imagenes/Guimena.png");
        ximena.setVisible(false);
        ImageView lopez = new ImageView("Imagenes/Lucillos.png");
        lopez.setVisible(false);
        ImageView guille = new ImageView("Imagenes/Guille_No_Seleccion.png");
        guille.setVisible(false);
        ImageView dani = new ImageView("Imagenes/Dani_no_seleccion.png");
        dani.setVisible(false);
        ImageView keke = new ImageView("Imagenes/Keke_No_Seleccion.png");
        keke.setVisible(false);
        ImageView guevara = new ImageView("Imagenes/Guevarote.png");
        guevara.setVisible(false);
        ImageView lorena = new ImageView("Imagenes/Lorena_no_seleccion.png");
        lorena.setVisible(false);
        ImageView maria = new ImageView("Imagenes/Maria_No_Seleccion.png");
        maria.setVisible(false);
        ImageView jud = new ImageView("Imagenes/Jut_No_Seleccion.png");
        jud.setVisible(false);
        ImageView elsa = new ImageView("Imagenes/Elsa_No_Seleccion.png");
        elsa.setVisible(false);
        ImageView eliseo = new ImageView("Imagenes/Eliseo_no_seleccion.png");
        eliseo.setVisible(false);
        ImageView raul = new ImageView("Imagenes/Rayul.png");
        raul.setVisible(false);
        ImageView irene = new ImageView("Imagenes/Irene_No_Seleccion.png");
        irene.setVisible(false);
        ImageView alvaro = new ImageView("Imagenes/Alvaro_No_Seleccion.png");
        alvaro.setVisible(false);
        ImageView hamil = new ImageView("Imagenes/Hamil_No_Seleccion.png");
        hamil.setVisible(false);

        GestorInventario geInv = GestorInventario.getInstancia();

        HashMap<TipoNini, ImageView> nombresImagenes = new HashMap<>();
        nombresImagenes.put(TipoNini.LUIS, luis);
        nombresImagenes.put(TipoNini.DIEGO, diego);
        nombresImagenes.put(TipoNini.CALLEJO, callejo);
        nombresImagenes.put(TipoNini.ADRIPAN, adripan);
        nombresImagenes.put(TipoNini.GUEVARA, guevara);
        nombresImagenes.put(TipoNini.LOPEZ, lopez);
        nombresImagenes.put(TipoNini.ISMA, isma);
        nombresImagenes.put(TipoNini.XIMENA, ximena);
        nombresImagenes.put(TipoNini.GUILLE, guille);
        nombresImagenes.put(TipoNini.DANI, dani);
        nombresImagenes.put(TipoNini.KEKE, keke);
        nombresImagenes.put(TipoNini.LORENA, lorena);
        nombresImagenes.put(TipoNini.MARIA, maria);
        nombresImagenes.put(TipoNini.JUD, jud);
        nombresImagenes.put(TipoNini.ELSA, elsa);
        nombresImagenes.put(TipoNini.ELISEO, eliseo);
        nombresImagenes.put(TipoNini.RAUL, raul);
        nombresImagenes.put(TipoNini.IRENE, irene);
        nombresImagenes.put(TipoNini.ALVARO, alvaro);
        nombresImagenes.put(TipoNini.HAMIL, hamil);

        HashMap<TipoNini, Integer> niniYCostes = new HashMap<>();
        niniYCostes.put(TipoNini.LUIS, 50);
        niniYCostes.put(TipoNini.DIEGO, 100);
        niniYCostes.put(TipoNini.CALLEJO, 50);
        niniYCostes.put(TipoNini.ADRIPAN, 25);
        niniYCostes.put(TipoNini.GUEVARA, 25);
        niniYCostes.put(TipoNini.LOPEZ, 125);
        niniYCostes.put(TipoNini.ISMA, 125);
        niniYCostes.put(TipoNini.XIMENA, 50);
        niniYCostes.put(TipoNini.GUILLE, 0);
        niniYCostes.put(TipoNini.DANI, 0);
        niniYCostes.put(TipoNini.KEKE, 0);
        niniYCostes.put(TipoNini.LORENA, 0);
        niniYCostes.put(TipoNini.MARIA, 0);
        niniYCostes.put(TipoNini.JUD, 0);
        niniYCostes.put(TipoNini.ELSA, 0);
        niniYCostes.put(TipoNini.ELISEO, 0);
        niniYCostes.put(TipoNini.RAUL, 0);
        niniYCostes.put(TipoNini.IRENE, 0);
        niniYCostes.put(TipoNini.ALVARO, 0);
        niniYCostes.put(TipoNini.HAMIL, 0);

        TipoNini[] inventarioCopia = geInv.getInventario();
        for (int i = 0; i < 8; i++) {
            if (inventarioCopia[i] != null && nombresImagenes.containsKey(inventarioCopia[i])) {
                ImageView niniSeleccionado = nombresImagenes.get(inventarioCopia[i]);
                int posicion = geInv.getPosicionActual(inventarioCopia[i]);

                // Nini 1
                int posicionXNini1 = 58;
                // Nini 2
                int posicionXNini2 = 113;
                // Nini 3
                int posicionXNini3 = 167;
                // Nini 4
                int posicionXNini4 = 222;
                // Nini 5
                int posicionXNini5 = 277;
                // Nini 6
                int posicionXNini6 = 332;
                // Nini 7
                int posicionXNini7 = 386;
                // Nini 8
                int posicionXNini8 = 441;

                int posicionYNinis = 37;

                niniSeleccionado.setVisible(true);
                niniSeleccionado.setFitWidth(50);
                niniSeleccionado.setFitHeight(50);
                niniSeleccionado.setOnMouseClicked(evento -> {
                    for (ImageView imagenAct : nombresImagenes.values()) {
                        if (imagenAct == luis) {
                            imagenAct.setImage(new Image("Imagenes/Luis_Cuadricula.png"));
                        } else if (imagenAct == diego) {
                            imagenAct.setImage(new Image("Imagenes/Diegosaas_1.png"));
                        } else if (imagenAct == callejo) {
                            imagenAct.setImage(new Image("Imagenes/Callejones.png"));
                        } else if (imagenAct == adripan) {
                            imagenAct.setImage(new Image("Imagenes/Adrinap.png"));
                        } else if (imagenAct == guevara) {
                            imagenAct.setImage(new Image("Imagenes/Guevarote.png"));
                        } else if (imagenAct == lopez) {
                            imagenAct.setImage(new Image("Imagenes/Lucillos.png"));
                        } else if (imagenAct == isma) {
                            imagenAct.setImage(new Image("Imagenes/Ismahil.png"));
                        } else if (imagenAct == ximena) {
                            imagenAct.setImage(new Image("Imagenes/Guimena.png"));
                        } else if (imagenAct == guille) {
                            imagenAct.setImage(new Image("Imagenes/Guille_No_Seleccion.png"));
                        } else if (imagenAct == dani) {
                            imagenAct.setImage(new Image("Imagenes/Dani_no_seleccion.png"));
                        } else if (imagenAct == keke) {
                            imagenAct.setImage(new Image("Imagenes/Keke_No_Seleccion.png"));
                        } else if (imagenAct == lorena) {
                            imagenAct.setImage(new Image("Imagenes/Lorena_no_seleccion.png"));
                        } else if (imagenAct == maria) {
                            imagenAct.setImage(new Image("Imagenes/Maria_No_Seleccion.png"));
                        } else if (imagenAct == jud) {
                            imagenAct.setImage(new Image("Imagenes/Jut_No_Seleccion.png"));
                        } else if (imagenAct == elsa) {
                            imagenAct.setImage(new Image("Imagenes/Elsa_No_Seleccion.png"));
                        } else if (imagenAct == eliseo) {
                            imagenAct.setImage(new Image("Imagenes/Eliseo_no_seleccion.png"));
                        } else if (imagenAct == raul) {
                            imagenAct.setImage(new Image("Imagenes/Rayul.png"));
                        } else if (imagenAct == irene) {
                            imagenAct.setImage(new Image("Imagenes/Irene_No_Seleccion.png"));
                        } else if (imagenAct == alvaro) {
                            imagenAct.setImage(new Image("Imagenes/Alvaro_No_Seleccion.png"));
                        } else if (imagenAct == hamil) {
                            imagenAct.setImage(new Image("Imagenes/Hamil_No_Seleccion.png"));
                        }
                    }
                    if (niniSeleccionado == luis) {
                        niniSeleccionado.setImage(new Image("Imagenes/Luis_Cuadricula_Seleccionada.png"));
                        niniSeleccionadoTipo = TipoNini.LUIS;
                    } else if (niniSeleccionado == diego) {
                        niniSeleccionado.setImage(new Image("Imagenes/Diegosaas_Seleccionado.png"));
                        niniSeleccionadoTipo = TipoNini.DIEGO;
                    } else if (niniSeleccionado == callejo) {
                        niniSeleccionado.setImage(new Image("Imagenes/Callejones_Seleccionado.png"));
                        niniSeleccionadoTipo = TipoNini.CALLEJO;
                    } else if (niniSeleccionado == adripan) {
                        niniSeleccionado.setImage(new Image("Imagenes/Adrinap_Seleccionado.png"));
                        niniSeleccionadoTipo = TipoNini.ADRIPAN;
                    } else if (niniSeleccionado == guevara) {
                        niniSeleccionado.setImage(new Image("Imagenes/Guevarote_Seleccionado.png"));
                        niniSeleccionadoTipo = TipoNini.GUEVARA;
                    } else if (niniSeleccionado == lopez) {
                        niniSeleccionado.setImage(new Image("Imagenes/Lucillos_Seleccionado.png"));
                        niniSeleccionadoTipo = TipoNini.LOPEZ;
                    } else if (niniSeleccionado == isma) {
                        niniSeleccionado.setImage(new Image("Imagenes/Ismahil_Seleccionado.png"));
                        niniSeleccionadoTipo = TipoNini.ISMA;
                    } else if (niniSeleccionado == ximena) {
                        niniSeleccionado.setImage(new Image("Imagenes/Guimena_Seleccionado.png"));
                        niniSeleccionadoTipo = TipoNini.XIMENA;
                    } else if (niniSeleccionado == guille) {
                        niniSeleccionado.setImage(new Image("Imagenes/Guille_Seleccion.png"));
                        niniSeleccionadoTipo = TipoNini.GUILLE;
                    } else if (niniSeleccionado == dani) {
                        niniSeleccionado.setImage(new Image("Imagenes/Dani_seleccion.png"));
                        niniSeleccionadoTipo = TipoNini.DANI;
                    } else if (niniSeleccionado == keke) {
                        niniSeleccionado.setImage(new Image("Imagenes/Keke_Seleccion.png"));
                        niniSeleccionadoTipo = TipoNini.KEKE;
                    } else if (niniSeleccionado == lorena) {
                        niniSeleccionado.setImage(new Image("Imagenes/Lorena_seleccion.png"));
                        niniSeleccionadoTipo = TipoNini.LORENA;
                    } else if (niniSeleccionado == maria) {
                        niniSeleccionado.setImage(new Image("Imagenes/Maria_Seleccion.png"));
                        niniSeleccionadoTipo = TipoNini.MARIA;
                    } else if (niniSeleccionado == jud) {
                        niniSeleccionado.setImage(new Image("Imagenes/Jut_Seleccion.png"));
                        niniSeleccionadoTipo = TipoNini.JUD;
                    } else if (niniSeleccionado == elsa) {
                        niniSeleccionado.setImage(new Image("Imagenes/Elsa_Seleccion.png"));
                        niniSeleccionadoTipo = TipoNini.ELSA;
                    } else if (niniSeleccionado == eliseo) {
                        niniSeleccionado.setImage(new Image("Imagenes/Eliseo_seleccion.png"));
                        niniSeleccionadoTipo = TipoNini.ELISEO;
                    } else if (niniSeleccionado == raul) {
                        niniSeleccionado.setImage(new Image("Imagenes/Rayul_Seleccionado.png"));
                        niniSeleccionadoTipo = TipoNini.RAUL;
                    } else if (niniSeleccionado == irene) {
                        niniSeleccionado.setImage(new Image("Imagenes/Irene_Seleccion.png"));
                        niniSeleccionadoTipo = TipoNini.IRENE;
                    } else if (niniSeleccionado == alvaro) {
                        niniSeleccionado.setImage(new Image("Imagenes/Alvaro_Seleccion.png"));
                        niniSeleccionadoTipo = TipoNini.ALVARO;
                    } else if (niniSeleccionado == hamil) {
                        niniSeleccionado.setImage(new Image("Imagenes/Hamil_Seleccion.png"));
                        niniSeleccionadoTipo = TipoNini.HAMIL;
                    }
                });

                if (posicion == 0) {
                    niniSeleccionado.setLayoutX(posicionXNini1);
                    niniSeleccionado.setLayoutY(posicionYNinis);
                } else if (posicion == 1) {
                    niniSeleccionado.setLayoutX(posicionXNini2);
                    niniSeleccionado.setLayoutY(posicionYNinis);
                } else if (posicion == 2) {
                    niniSeleccionado.setLayoutX(posicionXNini3);
                    niniSeleccionado.setLayoutY(posicionYNinis);
                } else if (posicion == 3) {
                    niniSeleccionado.setLayoutX(posicionXNini4);
                    niniSeleccionado.setLayoutY(posicionYNinis);
                } else if (posicion == 4) {
                    niniSeleccionado.setLayoutX(posicionXNini5);
                    niniSeleccionado.setLayoutY(posicionYNinis);
                } else if (posicion == 5) {
                    niniSeleccionado.setLayoutX(posicionXNini6);
                    niniSeleccionado.setLayoutY(posicionYNinis);
                } else if (posicion == 6) {
                    niniSeleccionado.setLayoutX(posicionXNini7);
                    niniSeleccionado.setLayoutY(posicionYNinis);
                } else if (posicion == 7) {
                    niniSeleccionado.setLayoutX(posicionXNini8);
                    niniSeleccionado.setLayoutY(posicionYNinis);
                }
            }
        }


        //Para colgar

        //Agarrini la palini
        ImageView colgar = new ImageView("Animaciones/Items/BotonColgar.png");
        colgar.setLayoutX(1010);
        colgar.setLayoutY(20);
        colgar.setFitWidth(75);
        colgar.setFitHeight(75);

        colgar.setOnMouseClicked(evento -> {
            modoColgarActivo = true;
            niniSeleccionadoTipo = null;
            colgar.setImage(new Image("Animaciones/Items/BotonColgarPulsado.png"));

            for (ImageView imagenAct : nombresImagenes.values()) {
                if (imagenAct == luis) {
                    imagenAct.setImage(new Image("Imagenes/Luis_Cuadricula.png"));
                } else if (imagenAct == diego) {
                    imagenAct.setImage(new Image("Imagenes/Diegosaas_1.png"));
                } else if (imagenAct == callejo) {
                    imagenAct.setImage(new Image("Imagenes/Callejones.png"));
                } else if (imagenAct == adripan) {
                    imagenAct.setImage(new Image("Imagenes/Adrinap.png"));
                } else if (imagenAct == guevara) {
                    imagenAct.setImage(new Image("Imagenes/Guevarote.png"));
                } else if (imagenAct == lopez) {
                    imagenAct.setImage(new Image("Imagenes/Lucillos.png"));
                } else if (imagenAct == isma) {
                    imagenAct.setImage(new Image("Imagenes/Ismahil.png"));
                } else if (imagenAct == ximena) {
                    imagenAct.setImage(new Image("Imagenes/Guimena.png"));
                } else if (imagenAct == guille) {
                    imagenAct.setImage(new Image("Imagenes/Guille_No_Seleccion.png"));
                } else if (imagenAct == dani) {
                    imagenAct.setImage(new Image("Imagenes/Dani_no_seleccion.png"));
                } else if (imagenAct == keke) {
                    imagenAct.setImage(new Image("Imagenes/Keke_No_Seleccion.png"));
                } else if (imagenAct == lorena) {
                    imagenAct.setImage(new Image("Imagenes/Lorena_no_seleccion.png"));
                } else if (imagenAct == maria) {
                    imagenAct.setImage(new Image("Imagenes/Maria_No_Seleccion.png"));
                } else if (imagenAct == jud) {
                    imagenAct.setImage(new Image("Imagenes/Jut_No_Seleccion.png"));
                } else if (imagenAct == elsa) {
                    imagenAct.setImage(new Image("Imagenes/Elsa_No_Seleccion.png"));
                } else if (imagenAct == eliseo) {
                    imagenAct.setImage(new Image("Imagenes/Eliseo_no_seleccion.png"));
                } else if (imagenAct == raul) {
                    imagenAct.setImage(new Image("Imagenes/Rayul.png"));
                } else if (imagenAct == irene) {
                    imagenAct.setImage(new Image("Imagenes/Irene_No_Seleccion.png"));
                } else if (imagenAct == alvaro) {
                    imagenAct.setImage(new Image("Imagenes/Alvaro_No_Seleccion.png"));
                } else if (imagenAct == hamil) {
                    imagenAct.setImage(new Image("Imagenes/Hamil_No_Seleccion.png"));
                }
            }

                });

        Pane root = new Pane(fondo, btnPausa, menuPlantas, cuadroButanos, cantidadButanitos, colgar, luis, diego, callejo, adripan, isma, ximena, lopez, guille, dani, keke, guevara, lorena, maria, jud, elsa, eliseo, raul, irene, alvaro, hamil);
        panelespecificoparacontroladorjuego = root;

        root.setOnMouseClicked((evento) -> {

            //Para colgar
            if (modoColgarActivo == true){
                int filaClick = Cuadricula.convertirAFila(evento.getY());
                int columnaClick = Cuadricula.convertirAColumna(evento.getX());

                if (terreno[filaClick][columnaClick].getHayPlanta()){
                    terreno[filaClick][columnaClick].getNini().morir();
                    terreno[filaClick][columnaClick].limpiar();
                    colgar.setImage(new Image("Animaciones/Items/BotonColgar.png"));
                    EstadisticasRecuento.sumarNinisEliminados();
                }

                modoColgarActivo = false;
                return;

            }

            //Para plantar
            // Si pinchas un sitio en el panel que devuelve null, no hace nada ni continua
            if (niniSeleccionadoTipo == null) {
                System.out.println("nulo");
                return;
            }

            // para hacer el cambio de donde pinchas en la pantalla a coordenadas de pixeles
            int filaPinchada = Cuadricula.convertirAFila(evento.getY());
            int columnaPinchada = Cuadricula.convertirAColumna(evento.getX());
            System.out.println("fila " + filaPinchada);
            System.out.println("columna " + columnaPinchada);

            // Comprobaciones, esta en los pixeles de la cuadricula? no hay nini ya? tienes butanitos suficientes?
            if (columnaPinchada < 0 || columnaPinchada >= Cuadricula.columnas || filaPinchada < 0 || filaPinchada >= Cuadricula.filas) {
                System.out.println("por ahi no master");
                return;
            }
            if (terreno[filaPinchada][columnaPinchada].getHayPlanta()) {
                System.out.println("hay un nini ahi");
                return;
            }

//            int pruebaCoste = niniYCostes.get(niniSeleccionadoTipo);
//            if (geB.getContadorButanitos() - pruebaCoste < 0){
//                return;
//            }

            if (geB.getContadorButanitos() < niniYCostes.get(niniSeleccionadoTipo) || geB.getContadorButanitos() <= 0) {
                return;
            }

            Nini niniNuevo = null;
            if (niniSeleccionadoTipo == TipoNini.LUIS) {
                luis.setImage(new Image("Imagenes/Luis_Cuadricula.png"));
                niniNuevo = new Luis(Cuadricula.buscarMitadCeldaEjeX(columnaPinchada), Cuadricula.buscarMitadCeldaEjeY(filaPinchada), root);
            } else if (niniSeleccionadoTipo == TipoNini.DIEGO) {
                diego.setImage(new Image("Imagenes/Diegosaas_1.png"));
                niniNuevo = new Diego(Cuadricula.buscarMitadCeldaEjeX(columnaPinchada), Cuadricula.buscarMitadCeldaEjeY(filaPinchada), root);
            } else if (niniSeleccionadoTipo == TipoNini.CALLEJO) {
                callejo.setImage(new Image("Imagenes/Callejones.png"));
                niniNuevo = new Callejo(Cuadricula.buscarMitadCeldaEjeX(columnaPinchada), Cuadricula.buscarMitadCeldaEjeY(filaPinchada), root);
            } else if (niniSeleccionadoTipo == TipoNini.ADRIPAN) {
                adripan.setImage(new Image("Imagenes/Adrinap.png"));
                niniNuevo = new Adripan(Cuadricula.buscarMitadCeldaEjeX(columnaPinchada), Cuadricula.buscarMitadCeldaEjeY(filaPinchada), root);
            } else if (niniSeleccionadoTipo == TipoNini.GUEVARA) {
                guevara.setImage(new Image("Imagenes/Guevarote.png"));
                niniNuevo = new Guevara(Cuadricula.buscarMitadCeldaEjeX(columnaPinchada), Cuadricula.buscarMitadCeldaEjeY(filaPinchada), root);
            } else if (niniSeleccionadoTipo == TipoNini.LOPEZ) {
                lopez.setImage(new Image("Imagenes/Lucillos.png"));
                niniNuevo = new Lopez(Cuadricula.buscarMitadCeldaEjeX(columnaPinchada), Cuadricula.buscarMitadCeldaEjeY(filaPinchada), root);
            } else if (niniSeleccionadoTipo == TipoNini.ISMA) {
                isma.setImage(new Image("Imagenes/Ismahil.png"));
                niniNuevo = new Isma(Cuadricula.buscarMitadCeldaEjeX(columnaPinchada), Cuadricula.buscarMitadCeldaEjeY(filaPinchada), root);
            } else if (niniSeleccionadoTipo == TipoNini.XIMENA) {
                ximena.setImage(new Image("Imagenes/Guimena.png"));
                niniNuevo = new Ximena(Cuadricula.buscarMitadCeldaEjeX(columnaPinchada), Cuadricula.buscarMitadCeldaEjeY(filaPinchada), root);
            } else if (niniSeleccionadoTipo == TipoNini.GUILLE) {
                guille.setImage(new Image("Imagenes/Guille_No_Seleccion.png"));
                niniNuevo = new Guille(Cuadricula.buscarMitadCeldaEjeX(columnaPinchada), Cuadricula.buscarMitadCeldaEjeY(filaPinchada), root);
            } else if (niniSeleccionadoTipo == TipoNini.DANI) {
                dani.setImage(new Image("Imagenes/Dani_no_seleccion.png"));
                niniNuevo = new Dani(Cuadricula.buscarMitadCeldaEjeX(columnaPinchada), Cuadricula.buscarMitadCeldaEjeY(filaPinchada), root);
            } else if (niniSeleccionadoTipo == TipoNini.KEKE) {
                keke.setImage(new Image("Imagenes/Keke_No_Seleccion.png"));
                niniNuevo = new Keke(Cuadricula.buscarMitadCeldaEjeX(columnaPinchada), Cuadricula.buscarMitadCeldaEjeY(filaPinchada), root);
            } else if (niniSeleccionadoTipo == TipoNini.LORENA) {
                lorena.setImage(new Image("Imagenes/Lorena_no_seleccion.png"));
                niniNuevo = new Lorena(Cuadricula.buscarMitadCeldaEjeX(columnaPinchada), Cuadricula.buscarMitadCeldaEjeY(filaPinchada), root);
            } else if (niniSeleccionadoTipo == TipoNini.MARIA) {
                maria.setImage(new Image("Imagenes/Maria_No_Seleccion.png"));
                niniNuevo = new Maria(Cuadricula.buscarMitadCeldaEjeX(columnaPinchada), Cuadricula.buscarMitadCeldaEjeY(filaPinchada), root);
            } else if (niniSeleccionadoTipo == TipoNini.JUD) {
                jud.setImage(new Image("Imagenes/Jut_No_Seleccion.png"));
                niniNuevo = new Jud(Cuadricula.buscarMitadCeldaEjeX(columnaPinchada), Cuadricula.buscarMitadCeldaEjeY(filaPinchada), root);
            } else if (niniSeleccionadoTipo == TipoNini.ELSA) {
                elsa.setImage(new Image("Imagenes/Elsa_No_Seleccion.png"));
                niniNuevo = new Elsa(Cuadricula.buscarMitadCeldaEjeX(columnaPinchada), Cuadricula.buscarMitadCeldaEjeY(filaPinchada), root);
            } else if (niniSeleccionadoTipo == TipoNini.ELISEO) {
                eliseo.setImage(new Image("Imagenes/Eliseo_no_seleccion.png"));
                niniNuevo = new Eliseo(Cuadricula.buscarMitadCeldaEjeX(columnaPinchada), Cuadricula.buscarMitadCeldaEjeY(filaPinchada), root);
            } else if (niniSeleccionadoTipo == TipoNini.RAUL) {
                raul.setImage(new Image("Imagenes/Rayul.png"));
                niniNuevo = new Raul(Cuadricula.buscarMitadCeldaEjeX(columnaPinchada), Cuadricula.buscarMitadCeldaEjeY(filaPinchada), root);
            } else if (niniSeleccionadoTipo == TipoNini.IRENE) {
                irene.setImage(new Image("Imagenes/Irene_No_Seleccion.png"));
                niniNuevo = new Irene(Cuadricula.buscarMitadCeldaEjeX(columnaPinchada), Cuadricula.buscarMitadCeldaEjeY(filaPinchada), root);
            } else if (niniSeleccionadoTipo == TipoNini.ALVARO) {
                alvaro.setImage(new Image("Imagenes/Alvaro_No_Seleccion.png"));
                niniNuevo = new Alvaro(Cuadricula.buscarMitadCeldaEjeX(columnaPinchada), Cuadricula.buscarMitadCeldaEjeY(filaPinchada), root);
            } else if (niniSeleccionadoTipo == TipoNini.HAMIL) {
                hamil.setImage(new Image("Imagenes/Hamil_No_Seleccion.png"));
                niniNuevo = new Hamil(Cuadricula.buscarMitadCeldaEjeX(columnaPinchada), Cuadricula.buscarMitadCeldaEjeY(filaPinchada), root);
            }


            // PARA BLOQUEAR TEMPORALMENTE AL NINI CUANDO ES PLANTADO
            int posicionBarraX = 0, posicionBarraY = 71;
            // Nini 1
            int posicionXNini1 = 58;
            // Nini 2
            int posicionXNini2 = 113;
            // Nini 3
            int posicionXNini3 = 167;
            // Nini 4
            int posicionXNini4 = 222;
            // Nini 5
            int posicionXNini5 = 277;
            // Nini 6
            int posicionXNini6 = 332;
            // Nini 7
            int posicionXNini7 = 386;
            // Nini 8
            int posicionXNini8 = 441;

            int posicionYNinis = 37;

            for (int i = 0; i < 8; i++) {
                if (inventarioCopia[i] != null && nombresImagenes.containsKey(inventarioCopia[i])) {
                    int posicion = geInv.getPosicionActual(inventarioCopia[i]);
                    if (posicion == 0 && inventarioCopia[i].equals(niniNuevo.getTipoNini())) {
                        posicionBarraX = 73;
                        ControladorJuego.bloquearNini(niniNuevo.getCooldownVolverPlantar(),posicionXNini1,posicionYNinis,root);
                    } else if (posicion == 1 && inventarioCopia[i].equals(niniNuevo.getTipoNini())) {
                        posicionBarraX = 130;
                        ControladorJuego.bloquearNini(niniNuevo.getCooldownVolverPlantar(),posicionXNini2,posicionYNinis,root);                    } else if (posicion == 2 && inventarioCopia[i].equals(niniNuevo.getTipoNini())) {
                        posicionBarraX = 185;
                        ControladorJuego.bloquearNini(niniNuevo.getCooldownVolverPlantar(),posicionXNini3,posicionYNinis,root);                    } else if (posicion == 3 && inventarioCopia[i].equals(niniNuevo.getTipoNini())) {
                        posicionBarraX = 240;
                        ControladorJuego.bloquearNini(niniNuevo.getCooldownVolverPlantar(),posicionXNini4,posicionYNinis,root);                    } else if (posicion == 4 && inventarioCopia[i].equals(niniNuevo.getTipoNini())) {
                        posicionBarraX = 295;
                        ControladorJuego.bloquearNini(niniNuevo.getCooldownVolverPlantar(),posicionXNini5,posicionYNinis,root);                    } else if (posicion == 5 && inventarioCopia[i].equals(niniNuevo.getTipoNini())) {
                        posicionBarraX = 350;
                        ControladorJuego.bloquearNini(niniNuevo.getCooldownVolverPlantar(),posicionXNini6,posicionYNinis,root);                    } else if (posicion == 6 && inventarioCopia[i].equals(niniNuevo.getTipoNini())) {
                        posicionBarraX = 405;
                        ControladorJuego.bloquearNini(niniNuevo.getCooldownVolverPlantar(),posicionXNini7,posicionYNinis,root);                    } else if (posicion == 7 && inventarioCopia[i].equals(niniNuevo.getTipoNini())) {
                        posicionBarraX = 460;
                        ControladorJuego.bloquearNini(niniNuevo.getCooldownVolverPlantar(),posicionXNini8,posicionYNinis,root);                    }
                }
            }
            ControladorJuego.crearBarraCooldownNini(niniNuevo.getCooldownVolverPlantar(),posicionBarraX,posicionBarraY,root);
            terreno[filaPinchada][columnaPinchada].setNini(niniNuevo);

            geB.restarButanitos(niniNuevo.getCosteButanitos());
            niniSeleccionadoTipo = null;
//            niniTransparente.setVisible(false);
            reloj.registrarNini(niniNuevo);
        });

        hitboxCasa = new Rectangle(
                0,
                150,
                200,
                550
        );
        hitboxCasa.setFill(Color.RED);
        hitboxCasa.setOpacity(0.5);
        hitboxCasa.setVisible(false);

        ConstruirPanelPausa(stage);
        ConstruirPanelPartidaPerdida(stage);
        root.getChildren().addAll(panelPausa, panelPartidaTerminada, hitboxCasa);

        return new Scene(root, 1280, 720);
    }

    /**
     * Construye el panel de pausa
     * @param stage ventana de la aplicacion
     */
    private void ConstruirPanelPausa(Stage stage) {

        panelPausa.setPrefSize(1280, 720);

        //Esta es la primera vez que uso el -fx y sirve como una especie de css
        panelPausa.setStyle("-fx-background-color: rgba(0,0,0,0.6);");
        Text textoPausa = new Text("Pausa");
        textoPausa.setFill(Color.WHITE);
        textoPausa.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
        textoPausa.setLayoutX(560);
        textoPausa.setLayoutY(300);

        Button btnReanudar = new Button("Reanudar");
        btnReanudar.setLayoutX(540);
        btnReanudar.setLayoutY(350);
        btnReanudar.setOnAction(evento -> {
            reloj.pausa();
            mostrarPanelPausa();
            ControladorMusica.despausarMusicaJuego();
        });
        btnReanudar.setStyle("-fx-background-color: none; -fx-text-fill: #ffffff; -fx-font-size: 35px;");
        btnReanudar.setOnMouseEntered(evento -> {btnReanudar.setStyle("-fx-background-color: none; -fx-text-fill: #979797; -fx-font-size: 35px;");});
        btnReanudar.setOnMouseExited(evento -> {btnReanudar.setStyle("-fx-background-color: none; -fx-text-fill: #ffffff; -fx-font-size: 35px;");});

        Button btnSalir = new Button("Salir");
        btnSalir.setLayoutX(540);
        btnSalir.setLayoutY(400);
        btnSalir.setOnAction(evento -> {
            reloj.terminar();
            ControladorReloj.reiniciar();
            GestorButanitos.reiniciar();
            EscenaMenu escenaMenu = new EscenaMenu();
            stage.setScene(escenaMenu.construir(stage));
            ControladorMusica.pararMusicaJuego();
        });
        btnSalir.setStyle("-fx-background-color: none; -fx-text-fill: #ffffff; -fx-font-size: 35px;");
        btnSalir.setOnMouseEntered(evento -> {btnSalir.setStyle("-fx-background-color: none; -fx-text-fill: #979797; -fx-font-size: 35px;");});
        btnSalir.setOnMouseExited(evento -> {btnSalir.setStyle("-fx-background-color: none; -fx-text-fill: #ffffff; -fx-font-size: 35px;");});



        panelPausa.setVisible(false);
        panelPausa.getChildren().addAll(textoPausa, btnReanudar, btnSalir);
    }

    /**
     * Construye el panel de la partida perdida
     * @param stage ventana de la aplicacion
     */
    private void ConstruirPanelPartidaPerdida(Stage stage) {

        panelPartidaTerminada.setPrefSize(1280, 720);

        //Esta es la primera vez que uso el -fx y sirve como una especie de css
        panelPartidaTerminada.setStyle("-fx-background-color: rgba(0,0,0,0.6);");
        Text textoGameOver = new Text("--- GAME OVER ---");
        textoGameOver.setFill(Color.RED);
        textoGameOver.setFont(Font.font("Verdana", FontWeight.BOLD, 50));
        textoGameOver.setLayoutX(370);
        textoGameOver.setLayoutY(270);


        Button btnSalir = new Button("Salir");
        btnSalir.setLayoutX(570);
        btnSalir.setLayoutY(400);
        btnSalir.setOnAction(evento -> {
            ControladorReloj.reiniciar();
            GestorButanitos.reiniciar();
            EscenaMenu escenaMenu = new EscenaMenu();
            stage.setScene(escenaMenu.construir(stage));
            ControladorMusica.pararMusicaJuego();
        });
        btnSalir.setStyle("-fx-background-color: none; -fx-text-fill: #dc3838; -fx-font-size: 35px;");
        btnSalir.setOnMouseEntered(evento -> {btnSalir.setStyle("-fx-background-color: none; -fx-text-fill: white; -fx-font-size: 35px;");});
        btnSalir.setOnMouseExited(evento -> {btnSalir.setStyle("-fx-background-color: none; -fx-text-fill: #dc3838; -fx-font-size: 35px;");});



        panelPartidaTerminada.setVisible(false);
        panelPartidaTerminada.getChildren().addAll(textoGameOver, btnSalir);
    }

    /**
     * Muestra el panel de pausa ya construido
     */
    public void mostrarPanelPausa() {
        if (reloj.isPausado()) {
            panelPausa.setVisible(true);
            panelPausa.toFront();
        } else {
            panelPausa.setVisible(false);
        }
    }

    public static Celda[][] getTerreno() {
        return terreno;
    }

    public static Rectangle getHitboxCasa() {
        return hitboxCasa;
    }

    public static ControladorReloj getReloj() {
        return reloj;
    }

    public static Pane getPanelPartidaTerminada() {
        return panelPartidaTerminada;
    }

    public static String getNombreJugadorLeido() {
        return nombreJugadorLeido;
    }
}
