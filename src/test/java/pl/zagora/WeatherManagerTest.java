package pl.zagora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import pl.zagora.model.WeatherDay;
import pl.zagora.model.WeatherPoint;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class WeatherManagerTest {

    private WeatherManager weatherManager = new WeatherManager();

    @BeforeEach
    void setUp() {

        weatherManager = new WeatherManager();

    }

    @Test
    public void selectDayMethodShouldAssignIthDayToSelectedDayAndFirstPointOfWeatherPointListToSelectedPoint() {
        //given
        WeatherDay sampleWeatherDay = mock(WeatherDay.class);
        WeatherDay thisWeatherDay = mock(WeatherDay.class);
        weatherManager.getWeatherDayList().add(sampleWeatherDay);
        weatherManager.getWeatherDayList().add(thisWeatherDay);
        WeatherPoint weatherPoint = mock(WeatherPoint.class);
        given(thisWeatherDay.getWeatherPoint(0)).willReturn(weatherPoint);

        //when
        weatherManager.selectDay(1);

        //then
        assertThat(weatherManager.getSelectedWeatherDay(), is(thisWeatherDay));
        assertThat(weatherManager.getSelectedWeatherPoint(), is(thisWeatherDay.getWeatherPoint(0)));

    }

    @Test
    void getCityName() {
        //given
        String countryCode = "fr";

        //when
        weatherManager.setCountryCode(countryCode);

        //then
        assertThat(weatherManager.getCountryName(), is("Francja"));

    }
}
