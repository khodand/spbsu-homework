import org.junit.Test;

import static org.junit.Assert.*;

public class TicTacTest {
    @org.junit.Test
    public void winConditionTest() {
        TicTac game = new TicTac();
        game.buttonPressed("1"); // X
        game.buttonPressed("1"); // O

        game.buttonPressed("2"); // X
        game.buttonPressed("5"); // O

        game.buttonPressed("4"); // X
        game.buttonPressed("9"); // O

        assertFalse(game.isGameOn());
    }

    @Test
    public void wichTurnTest(){
        TicTac game = new TicTac();
        game.buttonPressed("1"); // X
        game.buttonPressed("1"); // O

        game.buttonPressed("2"); // X

        assertEquals("O",game.getTurn());
    }
}