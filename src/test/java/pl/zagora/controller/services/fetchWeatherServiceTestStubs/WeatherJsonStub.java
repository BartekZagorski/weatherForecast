package pl.zagora.controller.services.fetchWeatherServiceTestStubs;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherJsonStub extends JSONObject{

    protected JSONObject jsonObject;

    public WeatherJsonStub() {
        this.jsonObject = new JSONObject();
    }


    @Override
    public JSONArray getJSONArray(String key) throws JSONException {
        return this.jsonObject.getJSONArray(key);
    }

    @Override
    public int getInt(String key) throws JSONException {
        return this.jsonObject.getInt(key);
    }
}
