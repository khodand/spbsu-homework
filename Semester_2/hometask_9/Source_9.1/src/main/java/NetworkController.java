import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

/** Controller class for Scene FXML file */
public class NetworkController extends Controller {

    /** Enum realizing status of current app */
    public enum Status {MY_TURN, WAITING_FOR_TURN, EXITING}

    /** Status of current app */
    public Status status;

    private Tictactoe.Player player;
    private ObjectOutputStream outputStream;
    private ObjectInputStream inputStream;

    /**
     * Sets up controller options before the app showing
     *
     * @param player the player of this app
     * @param socket socket data will be transferred
     * @throws IOException if something wrong with socket
     */
    public void setOptions(Tictactoe.Player player, Socket socket) throws IOException {
        this.player = player;
        outputStream = new ObjectOutputStream(socket.getOutputStream());
        inputStream = new ObjectInputStream(socket.getInputStream());
        newGame();
    }

    /** Action when current player closes the game */
    public void exitAction() {
        TTTEvent exitEvent = new TTTEvent(new TTTEvent.ExitGameClickAction(), player, TTTEvent.ActionType.EXIT_GAME);
        sendEvent(exitEvent);

    }

    /** Evaluates when game is over, for instance, when somebody wins or it is draw */
    protected void endGame() {
        Alert finishMessage = new Alert(Alert.AlertType.INFORMATION);
        finishMessage.setTitle("Game over");
        if (game.hasWinner()) {
            finishMessage.setContentText("Player " + (game.getPlayer() == Tictactoe.Player.X ? "O" : "X") + " wins!");
        } else {
            finishMessage.setContentText("Draw!");
        }

        finishMessage.showAndWait();
        newGame();
    }

    /**
     * Changes controls availability
     *
     * @param isDisabled <tt>true</tt> to disable controls, <tt>false</tt> to make them available
     */
    public void setSnooze(boolean isDisabled) {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttonArray[i][j].setDisable(isDisabled);
            }
        }
        newGameButton.setDisable(isDisabled);
    }

    /**
     * Evaluates TTTEvent from other player
     *
     * @param tttEvent received from other player
     */
    public void evaluate(TTTEvent tttEvent) {
        switch (tttEvent.getActionType()) {
            case NEW_GAME:
                Alert finishMessage = new Alert(Alert.AlertType.INFORMATION);
                finishMessage.setTitle("Game over");
                finishMessage.setContentText("Your opponent started new game");
                finishMessage.showAndWait();
                newGame();
                break;
            case CLICK_ON_FIELD:
                setSnooze(false);
                TTTEvent.ClickOnFieldAction clickOnFieldAction = (TTTEvent.ClickOnFieldAction) tttEvent.getTttEventAction();
                status = Status.MY_TURN;
                updateLabel("Your turn");
                updateButton(clickOnFieldAction.getRow(), clickOnFieldAction.getColumn());
                if (game.isFinished()) {
                    endGame();
                }
                break;
            case EXIT_GAME:
                Alert exitMessage = new Alert(Alert.AlertType.INFORMATION);
                exitMessage.setTitle("Game over");
                exitMessage.setContentText("Your opponent left the game.\nAfter clicking OK it will be closed");
                exitMessage.showAndWait();
                status = Status.EXITING;
                Platform.exit();
                break;
        }

    }


    /** Action when new game button is clicked */
    @FXML
    protected void newGameButtonEvent(ActionEvent event) {
        Alert confirmation = new Alert(Alert.AlertType.CONFIRMATION);
        confirmation.setTitle("Start new game");
        confirmation.setContentText("Click OK to start new game");
        confirmation.showAndWait();
        if (confirmation.getResult() == ButtonType.OK) {
            TTTEvent tttEvent = new TTTEvent(new TTTEvent.NewGameClickAction(), player, TTTEvent.ActionType.NEW_GAME);
            setSnooze(true);
            sendEvent(tttEvent);
            newGame();
        }
    }

    /** Starts a new game */
    @Override
    protected void newGame() {
        super.newGame();
        if (player == Tictactoe.Player.O) {
            setSnooze(true);
            updateLabel("Waiting...");
            status = Status.WAITING_FOR_TURN;
            waitForAnotherPlayer();
        } else {
            status = Status.MY_TURN;
            setSnooze(false);
            updateLabel("Your turn");
        }
    }

    /**
     * Send action to another player
     *
     * @param event action should be sent
     */
    public void sendEvent(TTTEvent event) {
        try {
            if (inputStream.available() == 0) {
                event.send(outputStream);
            } else {
                evaluate((TTTEvent) inputStream.readObject());
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
    }

    /** Creates a thread waiting for another player actions */
    public void waitForAnotherPlayer() {
        new Thread(() -> {
            TTTEvent newEvent = new TTTEvent(inputStream);
            Platform.runLater(() -> evaluate(newEvent));
        }).start();
    }

    /** Action when played clicks field button */
    @Override
    protected void nextTurn(ActionEvent event) {
        int row = getEventSourceRow(event);
        int column = getEventSourceColumn(event);
        if (buttonArray[row][column].textProperty().get().equals("")) {
            TTTEvent tttEvent = new TTTEvent(new TTTEvent.ClickOnFieldAction(row, column), player, TTTEvent.ActionType.CLICK_ON_FIELD);
            updateLabel("Waiting...");
            setSnooze(true);
            sendEvent(tttEvent);
            updateButton(row, column);
            if (game.isFinished()) {
                endGame();
            } else {
                waitForAnotherPlayer();
            }
            status = Status.WAITING_FOR_TURN;
        }
    }

    @FXML
    protected Button newGameButton;
}
