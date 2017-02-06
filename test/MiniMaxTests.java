import com.TTT.Board;
import com.TTT.MiniMax;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class MiniMaxTests {
    @Test
    public void findAllAvailableMoves() {
        Board board = new Board();
        board.placeMarker(1, "X");
        board.placeMarker(5, "O");
        MiniMax minimax = new MiniMax(board);
        List<Integer> availableMoves = minimax.availableMoves();

        assertEquals(7, availableMoves.size());
    }
}
