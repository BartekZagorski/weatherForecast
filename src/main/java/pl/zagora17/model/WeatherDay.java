package pl.zagora17.model;

import javafx.scene.image.Image;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;

public class WeatherDay {

    private final List<WeatherPoint> weatherPoints = new ArrayList<>();
    private ZonedDateTime date;

    public ZonedDateTime getDate() {
        return date;
    }

    public List<WeatherPoint> getWeatherPoints() {
        return weatherPoints;
    }

    public WeatherPoint getWeatherPoint(int i) {
        return weatherPoints.get(i);
    }

    public void setDate(ZonedDateTime date) {
        this.date = date;
    }

    public int getWeatherPointsCount() {
        return weatherPoints.size();
    }

    public int getAverageTemperature() {
        int sumOfTemperatureValue = 0;
        for (WeatherPoint weatherPoint : weatherPoints) {
            sumOfTemperatureValue += weatherPoint.getTempValue();
        }
        return sumOfTemperatureValue / getWeatherPointsCount();
    }

    public Image getMiddlePointWeatherIcon() {
        return weatherPoints.get(getWeatherPointsCount() / 2).getWeatherIcon();
    }


}
