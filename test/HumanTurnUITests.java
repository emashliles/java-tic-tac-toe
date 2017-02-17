import com.TTT.*;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class HumanTurnUITests {

    private Board board;
    private BoardPrinter printer;
    private PrintStream out;
    private ByteArrayOutputStream outputStream;
    private GameUI gameUI;

    @Before
    public void setUp() {
        board = new Board(3);
        printer = new BoardPrinter(new PrintStream(new ByteArrayOutputStream()));
        outputStream = new ByteArrayOutputStream();
        out = new PrintStream(outputStream);
        ByteArrayOutputStream gameUiOutStream = new ByteArrayOutputStream();
        PrintStream gameUiOut = new PrintStream(gameUiOutStream);
        gameUI = new GameUI(gameUiOut, printer);
    }

    @Test
    public void asksForInputAgainIfInputIsText() {
        ByteArrayInputStream in = new ByteArrayInputStream(("invalidInput\n2").getBytes());
        HumanTurnUI humanTurnUI = new HumanTurnUI(printer, out, in, gameUI);

        humanTurnUI.takeTurn(board);

        assertEquals(outputStream.toString(), "Please choose a space: Invalid input - you must enter a number. Please choose a space: ");
    }

    @Test
    public void asksForInputAgainIfInputIsNotOnBoard() {
        ByteArrayInputStream in = new ByteArrayInputStream(("10\n7").getBytes());
        HumanTurnUI humanTurnUI = new HumanTurnUI(printer, out, in, gameUI);

        humanTurnUI.takeTurn(board);

        assertEquals(outputStream.toString(), "Please choose a space: Invalid input - your choice must be a number on the board. Please choose a space: ");
    }

    @Test
    public void asksForInputAgainIfSelectionTaken() {
        ByteArrayInputStream in = new ByteArrayInputStream(("5\n2").getBytes());
        board.placeMarker(4, "X");
        HumanTurnUI humanTurnUI = new HumanTurnUI(printer, out, in, gameUI);

        humanTurnUI.takeTurn(board);

        assertEquals(outputStream.toString(), "Please choose a space: Invalid input - your choice must not be already taken. Please choose a space: ");
    }

    @Test
    public void makesSelectionZeroIndex() {
        ByteArrayInputStream in = new ByteArrayInputStream(("5").getBytes());
        HumanTurnUI humanTurnUI = new HumanTurnUI(printer, out, in, gameUI);
        HumanPlayer player1 = new HumanPlayer(humanTurnUI);
        HumanPlayer player2 = new HumanPlayer(humanTurnUI);

        Game game = new Game(board, player1, player2);

        game.doTurn();

        assertEquals(board.isOccupied(4), true);
    }

    @Test
    public void checkSelectionIsValid() {
        assertEquals(true, HumanTurnUI.validSelection("1"));
    }

    @Test
    public void checksSelectionIsNotString() {
        assertEquals(false, HumanTurnUI.validSelection("one"));
    }

    @Test
    public void checksSelectionIsValidInteger() {
        assertEquals(false, HumanTurnUI.validSelection("9999999999999999999999999999999999999"));
    }
}
