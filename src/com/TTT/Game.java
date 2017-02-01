package com.TTT;

public class Game {

    private Board board;
    private int currentPlayer;

    public Game(Board board) {
        this.board = board;
        currentPlayer = 1;
    }

    public boolean isOver() {
        return false;
    }

    public void doTurn(int space) {
        if(currentPlayer == 1) {
            board.placeMarker(space, "X");
            currentPlayer = 2;
        }
        else {
            board.placeMarker(space, "O");
            currentPlayer = 1;
        }

    }
}