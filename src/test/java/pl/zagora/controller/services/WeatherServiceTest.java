package pl.zagora.controller.services;

import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import pl.zagora.controller.DownloadWeatherResult;
import pl.zagora.controller.OkHttpAPIClient;
import pl.zagora.controller.WeatherAPIClient;
import pl.zagora.controller.services.fetchWeatherServiceTestStubs.WeatherJsonStub;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.mockito.ArgumentMatchers.isNull;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@ExtendWith(MockitoExtension.class)
class WeatherServiceTest {

    private WeatherService weatherService;
    private WeatherAPIClient weatherAPIClient;

    @BeforeEach
    void prepareWeatherService () {
        weatherAPIClient = mock(OkHttpAPIClient.class);
        weatherService = new WeatherService(weatherAPIClient);
    }

    @Test
    void getWeatherMethodWhenAPIRespondProperlyShouldReturnSUCCESS() throws IOException {

        //given

        String path = "src/test/resources/jsonDataWithHttpResponse200.json";
        String data = new String(Files.readAllBytes(Paths.get(path)));
        String cityName = "Płock";
        given(weatherAPIClient.call(cityName)).willReturn(data);

        //when

        weatherService.setCityName(cityName);
        DownloadWeatherResult downloadWeatherResult = weatherService.getWeather();

        //then

        assertThat(downloadWeatherResult, equalTo(DownloadWeatherResult.SUCCESS));

    }

    @Test
    void getWeatherMethodWhenThrowsExceptionIsOughtToReturnFAIL() throws IOException {
        //given

        String cityName = "Płock";
        given(weatherAPIClient.call(cityName)).willThrow(IOException.class);

        //when

        weatherService.setCityName(cityName);
        DownloadWeatherResult downloadWeatherResult = weatherService.getWeather();

        //then

        assertThat(downloadWeatherResult, is(DownloadWeatherResult.FAIL));
    }
}