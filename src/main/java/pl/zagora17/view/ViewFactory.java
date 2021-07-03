package pl.zagora17.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.zagora17.controller.BaseController;
import pl.zagora17.controller.MainWindowController;

import java.io.IOException;
import java.net.URL;

public class ViewFactory {

    public void showMainWindow() {
        BaseController mainWindowController = new MainWindowController(this, "MainWindow.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/" + mainWindowController.getFxmlName()));
        Parent parent;
        try{
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

    }
}
