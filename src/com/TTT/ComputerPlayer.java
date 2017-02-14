package com.TTT;

public class ComputerPlayer implements Player {
    @Override
    public Board doTurn(Board board, String marker) {
        MiniMax miniMax = new MiniMax();
        board.placeMarker(miniMax.nextMove(board, marker), marker);
        return board;
    }
}
