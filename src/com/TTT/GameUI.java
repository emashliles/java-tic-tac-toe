package com.TTT;

import java.io.PrintStream;

public class GameUI {
    private PrintStream out;
    private BoardPrinter printer;

    public GameUI(PrintStream out, BoardPrinter printer) {
        this.out = out;
        this.printer = printer;
    }

    public void announceWinner(Board board, String winningMarker) {
        if(isOver(board) == GameState.Win) {
            clearScreen();
            printer.printBoard(board);
            out.print("Player " + winningMarker + " is the winner.\n");
        }

        if (isOver(board) == GameState.Tie){
            clearScreen();
            printer.printBoard(board);
            out.print("This game is a tie.\n");
        }
    }

    private GameState isOver(Board board) {
        BoardEvaluator evaluator = new BoardEvaluator(board);
        return evaluator.evaluate();
    }

    public void printBoard(Board board) {
        printer.printBoard(board);
    }

    public void clearScreen() {
        out.print("\033[H\033[2J");
    }

    public void printPlayerTurn(PlayerMarkers player) {
        out.print("Player " + player.symbol() +"'s turn...");
    }
}
