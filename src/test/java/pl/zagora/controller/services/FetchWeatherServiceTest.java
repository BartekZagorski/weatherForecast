package pl.zagora.controller.services;

import org.json.JSONObject;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.zagora.controller.FetchWeatherResult;
import pl.zagora.controller.services.fetchWeatherServiceTestStubs.WeatherJsonStubAnotherHTTP;
import pl.zagora.controller.services.fetchWeatherServiceTestStubs.WeatherJsonStubHTTP200;
import pl.zagora.controller.services.fetchWeatherServiceTestStubs.WeatherJsonStubHTTP404;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
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

    @Test
    public void weatherDayListShouldHaveFiveDaysAfterFetchWeatherCallIfTheDataStartsFromMidnightUTC() {
        //given
        WeatherJsonStubHTTP200 wjs200 = new WeatherJsonStubHTTP200();
        wjs200.manipulateDataToStartFromMidnightUTC();
        fetchWeatherService.setWeatherJSON(wjs200);
        //when
        fetchWeatherService.fetchWeather();
        //then
        assertThat(fetchWeatherService.getWeatherDayList().size(), equalTo(5));
    }

    @Test
    public void weatherPointFromWeatherDayListShouldHaveSameHourThanRelevantWeatherPointFromWeatherJSON() {
        //given
        fetchWeatherService.setWeatherJSON((new WeatherJsonStubHTTP200()));
        fetchWeatherService.fetchWeather();

        //when

        String hourFromList = fetchWeatherService.getWeatherDayList().get(0).getWeatherPoints().get(0).getHour();
        JSONObject object = (JSONObject) fetchWeatherService.getWeatherJSON().getJSONArray("list").get(0);
        ZonedDateTime dateFromJSON =
                ZonedDateTime.ofInstant(Instant.ofEpochSecond(object.getLong("dt")), ZoneId.systemDefault());

        //then

        assertThat(hourFromList, equalTo(dateFromJSON.getHour() + ":00"));

    }

    @AfterEach
    public void cleanUpAfterEachTest() {
        fetchWeatherService = new FetchWeatherService();
    }

}
