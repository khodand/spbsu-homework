import org.junit.Test;

import java.io.*;

import static org.junit.Assert.*;

public class TTTEventTest {

    @Test
    public void sendTest() throws IOException, ClassNotFoundException {
        TTTEvent tttEvent = new TTTEvent(new TTTEvent.ExitGameClickAction(), TicTac.Player.X, TTTEvent.ActionType.EXIT_GAME);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        tttEvent.send(objectOutputStream);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        TTTEvent received = (TTTEvent) objectInputStream.readObject();

        assertEquals(received.getActionType(), tttEvent.getActionType());
    }

    @Test
    public void getConstructorTest() throws IOException {
        TTTEvent tttEvent = new TTTEvent(new TTTEvent.ExitGameClickAction(), TicTac.Player.X, TTTEvent.ActionType.EXIT_GAME);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(tttEvent);

        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        TTTEvent received = new TTTEvent(objectInputStream);

        assertEquals(received.getActionType(), tttEvent.getActionType());
    }
}