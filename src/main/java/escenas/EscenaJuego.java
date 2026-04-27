package escenas;

import controladores.ControladorMusica;
import controladores.ControladorReloj;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import modelos.*;
import modelos.Ninis.*;

import java.util.HashMap;

public class EscenaJuego {

    private ControladorReloj reloj = new ControladorReloj();
    private static Celda[][] terreno = new Celda[Cuadricula.filas][Cuadricula.columnas];
    private Pane panelPausa = new Pane();
    private TipoNini niniSeleccionadoTipo;
    private ImageView niniTransparente;


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
        btnPausa.setLayoutY(10);
        btnPausa.setOnAction(evento -> {
            reloj.pausa();
            mostrarPanelPausa();
            ControladorMusica.pausarMusicaJuego();
        });

        //Iniciar el reloj interno del juego (game loop)
        reloj.iniciarReloj();


        ImageView menuPlantas = new ImageView("Imagenes/PlantasRN.png");
        menuPlantas.setFitWidth(450);
        menuPlantas.setFitHeight(75);
        menuPlantas.setLayoutX(50);
        menuPlantas.setLayoutY(20);


        int numeroButanitos = geB.getContadorButanitos();
        Text cantidadButanitos = new Text();
        cantidadButanitos.setLayoutX(1100);
        cantidadButanitos.setLayoutY(20);
        cantidadButanitos.setFill(Color.WHITE);


        cantidadButanitos.setText(String.valueOf(numeroButanitos));
        geB.setTextoContador(cantidadButanitos);


        // para la barra de las plantas seleccionadas
        ImageView luis = new ImageView("Imagenes/Luis_Cuadricula.png");
        luis.setVisible(false);


        ImageView diego = new ImageView("Imagenes/Diegosaas_1.png");
        diego.setVisible(false);
        ImageView callejo = new ImageView("Imagenes/Callejones.png");
        callejo.setVisible(false);
        ImageView adripan = new ImageView("Imagenes/Adrinap.png");
        adripan.setVisible(false);
        ImageView isma = new ImageView("Imagenes/CosoPrueba.png");
        isma.setVisible(false);
        ImageView ximena = new ImageView("Imagenes/Guimena.png");
        ximena.setVisible(false);
        ImageView lopez = new ImageView("Imagenes/Lucillos.png");
        lopez.setVisible(false);
        ImageView guille = new ImageView("Imagenes/CosoPrueba.png");
        guille.setVisible(false);
        ImageView dani = new ImageView("Imagenes/CosoPrueba.png");
        dani.setVisible(false);
        ImageView keke = new ImageView("Imagenes/CosoPrueba.png");
        keke.setVisible(false);
        ImageView guevara = new ImageView("Imagenes/Guevarote.png");
        guevara.setVisible(false);
        ImageView lorena = new ImageView("Imagenes/CosoPrueba.png");
        lorena.setVisible(false);
        ImageView maria = new ImageView("Imagenes/CosoPrueba.png");
        maria.setVisible(false);
        ImageView jud = new ImageView("Imagenes/CosoPrueba.png");
        jud.setVisible(false);
        ImageView elsa = new ImageView("Imagenes/CosoPrueba.png");
        elsa.setVisible(false);
        ImageView eliseo = new ImageView("Imagenes/CosoPrueba.png");
        eliseo.setVisible(false);
        ImageView hueco1 = new ImageView("Imagenes/CosoPrueba.png");
        hueco1.setVisible(false);
        ImageView hueco2 = new ImageView("Imagenes/CosoPrueba.png");
        hueco2.setVisible(false);
        ImageView hueco3 = new ImageView("Imagenes/CosoPrueba.png");
        hueco3.setVisible(false);
        ImageView hueco4 = new ImageView("Imagenes/CosoPrueba.png");
        hueco4.setVisible(false);

        GestorInventario geInv = GestorInventario.getInstancia();

        HashMap<String, ImageView> nombresImagenes = new HashMap<>();
        nombresImagenes.put("luis", luis);
        nombresImagenes.put("diego", diego);
        nombresImagenes.put("callejo", callejo);
        nombresImagenes.put("adripan", adripan);
        nombresImagenes.put("guevara", guevara);
        nombresImagenes.put("lopez", lopez);
        nombresImagenes.put("isma", isma);
        nombresImagenes.put("ximena", ximena);
        nombresImagenes.put("guille", guille);
        nombresImagenes.put("dani", dani);
        nombresImagenes.put("keke", keke);
        nombresImagenes.put("lorena", lorena);
        nombresImagenes.put("maria", maria);
        nombresImagenes.put("jud", jud);
        nombresImagenes.put("elsa", elsa);
        nombresImagenes.put("eliseo", eliseo);

