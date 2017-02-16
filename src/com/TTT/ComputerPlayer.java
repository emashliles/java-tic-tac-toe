package com.TTT;

public class ComputerPlayer implements Player {

    private GameUI gameUI;

    public ComputerPlayer(GameUI gameUI) {

        this.gameUI = gameUI;
    }

    @Override
    public Board doTurn(Board board, PlayerMarkers marker) {
        gameUI.printBoard(board);

        MiniMax miniMax = new MiniMax();
        board.placeMarker(miniMax.nextMove(board, marker), marker.symbol());


        gameUI.announceWinner(board, marker.symbol());
        return board;
    }
}
