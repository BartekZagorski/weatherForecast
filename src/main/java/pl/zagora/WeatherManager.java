package pl.zagora;

import pl.zagora.model.WeatherDay;
import pl.zagora.model.WeatherPoint;

import java.util.List;
import java.util.Locale;

public class WeatherManager {

    private List<WeatherDay> weatherDayList;
    private WeatherDay selectedWeatherDay;
    private WeatherPoint selectedWeatherPoint;
    private String cityName;
    private String countryCode;

    public void setSelectedWeatherDay (int i) {
        selectedWeatherDay = weatherDayList.get(i);
    }
    public void setSelectedWeatherPoint(WeatherPoint selectedWeatherPoint) {
        this.selectedWeatherPoint = selectedWeatherPoint;
    }

    public void setSelectedWeatherPoint (int i) {
        selectedWeatherPoint = selectedWeatherDay.getWeatherPoint(i);
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

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }

    public String getCountryName() {
        Locale loc = new Locale("", countryCode);
        return loc.getDisplayCountry();
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public WeatherPoint getChosenWeatherPoint(int i) {
        return selectedWeatherDay.getWeatherPoints().get(i);
    }

    public void selectDay(int i) {
        setSelectedWeatherDay(i);
        setSelectedWeatherPoint(0);
    }
}
