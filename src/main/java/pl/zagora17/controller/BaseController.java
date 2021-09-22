package pl.zagora17.controller;

import pl.zagora17.WeatherManager;
import pl.zagora17.controller.services.WeatherService;
import pl.zagora17.view.ViewFactory;

public class BaseController {

    protected WeatherManager homeWeatherManager;
    protected WeatherManager awayWeatherManager;
    protected WeatherService weatherService;
    protected ViewFactory viewFactory;
    private final String fxmlName;

    public BaseController(WeatherManager homeWeatherManager, WeatherManager awayWeatherManager,
                          WeatherService weatherService,
                          ViewFactory viewFactory, String fxmlName) {
        this.homeWeatherManager = homeWeatherManager;
        this.awayWeatherManager = awayWeatherManager;
        this.weatherService = weatherService;
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName() {
        return fxmlName;
    }
}
