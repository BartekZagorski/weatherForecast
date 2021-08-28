package pl.zagora17.model;

import javafx.scene.image.Image;
import org.json.JSONArray;
import org.json.JSONObject;
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
    private String hour;

    public String getHour() {
        return hour;
    }

    public void setHour(String hour) {
        this.hour = hour;
    }

    public int getTempValue() {
        double doubleTempValue = weatherData.getJSONObject("main").getDouble(
                "temp");
        int intTempValue = (int) Math.round(doubleTempValue);
        return intTempValue;
    }

    public Image getWeatherIcon() {
        JSONArray weather = weatherData.getJSONArray("weather");
        String iconCode = weather.getJSONObject(0).getString("icon");
        String icon = "http://openweathermap.org/img/wn/"+ iconCode +"@2x.png";
        Image image = new Image(icon);
        return image;
    }
}
