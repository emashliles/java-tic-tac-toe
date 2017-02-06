package com.TTT;

import java.util.ArrayList;
import java.util.List;

public class MiniMax {
    private Board board;

    public MiniMax(Board board) {
        this.board = board;
    }

    public List<Integer> availableMoves() {
        List<Integer> availableMoves = new ArrayList<>();

        for(int i = 0; i < board.size(); i++) {
            if(!board.isOccupied(i)){
                availableMoves.add(i);
            }
        }
        return availableMoves;
    }

    public int evaluateMoves(List<Integer> availableMoves) {
        for (Integer move: availableMoves) {
            Board clonedBoard = (Board) board.clone();
            clonedBoard.placeMarker(move, "X");
            BoardEvaluator evaluator = new BoardEvaluator(clonedBoard);
            if(evaluator.evaluate() == GameState.Win)
                return move;
        }

        return 0;
    }
}
