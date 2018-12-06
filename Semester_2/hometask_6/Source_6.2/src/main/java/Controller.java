import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.text.Text;

/** Controller class for UI FXML file */
public class Controller {
    @FXML
    public Text headText;

    @FXML
    public Button button1;

    @FXML
    public Button button2;

    @FXML
    public Button button3;

    @FXML
    public Button button4;

    @FXML
    public Button button5;

    @FXML
    public Button button6;

    @FXML
    public Button button7;

    @FXML
    public Button button8;

    @FXML
    public Button button9;

    public Button NewGameButton;

    TicTac game;

    /** Initialization method */
    @FXML
    public void initialize(){
        game = new TicTac();
    }

    /**
     * Method for action when user wants to put X or O by a button click
     *
     * @param actionEvent
     */
    public void turn(ActionEvent actionEvent){
        Button pressedButton = (Button)actionEvent.getTarget();
        if (!game.isGameOn()){
            headText.setText("Congrats");
            return;
        }
        if (!pressedButton.getText().equals(""))
            return;

        pressedButton.setText(game.getTurn());

        String number = "";
        number += pressedButton.getId().charAt(pressedButton.getId().length() - 1);
        System.out.print(number);
        game.buttonPressed(number);

        headText.setText(game.getTurn()+" turn");
    }

    /**
     * Method for starting new game and clearing buttons
     * @param actionEvent
     */
    public void StartNewGame(ActionEvent actionEvent) {
        initialize();
        headText.setText("X turn");

        Button[] buttons = new Button[]{button1, button2, button3, button4, button5, button6, button7, button8, button9};
        for (int i = 0; i < 9; ++i) {
            buttons[i].setText("");
        }
    }
}
