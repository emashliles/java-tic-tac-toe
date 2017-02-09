import com.TTT.GameOptionsUI;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class GameOptionsUITests {
    @Test
    public void askUserForBoardSizeSelection() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);
        ByteArrayInputStream in = new ByteArrayInputStream("4".getBytes());
        GameOptionsUI ui = new GameOptionsUI(out, in);

        ui.boardSize();

        assertEquals("Would you like a 3x3 or 4x4 board? Please enter 3 or 4: ", outputStream.toString());
    }

    @Test
    public void getUserBoardSizeSelection() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);
        ByteArrayInputStream in = new ByteArrayInputStream("4".getBytes());
        GameOptionsUI ui = new GameOptionsUI(out, in);

        assertEquals(4 ,ui.boardSize());
    }
}
