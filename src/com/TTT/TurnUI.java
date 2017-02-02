package com.TTT;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TurnUI {

    private PrintStream out;
    private BoardPrinter printer;
    private Scanner scanner;
    private String inputPrompt ="Please enter a space number: ";

    public TurnUI(BoardPrinter printer, PrintStream out, InputStream in) {
        this.printer = printer;
        this.out = out;
        scanner = new Scanner(in);
        scanner.useDelimiter("\n");
    }

    public void takeTurn(Board board, Game game) {
        int selectedSpace = getPlayerInput(board, inputPrompt);

        while(selectedSpace < 0 || selectedSpace > (board.size() - 1) || board.isOccupied(selectedSpace)) {
            selectedSpace = getPlayerInput(board, "Invalid input. " + inputPrompt);
        }

        game.doTurn(selectedSpace);
    }

    private Integer getPlayerInput(Board board, String text) {
        printer.printBoard(board);
        out.print(text);
        String selection = scanner.nextLine();
        return parseSelection(selection);
    }

    private int parseSelection(String selection) {
        try {
            return Integer.parseInt(selection) - 1;
        }
        catch(NumberFormatException e){
            return -1;
        }
    }
}
