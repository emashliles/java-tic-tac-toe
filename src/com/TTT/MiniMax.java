package com.TTT;

import java.util.ArrayList;
import java.util.List;

public class MiniMax {

    private PlayerMarkers maxPlayer;
    private PlayerMarkers minPlayer;

    public int nextMove(Board board, PlayerMarkers maxPlayer){
        this.maxPlayer = maxPlayer;
        this.minPlayer = changePlayer(maxPlayer);

        List<Integer> moves = board.availableMoves();
        List<Integer> scores = new ArrayList<>();

        for(int move : moves) {
            Board clone = board.clone();
            clone.placeMarker(move, maxPlayer.symbol());
            scores.add(miniMax(maxPlayer, clone));
        }

        int bestScore = -200;
        int bestMove = -1;
        for(int i = 0; i < scores.size(); i++) {
            if(scores.get(i) > bestScore) {
                bestScore = scores.get(i);
                bestMove = moves.get(i);
            }
        }

        return bestMove;
    }

    public int miniMax(PlayerMarkers currentPlayer, Board board) {

        BoardEvaluator evaluator = new BoardEvaluator(board);
        if(evaluator.evaluate().equals(GameState.Win)) {
            return 10;
        }

        if(evaluator.evaluate().equals(GameState.Tie)) {
            return 0;
        }

        List<Integer> scores = new ArrayList<>();

        if(currentPlayer == maxPlayer){
            for(int move : board.availableMoves()) {
                Board clone = board.clone();
                clone.placeMarker(move, currentPlayer.symbol());
                int score = miniMax(changePlayer(currentPlayer), clone);
                scores.add(score);
            }
            return bestScore(scores, true);
        }
        else {
            for(int move : board.availableMoves()) {
                Board clone = board.clone();
                clone.placeMarker(move, currentPlayer.symbol());
                scores.add(miniMax(changePlayer(currentPlayer), clone));
            }
            return bestScore(scores, false);
        }
    }

    private int bestScore(List<Integer> scores, boolean maximize) {
        if(maximize) {
            int maxScore = -200;
            for (int score : scores) {
                if(score > maxScore) {
                    maxScore = score;
                }
            }
            return maxScore;
        }
        else {
            int minScore = 200;
            for (int score : scores) {
                if (score < minScore) {
                    minScore = score;
                }
            }
            return minScore;
        }
    }

    public int getScoreForMove(int move, Board board, String symbol) {
        return 0;
    }

    private PlayerMarkers changePlayer(PlayerMarkers currentPlayer) {
        if (currentPlayer == PlayerMarkers.X) {
            return PlayerMarkers.O;
        } else {
            return PlayerMarkers.X;
        }
    }
}
