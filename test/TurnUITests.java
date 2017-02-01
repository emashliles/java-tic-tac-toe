import com.TTT.Board;
import com.TTT.BoardPrinter;
import com.TTT.Game;
import com.TTT.TurnUI;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;

public class TurnUITests {
    @Test
    public void canAlternateTurns() {
        BoardPrinter printer = new BoardPrinter(System.out);
        ByteArrayInputStream in = new ByteArrayInputStream("1\n2\n".getBytes());
        TurnUI turns = new TurnUI(printer, System.out, in);
        Board board = new Board();
        Game game = new Game(board);

        turns.takeTurn(board, game);
        turns.takeTurn(board, game);

        assertEquals(board.markerAt(2), "O");
    }

    @Test
    public void asksForInputAgainIfInputIsText() {
        BoardPrinter printer = new BoardPrinter(System.out);
        ByteArrayInputStream in = new ByteArrayInputStream(("invalidInput\n2").getBytes());
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream out = new PrintStream(outputStream);

        TurnUI turns = new TurnUI(printer, out, in);
        Board board = new Board();
        Game game = new Game(board);

        turns.takeTurn(board, game);

        assertEquals(outputStream.toString(), "Please enter a space number: Invalid input. Please enter a space number: ");
    }
}
