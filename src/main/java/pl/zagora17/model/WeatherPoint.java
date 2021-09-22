package pl.zagora17.model;

import javafx.scene.image.Image;
import org.json.JSONArray;
import org.json.JSONObject;
import java.util.Date;

public class WeatherPoint {

    private JSONObject weatherData;
    private String hour;

    public JSONObject getWeatherData() {
        return weatherData;
    }

    public void setWeatherData(JSONObject weatherData) {
        this.weatherData = weatherData;
    }

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getTempValue() {
        double doubleTempValue = weatherData.getJSONObject("main").getDouble(
                "temp");
        return (int) Math.round(doubleTempValue);
    }

    public Image getWeatherIcon() {
        JSONArray weather = weatherData.getJSONArray("weather");
        String iconCode = weather.getJSONObject(0).getString("icon");
        String icon = "http://openweathermap.org/img/wn/"+ iconCode +"@2x.png";
        return new Image(icon);
    }
}
