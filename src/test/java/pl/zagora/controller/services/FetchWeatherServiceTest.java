package pl.zagora.controller.services;

import org.junit.jupiter.api.BeforeAll;

public class FetchWeatherServiceTest {

    public static FetchWeatherService fetchWeatherService;
    public static WeatherJsonStub weatherJsonStub;

    @BeforeAll
    public static void initializeFetchWeatherService() {
        fetchWeatherService = new FetchWeatherService();
        weatherJsonStub = new WeatherJsonStub();
        fetchWeatherService.setWeatherJSON(weatherJsonStub);
    }

}
