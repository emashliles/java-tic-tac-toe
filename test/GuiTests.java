import com.TTT.Gui;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class GuiTests {

    @Test
    public void printsBoard() throws Exception {
        ByteArrayOutputStream stdOutStream = new ByteArrayOutputStream();
        PrintStream stdOut = new PrintStream(stdOutStream);
        Gui gui = new Gui(stdOut);
        gui.printBoard();

        assertEquals(stdOutStream.toString(), "123\n456\n789");

    }
}
