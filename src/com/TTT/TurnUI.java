package com.TTT;

import java.io.InputStream;
import java.util.Scanner;

public class TurnUI {

    public void takeTurn(Board board, BoardPrinter printer, Game game, InputStream in) {
        printer.printBoard(board);
        Scanner sc = new Scanner(in);
        String selection = sc.nextLine();
        game.doTurn(Integer.parseInt(selection));
    }
}
