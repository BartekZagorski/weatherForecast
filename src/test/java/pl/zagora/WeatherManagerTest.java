package pl.zagora;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.zagora.model.WeatherDay;

import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

@ExtendWith(MockitoExtension.class)
public class WeatherManagerTest {

    private WeatherManager weatherManager = new WeatherManager();

    @Mock
    private WeatherDay weatherDay;

    @BeforeEach
    void setUp() {

        weatherManager = new WeatherManager();
        weatherManager.setWeatherDayList(List.of(weatherDay));

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
