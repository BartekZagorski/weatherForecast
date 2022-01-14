package pl.zagora.controller.services;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import org.json.JSONObject;
import pl.zagora.controller.DownloadWeatherResult;
import pl.zagora.controller.WeatherAPIClient;

import java.io.IOException;
import java.util.Objects;

public class WeatherService extends Service<DownloadWeatherResult> {

    private final WeatherAPIClient weatherAPIClient;
    private String cityName;
    private JSONObject weatherJSON;

    public WeatherService(WeatherAPIClient weatherAPIClient) {
        this.weatherAPIClient = weatherAPIClient;
    }

    public JSONObject getWeatherJSON() {
        return weatherJSON;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public DownloadWeatherResult getWeather() {
        try {
            String response = weatherAPIClient.call(cityName);
            weatherJSON = new JSONObject(Objects.requireNonNull(response));
            return DownloadWeatherResult.SUCCESS;
        } catch (IOException e) {
            return DownloadWeatherResult.FAIL;
        }
    }

    @Override
    protected Task<DownloadWeatherResult> createTask() {
        return new Task<>() {
            @Override
            protected DownloadWeatherResult call() {
                return getWeather();
            }
        };
    }
}