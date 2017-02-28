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
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PlayerOptions.fxml"));
        Parent PlayerOptions = loader.load();
        PlayerOptionsController controller = loader.getController();
        controller.initData(stage);

        Scene scene = new Scene(PlayerOptions, 600, 475);
        stage.setTitle("Player Options");
        stage.setScene(scene);
        stage.show();
    }


}
