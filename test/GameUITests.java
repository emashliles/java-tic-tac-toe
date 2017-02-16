import com.TTT.*;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class GameUITests {

    private Board board;
    private BoardPrinter printer;
    private PrintStream out;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
        board = new Board(3);
        printer = new BoardPrinter(new PrintStream(new ByteArrayOutputStream()));
        outputStream = new ByteArrayOutputStream();
        out = new PrintStream(outputStream);
    }

    @Test
    public void announceWinner() {
        ByteArrayInputStream in = new ByteArrayInputStream(("").getBytes());
        GameUI turns = new GameUI(out, printer);

        board.placeMarker(0, "X");
        board.placeMarker(1, "O");
        board.placeMarker(2, "X");
        board.placeMarker(3, "O");
        board.placeMarker(4, "X");
        board.placeMarker(5, "O");
        board.placeMarker(6, "X");

        turns.announceWinner(board, PlayerMarkers.X.symbol());

        assertEquals(outputStream.toString().contains("Player X is the winner."), true);
    }

    @Test
    public void clearScreen() {
        GameUI turns = new GameUI(out, printer);
        turns.clearScreen();
        assertEquals("\033[H\033[2J", outputStream.toString());
    }

    @Test
    public void printPlayersTurn() {
        GameUI gameUI = new GameUI(out, printer);
        gameUI.printPlayerTurn(PlayerMarkers.X);
        assertEquals("Player X's turn...", outputStream.toString());
    }
}
