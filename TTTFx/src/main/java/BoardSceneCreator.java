import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class BoardSceneCreator {

    private Stage stage;

    public BoardSceneCreator(Stage stage) {
        this.stage = stage;
    }

    public BoardController setUpController(FXMLLoader loader, Player player1, Player player2, TurnHandler turnHandler) {
        Board board = new Board(3);
        Game game = new Game(player1, player2);

        BoardController controller = loader.getController();
        controller.initData(game, player1, player2, board, turnHandler);

        return controller;
    }

    public void showScene(Parent parent) {
        Scene scene = new Scene(parent, 600, 475);
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
        stage.hide();
        stage.show();
    }

    public void doComputerTurnFirst(BoardController controller) {
        stage.setOnShown(event -> controller.doTurn());
    }

    public void doComputerTurns(BoardController controller) {
        stage.setOnShown(event -> controller.runComputerTurns());
    }
}
