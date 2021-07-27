module pl.zagora17 {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;
    requires org.json;

    exports pl.zagora17;

    opens pl.zagora17;
    opens pl.zagora17.controller;
}