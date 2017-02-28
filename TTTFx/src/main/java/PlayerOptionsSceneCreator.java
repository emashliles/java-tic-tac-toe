import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PlayerOptionsSceneCreator {
    private Stage stage;

    public PlayerOptionsSceneCreator(Stage stage) {
        this.stage = stage;
    }

    public void create() throws IOException {
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
