package com.TTT;

public class Game {

    private Board board;
    private TurnUI turns;
    private int currentPlayer;
    private String player1Marker;
    private String player2Marker;

    public Game(Board board, TurnUI turns) {
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
        turns.doTurn(space, board);
    }

    public boolean selectionOnBoard(int selection) {
      return turns.selectionOnBoard(selection, board);
    }

    public int currentPlayer() {
        return turns.currentPlayer();
    }

    public String getPlayerMarker(int playerNumber) {
        return turns.getPlayerMarker(playerNumber);
    }

    public void play() {
        turns.takeTurns(board);
    }
}
