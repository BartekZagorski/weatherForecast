package pl.zagora17.controller;

import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import org.json.JSONObject;
import pl.zagora17.WeatherManager;
import pl.zagora17.controller.services.FetchWeatherService;
import pl.zagora17.controller.services.WeatherService;
import pl.zagora17.view.ViewFactory;


public class MainWindowController extends BaseController {

    public MainWindowController(WeatherManager weatherManager, ViewFactory viewFactory, String fxmlName) {
        super( weatherManager, viewFactory, fxmlName);
    }

    @FXML
    private TextField homeCountryField;

    @FXML
    private TextField homeCityField;

    @FXML
    private Slider homeSlider;

    @FXML
    private TextField awayCountryField;

    @FXML
    private TextField awayCityField;

    @FXML
    private Slider awaySlider;


    @FXML
    void gridMouseClicked(MouseEvent event) {
        Node node = (Node) event.getTarget();
        setDay(node);
        }

    @FXML
    void confirmButtonAction() {
        String homeCityValue = homeCityField.getText().toLowerCase();
        if (homeCityValue != "") {
            WeatherService weatherService = new WeatherService(homeCityValue, "metric");
            weatherService.start();
            weatherService.setOnSucceeded(event -> {
                JSONObject weather = weatherService.getValue();
                int cod = weather.getInt("cod"); //internal parameter that verifies if city was found or not
                if (cod == 200) {
                    System.out.println("znaleziono "+homeCityValue+"\nrozpoczynam wczytywanie pogody");
                    FetchWeatherService fetchWeatherService = new FetchWeatherService(weatherService);
                } else if (cod == 404) {
                    System.out.println("Nie znaleziono miasta");
                }
//            Locale loc = new Locale("","DE");
//            System.out.println(loc.getDisplayCountry());
            });
        } else {
            System.out.println("Nic nie wpisano");
        }


    }
    private void setDay (Node node) {
        if (node instanceof AnchorPane) {
            node.setStyle("-fx-border-color:red");
        } else {
            setDay(node.getParent());
        }
    }

}
