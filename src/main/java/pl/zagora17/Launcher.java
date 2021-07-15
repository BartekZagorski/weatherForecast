package pl.zagora17;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import pl.zagora17.controller.WeatherService;
import pl.zagora17.view.ViewFactory;

import java.security.Timestamp;
import java.text.DateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.*;

/**
 * JavaFX App
 */
public class Launcher extends Application {

    @Override
    public void start(Stage stage) {

        //ViewFactory viewFactory = new ViewFactory();
        //viewFactory.showMainWindow();
        WeatherService weatherService = new WeatherService();
        weatherService.setCityName("Londyn");
        weatherService.setUnit("metric");
        JSONObject weather = weatherService.getWeather();
        List<JSONObject> jsonList = new ArrayList<JSONObject>();
        for (Object timestamp : weather.getJSONArray("list")) {
            jsonList.add((JSONObject) timestamp);
        }
        System.out.println(LocalDateTime.parse("2021-07-08 21:00:00".replace(" ", "T")));
        for (JSONObject object : jsonList) {
            Date date = new Date(object.getLong("dt")*1000 - 7200000);
            System.out.println(object.getLong("dt"));
            System.out.println(date);
            System.out.println("temp: " + object.getJSONObject("main").get("temp"));
            System.out.println("pressure: " + object.getJSONObject("main").get("pressure"));
            }
        }

    public static void main(String[] args) {
        launch(args);
    }

}