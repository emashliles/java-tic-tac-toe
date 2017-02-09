import com.TTT.Board;
import com.TTT.Game;
import com.TTT.GameState;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GameTests {

    private Board board;
    private Game game;

    @Before
    public void setUp() {
       board = new Board(3);
       game = new Game(board);
    }

    @Test
    public void startsNewGame() {
        assertThat(game.isOver(), is(GameState.NoWinner));
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
    public void checksSelectionIsNotOffTheBoard() {
        assertEquals(false, game.selectionOnBoard(10));
    }

    @Test
    public void checksSelectionIsAbove1() {
        assertEquals(false, game.selectionOnBoard(-1));
    }

    @Test
    public void checkSelectionIsOnTheBoard() {
        assertEquals(true, game.selectionOnBoard(5));
    }

    @Test
    public void detectsAWinner() {
        board.placeMarker(0, "X");
        board.placeMarker(3, "X");
        board.placeMarker(6, "X");
        assertThat(game.isOver(), is(GameState.Win));
    }

    @Test
    public void canReturnMarkerForCurrentPlayer() {
        assertEquals(game.getPlayerMarker(1), "X");
    }

    @Test
    public void canReturnCurrentPlayer() {
        assertEquals(game.currentPlayer(), 1);
    }

    @Test
    public void canPlayAFullGame() {
        game.doTurn(0);
        assertThat(game.isOver(), is(GameState.NoWinner));
        game.doTurn(1);
        assertThat(game.isOver(), is(GameState.NoWinner));
        game.doTurn(2);
        assertThat(game.isOver(), is(GameState.NoWinner));
        game.doTurn(3);
        assertThat(game.isOver(), is(GameState.NoWinner));
        game.doTurn(4);
        assertThat(game.isOver(), is(GameState.NoWinner));
        game.doTurn(5);
        assertThat(game.isOver(), is(GameState.NoWinner));
        game.doTurn(6);
        assertThat(game.isOver(), is(GameState.Win));
    }
}
