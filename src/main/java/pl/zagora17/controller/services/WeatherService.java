package pl.zagora17.controller.services;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import pl.zagora17.Config;
import java.io.IOException;
import java.util.Objects;

public class WeatherService extends Service<JSONObject> {

    private final OkHttpClient client = new OkHttpClient();
    private String cityName;
    private static final String UNIT = "metric";
    private final FetchWeatherService fetchWeatherService = new FetchWeatherService();

    public FetchWeatherService getFetchWeatherService() {
        return fetchWeatherService;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public JSONObject getWeather() {
        String url =
                "https://api.openweathermap.org/data/2.5/forecast?q=" + cityName + "&units=" + UNIT + "&appid=" + Config.API_KEY;
        Request request = new Request.Builder()
                .url(url).build();
        try {
            Response response = client.newCall(request).execute();
            return new JSONObject(Objects.requireNonNull(response.body()).string());
        } catch (IOException e) {
            return new JSONObject();
        }
    }

    @Override
    protected Task<JSONObject> createTask() {
        return new Task<>() {
            @Override
            protected JSONObject call() {
                return getWeather();
            }
        };
    }
}