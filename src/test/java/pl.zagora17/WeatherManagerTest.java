package pl.zagora17;

import org.junit.jupiter.api.Test;
import pl.zagora17.model.WeatherDay;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.mock;

public class WeatherManagerTest {

    @Test
    public void setSelectedWeatherDayMethodShouldSetTheIIndexElementOfWeatherDayList() {
        //given
        WeatherDay weatherDay = mock(WeatherDay.class);
        List<WeatherDay> weatherDays = new ArrayList<>();
        weatherDays.add(weatherDay);
        WeatherManager weatherManager = new WeatherManager();
        weatherManager.setWeatherDayList(weatherDays);

        //when
        weatherManager.setSelectedWeatherDay(0);

        //then
        assertThat(weatherManager.getSelectedWeatherDay(), is(weatherDay));

    }
}
