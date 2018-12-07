import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.net.Socket;

/** Maiin class for Application */
public class App extends Application {

    private static Socket socket;
    private static TicTac.Player player;
    private NetworkController controller;

    /**
     * The main entry point for JavaFX application.
     *
     * @param primaryStage the primary stage for this application
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("scene.fxml"));
        Parent root = fxmlLoader.load();
        controller = fxmlLoader.getController();
        controller.setOptions(player, socket);
        primaryStage.setTitle("Tick-tac-toe. Player: " + player.toString());
        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 250, 350));
        primaryStage.show();

    }

    /**
     * Method that evaluates before application halt
     *
     * @throws Exception
     */
    @Override
    public void stop() throws Exception {
        if (controller.status != NetworkController.Status.EXITING) {
            controller.exitAction();
        } else {
            socket.close();
        }
        super.stop();
    }

    /** The entry point for application */
    public static void main(TicTac.Player player, Socket socket, String[] args) {
        App.socket = socket;
        App.player = player;
        launch(args);
    }
}