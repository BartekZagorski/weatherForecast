package pl.zagora.controller.services;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.zagora.controller.FetchWeatherResult;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FetchWeatherServiceTest {

    private static FetchWeatherService fetchWeatherService = new FetchWeatherService();

    @BeforeAll
    public static void initializeFetchWeatherService() {
        fetchWeatherService.setWeatherJSON(new WeatherJsonStubHTTP200());
        fetchWeatherService.setWeatherDayList(new ArrayList<>());
    }

    @Test
    public void fetchWeatherWithCorrectDataShouldReturnSuccess() {
        //given
        //when
        FetchWeatherResult fetchWeatherResult = fetchWeatherService.fetchWeather();
        //then
        assertThat(fetchWeatherResult, equalTo(FetchWeatherResult.SUCCESS));
    }

}
