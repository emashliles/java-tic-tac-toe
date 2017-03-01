import java.io.InputStream;
import java.io.PrintStream;

public class Main {

    public static void main(String[] args) {
        run();
    }

    public static void run() {
        ReplayUi replayUi = new ReplayUi(System.in);
        boolean replay = true;
        while (replay) {
            startNewGame(System.in, System.out);
            replay = replayUi.replay(System.out);
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
}
