import javafx.application.Application;
import javafx.stage.Stage;

import java.io.IOException;

public class TTTFx extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        PlayerOptionsSceneCreator sceneCreator = new PlayerOptionsSceneCreator(stage);
        sceneCreator.create();
    }
}
