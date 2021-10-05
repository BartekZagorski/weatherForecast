package pl.zagora17.controller;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.util.StringConverter;
import org.json.JSONObject;
import pl.zagora17.WeatherManager;
import pl.zagora17.controller.services.FetchWeatherService;
import pl.zagora17.controller.services.WeatherService;
import pl.zagora17.model.WeatherDay;
import pl.zagora17.model.WeatherPoint;
import pl.zagora17.view.ViewFactory;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class WeatherController extends BaseController implements Initializable {

    public static final DateTimeFormatter LONG_DAY_NAME = DateTimeFormatter.ofPattern("EEEE");
    public static final DateTimeFormatter SHORT_DAY_NAME = DateTimeFormatter.ofPattern("EEE");
    private int homeSelectedDayNumber;
    private final String title;
    private final WeatherManager weatherManager = new WeatherManager();
    private final IntegerProperty fontSize = new SimpleIntegerProperty();
    private final IntegerProperty anchorWidth = new SimpleIntegerProperty();
    private final IntegerProperty gridControlWidth = new SimpleIntegerProperty();

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private Label titleLabel;

    @FXML
    private GridPane gridPane;

    @FXML
    private TextField countryField;
    
    @FXML
    private Button confirmButton;

    @FXML
    private TextField cityField;

    @FXML
    private Label countryAndTownLabel;

    @FXML
    private Label dayAndHourLabel;

    @FXML
    private HBox leftHBox;

    @FXML
    private HBox rightHBox;

    @FXML
    private Label tempLabel;

    @FXML
    private ImageView imageView;

    @FXML
    private Label precipitationLabel;

    @FXML
    private Label pressureLabel;

    @FXML
    private Label windLabel;

    @FXML
    private Label cloudyLabel;

    @FXML
    private Slider slider;

    @FXML
    private Label infoLabel;

    @FXML
    void confirmButtonAction() {
        confirmButton.setDisable(true);
        displayWeather(cityField, infoLabel, weatherManager, gridPane);
    }

    @FXML
    void townFieldKeyPressedAction(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER && !confirmButton.isDisabled()) {
            confirmButtonAction();
        }
    }

    public WeatherController(WeatherService weatherService, ViewFactory viewFactory,
                             String fxmlName, String title) {
        super(weatherService, viewFactory, fxmlName);
        this.title = title;
    }

    private void displaySelectedPoint() {
        setCountryAndTownLabel();
        setDayAndHourLabel();
        setTempValue();
        setWeatherIcon();
        setPrecipitationProbability();
        setPressureValue();
        setWindSpeed();
        setCloudyValue();
    }

    private void setCloudyValue() {
        int cloudyValue = getCurrentWeatherPoint().getWeatherData().getJSONObject("clouds").getInt("all");
        cloudyLabel.setText("zachmurzenie: " + cloudyValue + "%");
    }

    private void setWindSpeed() {
        double windSpeed = getCurrentWeatherPoint().getWeatherData().getJSONObject("wind").getDouble("speed");
        windLabel.setText("wiatr: " + windSpeed + " m/s");
    }

    private void setPressureValue() {
        int pressureValue = getCurrentWeatherPoint().getWeatherData().getJSONObject("main").getInt("pressure");
        pressureLabel.setText("ciśnienie: " + pressureValue + " hPa");
    }

    private void setPrecipitationProbability() {
        double pop = getCurrentWeatherPoint().getWeatherData().getDouble("pop");
        precipitationLabel.setText("opady: " + (int) (pop * 100) + "%");
    }

    private void setDayAndHourLabel() {
        String dayName = SHORT_DAY_NAME.format(weatherManager.getSelectedWeatherDay().getDate());
        String hour = weatherManager.getSelectedWeatherPoint().getHour();
        dayAndHourLabel.setText(dayName + " " + hour);
    }

    private void setCountryAndTownLabel() {
        String countryCode = weatherManager.getCountryCode();
        Locale loc = new Locale("", countryCode);
        countryAndTownLabel.setText(loc.getDisplayCountry() + ", " + weatherManager.getCityName());
    }

    private void setWeatherIcon() {
        Image image = getCurrentWeatherPoint().getWeatherIcon();
        imageView.setImage(image);
    }

    private void setTempValue() {
        int intTempValue = getCurrentWeatherPoint().getTempValue();
        tempLabel.setText(intTempValue + "\u00B0C");
    }

    private WeatherPoint getCurrentWeatherPoint() {
        return weatherManager.getSelectedWeatherPoint();
    }

    private void displayWeather(TextField cityField, Label infoLabel, WeatherManager weatherManager, GridPane gridPane) {
        String cityValue = cityField.getText().toLowerCase();
        changeWeatherDataVisible(false);
        infoLabel.setText("Wczytuję...");
        infoLabel.setVisible(true);

        if (!cityValue.equals("")) {
            weatherService.setCityName(cityValue);
            weatherService.restart();
            weatherService.setOnSucceeded(e1 -> {
                weatherManager.setWeatherDayList(new ArrayList<>());
                FetchWeatherService fetchWeatherService = weatherService.getFetchWeatherService();
                JSONObject weatherServiceResult = weatherService.getValue();
                fetchWeatherService.setWeatherJSON(weatherServiceResult);
                fetchWeatherService.setWeatherDayList(weatherManager.getWeatherDayList());
                fetchWeatherService.restart();
                fetchWeatherService.setOnSucceeded(e2 -> {
                    FetchWeatherResult fetchWeatherResult = fetchWeatherService.getValue();
                    switch (fetchWeatherResult) {
                        case SUCCESS:
                            processResult(infoLabel, weatherManager, gridPane, weatherServiceResult);
                            break;
                        case FAILED_BY_TOWN_NAME:
                            infoLabel.setText("Nie znaleziono miasta!");
                            break;
                        case FAILED_BY_UNEXPECTED_ERROR:
                            infoLabel.setText("Wystąpił błąd!");
                            break;
                    }
                });
                fetchWeatherService.setOnFailed(event -> {
                    infoLabel.setText("Brak połączenia z internetem!");
                });
                confirmButton.setDisable(false);
            });
        } else {
            infoLabel.setText("Nic nie wpisano!");
        }

    }

    private void processResult(Label infoLabel, WeatherManager weatherManager, GridPane gridPane,
                           JSONObject weatherServiceResult) {
        JSONObject cityData = weatherServiceResult.getJSONObject("city");
        weatherManager.setCityName(cityData.getString("name"));
        weatherManager.setCountryCode(cityData.getString("country"));
        int i = 0;
        for (WeatherDay weatherDay : weatherManager.getWeatherDayList()) {
            Node node = gridPane.getChildren().get(i++);
            AnchorPane anchorPane = (AnchorPane) node;
            String dayOfWeek = LONG_DAY_NAME.format(weatherDay.getDate());
            ((Label) anchorPane.getChildren().get(0)).setText(dayOfWeek);
            ((ImageView) anchorPane.getChildren().get(1)).setImage(weatherDay.getMiddlePointWeatherIcon());
            ((Label) anchorPane.getChildren().get(2)).setText(weatherDay.getAverageTemperature() + "\u00B0C");
        }
        homeSelectedDayNumber = 0;
        selectDay();
        prepareSlider();
        infoLabel.setVisible(false);
        changeWeatherDataVisible(true);
    }

    private void prepareSlider() {
        if (slider.getMajorTickUnit() != 1) {
            setUpSlider(slider);
        } else {
            updateSlider(slider);
        }
    }

    private void setUpSlider(Slider slider) {
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);
        updateSlider(slider);
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (!slider.isValueChanging() && !newValue.equals(oldValue)) {
                newValue = newValue.intValue();
                weatherManager.setSelectedWeatherPoint(weatherManager.getChosenWeatherPoint((int) newValue));
                displaySelectedPoint();
            }
        });
    }

    private void updateSlider(Slider slider) {
        slider.setMax(weatherManager.getSelectedWeatherDay().getWeatherPointsCount()-1);
        slider.setValue(0);
        slider.setLabelFormatter(null);
        slider.setLabelFormatter(new StringConverter<>() {
            @Override
            public String toString(Double d) {
                return weatherManager.getChosenWeatherPoint(d.intValue()).getHour();
            }
            @Override
            public Double fromString(String s) {
                return null;
            }
        });
    }

    private void changeWeatherDataVisible(boolean visibleStatus) {
        countryAndTownLabel.setVisible(visibleStatus);
        dayAndHourLabel.setVisible(visibleStatus);
        leftHBox.setVisible(visibleStatus);
        rightHBox.setVisible(visibleStatus);
        slider.setVisible(visibleStatus);
        gridPane.setVisible(visibleStatus);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initiateGridNodeCoords();
        titleLabel.setText(title);
        fontSize.bind(tempLabel.widthProperty().divide(2.3));
        anchorWidth.bind(gridPane.widthProperty().divide(2));
        gridControlWidth.bind(gridPane.widthProperty().divide(6).subtract(10));
        leftHBox.prefWidthProperty().bind(anchorWidth);
        rightHBox.prefWidthProperty().bind(anchorWidth);
        tempLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize));
        tempLabel.prefWidthProperty().bind(anchorWidth.divide(3).multiply(2));
        imageView.fitWidthProperty().bind(anchorWidth.divide(3));
        imageView.fitHeightProperty().bind(anchorWidth.divide(3));
        for (Node node : gridPane.getChildren()) {
            AnchorPane anchorPane = (AnchorPane) node;
            anchorPane.prefWidthProperty().bind(gridControlWidth);
            for (Node node1 : anchorPane.getChildren()) {
                if (node1 instanceof Label) {
                    Label label = (Label) node1;
                    label.prefWidthProperty().bind(gridControlWidth);
                } else {
                    ImageView imageView = (ImageView) node1;
                    imageView.translateXProperty().bind(gridControlWidth.subtract(imageView.getFitWidth()).divide(2));
                }
            }
        }
    }

    private void initiateGridNodeCoords() {
        int i = 0;
        for (Node node : gridPane.getChildren()) {
            node.setOnMouseClicked(mouseEvent -> {
                homeSelectedDayNumber = GridPane.getColumnIndex(node);
                selectDay();
                updateSlider(slider);
            });
            GridPane.setColumnIndex(node, i++);
        }
    }

    private void selectDay() {
        weatherManager.selectDay(homeSelectedDayNumber);
        markSelectedDay();
        displaySelectedPoint();
    }

    private void markSelectedDay() {
        for (Node node : gridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == homeSelectedDayNumber) {
                node.setStyle("-fx-background-color: #9babdd");
            } else {
                node.setStyle("");
            }
        }
    }
}

