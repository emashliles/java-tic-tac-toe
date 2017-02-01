package com.TTT;

import java.io.PrintStream;

public class BoardPrinter {
    private final PrintStream out;

    public BoardPrinter(PrintStream out) {
        this.out = out;
    }

    public void printBoard(Board board) {
        for(int spaceIndex = 0; spaceIndex < board.size(); spaceIndex++)
        {
            out.print(" " + board.markerAt(spaceIndex)+ " ");

            if((spaceIndex + 1) % 3 != 0)
                out.print("|");

            if(spaceIndex == 2 || spaceIndex == 5)
                out.print("\n===========\n");

            if(spaceIndex == 8)
                out.print("\n");
        }
    }
}
