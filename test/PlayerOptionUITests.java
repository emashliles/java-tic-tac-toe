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
    private GameUI gameUI;

    @Before
    public void setUp() {
        outStream = new ByteArrayOutputStream();
        out = new PrintStream(outStream);
        gameUI = new GameUI(out, new BoardPrinter(out));
    }

    @Test
    public void promptUserForOption() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\n".getBytes());
        optionUI = new PlayerOptionUI(out, in, gameUI);
        optionUI.playerOption();

        assertEquals("Please enter your choice: ", outStream.toString());
    }

    @Test
    public void return2HumanPlayers() {
        ByteArrayInputStream in = new ByteArrayInputStream("1\n".getBytes());
        optionUI = new PlayerOptionUI(out, in, gameUI);

        optionUI.playerOption();
        assertTrue(optionUI.player(1) instanceof HumanPlayer);
        assertTrue(optionUI.player(2) instanceof HumanPlayer);
    }

    @Test
    public void return2ComputerPlayers() {
        ByteArrayInputStream in = new ByteArrayInputStream("4\n".getBytes());
        optionUI = new PlayerOptionUI(out, in, gameUI);

        optionUI.playerOption();

        assertTrue(optionUI.player(1) instanceof ComputerPlayer);
        assertTrue(optionUI.player(2) instanceof ComputerPlayer);
    }

    @Test
    public void return1ComputerPlayer1HumanPlayer() {
        ByteArrayInputStream in = new ByteArrayInputStream("3\n".getBytes());
        optionUI = new PlayerOptionUI(out, in, gameUI);

        optionUI.playerOption();

        assertTrue(optionUI.player(1) instanceof ComputerPlayer);
        assertTrue(optionUI.player(2) instanceof HumanPlayer);
    }

    @Test
    public void ensureValidInput() {
        ByteArrayInputStream in = new ByteArrayInputStream("hello\n2".getBytes());
        optionUI = new PlayerOptionUI(out, in, gameUI);

        optionUI.playerOption();

        assertEquals("Please enter your choice: Please try that again: ", outStream.toString());
    }

    @Test
    public void introduceOptions() {
        ByteArrayInputStream in = new ByteArrayInputStream("hello\nhh".getBytes());

        optionUI = new PlayerOptionUI(out, in, gameUI);
        optionUI.introduce();

        assertEquals("\033[H\033[2JPlease select what players you would like.\n" +
                "\u001B[31m 1 \u001B[0m- Human v Human\n" +
                "\u001B[31m 2 \u001B[0m- Human v Computer\n" +
                "\u001B[31m 3 \u001B[0m- Computer v Human\n" +
                "\u001B[31m 4 \u001B[0m- Computer v Computer\n", outStream.toString());

    }
}
