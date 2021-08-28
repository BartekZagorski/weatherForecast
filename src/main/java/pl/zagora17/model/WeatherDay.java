package pl.zagora17.model;

import javafx.scene.image.Image;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class WeatherDay {

    private List<WeatherPoint> weatherPoints = new ArrayList<WeatherPoint>();
    private Date date;
    private String name;

    public Date getDate() {
        return date;
    }

    public List<WeatherPoint> getWeatherPoints() {
        return weatherPoints;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getWeatherPointsCount() {
        return weatherPoints.size();
    }

    public int getAverageTemperature() {
        int sumOfTemperatureValue = 0;
        for ( WeatherPoint weatherPoint : weatherPoints ) {
            sumOfTemperatureValue += weatherPoint.getTempValue();
        }
        return sumOfTemperatureValue / getWeatherPointsCount();
    }

    public Image getMiddlePointWeatherIcon() {
        return weatherPoints.get(getWeatherPointsCount()/2).getWeatherIcon();
    }
}
