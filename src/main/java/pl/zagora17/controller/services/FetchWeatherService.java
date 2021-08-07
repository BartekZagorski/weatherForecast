package pl.zagora17.controller.services;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import org.json.JSONObject;
import pl.zagora17.controller.FetchWeatherResult;
import pl.zagora17.model.WeatherDay;
import pl.zagora17.model.WeatherPoint;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FetchWeatherService extends Service<FetchWeatherResult> {

    private JSONObject weatherJSON;
    private List<WeatherDay> weatherDayList;

    public FetchWeatherService(JSONObject weatherJSON, List<WeatherDay> weatherDayList) {
        this.weatherJSON = weatherJSON;
        this.weatherDayList = weatherDayList;
    }

    public FetchWeatherResult fetchWeather () {
        List<JSONObject> jsonList = new ArrayList<JSONObject>();
        if (weatherJSON.getInt("cod") == 200) {
            for (Object timestamp : weatherJSON.getJSONArray("list")) {
                jsonList.add((JSONObject) timestamp);
            }
            SimpleDateFormat dateFormat = new SimpleDateFormat("ddMMyyyy");
            Date weatherDayDate = new Date(100000);
            WeatherDay weatherDay = new WeatherDay();
            for (JSONObject object : jsonList) {
                Date weatherPointDate = new Date(object.getLong("dt") * 1000 - 7200000);
                if (!dateFormat.format(weatherDayDate).equals(dateFormat.format(weatherPointDate)) ) {
                    if (!weatherDay.getWeatherPoints().isEmpty()) {
                        weatherDay.setDate(weatherDayDate);
                        weatherDayList.add(weatherDay);
                        weatherDay = new WeatherDay();
                    }
                    weatherDayDate = weatherPointDate;
                }
                WeatherPoint weatherPoint = new WeatherPoint();
                weatherPoint.setWeatherData(object);
                weatherPoint.setDate(weatherPointDate);
                weatherDay.getWeatherPoints().add(weatherPoint);
            }
            weatherDay.setDate(weatherDayDate);
            weatherDayList.add(weatherDay);
            return FetchWeatherResult.SUCCESS;
        } else if (weatherJSON.getInt("cod") == 404){
            return FetchWeatherResult.FAILED_BY_TOWN_NAME;
        } else {
            return FetchWeatherResult.FAILED_BY_UNEXPECTED_ERROR;
        }

    }

    @Override
    protected Task<FetchWeatherResult> createTask() {
        return new Task<FetchWeatherResult>() {
            @Override
            protected FetchWeatherResult call() throws Exception {
                return fetchWeather();
            }
        };
    }
}
