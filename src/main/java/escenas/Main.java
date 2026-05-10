package escenas;

import javafx.application.Application;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application {

    @Override
    public void start(Stage escenaPrincipal) {
        escenaPrincipal.setTitle("Ninis vs World");
        escenaPrincipal.setResizable(false);

        EscenaMenu menu = new EscenaMenu();
        escenaPrincipal.setScene(menu.construir(escenaPrincipal));
        Image logo = new Image("Imagenes/Ninis.png");
        escenaPrincipal.getIcons().add(logo);

        escenaPrincipal.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
