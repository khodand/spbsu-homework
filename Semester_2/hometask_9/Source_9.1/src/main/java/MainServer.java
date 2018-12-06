import java.io.IOException;
import java.net.ServerSocket;

/** Class for starting server app */
public class MainServer {

    /** Method for starting server app */
    public static void main(String[] args) {
        System.out.println("Tic-tac-toe game. Server");
        ServerSocket serverSocket;
        try {
            serverSocket = new ServerSocket(0); // creates socket on random free port
            System.out.println("Port: " + serverSocket.getLocalPort());
            App.main(Tictactoe.Player.X, serverSocket.accept(), null);
        } catch (IOException e) {
            System.out.println("Problems with creating socket");
            e.printStackTrace();
        }
    }
}