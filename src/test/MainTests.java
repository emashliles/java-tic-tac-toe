import org.junit.Before;
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
        ReplayUi replay = new ReplayUi(in);

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);

        replay.replay(out);

        assertEquals(outStream.toString(), "Replay? y/n ");
    }

    @Test
    public void canReplayIfRequested() {
        ByteArrayInputStream in = new ByteArrayInputStream("y\n".getBytes());
        ReplayUi replay = new ReplayUi(in);

        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);

        boolean replayOption = replay.replay(out);

        assertTrue(replayOption);
    }

    @Test
    public void noReplayIfNotRequested() {
        ByteArrayInputStream in = new ByteArrayInputStream("n\n".getBytes());
        ReplayUi replay = new ReplayUi(in);
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);

        boolean replayOption = replay.replay(out);

        assertFalse(replayOption);
    }

    @Test
    public void handleInvalidInput() {
        ByteArrayInputStream in = new ByteArrayInputStream("hello\nn\n".getBytes());
        ReplayUi replay = new ReplayUi(in);
        ByteArrayOutputStream outStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outStream);

        replay.replay(out);

        assertEquals(outStream.toString(), "Replay? y/n Please try that again y/n");
    }
}
