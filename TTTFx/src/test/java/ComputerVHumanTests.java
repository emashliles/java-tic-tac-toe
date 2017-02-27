import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
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


        Board board = new Board(3);
        ComputerFxPlayer player1 = new ComputerFxPlayer();
        HumanFxPlayer player2 = new HumanFxPlayer();
        Game game = new Game(player1, player2);

        game.doTurn(board);

        BoardPrinterController controller =
                loader.getController();
        ComputerVHumanTurnHandler turnHandler = new ComputerVHumanTurnHandler();
        controller.initData(game, player1, player2, board, turnHandler);

        Scene scene = new Scene(parent, 300, 275);
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
        stage.show();
    }

    @Test
    public void computerMoveIsDisplayedFirst() {
        verifyThat("#Space_1", hasText("X"));
    }

}