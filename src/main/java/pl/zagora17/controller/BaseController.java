package pl.zagora17.controller;

import pl.zagora17.WeatherManager;
import pl.zagora17.view.ViewFactory;

public class BaseController {

    protected WeatherManager homeWeatherManager;
    protected WeatherManager awayWeatherManager;
    protected ViewFactory viewFactory;
    private String fxmlName;

    public BaseController(WeatherManager homeWeatherManager, WeatherManager awayWeatherManager,
                          ViewFactory viewFactory, String fxmlName) {
        this.homeWeatherManager = homeWeatherManager;
        this.awayWeatherManager = awayWeatherManager;
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName() {
        return fxmlName;
    }
}
