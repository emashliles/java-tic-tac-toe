package com.TTT;

public class MiniMax {

    public int nextMove(Board board, String currentPlayerSymbol) {
        int bestScore = -200;
        int bestMove = -1;

        for(int move : board.availableMoves()) {
            Board clonedBoard = (Board) board.clone();

            int score = getScoreForMove(move, clonedBoard, currentPlayerSymbol, currentPlayerSymbol, changePlayerSymbol(currentPlayerSymbol));
            if (score > bestScore){
                bestMove = move;
                bestScore = score;
            }
        }
        return bestMove;
    }

    public int getScoreForMove(int move, Board board, String playerSymbol, String maxingPlayerSymbol, String minimizingPlayerSymbol) {
        int bestScore = -200;

        board.placeMarker(move, playerSymbol);
        BoardEvaluator evaluator = new BoardEvaluator(board);

        if (evaluator.evaluate() == GameState.Win && playerSymbol.equals(maxingPlayerSymbol)) {
            return 10;
        }

        if (evaluator.evaluate() == GameState.Tie && playerSymbol.equals(maxingPlayerSymbol)) {
            return 0;
        }

        if (evaluator.evaluate() == GameState.Win && playerSymbol.equals(minimizingPlayerSymbol)) {
            return -10;
        }

        if(evaluator.evaluate() == GameState.Tie && playerSymbol.equals(minimizingPlayerSymbol)) {
            return 0;
        }

        for (int nextMove : board.availableMoves()) {
            Board clonedBoard = (Board) board.clone();

            int score = getScoreForMove(nextMove, clonedBoard, changePlayerSymbol(playerSymbol), maxingPlayerSymbol, minimizingPlayerSymbol);
            bestScore = score;
        }

        return bestScore;
    }

    private String changePlayerSymbol(String currentPlayerSymbol) {
        if(currentPlayerSymbol == PlayerMarkers.X.symbol()) {
            return PlayerMarkers.O.symbol();
        }
        else {
            return PlayerMarkers.X.symbol();
        }
    }
}
