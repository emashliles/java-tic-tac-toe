package com.TTT;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class GameOptionsUI {
    private PrintStream out;
    private InputStream in;
    private Scanner scanner;

    public GameOptionsUI(PrintStream out, InputStream in) {
        this.out = out;
        this.in = in;
        scanner = new Scanner(in);
        scanner.useDelimiter("\n");
    }

    public int boardSize() {
        out.print("Would you like a 3x3 or 4x4 board? Please enter 3 or 4: ");

        int selection = getBoardSizeSelection();
        while(selection != 3 && selection != 4) {
            out.print("You must choose 3 for a 3x3 board or 4 for a 4x4 board.");
            selection = getBoardSizeSelection();
        }
        return selection;
    }

    private int getBoardSizeSelection() {
        return Integer.parseInt(scanner.nextLine());
    }
}
