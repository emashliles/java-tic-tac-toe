package com.TTT;

import java.io.PrintStream;

public class BoardPrinter {
    private final PrintStream out;

    public BoardPrinter(PrintStream out) {
        this.out = out;
    }

    public void printBoard(Board board) {
        for(int i = 0;i < board.size(); i++)
        {
            out.print(board.markerAt(i));

            if(i == 2 || i == 5 || i == 8)
                out.print("\n");
        }
    }
}
