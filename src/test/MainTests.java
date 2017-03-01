import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

public class MainTests {

    @Test
    public void offerReplayOption() {
        ByteArrayInputStream in = new ByteArrayInputStream("y\n".getBytes());
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);

        Main.replay(in, out);

        assertEquals(outStream.toString(), "Replay? y/n ");
    }

    @Test
    public void canReplayIfRequested() {
        ByteArrayInputStream in = new ByteArrayInputStream("y\n".getBytes());
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);

        boolean replay = Main.replay(in, out);

        assertTrue(replay);
    }

    @Test
    public void noReplayIfNotRequested() {
        ByteArrayInputStream in = new ByteArrayInputStream("n\n".getBytes());
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);

        boolean replay = Main.replay(in, out);

        assertFalse(replay);
    }

    @Test
    public void handleInvalidInput() {
        ByteArrayInputStream in = new ByteArrayInputStream("hello\nn\n".getBytes());
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);

        Main.replay(in, out);

        assertEquals(outStream.toString(), "Replay? y/n Please try that again y/n");

    }
}
