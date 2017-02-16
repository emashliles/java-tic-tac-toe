package com.TTT;

public class HumanPlayer implements Player {
    private TurnUI turns;

    public HumanPlayer(TurnUI turns) {
        this.turns = turns;
    }

    public Board doTurn(Board board, PlayerMarkers marker) {
        int space = turns.takeTurn(board);

        board.placeMarker(space, marker.symbol());

        turns.checkForEndOfGame(board, marker.symbol());

        return board;
    }
}
