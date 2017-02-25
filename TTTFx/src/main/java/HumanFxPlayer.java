public class HumanFxPlayer implements Player {

    boolean moveMade;
    private int selection;

    @Override
    public Board doTurn(Board board, PlayerMarkers marker) {
        board.placeMarker(selection, marker.symbol());
        return board;
    }

    public void getUserInput(int space) {
        moveMade = true;
    }
}
