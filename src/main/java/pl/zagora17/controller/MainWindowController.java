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
import pl.zagora17.controller.services.WeatherService;
import pl.zagora17.model.WeatherDay;
import pl.zagora17.model.WeatherPoint;
import pl.zagora17.view.ViewFactory;
import java.net.URL;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainWindowController extends BaseController implements Initializable {

    public static final DateTimeFormatter LONG_DAY_NAME = DateTimeFormatter.ofPattern("EEEE");
    public static final DateTimeFormatter SHORT_DAY_NAME = DateTimeFormatter.ofPattern("EEE");
    private int homeSelectedDayNumber;
    private final IntegerProperty fontSize = new SimpleIntegerProperty();
    private final IntegerProperty anchorWidth = new SimpleIntegerProperty();
    private final IntegerProperty gridControlWidth = new SimpleIntegerProperty();

    @FXML
    private GridPane homeTownGridPane;

    @FXML
    private TextField homeCountryField;
    
    @FXML
    private Button homeConfirmButton;

    @FXML
    private TextField homeCityField;

    @FXML
    private Label homeCountryAndTownLabel;

    @FXML
    private Label homeDayAndHourLabel;

    @FXML
    private HBox homeTownLeftHBox;

    @FXML
    private HBox homeTownRightHBox;

    @FXML
    private Label homeTownTempLabel;

    @FXML
    private ImageView homeImageView;

    @FXML
    private Label homePrecipitationLabel;

    @FXML
    private Label homeTownPressureLabel;

    @FXML
    private Label homeTownWindLabel;

    @FXML
    private Label homeTownCloudyLabel;

    @FXML
    private Slider homeSlider;

    @FXML
    private TextField awayCityField;

    @FXML
    private Label awayCountryAndTownLabel;

    @FXML
    private Label awayDayAndHourLabel;

    @FXML
    private HBox awayTownLeftHBox;

    @FXML
    private ImageView awayImageView;

    @FXML
    private Label awayTownTempLabel;

    @FXML
    private HBox awayTownRightHBox;

    @FXML
    private Label awayPrecipitationLabel;

    @FXML
    private Label awayTownPressureLabel;

    @FXML
    private Label awayTownWindLabel;

    @FXML
    private Label awayTownCloudyLabel;

    @FXML
    private Slider awaySlider;

    @FXML
    private GridPane awayTownGridPane;

    @FXML
    private Label awayInfoLabel;

    @FXML
    private Label homeInfoLabel;

    @FXML
    void confirmButtonAction() {
        homeConfirmButton.setDisable(true);
        displayWeather(homeCityField, homeInfoLabel, homeWeatherManager, homeTownGridPane);
    }

    @FXML
    void townFieldKeyPressedAction(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER && !homeConfirmButton.isDisabled()) {
            confirmButtonAction();
        }
    }

    public MainWindowController(WeatherManager homeWeatherManager,
                                WeatherManager awayWeatherManager, WeatherService weatherService,
                                ViewFactory viewFactory,
                                String fxmlName) {
        super( homeWeatherManager, awayWeatherManager, weatherService, viewFactory, fxmlName);
    }

    private void displaySelectedPoint(String place) {
        setCountryAndTownLabel(place);
        setDayAndHourLabel(place);
        setTempValue(place);
        setWeatherIcon(place);
        setPrecipitationProbability(place);
        setPressureValue(place);
        setWindSpeed(place);
        setCloudyValue(place);
    }

    private void setCloudyValue(String place) {
        int cloudyValue = getCurrentWeatherPoint(place).getWeatherData().getJSONObject("clouds").getInt(
                "all");
        Label label;
        if (place.equals("home")) {
            label = homeTownCloudyLabel;
        }   else label = awayTownCloudyLabel;
        label.setText("zachmurzenie: " + cloudyValue + "%");
    }

    private void setWindSpeed(String place) {
        double windSpeed =
                getCurrentWeatherPoint(place).getWeatherData().getJSONObject("wind").getDouble(
                "speed");
        Label label;
        if (place.equals("home")) {
            label = homeTownWindLabel;
        }   else label = awayTownWindLabel;
        label.setText("wiatr: " + windSpeed + " m/s");
    }

    private void setPressureValue(String place) {
        int pressureValue = getCurrentWeatherPoint(place).getWeatherData().getJSONObject("main").getInt(
                "pressure");
        Label label;
        if(place.equals("home")) {
            label = homeTownPressureLabel;
        }   else label = awayTownPressureLabel;
        label.setText("ciśnienie: " + pressureValue + " hPa");
    }

    private void setPrecipitationProbability(String place) {

        double pop = getCurrentWeatherPoint(place).getWeatherData().getDouble("pop");
        Label label;
        if (place.equals("home")) {
            label = homePrecipitationLabel;
        }   else label = awayPrecipitationLabel;
        label.setText("opady: " + (int) (pop * 100) + "%");
    }

    private void setDayAndHourLabel(String place) {
        WeatherManager weatherManager;
        Label label;
        if (place.equals("home")) {
            weatherManager = homeWeatherManager;
            label = homeDayAndHourLabel;
        } else {
            weatherManager = awayWeatherManager;
            label = awayDayAndHourLabel;
        }
        String dayName = SHORT_DAY_NAME.format(weatherManager.getSelectedWeatherDay().getDate());
        String hour = weatherManager.getSelectedWeatherPoint().getHour();
        label.setText(dayName + " " + hour);
    }

    private void setCountryAndTownLabel(String place) {
        if (place.equals("home")) {
            String countryCode = homeWeatherManager.getCountryCode();
            Locale loc = new Locale("", countryCode);
            homeCountryAndTownLabel.setText(loc.getDisplayCountry() + ", " + homeWeatherManager.getCityName());
        } else {
            String countryCode = awayWeatherManager.getCountryCode();
            Locale loc = new Locale("", countryCode);
            awayCountryAndTownLabel.setText(loc.getDisplayCountry() + ", " + awayWeatherManager.getCityName());
        }
    }

    private void setWeatherIcon(String place) {
        Image image = getCurrentWeatherPoint(place).getWeatherIcon();
        ImageView imageView;
        if (place.equals("home")) {
            imageView = homeImageView;
        }   else imageView = awayImageView;
        imageView.setImage(image);
    }

    private void setTempValue(String place) {
        int intTempValue = getCurrentWeatherPoint(place).getTempValue();
        Label label;
        if (place.equals("home")) {
            label = homeTownTempLabel;
        }   else label = awayTownTempLabel;
        label.setText(intTempValue + "\u00B0C");
    }

    private WeatherPoint getCurrentWeatherPoint(String place) {
        if (place.equals("home")) {
            return homeWeatherManager.getSelectedWeatherPoint();
        } else return awayWeatherManager.getSelectedWeatherPoint();

    }

    private void displayWeather(TextField cityField, Label infoLabel, WeatherManager weatherManager,
                                GridPane gridPane) {
        String cityValue = cityField.getText().toLowerCase();
        changeWeatherDataVisible(weatherManager, false);
        infoLabel.setText("Wczytuję...");
        infoLabel.setVisible(true);

        if (!cityValue.equals("")) {
            weatherService.setCityName(cityValue);
            weatherService.restart();
            weatherService.setOnSucceeded(e1 -> {
                weatherManager.setWeatherDayList(new ArrayList<>());

                weatherService.getFetchWeatherService().setWeatherJSON(weatherService.getValue());
                weatherService.getFetchWeatherService().setWeatherDayList(weatherManager.getWeatherDayList());
                weatherService.getFetchWeatherService().restart();
                weatherService.getFetchWeatherService().setOnSucceeded(e2 -> {
                    FetchWeatherResult fetchWeatherResult = weatherService.getFetchWeatherService().getValue();
                    switch (fetchWeatherResult) {
                        case SUCCESS:
                            JSONObject cityData = weatherService.getValue().getJSONObject("city");
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
                            if (homeSlider.getMajorTickUnit() != 1) {
                                setUpSlider(homeSlider);
                            } else {
                                updateSlider(homeSlider);
                            }
                            infoLabel.setVisible(false);
                            changeWeatherDataVisible(weatherManager, true);
                            break;
                        case FAILED_BY_TOWN_NAME:
                            infoLabel.setText("Nie znaleziono miasta!");
                            break;
                        case FAILED_BY_UNEXPECTED_ERROR:
                            infoLabel.setText("Wystąpił błąd!");
                            break;
                    }
                });
                homeConfirmButton.setDisable(false);
            });
        } else {
            infoLabel.setText("Nic nie wpisano!");
        }

    }

    private void setUpSlider(Slider slider) {
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);
        updateSlider(slider);
        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (!slider.isValueChanging() && !newValue.equals(oldValue)) {
                newValue = newValue.intValue();
                homeWeatherManager.setSelectedWeatherPoint(homeWeatherManager.getChosenWeatherPoint((int) newValue));
                displaySelectedPoint("home");
            }
        });
    }

    private void updateSlider(Slider slider) {
        slider.setMax(homeWeatherManager.getSelectedWeatherDay().getWeatherPointsCount()-1);
        slider.setValue(0);
        slider.setLabelFormatter(null);
        slider.setLabelFormatter(new StringConverter<>() {
            @Override
            public String toString(Double d) {
                return homeWeatherManager.getChosenWeatherPoint(d.intValue()).getHour();
            }
            @Override
            public Double fromString(String s) {
                return null;
            }
        });
    }

    private void changeWeatherDataVisible(WeatherManager weatherManager, boolean visibleStatus) {
        if (weatherManager.equals(homeWeatherManager)) {
            homeCountryAndTownLabel.setVisible(visibleStatus);
            homeDayAndHourLabel.setVisible(visibleStatus);
            homeTownLeftHBox.setVisible(visibleStatus);
            homeTownRightHBox.setVisible(visibleStatus);
            homeSlider.setVisible(visibleStatus);
            homeTownGridPane.setVisible(visibleStatus);
        } else {
            awayCountryAndTownLabel.setVisible(visibleStatus);
            awayDayAndHourLabel.setVisible(visibleStatus);
            awayTownLeftHBox.setVisible(visibleStatus);
            awayTownRightHBox.setVisible(visibleStatus);
            awaySlider.setVisible(visibleStatus);
            awayTownGridPane.setVisible(visibleStatus);
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        initiateGridNodeCoords();
        fontSize.bind(homeTownTempLabel.widthProperty().divide(2.3));
        anchorWidth.bind(homeTownGridPane.widthProperty().divide(2));
        gridControlWidth.bind(homeTownGridPane.widthProperty().divide(6).subtract(10));
        homeTownLeftHBox.prefWidthProperty().bind(anchorWidth);
        awayTownLeftHBox.prefWidthProperty().bind(anchorWidth);
        homeTownRightHBox.prefWidthProperty().bind(anchorWidth);
        awayTownRightHBox.prefWidthProperty().bind(anchorWidth);
        homeTownTempLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize));
        homeTownTempLabel.prefWidthProperty().bind(anchorWidth.divide(3).multiply(2));
        awayTownTempLabel.styleProperty().bind(Bindings.concat("-fx-font-size: ", fontSize));
        awayTownTempLabel.prefWidthProperty().bind(anchorWidth.divide(3).multiply(2));
        homeImageView.fitWidthProperty().bind(anchorWidth.divide(3));
        homeImageView.fitHeightProperty().bind(anchorWidth.divide(3));
        awayImageView.fitWidthProperty().bind(anchorWidth.divide(3));
        awayImageView.fitHeightProperty().bind(anchorWidth.divide(3));
        for (Node node : homeTownGridPane.getChildren()) {
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
        for (Node node : awayTownGridPane.getChildren()) {
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
        int j = 0;
        for (Node node : homeTownGridPane.getChildren()) {
            node.setOnMouseClicked(mouseEvent -> {
                homeSelectedDayNumber = GridPane.getColumnIndex(node);
                selectDay();
                updateSlider(homeSlider);
            });
            GridPane.setColumnIndex(node, i++);
        }
        for (Node node : awayTownGridPane.getChildren()) {
            GridPane.setColumnIndex(node, j++);
        }
    }

    private void selectDay() {
        homeWeatherManager.selectDay(homeSelectedDayNumber);
        markSelectedDay();
        displaySelectedPoint("home");
    }

    private void markSelectedDay() {
        for (Node node : homeTownGridPane.getChildren()) {
            if (GridPane.getColumnIndex(node) == homeSelectedDayNumber) {
                node.setStyle("-fx-background-color: #9babdd");
            } else {
                node.setStyle("");
            }
        }
    }


}

