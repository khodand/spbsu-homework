import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/** Class realizing objects contains information about actions need to be sent */
public class TTTEvent implements Serializable {

    private TTTEventAction tttEventAction;
    private TicTac.Player sender;
    private ActionType actionType;

    /** Type of action will be send */
    public enum ActionType {NEW_GAME, CLICK_ON_FIELD, EXIT_GAME}

    /**
     * Creates TTTEvent
     *
     * @param tttEventAction action will be sent
     * @param sender player who makes this action
     * @param actionType type of action will be send
     */
    public TTTEvent(TTTEventAction tttEventAction, TicTac.Player sender, ActionType actionType) {
        this.tttEventAction = tttEventAction;
        this.actionType = actionType;
        this.sender = sender;
    }

    /**
     * Receive TTTEvent from stream
     *
     * @param stream the source TTTEvent will be received from
     */
    public TTTEvent(ObjectInputStream stream) {
        TTTEvent tttEvent = read(stream);
        while (tttEvent == null) {
            tttEvent = read(stream);
        }
        this.tttEventAction = tttEvent.tttEventAction;
        this.sender = tttEvent.sender;
        this.actionType = tttEvent.actionType;
    }

    /**
     * Send TTTEvent to given stream
     *
     * @param stream action will be sent in
     * @throws IOException if something wrong with connection
     */
    public void send(ObjectOutputStream stream) throws IOException {
        stream.writeObject(this);
        stream.flush();
    }

    /**
     * Returns action of TTTEvent
     *
     * @return action of TTTEvent
     */
    public TTTEventAction getTttEventAction() {
        return tttEventAction;
    }

    /**
     * Returns action type of TTTEvent
     *
     * @return action type of TTTEvent
     */
    public ActionType getActionType() {
        return actionType;
    }

    private TTTEvent read(ObjectInputStream stream) {
        try {
            return (TTTEvent) stream.readObject();
        } catch (IOException e) {
            System.out.println("Something wrong with connection");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }


    /** Interface of action will be sent */
    public interface TTTEventAction {}

    /** Action when player clicks new game button */
    public static class NewGameClickAction implements TTTEventAction, Serializable {}

    /** Action when player closes the game */
    public static class ExitGameClickAction implements TTTEventAction, Serializable {}

    /** Action when player clicks field button */
    public static class ClickOnFieldAction implements TTTEventAction, Serializable {
        private int row;
        private int column;

        public ClickOnFieldAction(int row, int column) {
            this.row = row;
            this.column = column;
        }

        public int getRow() {
            return row;
        }

        public int getColumn() {
            return column;
        }
    }
}