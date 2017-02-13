import com.TTT.HumanPlayer;
import com.TTT.IPlayer;
import com.TTT.PlayerOptionsUI;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class PlayerOptionsUITests {

    @Test
    public void allowUserToSelectTwoHumanPlayers() {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);
        ByteArrayInputStream in = new ByteArrayInputStream("h\nh".getBytes());

        PlayerOptionsUI playerOptionsUI = new PlayerOptionsUI(in, out);

        IPlayer player1 = playerOptionsUI.getPlayer1();

        assertThat(player1 instanceof HumanPlayer, is(true));
    }
}
