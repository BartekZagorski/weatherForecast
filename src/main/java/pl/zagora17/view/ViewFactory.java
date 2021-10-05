package pl.zagora17.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.zagora17.controller.BaseController;
import pl.zagora17.controller.MainController;
import pl.zagora17.controller.services.WeatherService;

import java.io.IOException;

public class ViewFactory {

    public void showMainWindow() {

        BaseController mainWindowController = new MainController(new WeatherService(), this,
                "MainWindowGood.fxml");

        Parent parent = createView(mainWindowController);

        initializeStage(parent);
    }

    private void initializeStage(Parent parent) {
        Scene scene = new Scene(parent);
        Stage stage = new Stage();
        stage.setTitle("Prognoza Pogody");
        stage.setScene(scene);
        stage.setMinWidth(600);
        stage.setMinHeight(500);
        stage.show();
    }

    public Parent createView(BaseController baseController) {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/fxml/" + baseController.getFxmlName()));

        fxmlLoader.setController(baseController);

        Parent parent;
        try{
            parent = fxmlLoader.load();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return parent;
    }
}
