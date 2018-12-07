import java.io.IOException;
import java.net.Socket;
import java.util.InputMismatchException;
import java.util.Scanner;

/** Class for starting client app */
public class MainClient {

    /** Method for starting client app */
    public static void main(String[] args) {
        System.out.println("Tic-tac-toe game. Client");
        System.out.println("Enter the port:");
        Scanner scanner = new Scanner(System.in);
        try {
            Socket socket = new Socket("localhost", scanner.nextInt());
            App.main(TicTac.Player.O, socket, null);
        } catch (IOException e) {
            System.out.println("Port is not open");
        } catch (IllegalArgumentException |InputMismatchException e) {
            System.out.println("Wrong value");
        }
    }
}