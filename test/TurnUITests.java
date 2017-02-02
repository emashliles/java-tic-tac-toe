import com.TTT.Board;
import com.TTT.BoardPrinter;
import com.TTT.Game;
import com.TTT.TurnUI;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class TurnUITests {

    private Board board;
    private Game game;
    private BoardPrinter printer;
    private PrintStream out;
    private ByteArrayOutputStream outputStream;

    @Before
    public void setUp() {
       board = new Board();
       game = new Game(board);
       printer = new BoardPrinter(System.out);
       outputStream = new ByteArrayOutputStream();
       out = new PrintStream(outputStream);
    }

    @Test
    public void canAlternateTurns() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\n2\n".getBytes());
        TurnUI turns = new TurnUI(printer, System.out, in);

        turns.takeTurn(board, game);
        turns.takeTurn(board, game);

        assertEquals(board.markerAt(1), "O");
    }

    @Test
    public void asksForInputAgainIfInputIsText() {
        ByteArrayInputStream in = new ByteArrayInputStream(("invalidInput\n2").getBytes());
        TurnUI turns = new TurnUI(printer, out, in);

        turns.takeTurn(board, game);

        assertEquals(outputStream.toString(), "Please enter a space number: Invalid input. Please enter a space number: ");
    }

    @Test
    public void asksForInputAgainIfInputIsTooLarge() {
        ByteArrayInputStream in = new ByteArrayInputStream(("9999999999999999999999999999\n7").getBytes());
        TurnUI turns = new TurnUI(printer, out, in);

        turns.takeTurn(board, game);

        assertEquals(outputStream.toString(), "Please enter a space number: Invalid input. Please enter a space number: ");
    }

    @Test
    public void asksForInputAgainIfInputIsNotOnBoard() {
        ByteArrayInputStream in = new ByteArrayInputStream(("10\n7").getBytes());
        TurnUI turns = new TurnUI(printer, out, in);

        turns.takeTurn(board, game);

        assertEquals(outputStream.toString(), "Please enter a space number: Invalid input. Please enter a space number: ");
    }

    @Test
    public void asksForInputAgainIfSelectionTaken() {
        ByteArrayInputStream in = new ByteArrayInputStream(("5\n2").getBytes());
        board.placeMarker(4, "X");
        TurnUI turns = new TurnUI(printer, out, in);

        turns.takeTurn(board, game);

        assertEquals(outputStream.toString(), "Please enter a space number: Invalid input. Please enter a space number: ");
    }

    @Test
    public void zeroIndexSelection() {
        ByteArrayInputStream in = new ByteArrayInputStream(("5").getBytes());
        TurnUI turns = new TurnUI(printer, out, in);

        turns.takeTurn(board, game);

        assertEquals(board.isOccupied(4), true);

    }
}
