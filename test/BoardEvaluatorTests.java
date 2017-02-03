import com.TTT.Board;
import com.TTT.BoardEvaluator;
import com.TTT.GameState;
import com.TTT.TTTLine;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

public class BoardEvaluatorTests{
    @Test
    public void canDetectNoPlayerHasWon() {
        Board board = new Board();
        BoardEvaluator evaluator = new BoardEvaluator(board);

        assertThat(evaluator.evaluate(), is(GameState.NoWinner));
    }

    @Test
    public void canDetectAWinningColumnFromIndexes() {
        Board board = new Board();
        board.placeMarker(0, "X");
        board.placeMarker(3, "X");
        board.placeMarker(6, "X");

        BoardEvaluator evaluator = new BoardEvaluator(board);

        TTTLine column = board.getColumn(0);

        assertEquals(evaluator.checkLineIsWin(column), true);
    }

    @Test
    public void canDetectAWinningRowFromIndexes() {
        Board board = new Board();

        board.placeMarker(6, "X");
        board.placeMarker(7, "X" );
        board.placeMarker(8, "X" );

        BoardEvaluator evaluator = new BoardEvaluator(board);
        TTTLine row = board.getRow(2);

        assertThat(evaluator.checkLineIsWin(row), is(true));
    }

//    @Test
//    public void canDetectAWinningDiagonalFromIndexes() {
//        Board board = new Board();
//
//        board.placeMarker(0, "X");
//        board.placeMarker(3, "X" );
//        board.placeMarker(6, "X" );
//
//        BoardEvaluator evaluator = new BoardEvaluator(board);
//        TTTLine diagonal = board.getLeftToRightDiagonal(2);
//
//        assertThat(evaluator.checkLineIsWin(row), is(true));
//    }

    @Test
    public void canDetectWhenAPlayerHasWonAColumn() {
        Board board = new Board();

        board.placeMarker(2, "X");
        board.placeMarker(5, "X" );
        board.placeMarker(8, "X" );

        BoardEvaluator evaluator = new BoardEvaluator(board);

        assertThat(evaluator.evaluate(), is(GameState.Win));
    }

    @Test
    public void canDetectWhenAPlayerHasWonARow() {
        Board board = new Board();

        board.placeMarker(6, "X");
        board.placeMarker(7, "X" );
        board.placeMarker(8, "X" );

        BoardEvaluator evaluator = new BoardEvaluator(board);

        assertThat(evaluator.evaluate(), is(GameState.Win));
    }
}
