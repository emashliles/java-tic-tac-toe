import com.TTT.Board;
import com.TTT.BoardPrinter;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BoardPrinterTests {
    @Test
    public void canPrintBoard() {
        Board board = new Board();
        ByteArrayOutputStream outBytes = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outBytes);
        BoardPrinter ui = new BoardPrinter(out);
        ui.printBoard(board);

        assertEquals(outBytes.toString(), " 1 | 2 | 3 \n===========\n 4 | 5 | 6 \n===========\n 7 | 8 | 9 \n");
    }

    @Test
    public void canPrintBoardWithColouredPlayerMarkers() {
        Board board = new Board();
        board.placeMarker(0, "X");
        board.placeMarker(2, "O");
        ByteArrayOutputStream outBytes = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outBytes);
        BoardPrinter ui = new BoardPrinter(out);
        ui.printBoard(board);

        assertEquals(outBytes.toString(), "\u001B[31m X \u001B[0m| 2 |\u001B[34m O \u001B[0m\n===========\n 4 | 5 | 6 \n===========\n 7 | 8 | 9 \n");

    }
}
