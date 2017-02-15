package com.TTT;

public class Game {

    private Board board;
    private int currentPlayer;
    private PlayerMarkers player1Marker;
    private PlayerMarkers player2Marker;

    private Player player1;
    private Player player2;

    public Game(Board board, Player player1, Player player2) {
        this.board = board;
        currentPlayer = 1;
        player1Marker = PlayerMarkers.X;
        player2Marker = PlayerMarkers.O;

        this.player1 = player1;
        this.player2 = player2;
    }

    public GameState isOver(Board board) {
        BoardEvaluator evaluator = new BoardEvaluator(board);
        return evaluator.evaluate();
    }

    public void doTurn() {
        if(currentPlayer == 1) {
            player1.doTurn(board, player1Marker);
            currentPlayer = 2;
        }
        else {
            player2.doTurn(board, player2Marker);
            currentPlayer = 1;
        }
    }

    public void takeTurns(Board board) {
        while(isOver(board) == GameState.NoWinner) {
            doTurn();
        }
    }

    public void play() {
        takeTurns(board);
    }
}
