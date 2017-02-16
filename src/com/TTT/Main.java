package com.TTT;

public class Main {

    public static void main(String[] args) {
        run();
    }

    private static void run() {
        GameUI gameUI = new GameUI(System.out, new BoardPrinter(System.out));
        BoardSizeUI optionsUI = new BoardSizeUI(System.out, System.in, gameUI);
        Board board = new Board(optionsUI.boardSize());
        PlayerOptionUI players = new PlayerOptionUI(System.out, System.in, gameUI);
        players.introduce();
        players.playerOption();
        Player player1 = players.player(1);
        Player player2 = players.player(2);
        Game game = new Game(board, player1, player2);

        game.play();

    }
}
