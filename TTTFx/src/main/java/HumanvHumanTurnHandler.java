public class HumanvHumanTurnHandler implements TurnHandler {

    public void getPlayerTurn(String spaceString, Player player1, Player player2, PlayerMarkers currentPlayer) {

        HumanFxPlayer player1Human = (HumanFxPlayer) player1;
        HumanFxPlayer player2Human = (HumanFxPlayer) player2;

        if(currentPlayer == PlayerMarkers.X) {
            player1Human.getUserInput(Integer.parseInt(spaceString) - 1);
        }
        else {
            player2Human.getUserInput(Integer.parseInt(spaceString) - 1);
        }
    }

    @Override
    public void doTurn(Game game, Board board) {
        game.doTurn(board);
    }
}
