package pl.zagora.model;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.zagora.controller.services.fetchWeatherServiceTestStubs.WeatherJsonStubHTTP200;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WeatherPointTest {

    private static final WeatherPoint weatherPoint = new WeatherPoint();
    private static JSONObject weatherData;

    @BeforeAll
    public static void setupWeatherPoint() {
        WeatherJsonStubHTTP200 weatherJsonStubHTTP200 = new WeatherJsonStubHTTP200();
        JSONObject jsonObject = (JSONObject) weatherJsonStubHTTP200.getJSONArray("list").get(0);
        WeatherDataStub weatherDataStub = new WeatherDataStub(jsonObject);
        weatherPoint.setWeatherData(weatherDataStub);
        weatherData = weatherPoint.getWeatherData();
    }

    @Test
    public void getTempValueMethodIsSupposedToReturnAppropriateValue() {
        //given
        //when
        int tempValueFromWeatherData = (int) Math.round(weatherData.getJSONObject("main").getDouble("temp"));

        //then
        assertThat(weatherPoint.getTempValue(), equalTo(tempValueFromWeatherData));

    }

    @Test
    public void getCloudyValueMethodShouldReturnAppropriateValue() {
        //given
        //when
        int cloudyValueFromWeatherData = weatherData.getJSONObject("clouds").getInt("all");

        //then
        assertThat(weatherPoint.getCloudyValue(), is(cloudyValueFromWeatherData));
    }

    @Test
    public void getWindSpeedMethodIsOughtToReturnRelevantValue() {
        //given
        //when
        double windSpeedValueFromWeatherData = weatherData.getJSONObject("wind").getDouble("speed");

        //then
        assertThat(weatherPoint.getWindSpeed(), is(windSpeedValueFromWeatherData));
    }

    @Test
    public void getPressureValueMethodShouldReturnRelevantValue() {
        //given
        //when
        int pressureValueFromWeatherData = weatherData.getJSONObject("main").getInt("pressure");

        //then
        assertThat(weatherPoint.getPressureValue(), equalTo(pressureValueFromWeatherData));
    }

    @Test
    public void getPrecipitationProbabilityPercentValueMethodIsMeantToReturnAppropriateValue() {
        //given
        //when
        int precipitationProbabilityPercentValueFromWeatherData = (int) (weatherData.getDouble("pop")*100);

        //then
        assertThat(weatherPoint.getPrecipitationProbabilityPercentValue(),
                is(precipitationProbabilityPercentValueFromWeatherData));
    }
}
