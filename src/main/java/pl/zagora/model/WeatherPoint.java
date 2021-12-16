package pl.zagora.model;

import javafx.scene.image.Image;
import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherPoint {

    private JSONObject weatherData;
    private String hour;

    public void setWeatherData(JSONObject weatherData) {
        this.weatherData = weatherData;
    }

    public String getHour() {
        return hour;
    }

    public JSONObject getWeatherData() {
        return weatherData;
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

    public int getCloudyValue() {
        return weatherData.getJSONObject("clouds").getInt("all");
    }

    public double getWindSpeed() {
        return weatherData.getJSONObject("wind").getDouble("speed");
    }

    public int getPressureValue() {
        return weatherData.getJSONObject("main").getInt("pressure");
    }

    public int getPrecipitationProbabilityPercentValue() {
        return (int) (weatherData.getDouble("pop")*100);
    }

}
