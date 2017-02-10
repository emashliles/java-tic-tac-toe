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
       board = new Board(3);
       game = new Game(board);
       printer = new BoardPrinter(new PrintStream(new ByteArrayOutputStream()));
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
    public void canPlayAFullGame() {
        ByteArrayInputStream in = new ByteArrayInputStream(("1\n2\n3\n4\n5\n6\n7\n").getBytes());
        TurnUI turns = new TurnUI(printer, out, in);

        turns.takeTurns(board, game);

        assertEquals(outputStream.toString().contains("winner"), true);
    }

    @Test
    public void asksForInputAgainIfInputIsText() {
        ByteArrayInputStream in = new ByteArrayInputStream(("invalidInput\n2").getBytes());
        TurnUI turns = new TurnUI(printer, out, in);

        turns.takeTurn(board, game);

        assertEquals(outputStream.toString(), "Please choose a space: Invalid input - you must enter a number. Please choose a space: ");
    }

    @Test
    public void asksForInputAgainIfInputIsNotOnBoard() {
        ByteArrayInputStream in = new ByteArrayInputStream(("10\n7").getBytes());
        TurnUI turns = new TurnUI(printer, out, in);

        turns.takeTurn(board, game);

        assertEquals(outputStream.toString(), "Please choose a space: Invalid input - your choice must be a number on the board. Please choose a space: ");
    }

    @Test
    public void asksForInputAgainIfSelectionTaken() {
        ByteArrayInputStream in = new ByteArrayInputStream(("5\n2").getBytes());
        board.placeMarker(4, "X");
        TurnUI turns = new TurnUI(printer, out, in);

        turns.takeTurn(board, game);

        assertEquals(outputStream.toString(), "Please choose a space: Invalid input - your choice must not be already taken. Please choose a space: ");
    }

    @Test
    public void declaresAWinner() {
        board.placeMarker(0, "X");
        board.placeMarker(3, "X");

        ByteArrayInputStream in = new ByteArrayInputStream(("7").getBytes());
        TurnUI turns = new TurnUI(printer, out, in);

        turns.takeTurn(board, game);

        assertEquals(outputStream.toString(), "Please choose a space: Player X is the winner.\n");
    }

    @Test
    public void declaresATie() {
        board.placeMarker(0, "X");
        board.placeMarker(1, "O");
        board.placeMarker(2, "X");
        board.placeMarker(3, "X");
        board.placeMarker(4, "O");
        board.placeMarker(5, "X");
        board.placeMarker(6, "O");
        board.placeMarker(8, "O");

        ByteArrayInputStream in = new ByteArrayInputStream(("8").getBytes());
        TurnUI turns = new TurnUI(printer, out, in);

        turns.takeTurn(board, game);

        assertEquals(outputStream.toString(), "Please choose a space: This game is a tie.\n");
    }

    @Test
    public void makesSelectionZeroIndex() {
        ByteArrayInputStream in = new ByteArrayInputStream(("5").getBytes());
        TurnUI turns = new TurnUI(printer, out, in);

        turns.takeTurn(board, game);

        assertEquals(board.isOccupied(4), true);

    }
    @Test
    public void checkSelectionIsValid() {
        assertEquals(true, TurnUI.validSelection("1"));
    }

    @Test
    public void checksSelectionIsNotString() {
        assertEquals(false, TurnUI.validSelection("one"));
    }

    @Test
    public void checksSelectionIsValidInteger() {
        assertEquals(false, TurnUI.validSelection("9999999999999999999999999999999999999"));
    }
}
