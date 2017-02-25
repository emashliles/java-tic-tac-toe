import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class BoardTests extends ApplicationTest {

    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BoardPrinter.fxml"));
        Parent parent = loader.load();


        Board board = new Board(3);
        HumanFxPlayer player1 = new HumanFxPlayer();
        Player player2 = new HumanFxPlayer();
        Game game = new Game(board, player1, player2);

        BoardPrinterController controller =
                loader.<BoardPrinterController>getController();
        controller.initData(game, player1, board);

        Scene scene = new Scene(parent, 300, 275);
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
        stage.show();
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
}
