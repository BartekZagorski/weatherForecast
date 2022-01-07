package pl.zagora.model;

import javafx.scene.image.Image;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

public class WeatherPoint {

    private JSONObject weatherData;

    private String hour;
    private int tempValue;
    private String weatherIcon;
    private int cloudyValue;
    private double windSpeed;
    private int pressureValue;
    private int precipitationProbabilityPercentValue;

    public WeatherPoint (JSONObject jsonObject) {
        fetchProperties(jsonObject);
    }

    public void setPropertiesUsingJSON(JSONObject jsonObject) {
        fetchProperties(jsonObject);
    }

    private void fetchProperties(JSONObject jsonObject) {
        fetchHour(jsonObject);
        fetchTempValue(jsonObject);
        fetchWeatherIcon(jsonObject);
        fetchCloudyValue(jsonObject);
        fetchWindSpeed(jsonObject);
        fetchPressureValue(jsonObject);
        fetchPrecipitationProbabilityPercentValue(jsonObject);
    }

    public void setWeatherData(JSONObject weatherData) {
        this.weatherData = weatherData;
    }

    public String getHour() {
        return hour;
    }

    public JSONObject getWeatherData() {
        return weatherData;
    }

    private void fetchHour(JSONObject jsonObject) {
        int seconds = jsonObject.getInt("dt");
        ZonedDateTime zdt = ZonedDateTime.ofInstant(Instant.ofEpochSecond(seconds), ZoneId.systemDefault());
        this.hour = zdt.getHour() + ":00";
    }

    private void fetchTempValue(JSONObject jsonObject) {
        double doubleTempValue = jsonObject.getJSONObject("main").getDouble(
                "temp");
        this.tempValue = (int) Math.round(doubleTempValue);
    }

    public int getTempValue() {
        return tempValue;
    }

    private void fetchWeatherIcon(JSONObject jsonObject) {
        JSONArray weather = jsonObject.getJSONArray("weather");
        String iconCode = weather.getJSONObject(0).getString("icon");
        this.weatherIcon = "http://openweathermap.org/img/wn/"+ iconCode +"@2x.png";
    }

    public Image getWeatherIcon() {
        return new Image(weatherIcon);
    }

    private void fetchCloudyValue(JSONObject jsonObject) {
        this.cloudyValue = jsonObject.getJSONObject("clouds").getInt("all");
    }

    public int getCloudyValue() {
        return this.cloudyValue;
    }

    private void fetchWindSpeed(JSONObject jsonObject) {
        this.windSpeed = jsonObject.getJSONObject("wind").getDouble("speed");
    }

    public double getWindSpeed() {
        return this.windSpeed;
    }

    private void fetchPressureValue(JSONObject jsonObject) {
        this.pressureValue = jsonObject.getJSONObject("main").getInt("pressure");
    }

    public int getPressureValue() {
        return this.pressureValue;
    }

    private void fetchPrecipitationProbabilityPercentValue(JSONObject jsonObject) {
        this.precipitationProbabilityPercentValue = (int) (jsonObject.getDouble("pop")*100);
    }

    public int getPrecipitationProbabilityPercentValue() {
        return this.precipitationProbabilityPercentValue;
    }
}
