package com.TTT;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class BoardSizeUI {

    private PrintStream out;
    private Scanner scanner;
    private GameUI gameUI;

    public BoardSizeUI(PrintStream out, InputStream in, GameUI gameUI) {
        this.out = out;
        scanner = new Scanner(in);
        this.gameUI = gameUI;
        scanner.useDelimiter("\n");
    }

    public int boardSize() {
        gameUI.clearScreen();
        out.print("Would you like a 3x3 or 4x4 board? Please enter 3 or 4: ");

        String selection = getBoardSizeSelection();
        while(!validSelection(selection) || ((Integer.parseInt(selection) != 3) && (Integer.parseInt(selection) != 4))) {
            out.print("You must choose 3 for a 3x3 board or 4 for a 4x4 board.");
            selection = getBoardSizeSelection();
        }
        return Integer.parseInt(selection);
    }

    private String getBoardSizeSelection() {
        return scanner.nextLine();
    }

    private boolean validSelection(String selection) {
        try {
            Integer.parseInt(selection);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }
}
