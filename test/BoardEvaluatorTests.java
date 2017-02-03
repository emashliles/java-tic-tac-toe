import com.TTT.Board;
import com.TTT.BoardEvaluator;
import com.TTT.GameState;
import com.TTT.TTTLine;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BoardEvaluatorTests{

    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void canDetectNoPlayerHasWon() {
        BoardEvaluator evaluator = new BoardEvaluator(board);

        assertThat(evaluator.evaluate(), is(GameState.NoWinner));
    }

    @Test
    public void canDetectAWinningColumnFromIndexes() {
        board.placeMarker(0, "X");
        board.placeMarker(3, "X");
        board.placeMarker(6, "X");

        BoardEvaluator evaluator = new BoardEvaluator(board);

        TTTLine column = board.getColumn(0);

        assertEquals(evaluator.checkLineIsWin(column), true);
    }

    @Test
    public void canDetectAWinningRowFromIndexes() {
        board.placeMarker(6, "X");
        board.placeMarker(7, "X" );
        board.placeMarker(8, "X" );

        BoardEvaluator evaluator = new BoardEvaluator(board);
        TTTLine row = board.getRow(2);

        assertThat(evaluator.checkLineIsWin(row), is(true));
    }

    @Test
    public void canDetectAWinningDiagonalFromIndexes() {
        board.placeMarker(0, "X");
        board.placeMarker(4, "X" );
        board.placeMarker(8, "X" );

        BoardEvaluator evaluator = new BoardEvaluator(board);
        TTTLine diagonal = board.getLeftToRightDiagonal();

        assertThat(evaluator.checkLineIsWin(diagonal), is(true));
    }

    @Test
    public void canDetectWhenAPlayerHasWonAColumn() {
        board.placeMarker(2, "X");
        board.placeMarker(5, "X" );
        board.placeMarker(8, "X" );

        BoardEvaluator evaluator = new BoardEvaluator(board);

        assertThat(evaluator.evaluate(), is(GameState.Win));
    }

    @Test
    public void canDetectWhenAPlayerHasWonARow() {
        board.placeMarker(6, "X");
        board.placeMarker(7, "X" );
        board.placeMarker(8, "X" );

        BoardEvaluator evaluator = new BoardEvaluator(board);

        assertThat(evaluator.evaluate(), is(GameState.Win));
    }

    @Test
    public void canDetectWhenAPlayerHasWonADiagonal() {
        board.placeMarker(2, "X");
        board.placeMarker(4, "X" );
        board.placeMarker(6, "X" );

        BoardEvaluator evaluator = new BoardEvaluator(board);

        assertThat(evaluator.evaluate(), is(GameState.Win));
    }
}
