package com.TTT;

public class Main {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        BoardSizeUI optionsUI = new BoardSizeUI(System.out, System.in);
        Board board = new Board(optionsUI.boardSize());
        PlayerOptionUI players = new PlayerOptionUI(System.out, System.in);
        players.introduce();
        Player player1 = players.playerOption();
        Player player2 = players.playerOption();
        Game game = new Game(board, player1, player2);

        game.play();

    }
}
