import com.TTT.Board;
import com.TTT.MiniMax;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MiniMaxScoringTests {

    private MiniMax miniMax;
    private Board board;

    @Before
    public void setUp() {
        miniMax = new MiniMax();
        board = new Board(3);
    }

    @Test
    public void calculates0ScoreForTie() {
        board.placeMarker(0, "X");
        board.placeMarker(1, "O");
        board.placeMarker(2, "X");
        board.placeMarker(3, "X");
        board.placeMarker(4, "O");
        board.placeMarker(5, "X");
        board.placeMarker(6, "O");
        board.placeMarker(8, "O");

        assertEquals(0, miniMax.getScoreForMove(7,board));
    }

    @Test
    public void calculates10ForWinningMove() {
        board.placeMarker(0, "X");
        board.placeMarker(1, "O");
        board.placeMarker(2, "X");
        board.placeMarker(3, "X");
        board.placeMarker(4, "O");
        board.placeMarker(5, "X");

        assertEquals(10, miniMax.getScoreForMove(6, board));
    }

    @Test
    public void calculatesminus10forLoosingMove() {
        board.placeMarker(0, "O");
        board.placeMarker(1, "O");

        assertEquals(-10, miniMax.getScoreForMove(7, board));
    }
}