package com.TTT;

public class Game {

    private Board board;
    private int currentPlayer;
    private String player1Marker;
    private String player2Marker;

    public Game(Board board) {
        this.board = board;
        currentPlayer = 1;
        player1Marker = "X";
        player2Marker = "O";
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

    public boolean validSelection(String selection) {
        try {
            Integer.parseInt(selection);
            return true;
        }
        catch(NumberFormatException e){
            return false;
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
}
