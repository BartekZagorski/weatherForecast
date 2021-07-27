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

    private WeatherManager weatherManager = new WeatherManager();

    @Override
    public void start(Stage stage) {

        ViewFactory viewFactory = new ViewFactory(weatherManager);
        viewFactory.showMainWindow();
        WeatherService weatherService = new WeatherService("Glinojeck", "metric");
        FetchWeatherService fetchWeatherService = new FetchWeatherService(weatherService);
        List<WeatherDay> weatherDayList = new ArrayList<WeatherDay>();
        fetchWeatherService.fetchWeather(weatherDayList);
        int i = 1;
        for (WeatherDay weatherDay: weatherDayList) {

            for (WeatherPoint weatherPoint : weatherDay.getWeatherPoints()) {
                System.out.println(weatherPoint.getDate());
            }
            System.out.println("dzien nr " + i++);
        }
    }

//        JSONObject weather = weatherService.getWeather();
//        List<JSONObject> jsonList = new ArrayList<JSONObject>();
//        for (Object timestamp : weather.getJSONArray("list")) {
//            jsonList.add((JSONObject) timestamp);
//        }
//        System.out.println(LocalDateTime.parse("2021-07-08 21:00:00".replace(" ", "T")));
//        for (JSONObject object : jsonList) {
//            Date date = new Date(object.getLong("dt")*1000 - 7200000);
//            System.out.println(date.equals(new Date(object.getLong("dt")*1000 - 7200000)));
//            SimpleDateFormat sdf = new SimpleDateFormat("dd MM yyyy");
//            System.out.println(sdf.format(date));
//            System.out.println(new SimpleDateFormat("EEEE").format(date));
//            System.out.println(object.getLong("dt"));
//            System.out.println(date);
//            System.out.println("temp: " + object.getJSONObject("main").get("temp"));
//            System.out.println("pressure: " + object.getJSONObject("main").get("pressure"));
//            }
//        }

    public static void main(String[] args) {
        launch(args);
    }

}