public class HumanVComputerTurnHandler implements TurnHandler{

    @Override
    public void getPlayerTurn(String spaceString, Player player1, Player player2, PlayerMarkers currentPlayer) {
        HumanFxPlayer player1Human = (HumanFxPlayer) player1;

        player1Human.getUserInput(Integer.parseInt(spaceString)-1);
    }

    @Override
    public void doTurn(Game game, Board board) {
        game.doTurn(board);
        game.doTurn(board);
    }
}
