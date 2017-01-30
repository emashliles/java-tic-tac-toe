import com.TTT.Board;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTests {

    @Test
    public void createsStringOfEmptyBoard() {
        Board board = new Board();
        assertEquals(board.getString(), "123\n456\n789");
    }

}
