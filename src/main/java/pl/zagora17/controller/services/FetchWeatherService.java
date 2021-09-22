package pl.zagora17.controller.services;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import org.json.JSONObject;
import pl.zagora17.controller.FetchWeatherResult;
import pl.zagora17.model.WeatherDay;
import pl.zagora17.model.WeatherPoint;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FetchWeatherService extends Service<FetchWeatherResult> {

    private JSONObject weatherJSON;
    private List<WeatherDay> weatherDayList;

    public void setWeatherJSON(JSONObject weatherJSON) {
        this.weatherJSON = weatherJSON;
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
        WeatherPoint weatherPoint = new WeatherPoint();
        weatherPoint.setWeatherData(object);
        weatherPoint.setHour(getSimpleHour(object));
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

    private String getSimpleHour(JSONObject jsonObject) {
        int seconds = jsonObject.getInt("dt");
        ZonedDateTime zdt = ZonedDateTime.ofInstant(Instant.ofEpochSecond(seconds), ZoneId.systemDefault());
        return zdt.getHour() + ":00";
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
