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

    @Test
    public void identifyATieMove() {
        Board board = new Board();
        board.placeMarker(0, "O");
        board.placeMarker(1, "X");
        board.placeMarker(2, "O");
        board.placeMarker(3, "X");
        board.placeMarker(4, "O");
        board.placeMarker(5, "X");
        board.placeMarker(6, "X");
        board.placeMarker(7, "O");

        MiniMax miniMax = new MiniMax(board);
        List<Integer> availableMoves = miniMax.availableMoves();
        int tieMove = miniMax.evaluateMoves(availableMoves);

        assertEquals(8, tieMove);
    }

    @Test
    public void identifyAWinningMove() {
        Board board = new Board();
        board.placeMarker(0, "O");
        board.placeMarker(1, "X");
        board.placeMarker(2, "O");
        board.placeMarker(3, "X");
        board.placeMarker(4, "O");
        board.placeMarker(5, "X");
        board.placeMarker(6, "O");
        MiniMax minimax = new MiniMax(board);
        List<Integer> availableMoves = minimax.availableMoves();
        int winningMove = minimax.evaluateMoves(availableMoves);

        assertEquals(7, winningMove);
    }
}
