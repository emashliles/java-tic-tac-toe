import com.TTT.Board;
import com.TTT.Game;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTests {
    @Test
    public void startsNewGame() {
        Board board = new Board();
        Game game = new Game(board);
        assertEquals(false, game.isOver());
    }

    @Test
    public void handlesTurn() {
        Board board  = new Board();
        Game game = new Game(board);
        game.doTurn(1);
        assertEquals("X", board.markerAt(1));
    }

    @Test
    public void handlesSecondPlayerTurn()
    {
        Board board = new Board();
        Game game = new Game(board);
        game.doTurn(1);
        game.doTurn(5);
        assertEquals("O", board.markerAt(5));
    }
}
