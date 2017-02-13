package com.TTT;

public class HumanPlayer implements Player {
    private TurnUI turns;

    public HumanPlayer(TurnUI turns) {
        this.turns = turns;
    }

    public Board doTurn(Board board, String marker) {
        int space = turns.takeTurn(board);

        board.placeMarker(space, marker);

        turns.checkForEndOfGame(board, marker);

        return board;
    }
}
