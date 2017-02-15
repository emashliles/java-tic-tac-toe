package com.TTT;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class PlayerOptionUI {

    private PrintStream out;
    private InputStream in;
    private Scanner sc;

    public PlayerOptionUI(PrintStream out, InputStream in) {
        this.out = out;
        this.in = in;
        sc = new Scanner(in);
        sc.useDelimiter("\n");
    }

    public void introduce() {
        out.print("Please select a player type for each player.\n" +
                "You can choose human by entering h or computer by entering c.\n");
    }

    public Player playerOption(int playerNumber) {
        out.print("Player " + playerNumber + " (h/c): ");

        String option = sc.nextLine();
        option = validateSelection(option);

        return createPlayerSelection(option);
    }

    private String validateSelection(String option) {
        while(!"h".equals(option) && !"c".equals(option)) {
            out.print("Please try that again - enter h for human player or c for computer player :");
            option = sc.nextLine();
        }
        return option;
    }

    private Player createPlayerSelection(String option) {
        if(option.equals("h")) {
            return new HumanPlayer(new TurnUI(new BoardPrinter(out), out, in));
        }
        else {
            return new ComputerPlayer();
        }
    }
}
