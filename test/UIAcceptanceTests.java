import com.TTT.*;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class UIAcceptanceTests {

    private ByteArrayOutputStream printerOutStream;
    private PrintStream printerOut;
    private BoardPrinter printer;
    private ByteArrayOutputStream outStream;
    private PrintStream out;
    private Board board;

    @Before
    public void setUp() {
        printerOutStream = new ByteArrayOutputStream();
        printerOut = new PrintStream(printerOutStream);
        outStream = new ByteArrayOutputStream();
        out = new PrintStream(outStream);
        printer = new BoardPrinter(printerOut);
        board = new Board(3);
    }

    @Test
    public void announceComputerPlayerWin() {
        ByteArrayInputStream in = new ByteArrayInputStream("".getBytes());
        Player computer = new ComputerPlayer(new GameUI(out, in, printer));

        board.placeMarker(0, "X");
        board.placeMarker(1, "O");
        board.placeMarker(2, "X");
        board.placeMarker(3, "O");
        board.placeMarker(4, "X");
        board.placeMarker(5, "O");
        board.placeMarker(6, "X");

        computer.doTurn(board, PlayerMarkers.X);

        assertEquals("Player X is the winner.\n", outStream.toString());
    }
}
