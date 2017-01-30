package com.TTT;

import java.io.IOException;
import java.io.PrintStream;

public class Gui {
    private PrintStream out;

    public Gui(PrintStream stdOut) {
        out = stdOut;
    }

    public void printBoard() throws IOException {
        Board board = new Board();
        out.print(board.getString());
    }
}
