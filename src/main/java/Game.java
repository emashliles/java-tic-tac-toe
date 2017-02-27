public class Game {

    private int currentPlayer;
    private PlayerMarkers player1Marker;
    private PlayerMarkers player2Marker;

    private Player player1;
    private Player player2;

    public Game(Player player1, Player player2) {
        currentPlayer = 1;
        player1Marker = PlayerMarkers.X;
        player2Marker = PlayerMarkers.O;

        this.player1 = player1;
        this.player2 = player2;
    }

    public GameState isOver(Board board) {
        BoardEvaluator evaluator = new BoardEvaluator(board);
        return evaluator.evaluate();
    }

    public void doTurn(Board board) {
        if(currentPlayer == 1) {
            player1.doTurn(board, player1Marker);
            currentPlayer = 2;
        }
        else {
            player2.doTurn(board, player2Marker);
            currentPlayer = 1;
        }
    }

    public void takeTurns(Board board) {
        while(isOver(board) == GameState.NoWinner) {
            doTurn(board);
        }
    }

    public void play(Board board) {
        takeTurns(board);
    }

    public PlayerMarkers getCurrentPlayer() {
        if(currentPlayer == 1) {
            return player1Marker;
        }
        else {
            return player2Marker;
        }
    }
}
