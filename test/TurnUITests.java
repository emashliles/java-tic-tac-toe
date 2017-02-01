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
        BoardPrinter printer = new BoardPrinter(System.out);
        TurnUI turns = new TurnUI(printer);
        Board board = new Board();
        Game game = new Game(board);
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());

        turns.takeTurn(board, game, in);

        in = new ByteArrayInputStream("2".getBytes());
        turns.takeTurn(board, game, in);

        assertEquals(board.markerAt(2), "O");

    }


}
