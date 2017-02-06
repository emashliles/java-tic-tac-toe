package com.TTT;

import java.util.ArrayList;
import java.util.List;

public class MiniMax {
    private Board board;
    private Board clonedBoard;
    private List<Move> moves;
    private List<Integer> availableMoves;

    public MiniMax(Board board) {
        this.board = board;
        this.availableMoves = board.availableMoves();
        moves = new ArrayList<>();
    }

    public void evaluateMoves(String marker){
        evaluateMoves(availableMoves, marker);
    };

    public void evaluateMoves(List<Integer> availableMoves, String marker) {
        for (Integer move: availableMoves) {

            if(clonedBoard == null){
                clonedBoard = (Board) board.clone();
            }
            else {
                clonedBoard = (Board) clonedBoard.clone();
            }

            clonedBoard.placeMarker(move, marker);
            BoardEvaluator evaluator = new BoardEvaluator(clonedBoard);
            GameState moveOutcome = evaluator.evaluate();
            if(moveOutcome == GameState.Win){
                moves.add(new Move(move, 10));
            }
            if(moveOutcome == GameState.Tie){
                moves.add(new Move(move, 0));
            }
            if(moveOutcome == GameState.NoWinner){
                moves.add(new Move(move, -10));
            }

            if(marker == "X")
            {
                marker = "O";
            }
            else {
                marker = "X";
            }
        }
    }

    public int selectBestMove() {
        for(Move move : moves){
            if(move.moveScore == 10) {
                return move.moveIndex;
            }
        }
        for (Move move : moves){
            if(move.moveScore == 0){
                return move.moveIndex;
            }
        }
        return moves.get(0).moveIndex;
    }
}
