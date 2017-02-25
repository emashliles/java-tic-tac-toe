import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class GameTests {

    private Board board;
    private Game game;
    private BoardPrinter printer;
    private GameUI gameUI;

    @Before
    public void setUp() {
       board = new Board(3);
       HumanTurnUI humanTurnUI = new HumanTurnUI(new BoardPrinter(System.out),System.out, System.in, new GameUI(System.out, new BoardPrinter(System.out)));
       HumanPlayer player1 = new HumanPlayer(humanTurnUI);
       HumanPlayer player2 = new HumanPlayer(humanTurnUI);
       game = new Game(board, player1, player2);
       printer = new BoardPrinter(new PrintStream(new ByteArrayOutputStream()));
       ByteArrayOutputStream gameUiOutStream = new ByteArrayOutputStream();
       PrintStream gameUiOut = new PrintStream(gameUiOutStream);
       gameUI = new GameUI(gameUiOut, printer);
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

    @Test
    public void getCurrentPlayerMarker() {
        assertThat(game.getCurrentPlayer(), is(PlayerMarkers.X));
    }

    @Test
    public void canAlternateTurns() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\n2\n".getBytes());
        HumanTurnUI humanTurnUI = new HumanTurnUI(printer, System.out, in, gameUI);
        HumanPlayer player1 = new HumanPlayer(humanTurnUI);
        HumanPlayer player2 = new HumanPlayer(humanTurnUI);
        Game game = new Game(board, player1, player2);

        game.doTurn();
        game.doTurn();

        assertEquals(board.markerAt(1), "O");
    }
}
