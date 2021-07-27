package pl.zagora17.controller.services;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import org.json.JSONObject;
import pl.zagora17.model.WeatherDay;
import pl.zagora17.model.WeatherPoint;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FetchWeatherService {

    private WeatherService weatherService;

    public FetchWeatherService(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    public void fetchWeather (List<WeatherDay> weatherDayList) {
        List<JSONObject> jsonList = new ArrayList<JSONObject>();
        for (Object timestamp : weatherService.getWeather().getJSONArray("list")) {
            jsonList.add((JSONObject) timestamp);
        }
        SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
        String date = "";
        WeatherDay weatherDay = new WeatherDay();
        for (JSONObject object : jsonList) {
            Date objectDate = new Date(object.getLong("dt")*1000 - 7200000);
            if (!dateFormat.format(objectDate).equals(date) && !weatherDay.getWeatherPoints().isEmpty()) {
                weatherDayList.add(weatherDay);
                date = dateFormat.format(objectDate);
                weatherDay = new WeatherDay();
            }
            WeatherPoint weatherPoint = new WeatherPoint();
            weatherPoint.setWeatherData(object);
            weatherPoint.setDate(objectDate);
            weatherDay.getWeatherPoints().add(weatherPoint);
        }
        weatherDayList.add(weatherDay);



    }


}
