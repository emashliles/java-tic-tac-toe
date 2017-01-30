import com.TTT.Board;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoardTests {

    @Test
    public void createsEmptyBoard() {
        Board board = new Board();

        assertEquals(board.getString(), "123\n456\n789");
    }

    @Test
    public void placeMark() {
        Board board = new Board();
        board.placeMark(0, "X");
        Assert.assertEquals( "X23\n456\n789", board.getString());
    }

}
