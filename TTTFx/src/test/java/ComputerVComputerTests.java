import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class ComputerVComputerTests extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BoardPrinter.fxml"));
        Parent parent = loader.load();
        BoardSceneCreator boardSceneCreator = new BoardSceneCreator(stage);

        BoardController controller = boardSceneCreator.setUpController(loader, new ComputerFxPlayer(), new ComputerFxPlayer(), new ComputerVComputerTurnHandler());

        boardSceneCreator.doComputerTurns(controller);
        boardSceneCreator.showScene(parent);
    }

    @Test
    public void computerMovesAreAllDisplayed() {
        sleep(9000);
        verifyThat("#Space_1", hasText("X"));
        verifyThat("#Space_2", hasText("O"));
        verifyThat("#Space_3", hasText("X"));
        verifyThat("#Space_4", hasText("O"));
        verifyThat("#Space_5", hasText("O"));
        verifyThat("#Space_6", hasText("X"));
        verifyThat("#Space_7", hasText("O"));
        verifyThat("#Space_8", hasText("X"));
        verifyThat("#Space_9", hasText("X"));
    }
}
