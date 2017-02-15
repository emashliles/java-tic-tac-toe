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
        ByteArrayInputStream in = new ByteArrayInputStream("hh\n".getBytes());
        optionUI = new PlayerOptionUI(out, in);
        optionUI.playerOption();

        assertEquals("Please enter your choice: ", outStream.toString());
    }

    @Test
    public void return2HumanPlayers() {
        ByteArrayInputStream in = new ByteArrayInputStream("hh\n".getBytes());
        optionUI = new PlayerOptionUI(out, in);

        optionUI.playerOption();
        Player player1 = optionUI.getPlayer(1);
        Player player2 = optionUI.getPlayer(2);
        assertTrue(player1 instanceof HumanPlayer);
        assertTrue(player2 instanceof HumanPlayer);
    }

    @Test
    public void return2ComputerPlayers() {
        ByteArrayInputStream in = new ByteArrayInputStream("cc\n".getBytes());
        optionUI = new PlayerOptionUI(out, in);

        optionUI.playerOption();

        Player player1 = optionUI.getPlayer(1);
        Player player2 = optionUI.getPlayer(2);

        assertTrue(player1 instanceof ComputerPlayer);
        assertTrue(player2 instanceof ComputerPlayer);
    }

    @Test
    public void return1ComputerPlayer1HumanPlayer() {
        ByteArrayInputStream in = new ByteArrayInputStream("ch\n".getBytes());
        optionUI = new PlayerOptionUI(out, in);

        optionUI.playerOption();

        Player player1 = optionUI.getPlayer(1);
        Player player2 = optionUI.getPlayer(2);

        assertTrue(player1 instanceof ComputerPlayer);
        assertTrue(player2 instanceof HumanPlayer);
    }

    @Test
    public void ensureValidInput() {
        ByteArrayInputStream in = new ByteArrayInputStream("hello\nhh".getBytes());
        optionUI = new PlayerOptionUI(out, in);

        optionUI.playerOption();

        assertEquals("Please enter your choice: Please try that again: ", outStream.toString());
    }

    @Test
    public void introduceOptions() {
        ByteArrayInputStream in = new ByteArrayInputStream("hello\nhh".getBytes());

        optionUI = new PlayerOptionUI(out, in);
        optionUI.introduce();

        assertEquals("Please select what players you would like.\n" +
                "For Human v Human enter hh\n" +
                "For Human v Computer enter hc\n" +
                "For Computer v Human enter ch\n" +
                "For Computer v Computer enter cc\n", outStream.toString());

    }
}
