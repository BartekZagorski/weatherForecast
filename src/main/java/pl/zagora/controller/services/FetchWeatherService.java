package pl.zagora.controller.services;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import org.json.JSONObject;
import pl.zagora.controller.FetchWeatherResult;
import pl.zagora.model.WeatherDay;
import pl.zagora.model.WeatherPoint;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class FetchWeatherService extends Service<FetchWeatherResult> {

    private JSONObject weatherJSON;
    private List<WeatherDay> weatherDayList = new ArrayList<>();

    public void setWeatherJSON(JSONObject weatherJSON) {
        this.weatherJSON = weatherJSON;
    }

    public List<WeatherDay> getWeatherDayList() {
        return weatherDayList;
    }

    public void setWeatherDayList(List<WeatherDay> weatherDayList) {
        this.weatherDayList = weatherDayList;
    }

    public FetchWeatherResult fetchWeather () {
        if (httpStatus(200)) {
            processResult();
            return FetchWeatherResult.SUCCESS;
        } else if (httpStatus(404)){
            return FetchWeatherResult.FAILED_BY_TOWN_NAME;
        } else {
            return FetchWeatherResult.FAILED_BY_UNEXPECTED_ERROR;
        }
    }

    private void processResult() {
        List<JSONObject> jsonList = getJSONListFromOpenWeather();
        ZonedDateTime weatherDayDate = null;
        WeatherDay weatherDay = new WeatherDay();
        for (JSONObject object : jsonList) {
            ZonedDateTime weatherPointDate = ZonedDateTime.ofInstant(Instant.ofEpochSecond(object.getLong("dt")),
                    ZoneId.systemDefault());
            if (weatherDayDate == null) {
                weatherDayDate = weatherPointDate;
            } else if (!LocalDate.from(weatherDayDate).equals(LocalDate.from(weatherPointDate))) {
                weatherDay.setDate(weatherDayDate);
                weatherDayList.add(weatherDay);
                weatherDay = new WeatherDay();
                weatherDayDate = weatherPointDate;
            }
            addNewWeatherPointToTheList(weatherDay.getWeatherPoints(), object);
        }
        weatherDay.setDate(weatherDayDate);
        weatherDayList.add(weatherDay);
    }

    private void addNewWeatherPointToTheList(List<WeatherPoint> list, JSONObject object) {
        WeatherPoint weatherPoint = new WeatherPoint(object);
        list.add(weatherPoint);
    }

    private List<JSONObject> getJSONListFromOpenWeather() {
        List<JSONObject> jsonList = new ArrayList<>();
        for (Object timestamp : weatherJSON.getJSONArray("list")) {
            jsonList.add((JSONObject) timestamp);
        }
        return jsonList;
    }

    private boolean httpStatus(int i) {
        return weatherJSON.getInt("cod") == i;
    }

    @Override
    protected Task<FetchWeatherResult> createTask() {
        return new Task<>() {
            @Override
            protected FetchWeatherResult call() {
                return fetchWeather();
            }
        };
    }
}
