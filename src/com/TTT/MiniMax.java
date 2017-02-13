package com.TTT;

public class MiniMax {

    private String currentPlayerSymbol;

    public int nextMove(Board board) {
        int bestScore = -20;
        int bestMove = -1;
        currentPlayerSymbol = PlayerMarkers.X.symbol();

        for(int move : board.availableMoves()) {
            Board clonedBoard = (Board) board.clone();
            if (getScoreForMove(move, clonedBoard, currentPlayerSymbol) > bestScore){
                bestMove = move;
                bestScore = getScoreForMove(move, clonedBoard, currentPlayerSymbol);
            }
        }
        return bestMove;
    }

    public int getScoreForMove(int move, Board board, String playerSymbol) {
        int bestScore = -20;

        board.placeMarker(move, playerSymbol);
        BoardEvaluator evaluator = new BoardEvaluator(board);

        if (evaluator.evaluate() == GameState.Win) {
            return 10;
        }

        if (evaluator.evaluate() == GameState.Tie) {
            return 0;
        }

        changePlayerSymbol();

        for (int nextMove : board.availableMoves()) {
            Board clonedBoard = (Board) board.clone();
            if (getScoreForMove(nextMove, clonedBoard, currentPlayerSymbol) > bestScore) {
                bestScore = getScoreForMove(nextMove, clonedBoard, currentPlayerSymbol);
            }
        }

        return bestScore;
    }

    private void changePlayerSymbol() {
        if(currentPlayerSymbol == PlayerMarkers.X.symbol()) {
            currentPlayerSymbol = PlayerMarkers.O.symbol();
        }
        else {
            currentPlayerSymbol = PlayerMarkers.X.symbol();
        }
    }
}
