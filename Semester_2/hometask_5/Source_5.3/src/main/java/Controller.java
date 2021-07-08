import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


/** Controller class for JavaFX. */
public class Controller {
    private StackCalculator calculator;
    @FXML
    private TextField display;

    /** Create StackCalculator in our class. */
    public Controller() {
        calculator = new StackCalculator();
    }

    /** Recount result value after button clicked. */
    public void clickButton(ActionEvent actionEvent) {
        Button button = (Button) actionEvent.getSource();

        calculator.computing(button.getText());
        display.setText(calculator.getOutput());
    }
}