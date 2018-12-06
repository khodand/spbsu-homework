import org.junit.Test;

import static org.junit.Assert.*;

public class TictactoeTest {

    @Test
    public void getPlayerTest() {
        Tictactoe game = new Tictactoe();
        game.nextTurn(0, 0);
        assertEquals(Tictactoe.Player.O, game.getPlayer());
        game.nextTurn(1, 1);
        assertEquals(Tictactoe.Player.X, game.getPlayer());
        game.nextTurn(1, 1);
        assertEquals(Tictactoe.Player.X, game.getPlayer());
    }

    @Test
    public void nextTurn() {
        Tictactoe game = new Tictactoe();
        game.nextTurn(0, 0);
        game.nextTurn(0, 1);
        assertEquals(Tictactoe.Player.X, game.getPlayer());
        game.nextTurn(0, 0);
        assertEquals(Tictactoe.Player.X, game.getPlayer());
        game.nextTurn(0, 2);
        assertFalse(game.isFinished());
    }

    @Test
    public void hasWinner() {
        Tictactoe game = new Tictactoe();
        game.nextTurn(0, 0);
        assertFalse(game.hasWinner());
        game.nextTurn(1, 0);
        assertFalse(game.hasWinner());
        game.nextTurn(0, 1);
        assertFalse(game.hasWinner());
        game.nextTurn(2, 0);
        assertFalse(game.hasWinner());
        game.nextTurn(0, 2);
        assertTrue(game.hasWinner());
    }

    @Test
    public void isFinished() {
        Tictactoe game = new Tictactoe();
        game.nextTurn(0, 0);
        game.nextTurn(0, 1);
        game.nextTurn(0, 2);
        game.nextTurn(1, 0);
        game.nextTurn(1, 1);
        game.nextTurn(1, 2);
        assertFalse(game.isFinished());
        game.nextTurn(2, 1);
        game.nextTurn(2, 2);
        game.nextTurn(2, 0);
        assertTrue(game.isFinished());
    }
}
