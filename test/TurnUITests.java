import com.TTT.Board;
import com.TTT.BoardPrinter;
import com.TTT.Game;
import com.TTT.TurnUI;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.assertEquals;

public class TurnUITests {
    @Test
    public void canAlternateTurns() {
        TurnUI turns = new TurnUI();
        Board board = new Board();
        BoardPrinter printer = new BoardPrinter(System.out);
        Game game = new Game(board);
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());

        turns.takeTurn(board, printer, game, in);

        in = new ByteArrayInputStream("2".getBytes());
        turns.takeTurn(board, printer, game, in);

        assertEquals(board.markerAt(2), "O");

    }


}
