package pl.zagora17.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.DataFormat;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.StringConverter;
import org.json.JSONArray;
import org.json.JSONObject;
import pl.zagora17.WeatherManager;
import pl.zagora17.controller.services.FetchWeatherService;
import pl.zagora17.controller.services.WeatherService;
import pl.zagora17.model.WeatherDay;
import pl.zagora17.model.WeatherPoint;
import pl.zagora17.view.ViewFactory;


import java.awt.*;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.text.SimpleDateFormat;
import java.text.StringCharacterIterator;
import java.util.ArrayList;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.imageio.ImageIO;
import javax.swing.*;


public class MainWindowController extends BaseController {

    public MainWindowController(WeatherManager weatherManager, ViewFactory viewFactory, String fxmlName) {
        super( weatherManager, viewFactory, fxmlName);
    }

    private AnchorPane selectedDay = null;

    @FXML
    private GridPane homeTownGridPane;

    @FXML
    void homeTownFieldKeyPressedAction(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            confirmButtonAction();
        }
    }

    @FXML
    private TextField homeCountryField;

    @FXML
    private TextField homeCityField;

    @FXML
    private Label homeTownTempLabel;

    @FXML
    private ImageView homeImageView;

    @FXML
    private Slider homeSlider;

    @FXML
    private TextField awayCountryField;

    @FXML
    private TextField awayCityField;

    @FXML
    private Slider awaySlider;

    @FXML
    void gridMouseClicked(MouseEvent event) {
        Node node = (Node) event.getTarget();
        selectDay(node);
    }

    private void selectDay(Node node) {
        if (selectedDay != null) {
            selectedDay.setStyle("-fx-border-style: none");
        }
        setDay(node);
        setUpSlider(homeSlider);
        setTempValue();
        setWeatherIcon();
    }

    private void setWeatherIcon() {
        try {
            JSONArray weather =
                    weatherManager.getSelectedWeatherPoint().getWeatherData().getJSONArray("weather");
            String iconCode = weather.getJSONObject(0).getString("icon");
            URL url = new URL("http://openweathermap.org/img/wn/"+ iconCode +"@2x.png");
            Image image = new Image(String.valueOf(url));
            homeImageView.setImage(image);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    private void setTempValue() {
        double doubleTempValue = getCurrentWeatherPoint().getWeatherData().getJSONObject("main").getDouble(
                "temp");
        int intTempValue = (int) Math.round(doubleTempValue);
        System.out.println(doubleTempValue);
        homeTownTempLabel.setText(Integer.toString(intTempValue));
    }

    private WeatherPoint getCurrentWeatherPoint() {
        return weatherManager.getSelectedWeatherPoint();
    }

    @FXML
    void confirmButtonAction() {
        String homeCityValue = homeCityField.getText().toLowerCase();
        if (homeCityValue != "") {
            WeatherService weatherService = new WeatherService(homeCityValue, "metric");
            weatherService.start();
            weatherService.setOnSucceeded(e1 -> {
                weatherManager.setWeatherDayList(new ArrayList<WeatherDay>());
                FetchWeatherService fetchWeatherService = new FetchWeatherService(weatherService.getValue(),
                        weatherManager.getWeatherDayList());
                fetchWeatherService.start();
                fetchWeatherService.setOnSucceeded(e2 -> {
                    FetchWeatherResult fetchWeatherResult = fetchWeatherService.getValue();
                    switch (fetchWeatherResult) {
                        case SUCCESS:
                        int i=0;
                        for (WeatherDay weatherDay : weatherManager.getWeatherDayList()) {
                            Node node = homeTownGridPane.getChildren().get(i++);
                            AnchorPane anchorPane = (AnchorPane) node;
                            SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
                            String dayOfWeek = sdf.format(weatherDay.getDate());
                            ((Label)anchorPane.getChildren().get(0)).setText(dayOfWeek);
                        }
                        weatherManager.setSelectedWeatherDay(weatherManager.getWeatherDayList().get(0));
                        weatherManager.setSelectedWeatherPoint(weatherManager.getSelectedWeatherDay().getWeatherPoints().get(0));
                        selectDay(homeTownGridPane.getChildren().get(0));
                        break;
                        case FAILED_BY_TOWN_NAME:
                        System.out.println("Nie znaleziono miasta");
                        break;
                        case FAILED_BY_UNEXPECTED_ERROR:
                        System.out.println(("wystąpił błąd"));
                        break;
                    }
                });
//            Locale loc = new Locale("","DE");
//            System.out.println(loc.getDisplayCountry());
            });
        } else {
            System.out.println("Nic nie wpisano");
        }
    }
    private void setDay (Node node) {
        GridPane.setColumnIndex(homeTownGridPane.getChildren().get(0), 0);
        if (node instanceof AnchorPane) {
            node.setStyle("-fx-border-color:red");
            selectedDay = (AnchorPane) node;
            int numberOfADay = GridPane.getColumnIndex(selectedDay);
            weatherManager.setSelectedWeatherDay(weatherManager.getWeatherDayList().get(numberOfADay));
            weatherManager.setSelectedWeatherPoint(weatherManager.getSelectedWeatherDay().getWeatherPoints().get(0));
        } else {
            setDay(node.getParent());
        }
    }

    private void setUpSlider(Slider slider) {
        slider.setMax(weatherManager.getSelectedWeatherDay().getWeatherPointsCount()-1);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);
        slider.setValue(0);
        slider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double aDouble) {
                int i = aDouble.intValue();
                JSONObject jsonObject =
                        weatherManager.getSelectedWeatherDay().getWeatherPoints().get(i).getWeatherData();
                String dt_txt = jsonObject.getString("dt_txt");
                Pattern pattern = Pattern.compile("[0-9]{2}:[0-9]{2}");
                Matcher matcher = pattern.matcher(dt_txt);
                if (matcher.find()) {
                    return matcher.group();
                }
                return null;
            }

            @Override
            public Double fromString(String s) {
                return null;
            }
        });

        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (!homeSlider.isValueChanging() && newValue != oldValue) {
                newValue = newValue.intValue();
                weatherManager.setSelectedWeatherPoint(weatherManager.getSelectedWeatherDay().getWeatherPoints().get((int)newValue));
                setTempValue();
                setWeatherIcon();
            }
        });
    }

}
