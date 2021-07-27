package pl.zagora17.controller.services;

import javafx.concurrent.Service;
import javafx.concurrent.Task;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONObject;
import pl.zagora17.Config;

import java.io.IOException;

public class WeatherService extends Service<JSONObject> {

    private OkHttpClient client;
    private Response response;
    private String cityName;
    private String unit;
    private String url;
    private final String API_KEY = Config.API_KEY;

    public WeatherService(String cityName, String unit) {
        this.cityName = cityName;
        this.unit = unit;
    }

    public JSONObject getWeather() {
        client = new OkHttpClient();
        url = "https://api.openweathermap.org/data/2.5/forecast?q="+cityName+"&units="+unit+"&appid="+API_KEY;
        Request request = new Request.Builder()
                .url(url).build();
        try {
            response = client.newCall(request).execute();
            return new JSONObject(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected Task<JSONObject> createTask() {
        return new Task<JSONObject>() {
            @Override
            protected JSONObject call() throws Exception {
                return getWeather();
            }
        };
    }
}