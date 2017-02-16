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
        playerCombinations.add("1");
        playerCombinations.add("2");
        playerCombinations.add("3");
        playerCombinations.add("4");
    }

    public void introduce() {
        out.print("Please select what players you would like.\n" +
                "\u001B[31m 1 \u001B[0m- Human v Human\n" +
                "\u001B[31m 2 \u001B[0m- Human v Computer\n" +
                "\u001B[31m 3 \u001B[0m- Computer v Human\n" +
                "\u001B[31m 4 \u001B[0m- Computer v Computer\n");
    }

    public void playerOption() {
        out.print("Please enter your choice: ");
        String option = sc.nextLine();
        createPlayers(validateSelection(option));
    }

    private void createPlayers(String option) {
        switch (option) {
            case "1" :
                players[0] = humanPlayer();
                players[1] = humanPlayer();
                break;
            case "2" :
                players[0] = humanPlayer();
                players[1] = computerPlayer();
                break;
            case "3" :
                players[0] = computerPlayer();
                players[1] = humanPlayer();
                break;
            case "4" :
                players[0] = computerPlayer();
                players[1] = computerPlayer();
                break;
        }
    }

    private String validateSelection(String option) {
        while(!validSelection(option)) {
            out.print("Please try that again: ");
            option = sc.nextLine();
        }
        return option;
    }

    private boolean validSelection(String option) {
        if(playerCombinations.contains(option)) {
            return true;
        }
        return false;
    }

    private Player computerPlayer() {
        return new ComputerPlayer();
    }

    private Player humanPlayer() {
        return new HumanPlayer(new HumanTurnUI(new BoardPrinter(out), out, in));
    }

    public Player player(int playerNumber) {
        return players[playerNumber - 1];
    }
}
