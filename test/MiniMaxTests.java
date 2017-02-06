import com.TTT.Board;
import com.TTT.MiniMax;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MiniMaxTests {

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
        miniMax.evaluateMoves("X");
        int tieMove = miniMax.selectBestMove();

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
        minimax.evaluateMoves("X");
        int winningMove = minimax.selectBestMove();


        assertEquals(7, winningMove);
    }

    @Test
    public void pickFirstAvailableMoveIfNoWinAvailable() {
        Board board = new Board();
        board.placeMarker(5, "O");
        MiniMax miniMax = new MiniMax(board);
        miniMax.evaluateMoves( "X");
        int firstMove = miniMax.selectBestMove();

        assertEquals(0, firstMove);
    }
}
