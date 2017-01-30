import com.TTT.Board;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class BoardTests {

    @Test
    public void emptyBoardHasSize() {
        Board board = new Board();
        assertEquals(board.size(), 2);
    }

    @Test
    public void returnContentsOfSpace() {
        Board board = new Board();
        assertEquals(board.getContents(2), 3);
    }

    @Test
    public void spaceIsOccupied() {
        Board board = new Board();
        assertEquals(board.isOccupied(1), false);
    }
}
