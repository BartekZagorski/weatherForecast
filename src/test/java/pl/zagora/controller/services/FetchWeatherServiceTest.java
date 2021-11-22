package pl.zagora.controller.services;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.zagora.controller.FetchWeatherResult;
import pl.zagora.controller.services.fetchWeatherServiceTestStubs.WeatherJsonStubAnotherHTTP;
import pl.zagora.controller.services.fetchWeatherServiceTestStubs.WeatherJsonStubHTTP200;
import pl.zagora.controller.services.fetchWeatherServiceTestStubs.WeatherJsonStubHTTP404;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class FetchWeatherServiceTest {

    private static FetchWeatherService fetchWeatherService = new FetchWeatherService();

    @BeforeAll
    public static void initializeFetchWeatherService() {
        fetchWeatherService.setWeatherDayList(new ArrayList<>());
    }

    @Test
    public void fetchWeatherWithCorrectDataShouldReturnSuccess() {
        //given
        fetchWeatherService.setWeatherJSON(new WeatherJsonStubHTTP200());
        //when
        FetchWeatherResult fetchWeatherResult = fetchWeatherService.fetchWeather();
        //then
        assertThat(fetchWeatherResult, equalTo(FetchWeatherResult.SUCCESS));
    }

    @Test
    public void fetchWeatherWithBadTownNameShouldReturnFAILED_BY_TOWN_NAME() {
        //given
        fetchWeatherService.setWeatherJSON(new WeatherJsonStubHTTP404());
        //when
        FetchWeatherResult fetchWeatherResult = fetchWeatherService.fetchWeather();
        //then
        assertThat(fetchWeatherResult, equalTo(FetchWeatherResult.FAILED_BY_TOWN_NAME));
    }

    @Test
    public void fetchWeatherWithBadHTTPResponseShouldReturnFAILED_BY_UNEXPECTED_ERROR() {
        //given
        fetchWeatherService.setWeatherJSON(new WeatherJsonStubAnotherHTTP());
        //when
        FetchWeatherResult fetchWeatherResult = fetchWeatherService.fetchWeather();
        //then
        assertThat(fetchWeatherResult, equalTo(FetchWeatherResult.FAILED_BY_UNEXPECTED_ERROR));
    }

    @Test
    public void weatherDayListShouldHaveSixDaysAfterFetchWeatherCall() {
        //given
        fetchWeatherService.setWeatherJSON(new WeatherJsonStubHTTP200());
        //when
        fetchWeatherService.fetchWeather();
        //then
        assertThat(fetchWeatherService.getWeatherDayList().size(), equalTo(6));
    }


    @AfterAll
    public static void cleanUpAfterAllTests() {
        fetchWeatherService = new FetchWeatherService();
    }

}
