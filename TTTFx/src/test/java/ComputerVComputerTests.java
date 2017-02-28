import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import org.junit.Test;
import org.testfx.framework.junit.ApplicationTest;

import static org.testfx.api.FxAssert.verifyThat;
import static org.testfx.matcher.control.LabeledMatchers.hasText;

public class ComputerVComputerTests extends ApplicationTest {

    @Override
    public void start(Stage stage) throws Exception {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BoardPrinter.fxml"));
        Parent parent = loader.load();


        Board board = new Board(3);
        ComputerFxPlayer player1 = new ComputerFxPlayer();
        ComputerFxPlayer player2 = new ComputerFxPlayer();
        Game game = new Game(player1, player2);

        game.doTurn(board);

        BoardController controller =
                loader.getController();
        ComputerVComputerTurnHandler turnHandler = new ComputerVComputerTurnHandler();
        controller.initData(game, player1, player2, board, turnHandler);

        Scene scene = new Scene(parent, 300, 275);
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);

        stage.setOnShown(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                controller.runComputerTurns();
            }
        });
        stage.show();
    }

    @Test
    public void computerMovesAreAllDisplayed() {
        sleep(10000);
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
