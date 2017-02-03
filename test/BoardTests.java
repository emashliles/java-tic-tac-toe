import com.TTT.Board;
import com.TTT.TTTLine;
import org.junit.Test;

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

        TTTLine row = board.getRow(0);

        assertEquals(2,row.getSpaceIndex(2));
    }

    @Test
    public void canReturnAColumn() {
        Board board = new Board();
        TTTLine column = board.getColumn(1);

        assertEquals(7, column.getSpaceIndex(2));
    }

    @Test
    public void canReturnLeftToRightDiagonal() {
        Board board = new Board();

        TTTLine diagonal = board.getLeftToRightDiagonal();

        assertEquals(8, diagonal.getSpaceIndex(2));
    }

    @Test
    public void canReturnRightToLeftDiagonal() {
        Board board = new Board();

        TTTLine diagonal = board.getRightToLeftDiagonal();

        assertEquals(6, diagonal.getSpaceIndex(2));
    }

    @Test
    public void canReturnSideLength(){
        Board board = new Board();
        assertEquals(3, board.sideLength());
    }
}
