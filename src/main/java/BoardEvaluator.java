import java.util.HashSet;
import java.util.Set;

public class BoardEvaluator {
    private Board board;

    public BoardEvaluator(Board board) {
        this.board = board;
    }

    public GameState evaluate() {
        GameState gameState = GameState.NoWinner;

        for (Line line :
                board.allLines()) {
            if(checkLineIsWin(line)){
                gameState = GameState.Win;
            }
        }

        return checkBoardIsTied(gameState);
    }

    private GameState checkBoardIsTied(GameState gameState) {
        Set spaceMarkers = new HashSet();
        for (int i = 0; i < board.size(); i++){
            spaceMarkers.add(board.markerAt(i));
        }

        if(spaceMarkers.size() == 2) {
            gameState = GameState.Tie;
        }
        return gameState;
    }

    public boolean checkLineIsWin(Line line) {
        boolean win = false;
        Set spaceMarkers = new HashSet();

        for(int i = 0; i < line.size(); i++) {
            spaceMarkers.add(board.markerAt(line.getSpaceIndex(i)));
        }

        if (spaceMarkers.size() == 1) {
            win = true;
        }
        return win;
    }
}
