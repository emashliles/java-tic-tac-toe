import com.TTT.Board;
import com.TTT.TTTRow;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class BoardTests {

    @Test
    public void emptyBoardHasSize() {
        Board board = new Board();
        assertEquals(board.size(), 9);
    }

    @Test
    public void spaceIsNotOccupied() {
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

    @Test
    public void canReturnARow() {
        Board board = new Board();

        TTTRow row = board.getRow(0);

        assertEquals(2,row.getSpaceIndex(2));
    }

    @Test
    public void canReturnSideLength(){
        Board board = new Board();
        assertEquals(3, board.sideLength());
    }
}
