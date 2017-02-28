import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;

public class PlayerOptionsController {

    @FXML
    private Button hvh;

    public void HumanvHuman(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BoardPrinter.fxml"));
        Stage stage = (Stage) hvh.getScene().getWindow();
        Parent parent = loader.load();


        Board board = new Board(3);
        HumanFxPlayer player1 = new HumanFxPlayer();
        HumanFxPlayer player2 = new HumanFxPlayer();
        Game game = new Game(player1, player2);

        HumanvHumanTurnHandler turnHandler = new HumanvHumanTurnHandler();

        BoardPrinterController controller =
                loader.getController();
        controller.initData(game, player1, player2, board, turnHandler, stage);

        Scene scene = new Scene(parent, 600, 475);
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
        stage.show();
    }


    public void HumanVComputer(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BoardPrinter.fxml"));
        Stage stage = (Stage) hvh.getScene().getWindow();
        Parent parent = loader.load();


        Board board = new Board(3);
        HumanFxPlayer player1 = new HumanFxPlayer();
        ComputerFxPlayer player2 = new ComputerFxPlayer();
        Game game = new Game(player1, player2);

        BoardPrinterController controller =
                loader.getController();

        HumanVComputerTurnHandler turnHandler = new HumanVComputerTurnHandler();

        controller.initData(game, player1, player2, board, turnHandler, stage);

        Scene scene = new Scene(parent, 600, 475);
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
        stage.show();
    }

    public void ComputerVHuman(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BoardPrinter.fxml"));
        Stage stage = (Stage) hvh.getScene().getWindow();
        Parent parent = loader.load();


        Board board = new Board(3);
        ComputerFxPlayer player1 = new ComputerFxPlayer();
        HumanFxPlayer player2 = new HumanFxPlayer();
        Game game = new Game(player1, player2);

        game.doTurn(board);

        BoardPrinterController controller =
                loader.getController();

        ComputerVHumanTurnHandler turnHandler = new ComputerVHumanTurnHandler();

        controller.initData(game, player1, player2, board, turnHandler, stage);

        Scene scene = new Scene(parent, 600, 475);
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
        stage.show();
    }

    public void ComputerVComputer(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("BoardPrinter.fxml"));
        Stage stage = (Stage) hvh.getScene().getWindow();
        Parent parent = loader.load();


        Board board = new Board(3);
        ComputerFxPlayer player1 = new ComputerFxPlayer();
        ComputerFxPlayer player2 = new ComputerFxPlayer();
        Game game = new Game(player1, player2);

        BoardPrinterController controller =
                loader.getController();

        ComputerVComputerTurnHandler turnHandler = new ComputerVComputerTurnHandler();

        controller.initData(game, player1, player2, board, turnHandler, stage);

        Scene scene = new Scene(parent, 600, 475);
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
        stage.setOnShown(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                controller.doTurns();
            }
        });
        stage.hide();
        stage.show();
    }
}
