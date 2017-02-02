import com.TTT.Board;
import com.TTT.Game;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GameTests {

    private Board board;
    private Game game;

    @Before
    public void setUp() {
       board = new Board();
       game = new Game(board);
    }

    @Test
    public void startsNewGame() {
        assertEquals(false, game.isOver());
    }

    @Test
    public void handlesTurn() {
        game.doTurn(1);
        assertEquals("X", board.markerAt(1));
    }

    @Test
    public void handlesSecondPlayerTurn() {
        game.doTurn(1);
        game.doTurn(5);
        assertEquals("O", board.markerAt(5));
    }

    @Test
    public void checkSelectionIsValid() {
        assertEquals(true, game.validSelection("1"));
    }

    @Test
    public void checksSelectionIsNotString() {
        assertEquals(false, game.validSelection("one"));
    }

    @Test
    public void checksSelectionIsValidInteger() {
        assertEquals(false, game.validSelection("9999999999999999999999999999999999999"));
    }
}
