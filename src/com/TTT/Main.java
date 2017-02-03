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

        turns.takeTurns(board, game);
    }
}
