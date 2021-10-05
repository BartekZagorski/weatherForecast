package pl.zagora17.controller;

import pl.zagora17.controller.services.WeatherService;
import pl.zagora17.view.ViewFactory;

public class BaseController {


    protected WeatherService weatherService;
    protected ViewFactory viewFactory;
    private final String fxmlName;

    public BaseController(WeatherService weatherService,
                          ViewFactory viewFactory, String fxmlName) {

        this.weatherService = weatherService;
        this.viewFactory = viewFactory;
        this.fxmlName = fxmlName;
    }

    public String getFxmlName() {
        return fxmlName;
    }
}
