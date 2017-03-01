public class ComputerVHumanTurnHandler implements TurnHandler {

    private PlayerMarkers lastPlayerMoved;

    @Override
    public void getPlayerTurn(String spaceString, Player player1, Player player2, PlayerMarkers currentPlayer) {
        HumanFxPlayer player2Human = (HumanFxPlayer) player2;
        player2Human.getUserInput(Integer.parseInt(spaceString) - 1);
    }

    @Override
    public void doTurn(Game game, Board board) {
        lastPlayerMoved = game.getCurrentPlayer();
        game.doTurn(board);
        lastPlayerMoved = game.getCurrentPlayer();
        game.doTurn(board);
    }

    @Override
    public PlayerMarkers lastPlayerToMove() {
        return lastPlayerMoved;
    }
}
