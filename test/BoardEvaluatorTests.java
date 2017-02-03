import com.TTT.Board;
import com.TTT.BoardEvaluator;
import com.TTT.GameState;
import com.TTT.TTTRow;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

//    @Test
//    public void canDetectAWinningColumnFromIndexes() {
//        Board board = new Board();
//        board.placeMarker(0, "X");
//        board.placeMarker(3, "X");
//        board.placeMarker(6, "X");
//
//        BoardEvaluator evaluator = new BoardEvaluator(board);
//
//        TTTRow column = board.
//
//        evaluator.checkRowIsWin()
//
//        assertEquals();
//
//    }

    @Test
    public void canDetectAWinningRowFromIndexes() {
        Board board = new Board();

        board.placeMarker(6, "X");
        board.placeMarker(7, "X" );
        board.placeMarker(8, "X" );

        BoardEvaluator evaluator = new BoardEvaluator(board);
        TTTRow row = board.getRow(2);

        assertThat(evaluator.checkRowIsWin(row), is(true));
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
