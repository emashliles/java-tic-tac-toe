package com.TTT;

public class Main {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        BoardSizeUI optionsUI = new BoardSizeUI(System.out, System.in);
        Board board = new Board(optionsUI.boardSize());
        PlayerOptionUI players = new PlayerOptionUI(System.out, System.in);
        Player player1 = players.playerOption(1);
        Player player2 = players.playerOption(2);
        Game game = new Game(board, player1, player2);

        game.play();

    }
}
