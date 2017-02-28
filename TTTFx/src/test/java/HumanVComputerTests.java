import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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


        Board board = new Board(3);
        HumanFxPlayer player1 = new HumanFxPlayer();
        ComputerFxPlayer player2 = new ComputerFxPlayer();
        Game game = new Game(player1, player2);

        BoardPrinterController controller =
                loader.getController();
        HumanVComputerTurnHandler turnHandler = new HumanVComputerTurnHandler();
        controller.initData(game, player1, player2, board, turnHandler);

        Scene scene = new Scene(parent, 300, 275);
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void computerMoveIsDisplayed() {
        clickOn("#Space_5");
        verifyThat("#Space_1", hasText("O"));
    }
}
