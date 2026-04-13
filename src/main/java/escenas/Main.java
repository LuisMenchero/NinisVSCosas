package escenas;

import javafx.application.Application;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application {

    @Override
    public void start(Stage escenaPrincipal) {
        escenaPrincipal.setTitle("Ninis vs World");
        escenaPrincipal.setResizable(false);

        EscenaMenu menu = new EscenaMenu();
        escenaPrincipal.setScene(menu.construir(escenaPrincipal));

        escenaPrincipal.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
