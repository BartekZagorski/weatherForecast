package pl.zagora17.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import pl.zagora17.controller.services.WeatherService;
import pl.zagora17.view.ViewFactory;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController extends BaseController implements Initializable {

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private GridPane mainGridPane;

    public MainController(WeatherService weatherService, ViewFactory viewFactory,
                          String fxmlName) {
        super(weatherService, viewFactory, fxmlName);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        loadViews();
    }

    private void loadViews() {
        Parent parent = viewFactory.createView(new WeatherController(weatherService, viewFactory,
                "singleTownForecast.fxml", "Określ miejsce zamieszkania"));
        Parent parent1 = viewFactory.createView(new WeatherController(weatherService,viewFactory,
                "singleTownForecast.fxml", "Określ miejsce wyjazdu"));
        parent1.setStyle("-fx-background-color:  #b5c5f5");
        mainGridPane.add(parent, 0,0);
        mainGridPane.add(parent1, 1, 0);
    }
}
