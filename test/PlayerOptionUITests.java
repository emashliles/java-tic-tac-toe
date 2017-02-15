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
    public void promptUserForOption() {
        ByteArrayInputStream in = new ByteArrayInputStream("h\n".getBytes());
        optionUI = new PlayerOptionUI(out, in);
        optionUI.playerOption();

        assertEquals("Please enter your choice: ", outStream.toString());
    }

    @Test
    public void returnHumanPlayer() {
        ByteArrayInputStream in = new ByteArrayInputStream("h\n".getBytes());
        optionUI = new PlayerOptionUI(out, in);

        Player player = optionUI.playerOption();
        assertTrue(player instanceof HumanPlayer);
    }

    @Test
    public void returnComputerPlayer() {
        ByteArrayInputStream in = new ByteArrayInputStream("c\n".getBytes());
        optionUI = new PlayerOptionUI(out, in);

        Player player = optionUI.playerOption();
        assertTrue(player instanceof ComputerPlayer);
    }

    @Test
    public void ensureValidInput() {
        ByteArrayInputStream in = new ByteArrayInputStream("hello\nh".getBytes());
        optionUI = new PlayerOptionUI(out, in);

        optionUI.playerOption();

        assertEquals("Please enter your choice: Please try that again: ", outStream.toString());
    }

    @Test
    public void introduceOptions() {
        ByteArrayInputStream in = new ByteArrayInputStream("hello\nh".getBytes());

        optionUI = new PlayerOptionUI(out, in);
        optionUI.introduce();

        assertEquals("Please select a player type for each player." +
                "\nYou can choose human by entering h or computer by entering c.\n", outStream.toString());

    }
}
