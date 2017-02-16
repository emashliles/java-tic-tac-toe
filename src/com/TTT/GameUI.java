package com.TTT;

import java.io.InputStream;
import java.io.PrintStream;

public class GameUI {
    private PrintStream out;
    private InputStream in;
    private BoardPrinter printer;

    public GameUI(PrintStream out, InputStream in, BoardPrinter printer) {
        this.out = out;
        this.in = in;
        this.printer = printer;
    }

    public void announceWinner(Board board, String winningMarker) {
        if(isOver(board) == GameState.Win) {
            printer.printBoard(board);
            out.print("Player " + winningMarker + " is the winner.\n");
        }

        if (isOver(board) == GameState.Tie){
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
}
