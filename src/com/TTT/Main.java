package com.TTT;

public class Main {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        BoardSizeUI optionsUI = new BoardSizeUI(System.out, System.in);
        Board board = new Board(optionsUI.boardSize());
        BoardPrinter printer = new BoardPrinter(System.out);
        Game game = new Game(board);
        TurnUI turns = new TurnUI(printer, System.out, System.in);

        turns.takeTurns(board, game);
    }
}
