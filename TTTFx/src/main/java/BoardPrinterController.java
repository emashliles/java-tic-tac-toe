import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class BoardPrinterController {
    private Game game;
    private HumanFxPlayer humanFxPlayer;
    private Board board;

    public void initData(Game game, HumanFxPlayer humanFxPlayer, Board board) {
        this.humanFxPlayer = humanFxPlayer;
        this.game = game;
        this.board = board;
    }

    @FXML
    protected void buttonPressed(ActionEvent actionEvent) {
        PlayerMarkers marker = game.getCurrentPlayer();
        Button space = (Button)actionEvent.getSource();
        String s = space.getId();
        String spaceString = s.split("_")[1];
        humanFxPlayer.getUserInput(Integer.parseInt(spaceString) -1);
        game.doTurn();
        space.setText(marker.symbol());
    }
}
