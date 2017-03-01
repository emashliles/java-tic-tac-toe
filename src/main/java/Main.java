import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        boolean replay = true;
        while (replay) {
            startNewGame(System.in, System.out);
            replay = replay(System.in, System.out);
        }
    }

    public static void startNewGame(InputStream in, PrintStream out) {
        GameUI gameUI = new GameUI(out, new BoardPrinter(out));
        BoardSizeUI optionsUI = new BoardSizeUI(out, in, gameUI);
        Board board = new Board(optionsUI.boardSize());
        PlayerOptionUI players = new PlayerOptionUI(out, in, gameUI);
        players.introduce();
        players.playerOption();
        Player player1 = players.player(1);
        Player player2 = players.player(2);
        Game game = new Game(player1, player2);

        game.play(board);
    }

    public static boolean replay(InputStream in, PrintStream out) {
        out.print("Replay? y/n ");

        Scanner scanner = new Scanner(in);
        scanner.useDelimiter("\n");
        String selection = scanner.nextLine();
        while (!selection.equals("y") && !selection.equals("n")) {
            out.print("Please try that again y/n");
            selection = scanner.nextLine();
        }

        if(selection.equals("y")) {
            return true;
        }

        return false;
    }
}
