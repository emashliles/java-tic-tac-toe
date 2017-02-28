import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PlayerOptionsController {

    @FXML
    private Stage stage;

    private Parent parent;
    private FXMLLoader loader;

    public void initData(Stage stage) throws IOException {
        this.stage = stage;
        this.loader = new FXMLLoader(getClass().getResource("BoardPrinter.fxml"));
        this.parent = loader.load();
    }

    public void HumanvHuman(ActionEvent actionEvent) throws IOException {
        setUpController(loader, new HumanFxPlayer(), new HumanFxPlayer(), new HumanVHumanTurnHandler());

        showScene(parent);
    }

    public void HumanVComputer(ActionEvent actionEvent) throws IOException {
        setUpController(loader, new HumanFxPlayer(), new ComputerFxPlayer(), new HumanVComputerTurnHandler());

        showScene(parent);
    }

    public void ComputerVHuman(ActionEvent actionEvent) throws IOException {
        BoardController controller = setUpController(loader, new ComputerFxPlayer(), new HumanFxPlayer(), new ComputerVHumanTurnHandler());

        stage.setOnShown(event -> controller.doTurn());
        showScene(parent);
    }

    public void ComputerVComputer(ActionEvent actionEvent) throws IOException {
        BoardController controller = setUpController(loader, new ComputerFxPlayer(), new ComputerFxPlayer(), new ComputerVComputerTurnHandler());

        stage.setOnShown(event -> controller.runComputerTurns());
        showScene(parent);
    }

    private BoardController setUpController(FXMLLoader loader, Player player1, Player player2, TurnHandler turnHandler) {
        Board board = new Board(3);
        Game game = new Game(player1, player2);

        BoardController controller =
                loader.getController();

        controller.initData(game, player1, player2, board, turnHandler);

        return controller;
    }

    private void showScene(Parent parent) {
        Scene scene = new Scene(parent, 600, 475);
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
        stage.hide();
        stage.show();
    }
}
