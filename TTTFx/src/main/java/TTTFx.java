import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class TTTFx extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("BoardPrinter.fxml"));
        Scene scene = new Scene(root, 300, 275);

        stage.setTitle("Tic Tac Toe");
        stage.setScene(scene);
        stage.show();
    }
}
