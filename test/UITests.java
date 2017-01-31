import com.TTT.Board;
import com.TTT.BoardPrinter;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class UITests {
    @Test
    public void canPrintBoard() {
        Board board = new Board();
        ByteArrayOutputStream outBytes = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outBytes);
        BoardPrinter ui = new BoardPrinter(out);
        ui.printBoard(board);

        assertEquals(outBytes.toString(), "123\n456\n789\n");
    }
}
