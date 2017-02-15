package com.TTT;

import java.util.ArrayList;
import java.util.List;

public class MiniMax {

    public int nextMove(Board board, String currentPlayerSymbol) {
        List<Integer> scores = new ArrayList<>();
        List<Integer> moves = new ArrayList<>();

        for (int move : board.availableMoves()) {
            Board clonedBoard = board.clone();

            clonedBoard.placeMarker(move, currentPlayerSymbol);

            scores.add(getScoreForMove(move, clonedBoard, currentPlayerSymbol, currentPlayerSymbol, changePlayerSymbol(currentPlayerSymbol), 1));
            moves.add(move);
        }

        if (moves.size() == 1) {
            return moves.get(0);
        }

        int winningMove = -200;
        int winningScore = -200;
        for (int i = 0; i < moves.size(); i++) {
            if (scores.get(i) > winningScore) {
                winningMove = moves.get(i);
                winningScore = scores.get(i);
            }
        }

        return winningMove;
    }

    public int getScoreForMove(int move, Board board, String playerSymbol, String maxingPlayerSymbol, String minimizingPlayerSymbol, int depth) {
        int bestScore = -200;

        board.placeMarker(move, playerSymbol);
        BoardEvaluator evaluator = new BoardEvaluator(board);

        if (evaluator.evaluate() == GameState.Win && playerSymbol.equals(maxingPlayerSymbol)) {
            return 10 - depth;
        }

        if (evaluator.evaluate() == GameState.Tie) {
            return 0;
        }

        if (evaluator.evaluate() == GameState.Win && playerSymbol.equals(minimizingPlayerSymbol)) {
            return depth - 10;
        }

        for (int nextMove : board.availableMoves()) {
            Board clonedBoard = board.clone();
            int score = getScoreForMove(nextMove, clonedBoard, changePlayerSymbol(playerSymbol), maxingPlayerSymbol, minimizingPlayerSymbol, depth++);
            bestScore = score;
        }


        return bestScore;
    }

    private String changePlayerSymbol(String currentPlayerSymbol) {
        if (currentPlayerSymbol == PlayerMarkers.X.symbol()) {
            return PlayerMarkers.O.symbol();
        } else {
            return PlayerMarkers.X.symbol();
        }
    }
}
