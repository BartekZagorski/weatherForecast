package pl.zagora.controller.services.fetchWeatherServiceTestStubs;

import org.json.JSONObject;

public class WeatherJsonStubAnotherHTTP extends WeatherJsonStub {

    public WeatherJsonStubAnotherHTTP () {
        int dummyInt = 0;
        this.jsonObject = new JSONObject("{\n" +
                "\"cod\": \"" + dummyInt + "\",\n" +
                "}");
    }
}
