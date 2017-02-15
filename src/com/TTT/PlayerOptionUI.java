package com.TTT;

import java.io.PrintStream;

public class PlayerOptionUI {

    private PrintStream out;

    public PlayerOptionUI(PrintStream out) {
        this.out = out;
    }

    public Player getPlayerOption(int playerNumber) {
        out.print("Player " + playerNumber + " (h/c)");
        return null;
    }
}
