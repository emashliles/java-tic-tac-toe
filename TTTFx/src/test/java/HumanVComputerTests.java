import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class HumanVComputerTests extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BoardPrinter.fxml"));
        Parent parent = loader.load();
        BoardSceneCreator boardSceneCreator = new BoardSceneCreator(stage);
        boardSceneCreator.setUpController(loader, new HumanFxPlayer(), new ComputerFxPlayer(), new HumanVComputerTurnHandler());
        boardSceneCreator.showScene(parent);
    }

    @Test
    public void computerMoveIsDisplayed() {
        clickOn("#Space_5");
        verifyThat("#Space_1", hasText("O"));
    }

    @Test
    public void displaysWinner() {
        clickOn("#Space_1");
        clickOn("#Space_4");
        clickOn("#Space_3");
        clickOn("#Space_6");
        verifyThat("#InfoText", hasText("Player O is the winner."));
    }
}
