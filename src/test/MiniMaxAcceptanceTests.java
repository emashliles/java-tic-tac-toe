import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MiniMaxAcceptanceTests {

    private Board board;
    private MiniMax miniMax;

    @Before
    public void setUp() {
        board = new Board(3);
        miniMax = new MiniMax();
    }

    @Test
    public void makeOnlyAvailableMove() {
        board.placeMarker(0, "X");
        board.placeMarker(1, "O");
        board.placeMarker(2, "X");
        board.placeMarker(3, "X");
        board.placeMarker(4, "O");
        board.placeMarker(5, "X");
        board.placeMarker(6, "O");
        board.placeMarker(8, "O");

        assertEquals(7, miniMax.nextMove(board, PlayerMarkers.X));
    }

    @Test
    public void takeWinningMove() {
        board.placeMarker(0, "X");
        board.placeMarker(1, "O");
        board.placeMarker(2, "X");
        board.placeMarker(3, "O");
        board.placeMarker(4, "X");
        board.placeMarker(5, "O");

        assertEquals(6, miniMax.nextMove(board, PlayerMarkers.X));
    }

    @Test
    public void blockOpponentWinning() {
        board.placeMarker(0, "O");
        board.placeMarker(1, "O");
        board.placeMarker(4, "X");
        board.placeMarker(7, "X");

        assertEquals(2, miniMax.nextMove(board, PlayerMarkers.X));
    }

    @Test
    public void blockOpponentRightToLeftWinningDiagonal() {
        board.placeMarker(0, "X");
        board.placeMarker(1, "O");
        board.placeMarker(2, "O");
        board.placeMarker(4, "X");

        assertEquals(8, miniMax.nextMove(board, PlayerMarkers.O));
    }

    @Test
    public void blockOpponentLeftToRightWinningDiagonal() {
        board.placeMarker(0, "X");
        board.placeMarker(1, "O");
        board.placeMarker(2, "X");
        board.placeMarker(4, "X");
        board.placeMarker(8, "O");

        assertEquals(6, miniMax.nextMove(board, PlayerMarkers.O));
    }

    @Test
    public void createTwoPotentialWinningMoves() {
        board.placeMarker(4, "O");

        assertEquals(0, miniMax.nextMove(board, PlayerMarkers.X));
    }

    @Test
    public void selectACornerAtTheStart() {
        assertEquals(0, miniMax.nextMove(board, PlayerMarkers.X));
    }
}
