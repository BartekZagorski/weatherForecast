package pl.zagora17.model;

import org.json.JSONObject;

import java.text.DateFormat;
import java.time.LocalDateTime;
import java.util.Date;

public class WeatherPoint {

    public JSONObject getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(JSONObject weatherData) {
        this.weatherData = weatherData;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    private JSONObject weatherData;
    private Date date;




}
