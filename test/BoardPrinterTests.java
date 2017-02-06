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
}
