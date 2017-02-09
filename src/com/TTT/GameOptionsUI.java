package com.TTT;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class GameOptionsUI {
    private PrintStream out;
    private InputStream in;

    public GameOptionsUI(PrintStream out, InputStream in) {
        this.out = out;
        this.in = in;
    }

    public int boardSize() {
        out.print("Would you like a 3x3 or 4x4 board? Please enter 3 or 4: ");
        Scanner sc = new Scanner(in);
        return Integer.parseInt(sc.nextLine());
    }
}
