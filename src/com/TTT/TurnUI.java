package com.TTT;

import java.io.InputStream;
import java.util.Scanner;

public class TurnUI {

    private BoardPrinter printer;

    public TurnUI(BoardPrinter printer) {
        this.printer = printer;
    }

    public void takeTurn(Board board, Game game, InputStream in) {
        printer.printBoard(board);
        Scanner sc = new Scanner(in);
        String selection = sc.nextLine();
        game.doTurn(Integer.parseInt(selection));
    }
}
