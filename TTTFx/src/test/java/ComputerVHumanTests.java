import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class ComputerVHumanTests extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BoardPrinter.fxml"));
        Parent parent = loader.load();
        BoardSceneCreator boardSceneCreator = new BoardSceneCreator(stage);

        BoardController controller = boardSceneCreator.setUpController(loader, new ComputerFxPlayer(), new HumanFxPlayer(), new ComputerVHumanTurnHandler());

        boardSceneCreator.doComputerTurnFirst(controller);
        boardSceneCreator.showScene(parent);
    }

    @Test
    public void computerMoveIsDisplayedFirst() {
        verifyThat("#Space_1", hasText("X"));
    }

}