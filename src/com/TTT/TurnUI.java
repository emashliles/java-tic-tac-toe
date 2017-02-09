package com.TTT;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TurnUI {

    private PrintStream out;
    private BoardPrinter printer;
    private Scanner scanner;
    private String inputPrompt = "Please choose a space: ";

    public TurnUI(BoardPrinter printer, PrintStream out, InputStream in) {
        this.printer = printer;
        this.out = out;
        scanner = new Scanner(in);
        scanner.useDelimiter("\n");
    }

    public void takeTurn(Board board, Game game) {
        String selectedSpace = getPlayerInput(board, inputPrompt);
        String winningMarker = game.getPlayerMarker(game.currentPlayer());

        while(!validSelection(selectedSpace) || !game.selectionOnBoard(parseSelection(selectedSpace)) || board.isOccupied(parseSelection(selectedSpace))) {

            if (!validSelection(selectedSpace)) {
                selectedSpace = getPlayerInput(board, "Invalid input - you must enter a number. " + inputPrompt);
            }
            else if (!game.selectionOnBoard(parseSelection(selectedSpace))) {
                selectedSpace = getPlayerInput(board, "Invalid input - your choice must be a number on the board. " + inputPrompt);
            }
            else if (board.isOccupied(parseSelection(selectedSpace))) {
                selectedSpace = getPlayerInput(board, "Invalid input - your choice must not be already taken. " + inputPrompt);
            }
            else {
                selectedSpace = getPlayerInput(board, "Invalid input." + inputPrompt);
            }
        }

        game.doTurn(parseSelection(selectedSpace));

        if(game.isOver() == GameState.Win) {
            printer.printBoard(board);
            out.print("Player " + winningMarker + " is the winner.\n");
        }

        if (game.isOver() == GameState.Tie){
            printer.printBoard(board);
            out.print("This game is a tie.\n");
        }
    }

    private String getPlayerInput(Board board, String text) {
        printer.printBoard(board);
        out.print(text);
        String selection = scanner.nextLine();
        return selection;
    }

    public int parseSelection(String selection) {
        int selectedSpace = Integer.parseInt(selection);
        return zeroIndexSelection(selectedSpace);
    }

    public int zeroIndexSelection(int selection){
        return selection - 1;
    }

    public static boolean validSelection(String selection) {
        try {
            Integer.parseInt(selection);
            return true;
        }
        catch(NumberFormatException e){
            return false;
        }
    }

    public void takeTurns(Board board, Game game) {
        while(game.isOver() == GameState.NoWinner) {
            takeTurn(board, game);
        }
    }
}
