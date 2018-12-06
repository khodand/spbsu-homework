/** Class for performing tic-tac-toe game logic */
public class Tictactoe {

    /** Enum of player types */
    public enum Player {X, O}

    /** Enum of states button can have */
    private enum ButtonState {X, O, NOTHING}

    /** Array of states buttons have */
    private ButtonState[][] buttons;

    /** Value of <tt>Tictactoe.Player</tt> -- the player which turn is been waiting */
    private Player currentPlayer = Player.X;

    /** Constructor method */
    Tictactoe() {
        buttons = new ButtonState[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                buttons[i][j] = ButtonState.NOTHING;
            }
        }
    }

    /**
     * Returns the current player, which turn is been waiting.
     *
     * @return <tt>Tictactoe.Player</tt> value of current player
     */
    public Player getPlayer() {
        return currentPlayer;
    }

    /**
     * Realizes the action when user wants to change X or O value of game field.
     *
     * @param row row of field from 0 to 2
     * @param column column of field from 0 to 2
     * @return the new text for field pressed
     */
    public String nextTurn(int row, int column) {
        String result;
        if (buttons[row][column] == ButtonState.NOTHING) {
            buttons[row][column] = (currentPlayer == Player.X) ? ButtonState.X : ButtonState.O;
            result = (currentPlayer == Player.X) ? "X" : "O";
            currentPlayer = (currentPlayer == Player.X) ? Player.O : Player.X;
        } else {
            result = (buttons[row][column] == ButtonState.X) ? "X" : "O";
        }
        return result;
    }

    /**
     * Returns <tt>true</tt> if there are some three same symbols in one line
     *
     * @return <tt>true</tt> if there are some three same symbols in one line
     */
    public boolean hasWinner() {
        boolean result = false;

        for (int row = 0; row < 3; row++) {
            result |= buttons[row][0] == buttons[row][1] &&
                    buttons[row][1] == buttons[row][2] &&
                    buttons[row][0] != ButtonState.NOTHING;
        }

        for (int column = 0; column < 3; column++) {
            result |= buttons[0][column] == buttons[1][column] &&
                    buttons[1][column] == buttons[2][column] &&
                    buttons[0][column] != ButtonState.NOTHING;
        }

        result |= buttons[0][0] == buttons[1][1] &&
                buttons[1][1] == buttons[2][2] &&
                buttons[0][0] != ButtonState.NOTHING;

        result |= buttons[0][2] == buttons[1][1] &&
                buttons[1][1] == buttons[2][0] &&
                buttons[0][2] != ButtonState.NOTHING;

        return result;
    }

    /**
     * Return <tt>true</tt> if all fields are filled or there are some three same symbols in one line
     *
     * @return <tt>true</tt> if game is finished
     */
    public boolean isFinished() {
        boolean result = true;
        for (int row = 0; row < 3; row++) {
            for (int column = 0; column < 3; column++) {
                result &= buttons[row][column] != ButtonState.NOTHING;
            }
        }

        return result || hasWinner();
    }

}