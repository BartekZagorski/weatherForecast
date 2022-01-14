package pl.zagora.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

class WeatherDayTest {

    private WeatherDay weatherDay;

    @BeforeEach
    void setUp() {
        weatherDay = new WeatherDay();
    }

    @Test
    void getAverageTemperatureShouldReturnMeanValueOfCollection() {
        //given

            WeatherPoint weatherPoint1 = mock(WeatherPoint.class);
            WeatherPoint weatherPoint2 = mock(WeatherPoint.class);
            given(weatherPoint1.getTempValue()).willReturn(4);
            given(weatherPoint2.getTempValue()).willReturn(6);

            weatherDay.getWeatherPoints().add(weatherPoint1);
            weatherDay.getWeatherPoints().add(weatherPoint2);

        //when

            int averageTemperature = weatherDay.getAverageTemperature();

        //then

            assertEquals(averageTemperature, 5);

    }
}