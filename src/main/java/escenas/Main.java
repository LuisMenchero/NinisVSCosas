package escenas;

import javafx.application.Application;
import javafx.stage.Stage;

import static javafx.application.Application.launch;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Ninis vs World");
        primaryStage.setResizable(false);

        EscenaMenu menu = new EscenaMenu();
        primaryStage.setScene(menu.construir(primaryStage));

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }

}
