package com.TTT;

import java.util.ArrayList;
import java.util.List;

public class MiniMax {
    private Board board;

    public MiniMax(Board board) {
        this.board = board;
    }

    public int evaluateMoves(List<Integer> availableMoves) {
        for (Integer move: availableMoves) {
            Board clonedBoard = (Board) board.clone();
            clonedBoard.placeMarker(move, "X");
            BoardEvaluator evaluator = new BoardEvaluator(clonedBoard);
            GameState moveOutcome = evaluator.evaluate();
            if(moveOutcome == GameState.Win){
                return move;
            }
            if(moveOutcome == GameState.Tie){
                return move;
            }
        }

        return 0;
    }
}
