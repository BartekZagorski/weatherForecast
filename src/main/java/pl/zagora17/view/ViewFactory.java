package pl.zagora17.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.zagora17.WeatherManager;
import pl.zagora17.controller.BaseController;
import pl.zagora17.controller.MainWindowController;

import java.io.IOException;

public class ViewFactory {

    private WeatherManager weatherManager;

    public ViewFactory(WeatherManager weatherManager) {
        this.weatherManager = weatherManager;
    }

    public void showMainWindow() {
        BaseController mainWindowController = new MainWindowController(weatherManager,this, "MainWindow.fxml");
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/" + mainWindowController.getFxmlName()));

        fxmlLoader.setController(mainWindowController);
        Parent parent;
        try{
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setTitle("Prognoza Pogody");
        stage.setScene(scene);
        stage.setMinWidth(500);
        stage.setMinHeight(500);
        stage.show();

    }
}
