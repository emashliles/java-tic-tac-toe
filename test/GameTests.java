import com.TTT.Board;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTests {
    @Test
    public void startsNewGame() {
        Board board = new Board();
        Game game = new Game(board);
        assertEquals(game.isOver(), false);
    }

    @Test
    public void handlesTurn() {
        Board board  = new Board();
        Game game = new Game(board);
        game.doTurn(1, "X");
        assertEquals(board.isOccupied(1), true);
    }
}
