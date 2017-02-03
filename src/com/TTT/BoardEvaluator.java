package com.TTT;

public class BoardEvaluator {
    private Board board;

    public BoardEvaluator(Board board) {
        this.board = board;
    }

    public GameState evaluate() {
        GameState gameState = GameState.NoWinner;

        for (Line line :
                board.allLines()) {
            if(checkLineIsWin(line)){
                return GameState.Win;
            }

        }
        return gameState;
    }

    public boolean checkLineIsWin(Line line) {
        boolean win = false;
        String marker = "";

        for(int i = 0; i < line.size(); i ++){
            if(board.markerAt(line.getSpaceIndex(i)) == marker && marker != "" ) {
                win = true;
            }
            else {
                win = false;
            }

            if(marker == "") {
                marker = board.markerAt(line.getSpaceIndex(i));
            }
        }
        return win;
    }
}
