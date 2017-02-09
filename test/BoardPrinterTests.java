import com.TTT.Board;
import com.TTT.BoardPrinter;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static java.lang.System.out;
import static org.junit.Assert.assertEquals;

public class BoardPrinterTests {

    private Board board;
    private ByteArrayOutputStream outBytes;
    private PrintStream out;
    private BoardPrinter ui;

    @Before
    public void setUp() {
        board = new Board();
        outBytes = new ByteArrayOutputStream();
        out = new PrintStream(outBytes);
        ui = new BoardPrinter(out);
    }

    @Test
    public void canPrintBoard() {
        ui.printBoard(board);
        assertEquals(outBytes.toString(), " 1 | 2 | 3 \n===========\n 4 | 5 | 6 \n===========\n 7 | 8 | 9 \n");
    }

    @Test
    public void canPrintBoardWithColouredPlayerMarkers() {
        board.placeMarker(0, "X");
        board.placeMarker(2, "O");
        ui.printBoard(board);

        assertEquals(outBytes.toString(), "\u001B[31m X \u001B[0m| 2 |\u001B[34m O \u001B[0m\n===========\n 4 | 5 | 6 \n===========\n 7 | 8 | 9 \n");
    }
}
