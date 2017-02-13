package com.TTT;

import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

public class TurnUI {

    private PrintStream out;
    private BoardPrinter printer;
    private Scanner scanner;
    private String inputPrompt = "Please choose a space: ";
    private int currentPlayer;
    private String player1Marker;
    private String player2Marker;

    public TurnUI(BoardPrinter printer, PrintStream out, InputStream in) {
        this.printer = printer;
        this.out = out;
        scanner = new Scanner(in);
        scanner.useDelimiter("\n");
        currentPlayer = 1;
        player1Marker = PlayerMarkers.X.symbol();
        player2Marker = PlayerMarkers.O.symbol();
    }

    public int takeTurn(Board board) {
        String selectedSpace = getPlayerInput(board, inputPrompt);

        while(!validSelection(selectedSpace) || !board.selectionOnBoard(parseSelection(selectedSpace)) || board.isOccupied(parseSelection(selectedSpace))) {
            selectedSpace = getPlayerInput(board,  invalidReasonText(board, selectedSpace) + inputPrompt);
        }

        return parseSelection(selectedSpace);
    }

    public void checkForEndOfGame(Board board, String winningMarker) {
        if(isOver(board) == GameState.Win) {
            printer.printBoard(board);
            out.print("Player " + winningMarker + " is the winner.\n");
        }

        if (isOver(board) == GameState.Tie){
            printer.printBoard(board);
            out.print("This game is a tie.\n");
        }
    }

    public GameState isOver(Board board) {
        BoardEvaluator evaluator = new BoardEvaluator(board);
        return evaluator.evaluate();
    }

    private String invalidReasonText(Board board, String selectedSpace) {
        if (!validSelection(selectedSpace)) {
            return "Invalid input - you must enter a number. ";
        }
        else if (!board.selectionOnBoard(parseSelection(selectedSpace))) {
            return "Invalid input - your choice must be a number on the board. ";
        }
        else if (board.isOccupied(parseSelection(selectedSpace))) {
            return "Invalid input - your choice must not be already taken. ";
        }
        else {
            return "Invalid input";
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


}
