package pl.zagora17.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import pl.zagora17.view.ViewFactory;

public class MainWindowController extends BaseController{

    public MainWindowController(ViewFactory viewFactory, String fxmlName) {
        super(viewFactory, fxmlName);
    }

    @FXML
    private Button button;

}
