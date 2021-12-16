package pl.zagora;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.zagora.model.WeatherDay;

import java.util.ArrayList;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

public class WeatherManagerTest {

    static WeatherManager weatherManager = new WeatherManager();
    static WeatherDay weatherDay = mock(WeatherDay.class);

    @BeforeAll
    static void initializeWeatherManager() {
        weatherManager.setWeatherDayList(new ArrayList<>());
        weatherManager.getWeatherDayList().add(weatherDay);
    }

    @Test
    public void setSelectedWeatherDayMethodShouldSetTheIIndexElementOfWeatherDayList() {
        //given

        //when
        weatherManager.setSelectedWeatherDay(0);

        //then
        assertThat(weatherManager.getSelectedWeatherDay(), is(weatherDay));

    }
}
