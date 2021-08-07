package pl.zagora17.model;

import org.json.JSONObject;

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
}
