import javafx.fxml.FXML;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.Button;

/** Controller class for scene FXML file */
public class Controller {

    /** Array contains all buttons contains X or O */
    protected Button[][] buttonArray;

    /** Objects realizing all game  */
    protected Tictactoe game;

    /** Initialization method */
    public void initialize() {
        buttonArray = new Button[][]{{button00, button01, button02},
                {button10, button11, button12},
                {button20, button21, button22}};
    }

    /**
     * Returns the row of clicked button
     *
     * @param event event of click
     * @return the row of clicked button
     */
    protected int getEventSourceRow(ActionEvent event) {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (event.getSource().equals(buttonArray[row][column])) {
                    return row;
                }
            }
        }
        return -1;
    }

    /**
     * Returns the column of clicked button
     *
     * @param event event of click
     * @return the column of clicked button
     */
    protected int getEventSourceColumn(ActionEvent event) {
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                if (event.getSource().equals(buttonArray[row][column])) {
                    return column;
                }
            }
        }
        return -1;
    }

    /**
     * Changes text at button
     *
     * @param row the row of button
     * @param column the column of button
     */
    protected void updateButton(int row, int column) {
        buttonArray[row][column].setText(game.nextTurn(row, column));
    }

    /**
     * Method for action when user wants to put X or O by a button click
     *
     * @param event action event
     */
    @FXML
    protected void nextTurn(ActionEvent event) {
        int row = getEventSourceRow(event);
        int column = getEventSourceColumn(event);
        updateButton(row, column);
    }

    /**
     * Method for action when user clicks New Game Button
     *
     * @param event action event
     */
    @FXML
    protected void newGameButtonEvent(ActionEvent event) {
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Start new game");
        confirmation.setContentText("Click OK to start new game");
        confirmation.showAndWait();
        if (confirmation.getResult() == ButtonType.OK) {
            newGame();
        }
    }

    /** Starts a new game */
    protected void newGame() {
        game = new Tictactoe();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttonArray[i][j].setText("");
            }
        }
    }

    /** Updates the text on label showing current player */
    protected void updateLabel(String message) {
        nextTurnLabel.setText(message);
    }


    @FXML
    protected Button button00;

    @FXML
    protected Button button01;

    @FXML
    protected Button button02;

    @FXML
    protected Button button10;

    @FXML
    protected Button button11;

    @FXML
    protected Button button12;

    @FXML
    protected Button button20;

    @FXML
    protected Button button21;

    @FXML
    protected Button button22;

    @FXML
    protected Label nextTurnLabel;

}