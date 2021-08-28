package pl.zagora17.controller;

import javafx.beans.binding.Bindings;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.event.Event;
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
import javafx.scene.input.MouseEvent;
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
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;
import java.util.ResourceBundle;

public class MainWindowController extends BaseController implements Initializable {

    public MainWindowController(WeatherManager homeWeatherManager,
                                WeatherManager awayWeatherManager, ViewFactory viewFactory, String fxmlName) {
        super( homeWeatherManager, awayWeatherManager, viewFactory, fxmlName);
    }

    private AnchorPane homeSelectedDay = null;
    private AnchorPane awaySelectedDay = null;
    private IntegerProperty fontSize = new SimpleIntegerProperty();
    private IntegerProperty anchorWidth = new SimpleIntegerProperty();
    private IntegerProperty gridControlWidth = new SimpleIntegerProperty();

    @FXML
    private GridPane homeTownGridPane;

    @FXML
    void townFieldKeyPressedAction(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            confirmButtonAction(event);
        }
    }

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
    void gridMouseClicked(MouseEvent event) {
        Node node = (Node) event.getTarget();
        if (event.getSource().equals(homeTownGridPane))
        {
            if (homeWeatherManager.getWeatherDayList().size() == 5) {
                AnchorPane anchorPane = findAnchorPaneAncestor(node);
                if (GridPane.getColumnIndex(anchorPane) == 5) {
                    return;
                }
            }
            selectDay(node, homeWeatherManager, homeSelectedDay);
        } else {
            if (awayWeatherManager.getWeatherDayList().size() == 5) {
                AnchorPane anchorPane = findAnchorPaneAncestor(node);
                if (GridPane.getColumnIndex(anchorPane) == 5) {
                    return;
                }
            }
            selectDay(node, awayWeatherManager, awaySelectedDay);
        }
    }

    private void selectDay(Node node, WeatherManager weatherManager, AnchorPane selectedDay) {
        if (selectedDay != null) {
            selectedDay.setStyle("");
        }
        if (weatherManager.equals(homeWeatherManager)) {
            setDay(node, weatherManager, homeTownGridPane);
            setUpSlider(homeSlider);
            displaySelectedPoint("home");
        } else {
            setDay(node, weatherManager, awayTownGridPane);
            setUpSlider(awaySlider);
            displaySelectedPoint("away");
        }
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
        if (place == "home") {
            label = homeTownCloudyLabel;
        }   else label = awayTownCloudyLabel;
        label.setText("zachmurzenie: " + cloudyValue + "%");
    }

    private void setWindSpeed(String place) {
        Double windSpeed =
                getCurrentWeatherPoint(place).getWeatherData().getJSONObject("wind").getDouble(
                "speed");
        Label label;
        if (place == "home") {
            label = homeTownWindLabel;
        }   else label = awayTownWindLabel;
        label.setText("wiatr: " + String.valueOf(windSpeed) + " m/s");
    }

    private void setPressureValue(String place) {
        int pressureValue = getCurrentWeatherPoint(place).getWeatherData().getJSONObject("main").getInt(
                "pressure");
        Label label;
        if(place == "home") {
            label = homeTownPressureLabel;
        }   else label = awayTownPressureLabel;
        label.setText("ciśnienie: " + Integer.toString(pressureValue) + " hPa");
    }

    private void setPrecipitationProbability(String place) {

        double pop = getCurrentWeatherPoint(place).getWeatherData().getDouble("pop");
        Label label;
        if (place == "home") {
            label = homePrecipitationLabel;
        }   else label = awayPrecipitationLabel;
        label.setText("opady: " + String.valueOf((int)(pop*100)) + "%");
    }

    private void setDayAndHourLabel(String place) {
        SimpleDateFormat sdf = new SimpleDateFormat("EEE");
        WeatherManager weatherManager;
        Label label;
        if (place == "home") {
            weatherManager = homeWeatherManager;
            label = homeDayAndHourLabel;
        } else {
            weatherManager = awayWeatherManager;
            label = awayDayAndHourLabel;
        }
        String dayName = sdf.format(weatherManager.getSelectedWeatherDay().getDate());
        String hour = weatherManager.getSelectedWeatherPoint().getHour();
        label.setText(dayName + " " + hour);
    }

    private void setCountryAndTownLabel(String place) {
        if (place == "home") {
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
        if (place == "home") {
            imageView = homeImageView;
        }   else imageView = awayImageView;
        imageView.setImage(image);
    }

    private void setTempValue(String place) {
        int intTempValue = getCurrentWeatherPoint(place).getTempValue();
        Label label;
        if (place == "home") {
            label = homeTownTempLabel;
        }   else label = awayTownTempLabel;
        label.setText(Integer.toString(intTempValue) + "\u00B0C");
    }

    private WeatherPoint getCurrentWeatherPoint(String place) {
        if (place == "home") {
            return homeWeatherManager.getSelectedWeatherPoint();
        } else return awayWeatherManager.getSelectedWeatherPoint();

    }

    @FXML
    void confirmButtonAction(Event event) {
        if (!event.getTarget().equals(homeCityField) && !event.getTarget().equals(homeConfirmButton)) {
            displayWeather(awayCityField, awayInfoLabel, awayWeatherManager, awayTownGridPane, awaySlider);
        } else {
            displayWeather(homeCityField, homeInfoLabel, homeWeatherManager, homeTownGridPane, homeSlider);
        }
    }

    private void displayWeather(TextField cityField, Label infoLabel, WeatherManager weatherManager,
                                GridPane gridPane, Slider slider  ) {
        String cityValue = cityField.getText().toLowerCase();
        changeWeatherDataVisible(weatherManager, false);
        infoLabel.setText("Wczytuję...");
        infoLabel.setVisible(true);

        if (cityValue != "") {
            WeatherService weatherService = new WeatherService(cityValue, "metric");
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
                            JSONObject cityData = weatherService.getValue().getJSONObject("city");
                            weatherManager.setCityName(cityData.getString("name"));
                            weatherManager.setCountryCode(cityData.getString("country"));
                            int i = 0;
                            for (WeatherDay weatherDay : weatherManager.getWeatherDayList()) {
                                Node node = gridPane.getChildren().get(i++);
                                AnchorPane anchorPane = (AnchorPane) node;
                                SimpleDateFormat sdf = new SimpleDateFormat("EEEE");
                                String dayOfWeek = sdf.format(weatherDay.getDate());
                                ((Label) anchorPane.getChildren().get(0)).setText(dayOfWeek);
                                ((ImageView) anchorPane.getChildren().get(1)).setImage(weatherDay.getMiddlePointWeatherIcon());
                                ((Label) anchorPane.getChildren().get(2)).setText(String.valueOf(weatherDay.getAverageTemperature()) + "\u00B0C");
                            }
                            weatherManager.setSelectedWeatherDay(weatherManager.getWeatherDayList().get(0));
                            weatherManager.setSelectedWeatherPoint(weatherManager.getSelectedWeatherDay().getWeatherPoints().get(0));
                            if (weatherManager.equals(homeWeatherManager)) {
                                selectDay(gridPane.getChildren().get(0), weatherManager, homeSelectedDay);
                            }   else selectDay(gridPane.getChildren().get(0), weatherManager, awaySelectedDay);

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
            });
        } else {
            infoLabel.setText("Nic nie wpisano!");
        }
    }

    private void setDay (Node node, WeatherManager weatherManager, GridPane gridPane) {
        GridPane.setColumnIndex(gridPane.getChildren().get(0), 0);
        AnchorPane anchorPane = findAnchorPaneAncestor(node);

            anchorPane.setStyle("-fx-background-color:#9babdd");
        int numberOfADay = 0;
        if (weatherManager.equals(homeWeatherManager)) {
                homeSelectedDay = anchorPane;
                numberOfADay = GridPane.getColumnIndex(homeSelectedDay);
            }   else {
                awaySelectedDay = anchorPane;
                numberOfADay = GridPane.getColumnIndex(awaySelectedDay);
            }
            weatherManager.setSelectedWeatherDay(weatherManager.getWeatherDayList().get(numberOfADay));
            weatherManager.setSelectedWeatherPoint(weatherManager.getSelectedWeatherDay().getWeatherPoints().get(0));

    }

    private AnchorPane findAnchorPaneAncestor(Node node) {
        if (node instanceof AnchorPane) {
            return (AnchorPane) node;
        } else {
            return findAnchorPaneAncestor(node.getParent());
        }
    }

    private void setUpSlider(Slider slider) {
        if (slider.equals(homeSlider)) {
            slider.setMax(homeWeatherManager.getSelectedWeatherDay().getWeatherPointsCount()-1);
        } else slider.setMax(awayWeatherManager.getSelectedWeatherDay().getWeatherPointsCount()-1);
        slider.setMajorTickUnit(1);
        slider.setMinorTickCount(0);
        slider.setValue(0);
        slider.setLabelFormatter(null);
        slider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double aDouble) {
                int i = aDouble.intValue();
                WeatherManager weatherManager;
                if (slider.equals(homeSlider)) {
                    weatherManager = homeWeatherManager;
                }   else weatherManager = awayWeatherManager;
                String hour = weatherManager.getSelectedWeatherDay().getWeatherPoints().get(i).getHour();
                return hour;
            }

            @Override
            public Double fromString(String s) {
                return null;
            }
        });

        slider.valueProperty().addListener((observable, oldValue, newValue) -> {
            if (!slider.isValueChanging() && newValue != oldValue) {
                newValue = newValue.intValue();
                WeatherManager weatherManager;
                if (slider.equals(homeSlider)) {
                    weatherManager = homeWeatherManager;
                }   else weatherManager = awayWeatherManager;
                weatherManager.setSelectedWeatherPoint(weatherManager.getSelectedWeatherDay().getWeatherPoints().get((int)newValue));
                if (weatherManager.equals(homeWeatherManager)) {
                    displaySelectedPoint("home");
                } else displaySelectedPoint("away");
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
}
