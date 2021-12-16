package pl.zagora.model;

import org.json.JSONException;
import org.json.JSONObject;
import pl.zagora.controller.services.fetchWeatherServiceTestStubs.WeatherJsonStubHTTP200;

public class WeatherDataStub extends JSONObject {

    private JSONObject weatherData;

    public WeatherDataStub (JSONObject weatherData) {
        this.weatherData = weatherData;
    }

    @Override
    public JSONObject getJSONObject(String key) throws JSONException {
        return weatherData.getJSONObject(key);
    }

    @Override
    public double getDouble(String key) throws JSONException {
        return weatherData.getDouble(key);
    }
}
