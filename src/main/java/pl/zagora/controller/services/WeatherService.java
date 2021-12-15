package pl.zagora.controller.services;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import pl.zagora.Config;
import pl.zagora.controller.DownloadWeatherResult;

import java.io.IOException;
import java.util.Objects;

public class WeatherService extends Service<DownloadWeatherResult> {

    private final OkHttpClient client = new OkHttpClient();
    private String cityName;
    private static final String UNIT = "metric";
    private JSONObject weatherJSON;

    public JSONObject getWeatherJSON() {
        return weatherJSON;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public DownloadWeatherResult getWeather() {
        String url =
                "https://api.openweathermap.org/data/2.5/forecast?q=" + cityName + "&units=" + UNIT + "&appid=" + Config.API_KEY;
        Request request = new Request.Builder()
                .url(url).build();
        try {
            Response response = client.newCall(request).execute();
            weatherJSON = new JSONObject(Objects.requireNonNull(response.body()).string());
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