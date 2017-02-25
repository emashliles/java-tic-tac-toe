import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class PlayerOptionsTests extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        TTTFx ttt = new TTTFx();
        ttt.start(stage);
    }

    @Test
    public void displayOptionsForPlayerCombinations() {
        verifyThat("#hvh", hasText("Human v Human"));
    }
}
