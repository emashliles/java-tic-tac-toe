import com.TTT.Player;
import com.TTT.PlayerOptionUI;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class PlayerOptionUITests {

    private ByteArrayOutputStream outStream;
    private PrintStream out;
    private PlayerOptionUI optionUI;

    @Before
    public void setUp() {
        outStream = new ByteArrayOutputStream();
        out = new PrintStream(outStream);
        optionUI = new PlayerOptionUI(out);
    }

    @Test
    public void askUserForPlayer1Option() {
        optionUI.getPlayerOption(1);

        assertEquals("Player 1 (h/c)", outStream.toString());
    }

    @Test
    public void askUserForPlayer2Option() {
        optionUI.getPlayerOption(2);

        assertEquals("Player 2 (h/c)", outStream.toString());
    }
}
