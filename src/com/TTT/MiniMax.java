package com.TTT;

import java.util.ArrayList;
import java.util.List;

public class MiniMax {
    private Board board;
    private List<Move> moves;
    private List<Integer> availableMoves;
    private String maxMarker;
    private String miniMarker;

    public MiniMax(Board board) {
        this.board = board;
        moves = new ArrayList<>();
        maxMarker = "X";
        miniMarker = "O";
    }

    public void evaluateMoves() {
        availableMoves = board.availableMoves();
        for (Integer move: availableMoves){
            Move currentMove = new Move(move, 0);
            currentMove.isParent = true;
            evaluateMoves(maxMarker, board, currentMove);
        }
    }

    public void evaluateMoves(String marker, Board board, Move previousMove) {
        List<Integer> availableMoves = board.availableMoves();
        for (Integer move : availableMoves) {

            Board clonedBoard = (Board) board.clone();

            clonedBoard.placeMarker(move, marker);
            BoardEvaluator evaluator = new BoardEvaluator(clonedBoard);
            GameState moveOutcome = evaluator.evaluate();
            Move newMove = addMoveOutcome(move, moveOutcome, marker, previousMove);
            if(moveOutcome == GameState.Tie || moveOutcome == GameState.Win){
                return;
            }

            marker = changePlayer(marker);

            evaluateMoves(marker, clonedBoard, newMove);
        }
    }

    private Move addMoveOutcome(Integer move, GameState moveOutcome, String marker, Move previousMove) {
        Move newMove = new Move(move, 0);
        if (marker == maxMarker) {
            if (moveOutcome == GameState.Win) {
                newMove.moveScore = 10;
                addMoveToMoves(newMove, previousMove);
            }
            if (moveOutcome == GameState.Tie) {
                addMoveToMoves(newMove, previousMove);
            }
            if (moveOutcome == GameState.NoWinner) {
                addMoveToMoves(newMove, previousMove);
            }
        }
        if (marker == miniMarker){
            if (moveOutcome == GameState.Win) {
                newMove.moveScore = -10;
                addMoveToMoves(newMove, newMove);
            }
            if (moveOutcome == GameState.Tie) {
                addMoveToMoves(newMove, previousMove);
            }
            if (moveOutcome == GameState.NoWinner) {
                addMoveToMoves(newMove, previousMove);

            }
        }
        return newMove;
    }

    private void addMoveToMoves(Move move, Move previousMove) {
       if(previousMove.isParent) {
           previousMove.childMoves.add(move);
       }
       else{
           moves.add(move);
       }
    }

    private String changePlayer(String marker) {
        if(marker == maxMarker)
        {
            return miniMarker;
        }
        else {
            return maxMarker;
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
