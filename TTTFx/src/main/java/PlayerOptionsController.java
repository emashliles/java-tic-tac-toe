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
        Stage stage = (Stage) hvh.getScene().getWindow();
        Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("BoardPrinter.fxml"));
        Scene scene = new Scene(parent, 300, 275);
        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
        stage.show();
    }
}
