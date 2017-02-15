package com.TTT;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PlayerOptionUI {

    private PrintStream out;
    private InputStream in;
    private Scanner sc;
    private Player[] players;
    private List<String> playerCombinations;

    public PlayerOptionUI(PrintStream out, InputStream in) {
        this.out = out;
        this.in = in;
        sc = new Scanner(in);
        sc.useDelimiter("\n");
        players = new Player[2];
        playerCombinations = new ArrayList<>();
        playerCombinations.add("hh");
        playerCombinations.add("cc");
        playerCombinations.add("hc");
        playerCombinations.add("ch");
    }

    public void introduce() {
        out.print("Please select what players you would like.\n" +
                "For Human v Human enter hh\n" +
                "For Human v Computer enter hc\n" +
                "For Computer v Human enter ch\n" +
                "For Computer v Computer enter cc\n");
    }

    public void playerOption() {
        out.print("Please enter your choice: ");

        String option = sc.nextLine();
        String[] options = validateSelection(option);

        createPlayers(options);
    }

    private void createPlayers(String[] options) {
        for(int i = 0; i < options.length; i++) {
            players[i] = createPlayer(options[i]);
        }
    }

    private String[] validateSelection(String option) {
        String options[] = option.split("");

        while(!validSelection(option)) {
            out.print("Please try that again: ");
            option = sc.nextLine();
            options = option.split("");
        }
        return options;
    }

    private boolean validSelection(String option) {
        if(playerCombinations.contains(option)) {
            return true;
        }
        return false;
    }

    private Player createPlayer(String option) {
        if(option.equals("h")) {
            return new HumanPlayer(new TurnUI(new BoardPrinter(out), out, in));
        }
        else {
            return new ComputerPlayer();
        }
    }

    public Player player(int playerNumber) {
        return players[playerNumber - 1];
    }
}
