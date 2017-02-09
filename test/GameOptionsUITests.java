import com.TTT.GameOptionsUI;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class GameOptionsUITests {

    private ByteArrayOutputStream outputStream;
    private PrintStream out;
    private ByteArrayInputStream in;

    @Before
    public void setUp() {
        outputStream = new ByteArrayOutputStream();
        out = new PrintStream(outputStream);
    }

    @Test
    public void askUserForBoardSizeSelection() {
        in = new ByteArrayInputStream("4".getBytes());
        GameOptionsUI ui = new GameOptionsUI(out, in);

        ui.boardSize();

        assertEquals("Would you like a 3x3 or 4x4 board? Please enter 3 or 4: ", outputStream.toString());
    }

    @Test
    public void getUserBoardSizeSelection() {
        ByteArrayInputStream in = new ByteArrayInputStream("4".getBytes());
        GameOptionsUI ui = new GameOptionsUI(out, in);

        assertEquals(4 ,ui.boardSize());
    }

    @Test
    public void askAgainifSizeNotAvailable() {
        ByteArrayInputStream in = new ByteArrayInputStream("99\n3".getBytes());
        GameOptionsUI ui = new GameOptionsUI(out, in);
        ui.boardSize();

        assertEquals("Would you like a 3x3 or 4x4 board? Please enter 3 or 4: You must choose 3 for a 3x3 board or 4 for a 4x4 board.", outputStream.toString());
    }
}
