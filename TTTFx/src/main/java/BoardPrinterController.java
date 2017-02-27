import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BoardPrinterController {
    private Game game;
    private HumanFxPlayer player1;
    private HumanFxPlayer player2;
    private Board board;
    @FXML
    private Label GameOutcome;

    @FXML
    private Button Space_1;
    @FXML
    private Button Space_2;
    @FXML
    private Button Space_3;
    @FXML
    private Button Space_4;
    @FXML
    private Button Space_5;
    @FXML
    private Button Space_6;
    @FXML
    private Button Space_7;
    @FXML
    private Button Space_8;
    @FXML
    private Button Space_9;

    private List<Button> spaces;

    public void initData(Game game, HumanFxPlayer humanFxPlayer, HumanFxPlayer player2, Board board) {
        this.player1 = humanFxPlayer;
        this.game = game;
        this.player2 = player2;
        this.board = board;
        GridPane.setColumnSpan(GameOutcome, GridPane.REMAINING);
        spaces = new ArrayList<>();
        spaces.add(Space_1);
        spaces.add(Space_2);
        spaces.add(Space_3);
        spaces.add(Space_4);
        spaces.add(Space_5);
        spaces.add(Space_6);
        spaces.add(Space_7);
        spaces.add(Space_8);
        spaces.add(Space_9);
    }

    @FXML
    protected void buttonPressed(ActionEvent actionEvent) throws IOException {
        GameOutcome.setText("");

        PlayerMarkers marker = game.getCurrentPlayer();
        Button space = (Button)actionEvent.getSource();

        if(space.getText() != "") {
            GameOutcome.setText("Space already selected.");
            return;
        }

        if(game.isOver(board) == GameState.Win|| game.isOver(board) == GameState.Tie) {
            return;
        }

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

        if(game.isOver(board) == GameState.Tie) {
            GameOutcome.setText("This game is a tie.");
        }

        updateBoard();
    }

    private void updateBoard() throws IOException {
        for(int i = 0; i < board.size(); i++) {
            if(board.markerAt(i) == PlayerMarkers.X.symbol() || board.markerAt(i) == PlayerMarkers.O.symbol()) {
                Button space = spaces.get(i);
                space.setText(board.markerAt(i));
            }
        }
    }
}
