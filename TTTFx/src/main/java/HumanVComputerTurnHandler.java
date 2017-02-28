public class HumanVComputerTurnHandler implements TurnHandler{

    private PlayerMarkers lastPlayerMoved;

    @Override
    public void getPlayerTurn(String spaceString, Player player1, Player player2, PlayerMarkers currentPlayer) {
        HumanFxPlayer player1Human = (HumanFxPlayer) player1;
        player1Human.getUserInput(Integer.parseInt(spaceString)-1);
    }

    @Override
    public void doTurn(Game game, Board board) {
        lastPlayerMoved = game.getCurrentPlayer();
        game.doTurn(board);

        if(game.isOver(board) == GameState.NoWinner) {
            lastPlayerMoved = game.getCurrentPlayer();
            game.doTurn(board);
        }
    }

    @Override
    public PlayerMarkers lastPlayerToMove() {
        return lastPlayerMoved;
    }
}
