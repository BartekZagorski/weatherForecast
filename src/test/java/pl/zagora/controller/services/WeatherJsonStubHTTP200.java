package pl.zagora.controller.services;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class WeatherJsonStubHTTP200 extends JSONObject {

    private final JSONObject jsonObject;

    public WeatherJsonStubHTTP200() {
        String exampleJsonData = "{\n" +
                "\"cod\": \"200\",\n" +
                "\"message\": 0,\n" +
                "\"cnt\": 40,\n" +
                "\"list\": [\n" +
                "{\n" +
                "\"dt\": 1636912800,\n" +
                "\"main\": {\n" +
                "\"temp\": 13.16,\n" +
                "\"feels_like\": 12.05,\n" +
                "\"temp_min\": 13.16,\n" +
                "\"temp_max\": 14.23,\n" +
                "\"pressure\": 1016,\n" +
                "\"sea_level\": 1016,\n" +
                "\"grnd_level\": 1011,\n" +
                "\"humidity\": 58,\n" +
                "\"temp_kf\": -1.07\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 802,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"scattered clouds\",\n" +
                "\"icon\": \"03n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 27\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 3.98,\n" +
                "\"deg\": 345,\n" +
                "\"gust\": 5.75\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-14 18:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1636923600,\n" +
                "\"main\": {\n" +
                "\"temp\": 13.24,\n" +
                "\"feels_like\": 11.93,\n" +
                "\"temp_min\": 13.24,\n" +
                "\"temp_max\": 13.55,\n" +
                "\"pressure\": 1016,\n" +
                "\"sea_level\": 1016,\n" +
                "\"grnd_level\": 1011,\n" +
                "\"humidity\": 50,\n" +
                "\"temp_kf\": -0.31\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 800,\n" +
                "\"main\": \"Clear\",\n" +
                "\"description\": \"clear sky\",\n" +
                "\"icon\": \"01n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 7\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 2.73,\n" +
                "\"deg\": 350,\n" +
                "\"gust\": 4.39\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-14 21:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1636934400,\n" +
                "\"main\": {\n" +
                "\"temp\": 15.54,\n" +
                "\"feels_like\": 14.17,\n" +
                "\"temp_min\": 15.54,\n" +
                "\"temp_max\": 15.54,\n" +
                "\"pressure\": 1018,\n" +
                "\"sea_level\": 1018,\n" +
                "\"grnd_level\": 1013,\n" +
                "\"humidity\": 39,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 800,\n" +
                "\"main\": \"Clear\",\n" +
                "\"description\": \"clear sky\",\n" +
                "\"icon\": \"01d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 0\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 3.45,\n" +
                "\"deg\": 346,\n" +
                "\"gust\": 3.89\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-15 00:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1636945200,\n" +
                "\"main\": {\n" +
                "\"temp\": 17.96,\n" +
                "\"feels_like\": 16.8,\n" +
                "\"temp_min\": 17.96,\n" +
                "\"temp_max\": 17.96,\n" +
                "\"pressure\": 1016,\n" +
                "\"sea_level\": 1016,\n" +
                "\"grnd_level\": 1011,\n" +
                "\"humidity\": 38,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 800,\n" +
                "\"main\": \"Clear\",\n" +
                "\"description\": \"clear sky\",\n" +
                "\"icon\": \"01d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 3\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 1.97,\n" +
                "\"deg\": 13,\n" +
                "\"gust\": 1.47\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-15 03:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1636956000,\n" +
                "\"main\": {\n" +
                "\"temp\": 18.8,\n" +
                "\"feels_like\": 17.78,\n" +
                "\"temp_min\": 18.8,\n" +
                "\"temp_max\": 18.8,\n" +
                "\"pressure\": 1016,\n" +
                "\"sea_level\": 1016,\n" +
                "\"grnd_level\": 1011,\n" +
                "\"humidity\": 40,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 800,\n" +
                "\"main\": \"Clear\",\n" +
                "\"description\": \"clear sky\",\n" +
                "\"icon\": \"01d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 2\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 1.16,\n" +
                "\"deg\": 105,\n" +
                "\"gust\": 1.37\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-15 06:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1636966800,\n" +
                "\"main\": {\n" +
                "\"temp\": 18.29,\n" +
                "\"feels_like\": 17.4,\n" +
                "\"temp_min\": 18.29,\n" +
                "\"temp_max\": 18.29,\n" +
                "\"pressure\": 1018,\n" +
                "\"sea_level\": 1018,\n" +
                "\"grnd_level\": 1013,\n" +
                "\"humidity\": 47,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 800,\n" +
                "\"main\": \"Clear\",\n" +
                "\"description\": \"clear sky\",\n" +
                "\"icon\": \"01n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 0\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 2.69,\n" +
                "\"deg\": 165,\n" +
                "\"gust\": 2.99\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-15 09:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1636977600,\n" +
                "\"main\": {\n" +
                "\"temp\": 17.12,\n" +
                "\"feels_like\": 16.43,\n" +
                "\"temp_min\": 17.12,\n" +
                "\"temp_max\": 17.12,\n" +
                "\"pressure\": 1019,\n" +
                "\"sea_level\": 1019,\n" +
                "\"grnd_level\": 1014,\n" +
                "\"humidity\": 59,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 800,\n" +
                "\"main\": \"Clear\",\n" +
                "\"description\": \"clear sky\",\n" +
                "\"icon\": \"01n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 0\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 1.83,\n" +
                "\"deg\": 135,\n" +
                "\"gust\": 3.27\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-15 12:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1636988400,\n" +
                "\"main\": {\n" +
                "\"temp\": 16.27,\n" +
                "\"feels_like\": 15.55,\n" +
                "\"temp_min\": 16.27,\n" +
                "\"temp_max\": 16.27,\n" +
                "\"pressure\": 1018,\n" +
                "\"sea_level\": 1018,\n" +
                "\"grnd_level\": 1013,\n" +
                "\"humidity\": 61,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 500,\n" +
                "\"main\": \"Rain\",\n" +
                "\"description\": \"light rain\",\n" +
                "\"icon\": \"10n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 33\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 0.98,\n" +
                "\"deg\": 15,\n" +
                "\"gust\": 2.21\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0.4,\n" +
                "\"rain\": {\n" +
                "\"3h\": 0.32\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-15 15:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1636999200,\n" +
                "\"main\": {\n" +
                "\"temp\": 15.28,\n" +
                "\"feels_like\": 14.22,\n" +
                "\"temp_min\": 15.28,\n" +
                "\"temp_max\": 15.28,\n" +
                "\"pressure\": 1019,\n" +
                "\"sea_level\": 1019,\n" +
                "\"grnd_level\": 1014,\n" +
                "\"humidity\": 52,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 500,\n" +
                "\"main\": \"Rain\",\n" +
                "\"description\": \"light rain\",\n" +
                "\"icon\": \"10n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 56\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 3.31,\n" +
                "\"deg\": 345,\n" +
                "\"gust\": 4.15\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0.21,\n" +
                "\"rain\": {\n" +
                "\"3h\": 0.37\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-15 18:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637010000,\n" +
                "\"main\": {\n" +
                "\"temp\": 14.97,\n" +
                "\"feels_like\": 13.88,\n" +
                "\"temp_min\": 14.97,\n" +
                "\"temp_max\": 14.97,\n" +
                "\"pressure\": 1019,\n" +
                "\"sea_level\": 1019,\n" +
                "\"grnd_level\": 1014,\n" +
                "\"humidity\": 52,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 804,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"overcast clouds\",\n" +
                "\"icon\": \"04n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 94\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 4.02,\n" +
                "\"deg\": 357,\n" +
                "\"gust\": 4.88\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0.01,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-15 21:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637020800,\n" +
                "\"main\": {\n" +
                "\"temp\": 15.42,\n" +
                "\"feels_like\": 14.35,\n" +
                "\"temp_min\": 15.42,\n" +
                "\"temp_max\": 15.42,\n" +
                "\"pressure\": 1020,\n" +
                "\"sea_level\": 1020,\n" +
                "\"grnd_level\": 1015,\n" +
                "\"humidity\": 51,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 804,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"overcast clouds\",\n" +
                "\"icon\": \"04d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 97\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 4.43,\n" +
                "\"deg\": 354,\n" +
                "\"gust\": 4.79\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-16 00:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637031600,\n" +
                "\"main\": {\n" +
                "\"temp\": 16.56,\n" +
                "\"feels_like\": 15.5,\n" +
                "\"temp_min\": 16.56,\n" +
                "\"temp_max\": 16.56,\n" +
                "\"pressure\": 1018,\n" +
                "\"sea_level\": 1018,\n" +
                "\"grnd_level\": 1013,\n" +
                "\"humidity\": 47,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 804,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"overcast clouds\",\n" +
                "\"icon\": \"04d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 100\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 4.07,\n" +
                "\"deg\": 12,\n" +
                "\"gust\": 4.18\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-16 03:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637042400,\n" +
                "\"main\": {\n" +
                "\"temp\": 17.61,\n" +
                "\"feels_like\": 16.71,\n" +
                "\"temp_min\": 17.61,\n" +
                "\"temp_max\": 17.61,\n" +
                "\"pressure\": 1018,\n" +
                "\"sea_level\": 1018,\n" +
                "\"grnd_level\": 1013,\n" +
                "\"humidity\": 49,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 804,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"overcast clouds\",\n" +
                "\"icon\": \"04d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 96\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 3.05,\n" +
                "\"deg\": 36,\n" +
                "\"gust\": 3.1\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-16 06:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637053200,\n" +
                "\"main\": {\n" +
                "\"temp\": 15.96,\n" +
                "\"feels_like\": 15.36,\n" +
                "\"temp_min\": 15.96,\n" +
                "\"temp_max\": 15.96,\n" +
                "\"pressure\": 1020,\n" +
                "\"sea_level\": 1020,\n" +
                "\"grnd_level\": 1015,\n" +
                "\"humidity\": 67,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 803,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"broken clouds\",\n" +
                "\"icon\": \"04n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 53\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 6.31,\n" +
                "\"deg\": 66,\n" +
                "\"gust\": 6.4\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-16 09:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637064000,\n" +
                "\"main\": {\n" +
                "\"temp\": 14.89,\n" +
                "\"feels_like\": 14.18,\n" +
                "\"temp_min\": 14.89,\n" +
                "\"temp_max\": 14.89,\n" +
                "\"pressure\": 1021,\n" +
                "\"sea_level\": 1021,\n" +
                "\"grnd_level\": 1016,\n" +
                "\"humidity\": 67,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 803,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"broken clouds\",\n" +
                "\"icon\": \"04n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 76\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 5.82,\n" +
                "\"deg\": 54,\n" +
                "\"gust\": 7.84\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0.08,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-16 12:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637074800,\n" +
                "\"main\": {\n" +
                "\"temp\": 14.78,\n" +
                "\"feels_like\": 13.91,\n" +
                "\"temp_min\": 14.78,\n" +
                "\"temp_max\": 14.78,\n" +
                "\"pressure\": 1021,\n" +
                "\"sea_level\": 1021,\n" +
                "\"grnd_level\": 1016,\n" +
                "\"humidity\": 61,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 500,\n" +
                "\"main\": \"Rain\",\n" +
                "\"description\": \"light rain\",\n" +
                "\"icon\": \"10n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 100\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 4.76,\n" +
                "\"deg\": 34,\n" +
                "\"gust\": 5.62\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0.22,\n" +
                "\"rain\": {\n" +
                "\"3h\": 0.12\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-16 15:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637085600,\n" +
                "\"main\": {\n" +
                "\"temp\": 14.33,\n" +
                "\"feels_like\": 13.2,\n" +
                "\"temp_min\": 14.33,\n" +
                "\"temp_max\": 14.33,\n" +
                "\"pressure\": 1022,\n" +
                "\"sea_level\": 1022,\n" +
                "\"grnd_level\": 1016,\n" +
                "\"humidity\": 53,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 804,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"overcast clouds\",\n" +
                "\"icon\": \"04n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 100\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 3.63,\n" +
                "\"deg\": 26,\n" +
                "\"gust\": 4.07\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0.1,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-16 18:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637096400,\n" +
                "\"main\": {\n" +
                "\"temp\": 14.05,\n" +
                "\"feels_like\": 12.82,\n" +
                "\"temp_min\": 14.05,\n" +
                "\"temp_max\": 14.05,\n" +
                "\"pressure\": 1023,\n" +
                "\"sea_level\": 1023,\n" +
                "\"grnd_level\": 1017,\n" +
                "\"humidity\": 50,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 804,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"overcast clouds\",\n" +
                "\"icon\": \"04n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 98\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 3.01,\n" +
                "\"deg\": 42,\n" +
                "\"gust\": 3.23\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-16 21:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637107200,\n" +
                "\"main\": {\n" +
                "\"temp\": 14.32,\n" +
                "\"feels_like\": 13.09,\n" +
                "\"temp_min\": 14.32,\n" +
                "\"temp_max\": 14.32,\n" +
                "\"pressure\": 1024,\n" +
                "\"sea_level\": 1024,\n" +
                "\"grnd_level\": 1019,\n" +
                "\"humidity\": 49,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 804,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"overcast clouds\",\n" +
                "\"icon\": \"04d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 99\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 3.23,\n" +
                "\"deg\": 44,\n" +
                "\"gust\": 3.13\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-17 00:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637118000,\n" +
                "\"main\": {\n" +
                "\"temp\": 15.38,\n" +
                "\"feels_like\": 14.17,\n" +
                "\"temp_min\": 15.38,\n" +
                "\"temp_max\": 15.38,\n" +
                "\"pressure\": 1022,\n" +
                "\"sea_level\": 1022,\n" +
                "\"grnd_level\": 1017,\n" +
                "\"humidity\": 46,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 803,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"broken clouds\",\n" +
                "\"icon\": \"04d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 83\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 2.11,\n" +
                "\"deg\": 69,\n" +
                "\"gust\": 1.95\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-17 03:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637128800,\n" +
                "\"main\": {\n" +
                "\"temp\": 16.42,\n" +
                "\"feels_like\": 15.24,\n" +
                "\"temp_min\": 16.42,\n" +
                "\"temp_max\": 16.42,\n" +
                "\"pressure\": 1022,\n" +
                "\"sea_level\": 1022,\n" +
                "\"grnd_level\": 1017,\n" +
                "\"humidity\": 43,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 803,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"broken clouds\",\n" +
                "\"icon\": \"04d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 56\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 1.84,\n" +
                "\"deg\": 104,\n" +
                "\"gust\": 2.21\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-17 06:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637139600,\n" +
                "\"main\": {\n" +
                "\"temp\": 16.12,\n" +
                "\"feels_like\": 15.07,\n" +
                "\"temp_min\": 16.12,\n" +
                "\"temp_max\": 16.12,\n" +
                "\"pressure\": 1022,\n" +
                "\"sea_level\": 1022,\n" +
                "\"grnd_level\": 1017,\n" +
                "\"humidity\": 49,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 803,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"broken clouds\",\n" +
                "\"icon\": \"04n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 66\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 3.9,\n" +
                "\"deg\": 121,\n" +
                "\"gust\": 3.74\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-17 09:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637150400,\n" +
                "\"main\": {\n" +
                "\"temp\": 14.95,\n" +
                "\"feels_like\": 13.99,\n" +
                "\"temp_min\": 14.95,\n" +
                "\"temp_max\": 14.95,\n" +
                "\"pressure\": 1023,\n" +
                "\"sea_level\": 1023,\n" +
                "\"grnd_level\": 1017,\n" +
                "\"humidity\": 57,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 803,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"broken clouds\",\n" +
                "\"icon\": \"04n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 81\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 3.93,\n" +
                "\"deg\": 114,\n" +
                "\"gust\": 4.75\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0.01,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-17 12:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637161200,\n" +
                "\"main\": {\n" +
                "\"temp\": 14.89,\n" +
                "\"feels_like\": 13.98,\n" +
                "\"temp_min\": 14.89,\n" +
                "\"temp_max\": 14.89,\n" +
                "\"pressure\": 1021,\n" +
                "\"sea_level\": 1021,\n" +
                "\"grnd_level\": 1016,\n" +
                "\"humidity\": 59,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 804,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"overcast clouds\",\n" +
                "\"icon\": \"04n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 87\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 2.64,\n" +
                "\"deg\": 91,\n" +
                "\"gust\": 3.61\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0.05,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-17 15:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637172000,\n" +
                "\"main\": {\n" +
                "\"temp\": 14.8,\n" +
                "\"feels_like\": 13.93,\n" +
                "\"temp_min\": 14.8,\n" +
                "\"temp_max\": 14.8,\n" +
                "\"pressure\": 1021,\n" +
                "\"sea_level\": 1021,\n" +
                "\"grnd_level\": 1015,\n" +
                "\"humidity\": 61,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 804,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"overcast clouds\",\n" +
                "\"icon\": \"04n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 92\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 1.78,\n" +
                "\"deg\": 60,\n" +
                "\"gust\": 2.08\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0.08,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-17 18:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637182800,\n" +
                "\"main\": {\n" +
                "\"temp\": 14.62,\n" +
                "\"feels_like\": 13.81,\n" +
                "\"temp_min\": 14.62,\n" +
                "\"temp_max\": 14.62,\n" +
                "\"pressure\": 1020,\n" +
                "\"sea_level\": 1020,\n" +
                "\"grnd_level\": 1015,\n" +
                "\"humidity\": 64,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 804,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"overcast clouds\",\n" +
                "\"icon\": \"04n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 100\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 2.99,\n" +
                "\"deg\": 48,\n" +
                "\"gust\": 3.32\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0.13,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-17 21:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637193600,\n" +
                "\"main\": {\n" +
                "\"temp\": 14.35,\n" +
                "\"feels_like\": 13.75,\n" +
                "\"temp_min\": 14.35,\n" +
                "\"temp_max\": 14.35,\n" +
                "\"pressure\": 1020,\n" +
                "\"sea_level\": 1020,\n" +
                "\"grnd_level\": 1015,\n" +
                "\"humidity\": 73,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 500,\n" +
                "\"main\": \"Rain\",\n" +
                "\"description\": \"light rain\",\n" +
                "\"icon\": \"10d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 100\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 3.24,\n" +
                "\"deg\": 39,\n" +
                "\"gust\": 3.79\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0.37,\n" +
                "\"rain\": {\n" +
                "\"3h\": 0.11\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-18 00:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637204400,\n" +
                "\"main\": {\n" +
                "\"temp\": 13.86,\n" +
                "\"feels_like\": 13.26,\n" +
                "\"temp_min\": 13.86,\n" +
                "\"temp_max\": 13.86,\n" +
                "\"pressure\": 1017,\n" +
                "\"sea_level\": 1017,\n" +
                "\"grnd_level\": 1012,\n" +
                "\"humidity\": 75,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 500,\n" +
                "\"main\": \"Rain\",\n" +
                "\"description\": \"light rain\",\n" +
                "\"icon\": \"10d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 100\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 4.91,\n" +
                "\"deg\": 2,\n" +
                "\"gust\": 5.1\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0.44,\n" +
                "\"rain\": {\n" +
                "\"3h\": 0.31\n" +
                "},\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-18 03:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637215200,\n" +
                "\"main\": {\n" +
                "\"temp\": 14.05,\n" +
                "\"feels_like\": 13.39,\n" +
                "\"temp_min\": 14.05,\n" +
                "\"temp_max\": 14.05,\n" +
                "\"pressure\": 1017,\n" +
                "\"sea_level\": 1017,\n" +
                "\"grnd_level\": 1012,\n" +
                "\"humidity\": 72,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 804,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"overcast clouds\",\n" +
                "\"icon\": \"04d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 100\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 4.99,\n" +
                "\"deg\": 4,\n" +
                "\"gust\": 5.54\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0.3,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-18 06:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637226000,\n" +
                "\"main\": {\n" +
                "\"temp\": 14.18,\n" +
                "\"feels_like\": 13.61,\n" +
                "\"temp_min\": 14.18,\n" +
                "\"temp_max\": 14.18,\n" +
                "\"pressure\": 1017,\n" +
                "\"sea_level\": 1017,\n" +
                "\"grnd_level\": 1012,\n" +
                "\"humidity\": 75,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 804,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"overcast clouds\",\n" +
                "\"icon\": \"04n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 100\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 3.76,\n" +
                "\"deg\": 5,\n" +
                "\"gust\": 4.5\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0.01,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-18 09:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637236800,\n" +
                "\"main\": {\n" +
                "\"temp\": 13.99,\n" +
                "\"feels_like\": 13.43,\n" +
                "\"temp_min\": 13.99,\n" +
                "\"temp_max\": 13.99,\n" +
                "\"pressure\": 1017,\n" +
                "\"sea_level\": 1017,\n" +
                "\"grnd_level\": 1012,\n" +
                "\"humidity\": 76,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 804,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"overcast clouds\",\n" +
                "\"icon\": \"04n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 100\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 3,\n" +
                "\"deg\": 350,\n" +
                "\"gust\": 3.79\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0.01,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-18 12:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637247600,\n" +
                "\"main\": {\n" +
                "\"temp\": 13.48,\n" +
                "\"feels_like\": 12.87,\n" +
                "\"temp_min\": 13.48,\n" +
                "\"temp_max\": 13.48,\n" +
                "\"pressure\": 1016,\n" +
                "\"sea_level\": 1016,\n" +
                "\"grnd_level\": 1011,\n" +
                "\"humidity\": 76,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 804,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"overcast clouds\",\n" +
                "\"icon\": \"04n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 96\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 3.46,\n" +
                "\"deg\": 353,\n" +
                "\"gust\": 5.4\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-18 15:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637258400,\n" +
                "\"main\": {\n" +
                "\"temp\": 13.01,\n" +
                "\"feels_like\": 12.25,\n" +
                "\"temp_min\": 13.01,\n" +
                "\"temp_max\": 13.01,\n" +
                "\"pressure\": 1015,\n" +
                "\"sea_level\": 1015,\n" +
                "\"grnd_level\": 1010,\n" +
                "\"humidity\": 72,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 803,\n" +
                "\"main\": \"Clouds\",\n" +
                "\"description\": \"broken clouds\",\n" +
                "\"icon\": \"04n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 63\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 3.87,\n" +
                "\"deg\": 357,\n" +
                "\"gust\": 6.64\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-18 18:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637269200,\n" +
                "\"main\": {\n" +
                "\"temp\": 12.5,\n" +
                "\"feels_like\": 11.66,\n" +
                "\"temp_min\": 12.5,\n" +
                "\"temp_max\": 12.5,\n" +
                "\"pressure\": 1016,\n" +
                "\"sea_level\": 1016,\n" +
                "\"grnd_level\": 1011,\n" +
                "\"humidity\": 71,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 800,\n" +
                "\"main\": \"Clear\",\n" +
                "\"description\": \"clear sky\",\n" +
                "\"icon\": \"01n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 1\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 3.35,\n" +
                "\"deg\": 358,\n" +
                "\"gust\": 6.09\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-18 21:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637280000,\n" +
                "\"main\": {\n" +
                "\"temp\": 14.21,\n" +
                "\"feels_like\": 13.17,\n" +
                "\"temp_min\": 14.21,\n" +
                "\"temp_max\": 14.21,\n" +
                "\"pressure\": 1016,\n" +
                "\"sea_level\": 1016,\n" +
                "\"grnd_level\": 1011,\n" +
                "\"humidity\": 57,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 800,\n" +
                "\"main\": \"Clear\",\n" +
                "\"description\": \"clear sky\",\n" +
                "\"icon\": \"01d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 0\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 4.07,\n" +
                "\"deg\": 355,\n" +
                "\"gust\": 4.57\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-19 00:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637290800,\n" +
                "\"main\": {\n" +
                "\"temp\": 16.59,\n" +
                "\"feels_like\": 15.66,\n" +
                "\"temp_min\": 16.59,\n" +
                "\"temp_max\": 16.59,\n" +
                "\"pressure\": 1014,\n" +
                "\"sea_level\": 1014,\n" +
                "\"grnd_level\": 1009,\n" +
                "\"humidity\": 52,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 800,\n" +
                "\"main\": \"Clear\",\n" +
                "\"description\": \"clear sky\",\n" +
                "\"icon\": \"01d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 0\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 2.29,\n" +
                "\"deg\": 12,\n" +
                "\"gust\": 1.99\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-19 03:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637301600,\n" +
                "\"main\": {\n" +
                "\"temp\": 17.68,\n" +
                "\"feels_like\": 16.73,\n" +
                "\"temp_min\": 17.68,\n" +
                "\"temp_max\": 17.68,\n" +
                "\"pressure\": 1013,\n" +
                "\"sea_level\": 1013,\n" +
                "\"grnd_level\": 1008,\n" +
                "\"humidity\": 47,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 800,\n" +
                "\"main\": \"Clear\",\n" +
                "\"description\": \"clear sky\",\n" +
                "\"icon\": \"01d\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 0\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 1.02,\n" +
                "\"deg\": 106,\n" +
                "\"gust\": 0.93\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"d\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-19 06:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637312400,\n" +
                "\"main\": {\n" +
                "\"temp\": 17.23,\n" +
                "\"feels_like\": 16.31,\n" +
                "\"temp_min\": 17.23,\n" +
                "\"temp_max\": 17.23,\n" +
                "\"pressure\": 1013,\n" +
                "\"sea_level\": 1013,\n" +
                "\"grnd_level\": 1008,\n" +
                "\"humidity\": 50,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 800,\n" +
                "\"main\": \"Clear\",\n" +
                "\"description\": \"clear sky\",\n" +
                "\"icon\": \"01n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 0\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 1.63,\n" +
                "\"deg\": 176,\n" +
                "\"gust\": 2.03\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-19 09:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637323200,\n" +
                "\"main\": {\n" +
                "\"temp\": 16.31,\n" +
                "\"feels_like\": 15.54,\n" +
                "\"temp_min\": 16.31,\n" +
                "\"temp_max\": 16.31,\n" +
                "\"pressure\": 1013,\n" +
                "\"sea_level\": 1013,\n" +
                "\"grnd_level\": 1008,\n" +
                "\"humidity\": 59,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 800,\n" +
                "\"main\": \"Clear\",\n" +
                "\"description\": \"clear sky\",\n" +
                "\"icon\": \"01n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 0\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 2.49,\n" +
                "\"deg\": 216,\n" +
                "\"gust\": 4.16\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-19 12:00:00\"\n" +
                "},\n" +
                "{\n" +
                "\"dt\": 1637334000,\n" +
                "\"main\": {\n" +
                "\"temp\": 15.36,\n" +
                "\"feels_like\": 14.41,\n" +
                "\"temp_min\": 15.36,\n" +
                "\"temp_max\": 15.36,\n" +
                "\"pressure\": 1012,\n" +
                "\"sea_level\": 1012,\n" +
                "\"grnd_level\": 1007,\n" +
                "\"humidity\": 56,\n" +
                "\"temp_kf\": 0\n" +
                "},\n" +
                "\"weather\": [\n" +
                "{\n" +
                "\"id\": 800,\n" +
                "\"main\": \"Clear\",\n" +
                "\"description\": \"clear sky\",\n" +
                "\"icon\": \"01n\"\n" +
                "}\n" +
                "],\n" +
                "\"clouds\": {\n" +
                "\"all\": 0\n" +
                "},\n" +
                "\"wind\": {\n" +
                "\"speed\": 2.17,\n" +
                "\"deg\": 273,\n" +
                "\"gust\": 3.09\n" +
                "},\n" +
                "\"visibility\": 10000,\n" +
                "\"pop\": 0,\n" +
                "\"sys\": {\n" +
                "\"pod\": \"n\"\n" +
                "},\n" +
                "\"dt_txt\": \"2021-11-19 15:00:00\"\n" +
                "}\n" +
                "],\n" +
                "\"city\": {\n" +
                "\"id\": 1850147,\n" +
                "\"name\": \"Tokyo\",\n" +
                "\"coord\": {\n" +
                "\"lat\": 35.6895,\n" +
                "\"lon\": 139.6917\n" +
                "},\n" +
                "\"country\": \"JP\",\n" +
                "\"population\": 8336599,\n" +
                "\"timezone\": 32400,\n" +
                "\"sunrise\": 1636924612,\n" +
                "\"sunset\": 1636961695\n" +
                "}\n" +
                "}";
        this.jsonObject = new JSONObject(exampleJsonData);
    }

    @Override
    public JSONArray getJSONArray(String key) throws JSONException {
        return this.jsonObject.getJSONArray(key);
    }

    @Override
    public int getInt(String key) throws JSONException {
        return this.jsonObject.getInt(key);
    }
}
