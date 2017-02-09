package com.TTT;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class BoardPrinter {
    private final PrintStream out;
    private List<Integer> separatorRows;

    public BoardPrinter(PrintStream out) {
        this.out = out;
        separatorRows = new ArrayList<Integer>();
        separatorRows.add(2);
        separatorRows.add(5);
    }

    public void printBoard(Board board) {
        int rowSize = 3;
        int finalNewLine = (board.size() - 1);

        for (int spaceIndex = 0; spaceIndex < board.size(); spaceIndex++) {
            printSpace(board, spaceIndex);

            if ((spaceIndex + 1) % rowSize != 0)
                out.print("|");

            if (separatorRows.contains(spaceIndex))
                out.print("\n===========\n");

            if (spaceIndex == finalNewLine)
                out.print("\n");
        }
    }

    private void printSpace(Board board, int spaceIndex) {
        String space = board.markerAt(spaceIndex);

        if (space.equals(PlayerMarkers.X.symbol())) {
            out.print(PlayerMarkers.X.display());
        }
        else if (space.equals(PlayerMarkers.O.symbol())) {
            out.print(PlayerMarkers.O.display());
        }
        else {
            out.print(" " + space + " ");
        }
    }
}