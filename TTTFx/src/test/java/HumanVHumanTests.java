import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class HumanVHumanTests extends ApplicationTest {

    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BoardPrinter.fxml"));
        Parent parent = loader.load();
        BoardSceneCreator boardSceneCreator = new BoardSceneCreator(stage);
        boardSceneCreator.setUpController(loader, new HumanFxPlayer(), new HumanFxPlayer(), new HumanVHumanTurnHandler());
        boardSceneCreator.showScene(parent);
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

    @Test
    public void canPrintBoardWithMovesMade() {
        clickOn("#Space_2");
        clickOn("#Space_8");
        verifyThat("#Space_1", hasText(""));
        verifyThat("#Space_2", hasText("X"));
        verifyThat("#Space_3", hasText(""));
        verifyThat("#Space_4", hasText(""));
        verifyThat("#Space_5", hasText(""));
        verifyThat("#Space_6", hasText(""));
        verifyThat("#Space_7", hasText(""));
        verifyThat("#Space_8", hasText("O"));
        verifyThat("#Space_9", hasText(""));
    }

    @Test
    public void humanCanMakeMove() {
        clickOn("#Space_2");
        verifyThat("#Space_2", hasText("X"));
    }

    @Test
    public void declaresWinner() {
        clickOn("#Space_1");
        clickOn("#Space_2");
        clickOn("#Space_3");
        clickOn("#Space_4");
        clickOn("#Space_5");
        clickOn("#Space_6");
        clickOn("#Space_7");
        verifyThat("#InfoText", hasText("Player X is the winner."));
    }

    @Test
    public void declaresTie() {
        clickOn("#Space_1");
        clickOn("#Space_2");
        clickOn("#Space_3");
        clickOn("#Space_5");
        clickOn("#Space_4");
        clickOn("#Space_7");
        clickOn("#Space_6");
        clickOn("#Space_9");
        clickOn("#Space_8");
        verifyThat("#InfoText", hasText("This game is a tie."));
    }

    @Test
    public void displaysMessageWhenSameSpaceSelected() {
        clickOn("#Space_2");
        clickOn("#Space_2");
        verifyThat("#InfoText", hasText("Space already selected."));
    }

    @Test
    public void markersCannotBePlacedWhenGameOver() {
        clickOn("#Space_1");
        clickOn("#Space_2");
        clickOn("#Space_3");
        clickOn("#Space_4");
        clickOn("#Space_5");
        clickOn("#Space_6");
        clickOn("#Space_7");
        clickOn("#Space_8");
        verifyThat("#Space_8", hasText(""));
    }

    @Test
    public void canReplayGame() {
        clickOn("#Space_1");
        clickOn("#Space_2");
        clickOn("#Space_3");
        clickOn("#Space_4");
        clickOn("#Space_5");
        clickOn("#Space_6");
        clickOn("#Space_7");
        clickOn("#Replay");
        verifyThat("#hvh", hasText("Human v Human"));
    }
}
