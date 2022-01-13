package pl.zagora.controller;

import java.io.IOException;

public interface WeatherAPIClient {
    String call(String cityName) throws IOException;
}
