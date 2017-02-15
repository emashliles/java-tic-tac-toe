import com.TTT.ComputerPlayer;
import com.TTT.HumanPlayer;
import com.TTT.Player;
import com.TTT.PlayerOptionUI;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;

public class PlayerOptionUITests {

    private ByteArrayOutputStream outStream;
    private PrintStream out;
    private PlayerOptionUI optionUI;

    @Before
    public void setUp() {
        outStream = new ByteArrayOutputStream();
        out = new PrintStream(outStream);
    }

    @Test
    public void askUserForPlayer1Option() {
        ByteArrayInputStream in = new ByteArrayInputStream("h\n".getBytes());
        optionUI = new PlayerOptionUI(out, in);
        optionUI.playerOption(1);

        assertEquals("Player 1 (h/c): ", outStream.toString());
    }

    @Test
    public void askUserForPlayer2Option() {
        ByteArrayInputStream in = new ByteArrayInputStream("h\n".getBytes());
        optionUI = new PlayerOptionUI(out, in);
        optionUI.playerOption(2);

        assertEquals("Player 2 (h/c): ", outStream.toString());
    }

    @Test
    public void returnHumanPlayerIfUserRequests() {
        ByteArrayInputStream in = new ByteArrayInputStream("h\n".getBytes());
        optionUI = new PlayerOptionUI(out, in);

        Player player = optionUI.playerOption(1);
        assertTrue(player instanceof HumanPlayer);
    }

    @Test
    public void returnComputerPlayerIfUserRequests() {
        ByteArrayInputStream in = new ByteArrayInputStream("c\n".getBytes());
        optionUI = new PlayerOptionUI(out, in);

        Player player = optionUI.playerOption(1);
        assertTrue(player instanceof ComputerPlayer);
    }

    @Test
    public void askForSelectionAgainIfInputInvalid() {
        ByteArrayInputStream in = new ByteArrayInputStream("hello\nh".getBytes());

        optionUI = new PlayerOptionUI(out, in);

        optionUI.playerOption(1);

        assertEquals("Player 1 (h/c): Please try that again - enter h for human player or c for computer player :", outStream.toString());
    }
}
