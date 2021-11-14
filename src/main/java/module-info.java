module pl.zagora {
    requires javafx.controls;
    requires javafx.fxml;
    requires okhttp3;
    requires org.json;
    requires java.desktop;

    exports pl.zagora;
    exports pl.zagora.model;

    opens pl.zagora;
    opens pl.zagora.controller;
}