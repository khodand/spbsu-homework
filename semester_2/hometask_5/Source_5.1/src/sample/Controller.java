package sample;

import javafx.fxml.FXML;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Slider;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    private ProgressBar progressBar1;
    @FXML
    private Slider slider1;
    @FXML
    private Text text;


    // Actions when slider's toggle drags
    public void dragAction() {
        slider1.valueProperty().addListener((observable, oldValue, newValue) -> progressBar1.progressProperty().setValue((double)newValue / 100));
        slider1.valueProperty().addListener((observable, oldValue, newValue) -> text.textProperty().setValue(String.valueOf(newValue)));
    }
}
