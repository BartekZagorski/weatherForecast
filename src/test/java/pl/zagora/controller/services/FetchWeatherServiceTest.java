package pl.zagora.controller.services;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.zagora.controller.FetchWeatherResult;
import pl.zagora.controller.services.fetchWeatherServiceTestStubs.WeatherJsonStub;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;

public class FetchWeatherServiceTest {

    private FetchWeatherService fetchWeatherService = new FetchWeatherService();

    @BeforeEach
    public void initializeFetchWeatherService() {
        fetchWeatherService.setWeatherDayList(new ArrayList<>());
    }

    @Test
    public void fetchWeatherWithCorrectDataShouldReturnSuccess() {
        //given
        fetchWeatherService.setWeatherJSON(new WeatherJsonStub("jsonDataWithHttpResponse200.json").getJsonObject());
        //when
        FetchWeatherResult fetchWeatherResult = fetchWeatherService.fetchWeather();
        //then
        assertThat(fetchWeatherResult, equalTo(FetchWeatherResult.SUCCESS));
    }

    @Test
    public void fetchWeatherWithBadTownNameShouldReturnFAILED_BY_TOWN_NAME() {
        //given
        fetchWeatherService.setWeatherJSON(new WeatherJsonStub("jsonDataWithHttpResponse404.json").getJsonObject());
        //when
        FetchWeatherResult fetchWeatherResult = fetchWeatherService.fetchWeather();
        //then
        assertThat(fetchWeatherResult, equalTo(FetchWeatherResult.FAILED_BY_TOWN_NAME));
    }

    @Test
    public void fetchWeatherWithBadHTTPResponseShouldReturnFAILED_BY_UNEXPECTED_ERROR() {
        //given
        fetchWeatherService.setWeatherJSON(new WeatherJsonStub("jsonDataWithAnotherHttpResponse.json").getJsonObject());
        //when
        FetchWeatherResult fetchWeatherResult = fetchWeatherService.fetchWeather();
        //then
        assertThat(fetchWeatherResult, equalTo(FetchWeatherResult.FAILED_BY_UNEXPECTED_ERROR));
    }

    @Test
    public void weatherDayListShouldHaveSixDaysAfterFetchWeatherCall() {
        //given
        fetchWeatherService.setWeatherJSON(new WeatherJsonStub("jsonDataWithHttpResponse200.json").getJsonObject());
        //when
        fetchWeatherService.fetchWeather();
        //then
        assertThat(fetchWeatherService.getWeatherDayList().size(), equalTo(6));
    }

    @Test
    public void weatherDayListShouldHaveFiveDaysAfterFetchWeatherCallIfTheDataStartsFromMidnightUTC() {
        //given
        WeatherJsonStub wjs = new WeatherJsonStub("jsonDataWithHttpResponse200ThatBeginsAtMidnightUTC.json");
        fetchWeatherService.setWeatherJSON(wjs.getJsonObject());
        //when
        fetchWeatherService.fetchWeather();
        //then
        assertThat(fetchWeatherService.getWeatherDayList().size(), equalTo(5));
    }

    @Test
    public void weatherPointFromWeatherDayListShouldHaveSameHourThanRelevantWeatherPointFromWeatherJSON() {
        //given
        JSONObject jsonObject = new WeatherJsonStub("jsonDataWithHttpResponse200.json").getJsonObject();
        fetchWeatherService.setWeatherJSON(jsonObject);
        fetchWeatherService.fetchWeather();

        //when

        String hourFromList = fetchWeatherService.getWeatherDayList().get(0).getWeatherPoints().get(0).getHour();
        JSONObject object = (JSONObject) jsonObject.getJSONArray("list").get(0);
        ZonedDateTime dateFromJSON =
                ZonedDateTime.ofInstant(Instant.ofEpochSecond(object.getLong("dt")), ZoneId.systemDefault());

        //then

        assertThat(hourFromList, equalTo(dateFromJSON.getHour() + ":00"));

    }

}
