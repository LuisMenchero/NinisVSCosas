module com.example.ninisvstheworld {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.ninisvstheworld to javafx.fxml;
    exports com.example.ninisvstheworld;
}