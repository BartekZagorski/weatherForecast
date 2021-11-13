package pl.zagora17;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pl.zagora17.model.WeatherDay;
import pl.zagora17.model.WeatherPoint;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

public class WeatherManagerTest {

    static WeatherManager weatherManager = new WeatherManager();
    static WeatherDay weatherDay = mock(WeatherDay.class);

    @BeforeAll
    static void initializeWeatherManager() {
        weatherManager.setWeatherDayList(new ArrayList<>());
    }

    @Test
    public void setSelectedWeatherDayMethodShouldSetTheIIndexElementOfWeatherDayList() {
        //given
        weatherManager.getWeatherDayList().add(weatherDay);

        //when
        weatherManager.setSelectedWeatherDay(0);

        //then
        assertThat(weatherManager.getSelectedWeatherDay(), is(weatherDay));

    }

    @Test
    public void setSelectedWeatherPointMethodShouldSetIIndexElementOfWeatherPointList() {
        //given


    }
}
