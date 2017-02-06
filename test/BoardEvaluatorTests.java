import com.TTT.Board;
import com.TTT.BoardEvaluator;
import com.TTT.GameState;
import com.TTT.TTTRow;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardEvaluatorTests{
    @Test
    public void canDetectNoPlayerHasWon() {
        Board board = new Board();
        BoardEvaluator evaluator = new BoardEvaluator(board);

        assertThat(evaluator.evaluate(), is(GameState.NoWinner));
    }

    @Test
    public void canDetectAWinningRowFromIndexes() {
        Board board = new Board();

        board.placeMarker(6, "X");
        board.placeMarker(7, "X" );
        board.placeMarker(8, "X" );

        BoardEvaluator evaluator = new BoardEvaluator(board);
        List<Integer> spaces = new ArrayList<>();
        spaces.add(6);
        spaces.add(7);
        spaces.add(8);

        TTTRow row = new TTTRow(spaces);

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
