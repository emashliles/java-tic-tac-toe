package com.TTT;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TurnUI {

    private PrintStream out;
    private BoardPrinter printer;
    private Scanner scanner;
    private String inputPrompt ="Please enter a size number: ";

    public TurnUI(BoardPrinter printer, PrintStream out, InputStream in) {
        this.printer = printer;
        this.out = out;
        scanner = new Scanner(in);
        scanner.useDelimiter("\n");
    }

    public void takeTurn(Board board, Game game) {
        String selectedSpace = getPlayerInput(board, inputPrompt);
        String winningMarker = game.getPlayerMarker(game.currentPlayer());

        while(!game.validSelection(selectedSpace) || !game.selectionOnBoard(parseSelection(selectedSpace)) || board.isOccupied(parseSelection(selectedSpace))) {
            selectedSpace = getPlayerInput(board, "Invalid input. " + inputPrompt);
        }

        game.doTurn(parseSelection(selectedSpace));

        if(game.isOver() == GameState.Win) {
            out.print("Player " + winningMarker + " is the winner.");
        }

        if (game.isOver() == GameState.Tie){
            out.print("This game is a tie.");
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
}
