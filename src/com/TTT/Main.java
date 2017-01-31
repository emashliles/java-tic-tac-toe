package com.TTT;

import java.io.InputStream;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        Board board = new Board();
        BoardPrinter printer = new BoardPrinter(System.out);
        Game game = new Game(board);

        takeTurns(board, printer, game, System.in);
    }

    private static void takeTurns(Board board, BoardPrinter printer, Game game, InputStream in) {
        while(!game.isOver()) {
            printer.printBoard(board);
            Scanner sc = new Scanner(in);
            String selection = sc.nextLine();
            game.doTurn(Integer.parseInt(selection));
        }
    }
}
