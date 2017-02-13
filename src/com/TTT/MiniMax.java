package com.TTT;

public class MiniMax {
    public int nextMove(Board board) {
        int bestScore = 0;
        int bestMove = -1;

        for(int move : board.availableMoves()) {
            Board clonedBoard = (Board) board.clone();
            if (getScoreForMove(move, clonedBoard) > bestScore){
                bestMove = move;
                bestScore = getScoreForMove(move, clonedBoard);
            }
        }
        return bestMove;
    }

    public int getScoreForMove(int move, Board board) {
        board.placeMarker(move, PlayerMarkers.X.symbol());

        BoardEvaluator evaluator = new BoardEvaluator(board);

        if(evaluator.evaluate() == GameState.Win) {
            return 10;
        }

        if(evaluator.evaluate() == GameState.Tie) {
            return 0;
        }

        return -10;
    }
}
