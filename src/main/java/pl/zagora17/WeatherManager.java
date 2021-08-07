package pl.zagora17;

import pl.zagora17.model.WeatherDay;
import pl.zagora17.model.WeatherPoint;

import java.util.ArrayList;
import java.util.List;

public class WeatherManager {

    private List<WeatherDay> weatherDayList;
    private WeatherDay selectedWeatherDay;
    private WeatherPoint selectedWeatherPoint;

    public void setSelectedWeatherDay(WeatherDay selectedWeatherDay) {
        this.selectedWeatherDay = selectedWeatherDay;
    }

    public void setSelectedWeatherPoint(WeatherPoint selectedWeatherPoint) {
        this.selectedWeatherPoint = selectedWeatherPoint;
    }

    public List<WeatherDay> getWeatherDayList() {
        return weatherDayList;
    }

    public void setWeatherDayList(List<WeatherDay> weatherDayList) {
        this.weatherDayList = weatherDayList;
    }

    public WeatherDay getSelectedWeatherDay() {
        return selectedWeatherDay;
    }

    public WeatherPoint getSelectedWeatherPoint() {
        return selectedWeatherPoint;
    }
}
