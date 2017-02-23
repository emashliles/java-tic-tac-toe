import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class BoardTests extends ApplicationTest {
    public void start(Stage stage) throws Exception {

        TTTFx ttt = new TTTFx();
        ttt.start(stage);
    }

    @Test
    public void canPrintBoard() {
        verifyThat("#Space_1", hasText(""));
        verifyThat("#Space_2", hasText(""));
        verifyThat("#Space_3", hasText(""));
        verifyThat("#Space_4", hasText(""));
        verifyThat("#Space_5", hasText(""));
        verifyThat("#Space_6", hasText(""));
        verifyThat("#Space_7", hasText(""));
        verifyThat("#Space_8", hasText(""));
        verifyThat("#Space_9", hasText(""));
    }
}
