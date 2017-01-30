import com.TTT.Board;

public class Game {

    private Board board;

    public Game(Board board) {
        this.board = board;
    }

    public boolean isOver() {
        return false;
    }

    public void doTurn(int space, String marker) {
        board.placeMarker(space, marker);
    }
}
