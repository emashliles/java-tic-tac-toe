import com.TTT.Board;
import com.TTT.BoardPrinter;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BoardPrinterTests {
    @Test
    public void boardIsEmpty() throws Exception {


    }

    @Test
    public void printsBoard() throws Exception {
        ByteArrayOutputStream stdOutStream = new ByteArrayOutputStream();
        PrintStream stdOut = new PrintStream(stdOutStream);
        BoardPrinter boardPrinter = new BoardPrinter(stdOut);
        boardPrinter.printBoard();

        assertEquals(stdOutStream.toString(), " 1 | 2 | 3 \n 4 | 5 | 6 \n 7 | 8 | 9 ");

    }
}
