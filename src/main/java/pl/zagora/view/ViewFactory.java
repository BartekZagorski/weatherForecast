package pl.zagora.view;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.zagora.controller.BaseController;
import pl.zagora.controller.MainController;
import pl.zagora.controller.OkHttpAPIClient;
import pl.zagora.controller.services.WeatherService;

import java.io.IOException;

public class ViewFactory {

    public void showMainWindow() {

        BaseController mainWindowController = new MainController(new WeatherService(new OkHttpAPIClient()), this,
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
