package com.TTT;

public class BoardEvaluator {
    private Board board;

    public BoardEvaluator(Board board) {
        this.board = board;
    }

    public GameState evaluate() {
        GameState gameState = GameState.NoWinner;

        gameState = evaluateRows(gameState);

        gameState = evaluateColumns(gameState);

        gameState = evaluateDiagonals(gameState);

        return gameState;
    }

    private GameState evaluateDiagonals(GameState gameState) {
            TTTLine leftToRightDiagonal = board.getLeftToRightDiagonal();

            if(checkLineIsWin(leftToRightDiagonal))
                return GameState.Win;

            TTTLine rightToLeftDiagonal = board.getRightToLeftDiagonal();

            if(checkLineIsWin(rightToLeftDiagonal))
                gameState = GameState.Win;

        return gameState;
    }

    private GameState evaluateRows(GameState gameState) {
        for(int i = 0; i < board.sideLength(); i++) {
           TTTLine row = board.getRow(i);

           if(checkLineIsWin(row))
               gameState = GameState.Win;
        }
        return gameState;
    }

    private GameState evaluateColumns(GameState gameState) {
        for(int i = 0; i < board.sideLength(); i++) {
            TTTLine column = board.getColumn(i);

            if(checkLineIsWin(column))
                gameState = GameState.Win;
        }
        return gameState;
    }

    public boolean checkLineIsWin(TTTLine row) {
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