        String[] inventarioCopia = geInv.getInventario();
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
//                        } else if (imagenAct == isma) {

                        } else if (imagenAct == ximena) {
                            imagenAct.setImage(new Image("Imagenes/Guimena.png"));
//                        } else if (imagenAct == guille) {
//
//                        } else if (imagenAct == dani) {
//
//                        } else if (imagenAct == keke) {
//
//                        } else if (imagenAct == lorena) {
//
//                        } else if (imagenAct == maria) {
//
//                        } else if (imagenAct == jud) {
//
//                        } else if (imagenAct == elsa) {
//
//                        } else if (imagenAct == eliseo) {

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
//                    } else if (niniSeleccionado == isma) {

                    } else if (niniSeleccionado == ximena) {
                        niniSeleccionado.setImage(new Image("Imagenes/Guimena_Seleccionado.png"));
                        niniSeleccionadoTipo = TipoNini.XIMENA;
//                    } else if (niniSeleccionado == guille) {
//
//                    } else if (niniSeleccionado == dani) {
//
//                    } else if (niniSeleccionado == keke) {
//
//                    } else if (niniSeleccionado == lorena) {
//
//                    } else if (niniSeleccionado == maria) {
//
//                    } else if (niniSeleccionado == jud) {
//
//                    } else if (niniSeleccionado == elsa) {
//
//                    } else if (niniSeleccionado == eliseo) {

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

        Pane root = new Pane(fondo, btnPausa, menuPlantas, cantidadButanitos,luis, diego, callejo, adripan, isma, ximena, lopez, guille, dani, keke, guevara, lorena, maria, jud, elsa, eliseo, hueco1, hueco2, hueco3, hueco4);
//        niniTransparente = new ImageView();
//        niniTransparente.setLayoutX(Cuadricula.anchoCelda);
//        niniTransparente.setLayoutY(Cuadricula.altoCelda);
//        niniTransparente.setOpacity(0.6);
//        niniTransparente.setVisible(false);

//        root.setOnMouseClicked((evento) -> {
//            niniTransparente.setLayoutX(evento.getX() - niniTransparente.getFitWidth() / 2);
//            niniTransparente.setLayoutY(evento.getY() - niniTransparente.getFitHeight() / 2);
//        });

        root.setOnMouseClicked((evento) -> {
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

            Nini niniNuevo = null;


            if (niniSeleccionadoTipo == TipoNini.LUIS) {
                luis.setImage(new Image("Imagenes/Luis_Cuadricula.png"));
                niniNuevo = new  Luis(Cuadricula.buscarMitadCeldaEjeX(columnaPinchada), Cuadricula.buscarMitadCeldaEjeY(filaPinchada), root, geB);
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

//                        } else if (niniSeleccionadoTipo == TipoNini.ISMA) {

            } else if (niniSeleccionadoTipo == TipoNini.XIMENA) {
                ximena.setImage(new Image("Imagenes/Guimena.png"));

//                        } else if (niniSeleccionadoTipo == TipoNini.GUILLE) {
//
//                        } else if (niniSeleccionadoTipo == TipoNini.DANI) {
//
//                        } else if (niniSeleccionadoTipo == TipoNini.KEKE) {
//
//                        } else if (niniSeleccionadoTipo == TipoNini.LORENA) {
//
//                        } else if (niniSeleccionadoTipo == TipoNini.MARIA) {
//
//                        } else if (niniSeleccionadoTipo == TipoNini.JUD) {
//
//                        } else if (niniSeleccionadoTipo == TipoNini.ELSA
//
//                        } else if (niniSeleccionadoTipo == TipoNini.ELISEO) {

            }

            if (geB.getContadorButanitos() < niniNuevo.getCosteButanitos() || geB.getContadorButanitos() <= 0) {
                return;
            }

            ImageView niniNuevoImagen = new ImageView(new Image(niniNuevo.getRutaImagenNini()));
            niniNuevoImagen.setFitWidth(Cuadricula.anchoCelda);
            niniNuevoImagen.setFitHeight(Cuadricula.altoCelda);
            niniNuevoImagen.setLayoutX(Cuadricula.buscarMitadCeldaEjeX(columnaPinchada));
            niniNuevoImagen.setLayoutY(Cuadricula.buscarMitadCeldaEjeY(filaPinchada));

            terreno[filaPinchada][columnaPinchada].setNini(niniNuevo);

            geB.restarButanitos(niniNuevo.getCosteButanitos());
            niniSeleccionadoTipo = null;
//            niniTransparente.setVisible(false);
            reloj.registrar(niniNuevo);

            root.getChildren().add(niniNuevoImagen);
        });

        ConstruirPanelPausa(stage);
        root.getChildren().add(panelPausa);

        return new Scene(root, 1280, 720);
    }


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
        btnReanudar.setLayoutX(560);
        btnReanudar.setLayoutY(350);
        btnReanudar.setOnAction(evento -> {
            reloj.pausa();
            mostrarPanelPausa();
            ControladorMusica.despausarMusicaJuego();
        });

        Button btnSalir = new Button("Salir");
        btnSalir.setLayoutX(560);
        btnSalir.setLayoutY(400);
        btnSalir.setOnAction(evento -> {
            EscenaMenu escenaMenu = new EscenaMenu();
            stage.setScene(escenaMenu.construir(stage));
            ControladorMusica.pararMusicaJuego();
        });


        panelPausa.setVisible(false);
        panelPausa.getChildren().addAll(textoPausa, btnReanudar, btnSalir);
    }


    public void seleccionarNini(TipoNini tipoNini, String rutaImagenTransparente) {
        niniSeleccionadoTipo = tipoNini;
        niniTransparente.setImage(new Image(rutaImagenTransparente));
        niniTransparente.setOpacity(0.6);
        niniTransparente.setVisible(true);
    }


    public void mostrarPanelPausa() {
        if (reloj.isPausado()) {
            panelPausa.setVisible(true);
        } else {
            panelPausa.setVisible(false);
        }
    }

    public static Celda[][] getTerreno() {
        return terreno;
    }
}
