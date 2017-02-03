package com.TTT;

public class BoardEvaluator {
    private Board board;

    public BoardEvaluator(Board board) {
        this.board = board;
    }

    public GameState evaluate() {
        int rows = board.sideLength();
        GameState gameState = GameState.NoWinner;

        for(int i = 0; i < rows; i++) {
           TTTRow row = board.getRow(i);

           if(checkRowIsWin(row))
               gameState = GameState.Win;
        }

        return gameState;
    }

    public boolean checkRowIsWin(TTTRow row) {
        boolean win = false;
        String marker = "";

        for(int i = 0; i < row.size(); i ++){
            if(board.markerAt(row.getSpaceIndex(i)) == marker && marker != "" ) {
                win = true;
            }
            else {
                win = false;
            }

            if(marker == "") {
                marker = board.markerAt(row.getSpaceIndex(i));
            }
        }
        return win;
    }
}
