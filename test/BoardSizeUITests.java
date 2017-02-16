import com.TTT.BoardPrinter;
import com.TTT.BoardSizeUI;
import com.TTT.GameUI;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class BoardSizeUITests {

    private ByteArrayOutputStream outputStream;
    private PrintStream out;
    private ByteArrayInputStream in;
    private ByteArrayOutputStream gameUIOutStream;
    private GameUI gameUI;

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        out = new PrintStream(outputStream);
        gameUIOutStream = new ByteArrayOutputStream();
        PrintStream gameUIOut = new PrintStream(gameUIOutStream);
        gameUI = new GameUI(gameUIOut, new BoardPrinter(System.out));
    }

    @Test
    public void getUserBoardSizeSelection() {
        ByteArrayInputStream in = new ByteArrayInputStream("4".getBytes());
        BoardSizeUI ui = new BoardSizeUI(out, in, gameUI);

        assertEquals(4 ,ui.boardSize());
    }

    @Test
    public void clearScreenBeforePrintingOptions() {
        in = new ByteArrayInputStream("4".getBytes());
        BoardSizeUI ui = new BoardSizeUI(out, in, gameUI);

        ui.boardSize();

        assertEquals("\033[H\033[2J", gameUIOutStream.toString());
    }

    @Test
    public void askUserForBoardSizeSelection() {
        in = new ByteArrayInputStream("4".getBytes());
        BoardSizeUI ui = new BoardSizeUI(out, in, gameUI);

        ui.boardSize();

        assertEquals("Would you like a 3x3 or 4x4 board? Please enter 3 or 4: ", outputStream.toString());
    }

    @Test
    public void askAgainifSizeNotAvailable() {
        ByteArrayInputStream in = new ByteArrayInputStream("99\n3".getBytes());
        BoardSizeUI ui = new BoardSizeUI(out, in, gameUI);
        ui.boardSize();

        assertEquals("Would you like a 3x3 or 4x4 board? Please enter 3 or 4: You must choose 3 for a 3x3 board or 4 for a 4x4 board.", outputStream.toString());
    }

    @Test
    public void askAgainIfInvalidInputEntered() {
        ByteArrayInputStream in = new ByteArrayInputStream("InvalidInput\n3".getBytes());
        BoardSizeUI ui = new BoardSizeUI(out, in, gameUI);
        ui.boardSize();

        assertEquals("Would you like a 3x3 or 4x4 board? Please enter 3 or 4: You must choose 3 for a 3x3 board or 4 for a 4x4 board.", outputStream.toString());
    }
}
