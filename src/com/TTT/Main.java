package com.TTT;

import java.io.InputStream;

public class Main {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Board board = new Board();
        BoardPrinter printer = new BoardPrinter(System.out);
        Game game = new Game(board);
        TurnUI turns = new TurnUI();

        takeTurns(board, printer, game, System.in, turns);
    }

    public static void takeTurns(Board board, BoardPrinter printer, Game game, InputStream in, TurnUI turns) {
        while(!game.isOver()) {
            turns.takeTurn(board, printer, game, in);
        }
    }

}
