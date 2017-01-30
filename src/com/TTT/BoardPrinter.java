package com.TTT;

import java.io.IOException;
import java.io.PrintStream;

public class BoardPrinter {
    private PrintStream out;

    public BoardPrinter(PrintStream stdOut) {
        out = stdOut;
    }

    public void printBoard() throws IOException {
        Board board = new Board();
        out.print(board.getString());
    }
}
