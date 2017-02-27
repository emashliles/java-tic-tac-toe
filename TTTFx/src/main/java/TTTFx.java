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
        Parent parent = FXMLLoader.load(getClass().getClassLoader().getResource("PlayerOptions.fxml"));
        Scene scene = new Scene(parent, 600, 475);
        stage.setTitle("Player Options");
        stage.setScene(scene);
        stage.show();
    }


}
