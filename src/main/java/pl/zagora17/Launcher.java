package pl.zagora17;

import javafx.application.Application;
import javafx.stage.Stage;
import org.json.JSONObject;
import pl.zagora17.controller.services.FetchWeatherService;
import pl.zagora17.controller.services.WeatherService;
import pl.zagora17.model.WeatherDay;
import pl.zagora17.model.WeatherPoint;
import pl.zagora17.view.ViewFactory;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * JavaFX App
 */
public class Launcher extends Application {

    private WeatherManager homeWeatherManager = new WeatherManager();
    private WeatherManager awayWeatherManager = new WeatherManager();

    @Override
    public void start(Stage stage) {

        ViewFactory viewFactory = new ViewFactory(homeWeatherManager, awayWeatherManager);
        viewFactory.showMainWindow();

    }

    public static void main(String[] args) {
        launch(args);
    }

}