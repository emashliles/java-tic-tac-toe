package com.TTT;

public class Main {

    public static void main(String[] args) {
        Board board = new Board();
        BoardPrinter printer = new BoardPrinter(System.out);
        printer.printBoard(board);
    }
}
