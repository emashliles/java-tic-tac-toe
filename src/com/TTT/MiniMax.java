package com.TTT;

public class MiniMax {
    public int nextMove(Board board) {
        return -1;
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
