import com.TTT.Board;
import org.junit.Test;

import static junit.framework.TestCase.assertEquals;


public class BoardTests {

    @Test
    public void emptyBoardHasSize() {
        Board board = new Board();
        assertEquals(board.size(), 9);
    }

    @Test
    public void spaceIsOccupied() {
        Board board = new Board();
        assertEquals(board.isOccupied(1), false);
    }

    @Test
    public void placeMarkerMakesSpaceOccupied() {
        Board board = new Board();
        board.placeMarker(3, "X");
        assertEquals(board.isOccupied(3), true);
    }

    @Test
    public void placeMarkerAddsMarkerToCorrectSpace() {
        Board board = new Board();
        board.placeMarker(1, "X");
        assertEquals(board.markerAt(1), "X");
    }
}
