public class ComputerPlayer implements Player {

    private GameUI gameUI;

    public ComputerPlayer(GameUI gameUI) {
        this.gameUI = gameUI;
    }

    @Override
    public Board doTurn(Board board, PlayerMarkers marker) {
        gameUI.clearScreen();
        gameUI.printBoard(board);
        gameUI.printPlayerTurn(marker);

        MiniMax miniMax = new MiniMax();
        board.placeMarker(miniMax.nextMove(board, marker), marker.symbol());

        gameUI.pause();
        gameUI.announceWinner(board, marker.symbol());
        return board;
    }
}
