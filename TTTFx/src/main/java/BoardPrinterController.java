import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class BoardPrinterController{
    private Game game;
    private Player player1;
    private Player player2;
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

    @FXML
    private Stage stage;

    private List<Button> spaces;
    private TurnHandler turnHandler;

    public void initData(Game game, Player player1, Player player2, Board board, TurnHandler turnHandler, Stage stage) {
        this.player1 = player1;
        this.game = game;
        this.player2 = player2;
        this.board = board;
        this.turnHandler = turnHandler;
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
        updateBoard();
        this.stage = stage;
        stage.setOnShown(new EventHandler<WindowEvent>() {
            @Override
            public void handle(WindowEvent event) {
                try {
                    doTurns();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @FXML
    protected void buttonPressed(ActionEvent actionEvent) throws IOException {
        GameOutcome.setText("");

        PlayerMarkers marker = game.getCurrentPlayer();
        Button space = (Button)actionEvent.getSource();

        if (checkForGameOver(space)) return;

        String spaceString = getButtonFxId(space);

        turnHandler.getPlayerTurn(spaceString, player1, player2, game.getCurrentPlayer());

        doTurn();

        setGameOverMessage(marker);

        updateBoard();
    }

    private void doTurn() {
        turnHandler.doTurn(game, board);
    }

    private boolean checkForGameOver(Button space) {
        if(space.getText() != "") {
            GameOutcome.setText("Space already selected.");
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
            GameOutcome.setText("Player " + marker.symbol() + " is the winner.");
        }

        if(game.isOver(board) == GameState.Tie) {
            GameOutcome.setText("This game is a tie.");
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

    public void doTurns() throws InterruptedException {
        while (game.isOver(board) == GameState.NoWinner) {
            game.doTurn(board);
            updateBoard();
            setGameOverMessage(game.getCurrentPlayer());
        }
    }
}
