package pl.zagora.controller.services.fetchWeatherServiceTestStubs;

import org.json.JSONObject;

public class WeatherJsonStubHTTP404 extends WeatherJsonStub {

    public WeatherJsonStubHTTP404() {
        this.jsonObject = new JSONObject("{\n" +
                "\"cod\": \"404\",\n" +
                "\"message\": \"city not found\"\n" +
                "}");
    }
}
