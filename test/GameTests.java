import com.TTT.*;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class GameTests {

    private Board board;
    private Game game;

    @Before
    public void setUp() {
       board = new Board(3);
       HumanTurnUI turns = new HumanTurnUI(new BoardPrinter(System.out),System.out, System.in);
        HumanPlayer player1 = new HumanPlayer(turns);
        HumanPlayer player2 = new HumanPlayer(turns);
        game = new Game(board, player1, player2);
    }

    @Test
    public void startsNewGame() {
        assertThat(game.isOver(board), is(GameState.NoWinner));
    }

    @Test
    public void detectsAWinner() {
        board.placeMarker(0, "X");
        board.placeMarker(3, "X");
        board.placeMarker(6, "X");
        assertThat(game.isOver(board), is(GameState.Win));
    }
}
