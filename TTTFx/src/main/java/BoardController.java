import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class BoardController {
    private Game game;
    private Player player1;
    private Player player2;
    private Board board;

    @FXML
    private Label InfoText;

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
    private TurnHandler turnHandler;

    public void initData(Game game, Player player1, Player player2, Board board, TurnHandler turnHandler) {
        this.player1 = player1;
        this.game = game;
        this.player2 = player2;
        this.board = board;
        this.turnHandler = turnHandler;
        spaces = new ArrayList<>();
        addSpacesToList();

        allowTextToSpanMultipleColumns();

        updateBoard();
    }

    private void allowTextToSpanMultipleColumns() {
        GridPane.setColumnSpan(InfoText, GridPane.REMAINING);
    }

    public void runComputerTurns() {
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(new Runnable() {
                    @Override
                    public void run() {
                        doTurns();
                    }
                });

            }
        }, 1000, 1000);

    }

    @FXML
    protected void spaceSelected(ActionEvent actionEvent) throws IOException {
        setInfoText("");

        PlayerMarkers marker = game.getCurrentPlayer();
        Button space = (Button)actionEvent.getSource();

        if (checkForGameOver(space)) return;

        String spaceString = getButtonFxId(space);

        turnHandler.getPlayerTurn(spaceString, player1, player2, game.getCurrentPlayer());

        turnHandler.doTurn(game, board);

        setGameOverMessage(marker);

        updateBoard();
    }

    private void doTurns() {
        if (game.isOver(board) == GameState.NoWinner) {
            game.doTurn(board);
            updateBoard();
            setGameOverMessage(game.getCurrentPlayer());
        }
    }

    private void setInfoText(String value) {
        InfoText.setText(value);
    }

    private boolean checkForGameOver(Button space) {
        if(space.getText() != "") {
            setInfoText("Space already selected.");
            return true;
        }

        if(game.isOver(board) == GameState.Win|| game.isOver(board) == GameState.Tie) {
            return true;
        }
        return false;
    }

    private String getButtonFxId(Button space) {
        String s = space.getId();
        return s.split("_")[1];
    }

    private void setGameOverMessage(PlayerMarkers marker) {
        if(game.isOver(board) == GameState.Win) {
            setInfoText("Player " + marker.symbol() + " is the winner.");
        }

        if(game.isOver(board) == GameState.Tie) {
            setInfoText("This game is a tie.");
        }
    }

    private void updateBoard() {
        for(int i = 0; i < board.size(); i++) {
            if(board.markerAt(i) == PlayerMarkers.X.symbol() || board.markerAt(i) == PlayerMarkers.O.symbol()) {
                Button space = spaces.get(i);
                space.setText(board.markerAt(i));
            }
        }
    }

    private void addSpacesToList() {
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
}
