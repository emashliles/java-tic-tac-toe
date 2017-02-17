package com.TTT;

public class HumanPlayer implements Player {

    private HumanTurnUI turns;

    public HumanPlayer(HumanTurnUI turns) {
        this.turns = turns;
    }

    public Board doTurn(Board board, PlayerMarkers marker) {
        int space = turns.takeTurn(board);

        board.placeMarker(space, marker.symbol());
        turns.announceWinner(board, marker.symbol());

        return board;
    }
}
