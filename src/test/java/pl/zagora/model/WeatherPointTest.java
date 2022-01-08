package pl.zagora.model;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.zagora.controller.services.fetchWeatherServiceTestStubs.WeatherJsonStubHTTP200;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;

public class WeatherPointTest {

    private WeatherPoint weatherPoint;
    private JSONObject weatherData;

    @BeforeEach
    public void setupWeatherPoint() {
        weatherData = (JSONObject) new WeatherJsonStubHTTP200().getJSONArray("list").get(0);
    }

    @Test
    public void getTempValueMethodIsSupposedToReturnAppropriateValue() {
        //given
        int tempValueFromWeatherData = (int) Math.round(weatherData.getJSONObject("main").getDouble("temp"));

        //when
        weatherPoint = new WeatherPoint(weatherData);

        //then
        assertThat(weatherPoint.getTempValue(), equalTo(tempValueFromWeatherData));

    }

    @Test
    public void getCloudyValueMethodShouldReturnAppropriateValue() {
        //given
        int cloudyValueFromWeatherData = weatherData.getJSONObject("clouds").getInt("all");

        //when
        weatherPoint = new WeatherPoint(weatherData);

        //then
        assertThat(weatherPoint.getCloudyValue(), is(cloudyValueFromWeatherData));
    }

    @Test
    public void getWindSpeedMethodIsOughtToReturnRelevantValue() {
        //given
        double windSpeedValueFromWeatherData = weatherData.getJSONObject("wind").getDouble("speed");

        //when
        weatherPoint = new WeatherPoint(weatherData);

        //then
        assertThat(weatherPoint.getWindSpeed(), is(windSpeedValueFromWeatherData));
    }

    @Test
    public void getPressureValueMethodShouldReturnRelevantValue() {
        //given
        int pressureValueFromWeatherData = weatherData.getJSONObject("main").getInt("pressure");

        //when
        weatherPoint = new WeatherPoint(weatherData);

        //then
        assertThat(weatherPoint.getPressureValue(), equalTo(pressureValueFromWeatherData));
    }

    @Test
    public void getPrecipitationProbabilityPercentValueMethodIsMeantToReturnAppropriateValue() {
        //given
        int precipitationProbabilityPercentValueFromWeatherData = (int) (weatherData.getDouble("pop")*100);

        //when
        weatherPoint = new WeatherPoint(weatherData);

        //then
        assertThat(weatherPoint.getPrecipitationProbabilityPercentValue(),
                is(precipitationProbabilityPercentValueFromWeatherData));
    }
}
