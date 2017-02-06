import com.TTT.Board;
import com.TTT.Line;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static junit.framework.TestCase.assertEquals;


public class BoardTests {

    private Board board;

    @Before
    public void setUp() {
        board = new Board();
    }

    @Test
    public void emptyBoardHasSize() {
        assertEquals(board.size(), 9);
    }

    @Test
    public void spaceIsNotOccupied() {
        assertEquals(board.isOccupied(1), false);
    }

    @Test
    public void placeMarkerMakesSpaceOccupied() {
        board.placeMarker(3, "X");
        assertEquals(board.isOccupied(3), true);
    }

    @Test
    public void placeMarkerAddsMarkerToCorrectSpace() {
        board.placeMarker(1, "X");
        assertEquals(board.markerAt(1), "X");
    }

    @Test
    public void canReturnARow() {
        Line row = board.getRow(0);
        assertEquals(2,row.getSpaceIndex(2));
    }

    @Test
    public void canReturnAColumn() {
        Line column = board.getColumn(1);
        assertEquals(7, column.getSpaceIndex(2));
    }

    @Test
    public void canReturnLeftToRightDiagonal() {
        Line diagonal = board.getLeftToRightDiagonal();
        assertEquals(8, diagonal.getSpaceIndex(2));
    }

    @Test
    public void canReturnRightToLeftDiagonal() {
        Line diagonal = board.getRightToLeftDiagonal();
        assertEquals(6, diagonal.getSpaceIndex(2));
    }

    @Test
    public void canReturnSideLength(){
        assertEquals(3, board.sideLength());
    }

    @Test
    public void returnAListOfAllLines() {
        List<Line> lines = board.allLines();
        assertEquals(8, lines.size());
    }

    @Test
    public void returnAllLinesCorrectly() {
        List<Line> lines = board.allLines();

        Line diagonal = lines.get(7);
        Line row = lines.get(2);
        Line column = lines.get(5);

        assertEquals(lines.contains(diagonal), true);
        assertEquals(lines.contains(row), true);
        assertEquals(lines.contains(column), true);
    }
}
