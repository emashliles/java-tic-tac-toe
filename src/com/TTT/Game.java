package com.TTT;

public class Game {

    private Board board;
    private TurnUI turns;
    private int currentPlayer;
    private String player1Marker;
    private String player2Marker;

    private Player player1;
    private Player player2;

    public Game(Board board, TurnUI turns) {
        this.board = board;
        this.turns = turns;
        currentPlayer = 1;
        player1Marker = PlayerMarkers.X.symbol();
        player2Marker = PlayerMarkers.O.symbol();

        player1 = new HumanPlayer(turns);
        player2 = new HumanPlayer(turns);
    }

    public GameState isOver(Board board) {
        return turns.isOver(board);
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

    public boolean selectionOnBoard(int selection) {
      return board.selectionOnBoard(selection);
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
