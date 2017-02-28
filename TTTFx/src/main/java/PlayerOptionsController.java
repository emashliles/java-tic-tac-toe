import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.stage.Stage;

import java.io.IOException;

public class PlayerOptionsController {

    private Parent parent;
    private FXMLLoader loader;
    private BoardSceneCreator boardSceneCreator;

    public void initData(Stage stage) throws IOException {
        this.loader = new FXMLLoader(getClass().getResource("BoardPrinter.fxml"));
        this.parent = loader.load();
        boardSceneCreator = new BoardSceneCreator(stage);
    }

    public void HumanvHuman(ActionEvent actionEvent) throws IOException {
        boardSceneCreator.setUpController(loader, new HumanFxPlayer(), new HumanFxPlayer(), new HumanVHumanTurnHandler());
        boardSceneCreator.showScene(parent);
    }

    public void HumanVComputer(ActionEvent actionEvent) throws IOException {
        boardSceneCreator.setUpController(loader, new HumanFxPlayer(), new ComputerFxPlayer(), new HumanVComputerTurnHandler());
        boardSceneCreator.showScene(parent);
    }

    public void ComputerVHuman(ActionEvent actionEvent) throws IOException {
        BoardController controller = boardSceneCreator.setUpController(loader, new ComputerFxPlayer(), new HumanFxPlayer(), new ComputerVHumanTurnHandler());

        boardSceneCreator.doComputerTurnFirst(controller);
        boardSceneCreator.showScene(parent);
    }

    public void ComputerVComputer(ActionEvent actionEvent) throws IOException {
        BoardController controller = boardSceneCreator.setUpController(loader, new ComputerFxPlayer(), new ComputerFxPlayer(), new ComputerVComputerTurnHandler());

        boardSceneCreator.doComputerTurns(controller);
        boardSceneCreator.showScene(parent);
    }
}
