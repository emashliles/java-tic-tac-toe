import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class BoardPrinterController {
    private Game game;
    private HumanFxPlayer player1;
    private HumanFxPlayer player2;
    private Board board;
    @FXML
    private Label GameOutcome;

    public void initData(Game game, HumanFxPlayer humanFxPlayer, HumanFxPlayer player2, Board board) {
        this.player1 = humanFxPlayer;
        this.game = game;
        this.player2 = player2;
        this.board = board;
    }

    @FXML
    protected void buttonPressed(ActionEvent actionEvent) {
        PlayerMarkers marker = game.getCurrentPlayer();
        Button space = (Button)actionEvent.getSource();
        String s = space.getId();
        String spaceString = s.split("_")[1];

        if(game.getCurrentPlayer() == PlayerMarkers.X) {
            player1.getUserInput(Integer.parseInt(spaceString) - 1);
        }
        else {
            player2.getUserInput(Integer.parseInt(spaceString) - 1);
        }

        game.doTurn(board);
        if(game.isOver(board) == GameState.Win) {
            GameOutcome.setText("Player " + marker.symbol() + " is the winner.");
        }
        space.setText(marker.symbol());
    }
}
