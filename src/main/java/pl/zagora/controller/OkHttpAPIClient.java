package pl.zagora.controller;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import pl.zagora.Config;

import java.io.IOException;
import java.util.Objects;

public class OkHttpAPIClient implements WeatherAPIClient {

    private final OkHttpClient client = new OkHttpClient();
    private static final String UNIT = "metric";

    @Override
    public String call(String cityName) throws IOException {
        String url =
                "https://api.openweathermap.org/data/2.5/forecast?q=" + cityName + "&units=" + UNIT + "&appid=" + Config.API_KEY;
        Request request = new Request.Builder()
                .url(url).build();
        Response response = client.newCall(request).execute();
        return Objects.requireNonNull(response.body()).string();
    }

}
