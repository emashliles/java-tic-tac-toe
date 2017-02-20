public class HumanPlayer implements Player {

    private HumanTurnUI humanTurnUI;

    public HumanPlayer(HumanTurnUI humanTurnUI) {
        this.humanTurnUI = humanTurnUI;
    }

    public Board doTurn(Board board, PlayerMarkers marker) {
        int space = humanTurnUI.takeTurn(board);

        board.placeMarker(space, marker.symbol());
        humanTurnUI.announceWinner(board, marker.symbol());

        return board;
    }
}
