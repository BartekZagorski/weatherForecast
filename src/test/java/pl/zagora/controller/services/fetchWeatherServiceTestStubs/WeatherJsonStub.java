package pl.zagora.controller.services.fetchWeatherServiceTestStubs;

import org.json.JSONObject;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class WeatherJsonStub{

    protected JSONObject jsonObject;

    public JSONObject getJsonObject() {
        return jsonObject;
    }
    public WeatherJsonStub (String filename) {
        String path = "src/test/resources/" + filename;
        String data;
        try {
            data = new String(Files.readAllBytes(Paths.get(path)));
        } catch (IOException e) {
            data = "";
        }
        jsonObject = new JSONObject(data);
    }
}
