import com.TTT.Board;
import com.TTT.MiniMax;
import com.TTT.PlayerMarkers;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BenchmarkMiniMax {

    private Board board;
    private MiniMax miniMax;

    @Before
    public void setUp() {
        board = new Board(4);
        miniMax = new MiniMax();
    }

    @Test
    public void firstMoveLessThan200ms() {
        long startTime = System.currentTimeMillis();
        miniMax.nextMove(board, PlayerMarkers.X);
        long stopTime = System.currentTimeMillis();

        long totalTime = stopTime - startTime;
        assertEquals(totalTime, 100, 100);
    }

    @Test
    public void averageTimeForEndGameMove() {
        long startTime = System.currentTimeMillis();

        int i = 0;
        while(i < 100) {
            board.placeMarker(0, "X");
            board.placeMarker(1, "O");
            board.placeMarker(2, "X");
            board.placeMarker(3, "X");
            board.placeMarker(4, "O");
            board.placeMarker(5, "X");
            board.placeMarker(6, "O");
            board.placeMarker(8, "O");
            miniMax.nextMove(board, PlayerMarkers.X);
            i++;
        }

        long stopTime = System.currentTimeMillis();

        long totalTime = stopTime - startTime;
        assertEquals(totalTime, 1000, 1000);
    }

    @Test
    public void extendLine() {
        board.placeMarker(0, "X");
        board.placeMarker(1, "O");
        board.placeMarker(2, "X");
        board.placeMarker(3, "O");
        board.placeMarker(4, "X");
        board.placeMarker(5, "O");

        long startTime = System.currentTimeMillis();
        miniMax.nextMove(board, PlayerMarkers.X);
        long stopTime = System.currentTimeMillis();

        long totalTime = stopTime - startTime;
        assertEquals(totalTime, 100, 100);
    }

    @Test
    public void blockOpponentLine() {
        board.placeMarker(0, "O");
        board.placeMarker(1, "O");
        board.placeMarker(4, "X");
        board.placeMarker(7, "X");

        long startTime = System.currentTimeMillis();
        miniMax.nextMove(board, PlayerMarkers.X);
        long stopTime = System.currentTimeMillis();

        long totalTime = stopTime - startTime;
        assertEquals(totalTime, 100, 100);
    }

    @Test
    public void blockOpponentRightToLeftDiagonal() {
        board.placeMarker(0, "X");
        board.placeMarker(1, "O");
        board.placeMarker(2, "O");
        board.placeMarker(4, "X");

        long startTime = System.currentTimeMillis();
        miniMax.nextMove(board, PlayerMarkers.X);
        long stopTime = System.currentTimeMillis();

        long totalTime = stopTime - startTime;
        assertEquals(totalTime, 100, 100);
    }

    @Test
    public void blockOpponentLeftToRightDiagonal() {
        board.placeMarker(0, "X");
        board.placeMarker(1, "O");
        board.placeMarker(2, "X");
        board.placeMarker(4, "X");
        board.placeMarker(8, "O");

        long startTime = System.currentTimeMillis();
        miniMax.nextMove(board, PlayerMarkers.X);
        long stopTime = System.currentTimeMillis();

        long totalTime = stopTime - startTime;
        assertEquals(totalTime, 100, 100);
    }
}
