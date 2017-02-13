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
        currentPlayer =1;
        player1Marker = PlayerMarkers.X.symbol();
        player2Marker = PlayerMarkers.O.symbol();
    }

    public int takeTurn(Board board) {
        String selectedSpace = getPlayerInput(board, inputPrompt);
        String winningMarker = getPlayerMarker(currentPlayer);

        while(!validSelection(selectedSpace) || !selectionOnBoard(parseSelection(selectedSpace), board) || board.isOccupied(parseSelection(selectedSpace))) {
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

    public void doTurn(int space, Board board) {
        if(currentPlayer == 1) {
            board.placeMarker(space, player1Marker);
            currentPlayer = 2;
        }
        else {
            board.placeMarker(space, player2Marker);
            currentPlayer = 1;
        }
    }

    public String getPlayerMarker(int playerNumber) {
        if(currentPlayer == 1)
            return player1Marker;

        return player2Marker;
    }
    public GameState isOver(Board board) {
        BoardEvaluator evaluator = new BoardEvaluator(board);
        return evaluator.evaluate();
    }

    public boolean selectionOnBoard(int selection, Board board) {
        if(selection > (board.size() - 1) || selection < 0) {
            return false;
        }
        return true;
    }
    private String invalidReasonText(Board board, String selectedSpace) {
        if (!validSelection(selectedSpace)) {
            return "Invalid input - you must enter a number. ";
        }
        else if (!selectionOnBoard(parseSelection(selectedSpace), board)) {
            return "Invalid input - your choice must be a number on the board. ";
        }
        else if (board.isOccupied(parseSelection(selectedSpace))) {
            return "Invalid input - your choice must not be already taken. ";
        }
        else {
            return "Invalid input";
        }
    }

    public int currentPlayer() {
        return currentPlayer;
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
