package com.TTT;

public class Game {

    private Board board;
    private TurnUI turns;
    private int currentPlayer;
    private String player1Marker;
    private String player2Marker;

    public Game(Board board) {
        this.board = board;
        this.turns = turns;
        currentPlayer = 1;
        player1Marker = PlayerMarkers.X.symbol();
        player2Marker = PlayerMarkers.O.symbol();
    }

    public GameState isOver() {
        BoardEvaluator evaluator = new BoardEvaluator(board);
        return evaluator.evaluate();
    }

    public void doTurn(int space) {
        if(currentPlayer == 1) {
            board.placeMarker(space, player1Marker);
            currentPlayer = 2;
        }
        else {
            board.placeMarker(space, player2Marker);
            currentPlayer = 1;
        }
    }

    public boolean selectionOnBoard(int selection) {
       if(selection > (board.size() - 1) || selection < 0) {
           return false;
       }
       return true;
    }

    public int currentPlayer() {
        return currentPlayer;
    }

    public String getPlayerMarker(int playerNumber) {
        if(currentPlayer == 1)
            return player1Marker;

        return player2Marker;
    }

    public void play() {
        turns.takeTurns(board);
    }
}
