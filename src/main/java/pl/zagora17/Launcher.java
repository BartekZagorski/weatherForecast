package pl.zagora17;

import javafx.application.Application;
import javafx.stage.Stage;
import pl.zagora17.view.ViewFactory;

/**
 * JavaFX App
 */
public class Launcher extends Application {

    private final WeatherManager homeWeatherManager = new WeatherManager();
    private final WeatherManager awayWeatherManager = new WeatherManager();

    @Override
    public void start(Stage stage) {

        ViewFactory viewFactory = new ViewFactory(homeWeatherManager, awayWeatherManager);
        viewFactory.showMainWindow();

    }

    public static void main(String[] args) {
        launch(args);
    }

}