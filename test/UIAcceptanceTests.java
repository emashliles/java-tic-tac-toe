import com.TTT.*;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class UIAcceptanceTests {

    @Test
    public void announceComputerPlayerWin() {

        ByteArrayOutputStream printerOutStream = new ByteArrayOutputStream();
        PrintStream printerOut = new PrintStream(printerOutStream);
        BoardPrinter printer = new BoardPrinter(printerOut);

        ByteArrayInputStream in = new ByteArrayInputStream("".getBytes());
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);
        Player computer = new ComputerPlayer(new GameUI(out, in, printer));

        Board board = new Board(3);

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
