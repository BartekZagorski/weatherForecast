package pl.zagora17.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import pl.zagora17.Config;

import java.io.IOException;
import java.net.URL;

public class WeatherService {

    private OkHttpClient client;
    private Response response;
    private String cityName;
    String unit;
    private String url;
    private String apiKey = Config.API_KEY;

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String s) {
        url = s;
    }

    public JSONObject getWeather() {
        client = new OkHttpClient();
        setUrl("https://api.openweathermap.org/data/2.5/forecast?q="+getCityName()+"&units="+getUnit()                     +"&appid="+getApiKey());
        Request request = new Request.Builder()
                .url(getUrl()).build();
        try {
            response = client.newCall(request).execute();
            return new JSONObject(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public JSONArray getListArray() {
        JSONArray listArray = getWeather().getJSONArray("list");
        return listArray;
    }

}