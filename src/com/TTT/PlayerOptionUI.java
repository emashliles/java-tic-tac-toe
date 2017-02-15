package com.TTT;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class PlayerOptionUI {

    private PrintStream out;
    private ByteArrayInputStream in;
    private Scanner sc;

    public PlayerOptionUI(PrintStream out, ByteArrayInputStream in) {
        this.out = out;
        this.in = in;
        sc = new Scanner(in);
    }

    public Player getPlayerOption(int playerNumber) {
        out.print("Player " + playerNumber + " (h/c)");
        String option = sc.nextLine();

        if(option.equals("h")) {
            return new HumanPlayer(new TurnUI(new BoardPrinter(out), out, in));
        }
        return null;
    }
}
