package escenas;

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

    public ControladorReloj reloj = new ControladorReloj();
    public static Celda[][] terreno = new Celda[Cuadricula.columnas][Cuadricula.filas];


    public Scene construir(Stage stage) {
        ImageView fondo = new ImageView("imagenes/fondoNvsW.png");
        fondo.setFitWidth(1280);
        fondo.setFitHeight(720);

        // Para crear e inicializar el tablero donde colocar las plantas/ninis
        for (int i = 0; i < Cuadricula.columnas; i++) {
            for (int j = 0; j < Cuadricula.filas; j++) {
                terreno[i][j] = new Celda();
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
                    } else if (niniSeleccionado == diego) {
                        niniSeleccionado.setImage(new Image("Imagenes/Diegosaas_Seleccionado.png"));
                    } else if (niniSeleccionado == callejo) {
                        niniSeleccionado.setImage(new Image("Imagenes/Callejones_Seleccionado.png"));
                    } else if (niniSeleccionado == adripan) {
                        niniSeleccionado.setImage(new Image("Imagenes/Adrinap_Seleccionado.png"));
                    } else if (niniSeleccionado == guevara) {
                        niniSeleccionado.setImage(new Image("Imagenes/Guevarote_Seleccionado.png"));
                    } else if (niniSeleccionado == lopez) {
                        niniSeleccionado.setImage(new Image("Imagenes/Lucillos_Seleccionado.png"));
//                    } else if (niniSeleccionado == isma) {

                    } else if (niniSeleccionado == ximena) {
                        niniSeleccionado.setImage(new Image("Imagenes/Guimena_Seleccionado.png"));
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

        Pane root = new Pane(fondo, btnPausa, menuPlantas, cantidadButanitos, luis, diego, callejo, adripan, isma, ximena, lopez, guille, dani, keke, guevara, lorena, maria, jud, elsa, eliseo, hueco1, hueco2, hueco3, hueco4);


        Luis l1 = new Luis(Cuadricula.buscarMitadCeldaEjeX(2), Cuadricula.buscarMitadCeldaEjeY(1), root, geB);
        terreno[2][1].setNini(l1);
        reloj.registrar(l1);

        Luis l2 = new Luis(Cuadricula.buscarMitadCeldaEjeX(1), Cuadricula.buscarMitadCeldaEjeY(2), root, geB);
        terreno[1][2].setNini(l2);
        reloj.registrar(l2);

        Diego d1 = new Diego(Cuadricula.buscarMitadCeldaEjeX(1), Cuadricula.buscarMitadCeldaEjeY(1), root);
        terreno[1][1].setNini(d1);
        reloj.registrar(d1);

        Callejo c1 = new Callejo(Cuadricula.buscarMitadCeldaEjeX(3), Cuadricula.buscarMitadCeldaEjeY(3), root);
        terreno[3][3].setNini(c1);
        reloj.registrar(c1);

        Lopez lopi1 = new Lopez(Cuadricula.buscarMitadCeldaEjeX(2), Cuadricula.buscarMitadCeldaEjeY(3), root);
        terreno[2][3].setNini(lopi1);
        reloj.registrar(lopi1);

        Adripan ad1 = new Adripan(Cuadricula.buscarMitadCeldaEjeX(5), Cuadricula.buscarMitadCeldaEjeY(3), root);
        terreno[5][3].setNini(ad1);
        reloj.registrar(ad1);

        Guevara g1 = new Guevara(Cuadricula.buscarMitadCeldaEjeX(7), Cuadricula.buscarMitadCeldaEjeY(3), root, terreno);
        terreno[7][3].setNini(g1);
        reloj.registrar(g1);

        Luis l33 = new Luis(Cuadricula.buscarMitadCeldaEjeX(6), Cuadricula.buscarMitadCeldaEjeY(1), root, geB);
        terreno[6][1].setNini(l33);
        reloj.registrar(l33);

        ConstruirPanelPausa(stage);
        root.getChildren().add(panelPausa);

        return new Scene(root, 1280, 720);
    }

    Pane panelPausa = new Pane();

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
        });

        Button btnSalir = new Button("Salir");
        btnSalir.setLayoutX(560);
        btnSalir.setLayoutY(400);
        btnSalir.setOnAction(evento -> {
            EscenaMenu escenaMenu = new EscenaMenu();
            stage.setScene(escenaMenu.construir(stage));
        });


        panelPausa.setVisible(false);
        panelPausa.getChildren().addAll(textoPausa, btnReanudar, btnSalir);
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
