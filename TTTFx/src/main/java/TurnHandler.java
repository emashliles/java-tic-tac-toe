public interface TurnHandler {
    void getPlayerTurn(String spaceString, Player player2, Player player1, PlayerMarkers currentPlayer);
    void doTurn(Game game, Board board);
}
