package com.TTT;

public class Main {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Board board = new Board();
        BoardPrinter printer = new BoardPrinter(System.out);
        Game game = new Game(board);
        TurnUI turns = new TurnUI(printer, System.out, System.in);

        takeTurns(board, game, turns);
    }

    public static void takeTurns(Board board, Game game, TurnUI turns) {
        while(game.isOver() == GameState.NoWinner) {
            turns.takeTurn(board, game);
        }
    }

}
