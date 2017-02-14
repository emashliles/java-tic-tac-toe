package com.TTT;

public class Main {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        BoardSizeUI optionsUI = new BoardSizeUI(System.out, System.in);
        Board board = new Board(optionsUI.boardSize());
        BoardPrinter printer = new BoardPrinter(System.out);
        TurnUI turns = new TurnUI(printer, System.out, System.in);
        Player player1 = new HumanPlayer(turns);
        Player player2 = new ComputerPlayer();
        Game game = new Game(board, player1, player2);

       game.play();

       printer.printBoard(board);
    }
}
