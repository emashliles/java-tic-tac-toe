package com.TTT;

import java.io.PrintStream;

public class BoardPrinter {
    private final PrintStream out;

    public BoardPrinter(PrintStream out) {
        this.out = out;
    }

    public void printBoard(Board board) {
        for(int i = 0; i < board.sideLength(); i++) {
            Line row = board.getRow(i);

            printRow(board, row);

            printSeparator(board, i, row);
        }
    }

    private void printSeparator(Board board, int i, Line row) {
        out.print("\n");
        if(i != board.sideLength() -1) {
            out.print(lineSeparator(row.size()));
        }
    }

    private void printRow(Board board, Line row) {
        for (int rowIndex = 0; rowIndex < row.size(); rowIndex++) {
            printSpace(board, row.getSpaceIndex(rowIndex));

            if ((rowIndex + 1) % row.size() != 0)
                out.print("|");
        }
    }

    private String lineSeparator(int rowSize) {
        return new String(new char[(5 * rowSize)-1]).replace("\0", "=") + "\n";
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
            out.print(String.format("%3s", space) + " ");
        }
    }
}