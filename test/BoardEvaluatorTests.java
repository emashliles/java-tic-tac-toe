import com.TTT.Board;
import com.TTT.BoardEvaluator;
import com.TTT.GameState;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class BoardEvaluatorTests{
    @Test
    public void canDetectNoPlayerHasWon() {
        Board board = new Board();
        BoardEvaluator evaluator = new BoardEvaluator(board);

        assertThat(evaluator.evaluate(), is(GameState.NoWinner));
    }


}
