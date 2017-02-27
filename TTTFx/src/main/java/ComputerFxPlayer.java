public class ComputerFxPlayer implements Player {
    @Override
    public Board doTurn(Board board, PlayerMarkers marker) {
        MiniMax miniMax = new MiniMax();
        board.placeMarker(miniMax.nextMove(board, marker), marker.symbol());
        return board;
    }
}
