import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

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
}
