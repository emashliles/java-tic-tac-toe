package com.TTT;

import java.util.ArrayList;
import java.util.List;

public class MiniMax {

    public static final int DEFAULT_MAX_SCORE = 200;
    public static final int DEFAULT_BEST_MOVE = -1;
    public static final int DEFAULT_MIN_SCORE = -200;

    public static final int MAX_PLAYER_WIN_SCORE = 10;
    public static final int MIN_PLAYER_WIN_SCORE = -10;
    public static final int TIE_SCORE = 0;
    private PlayerMarkers maxPlayer;

    public int nextMove(Board board, PlayerMarkers maxPlayer) {
        this.maxPlayer = maxPlayer;

        List<Integer> moves = board.availableMoves();
        List<Integer> scores = new ArrayList<>();

        if(nonCalculatedMove(board)) {
            return board.availableMoves().get(0);
        }

        for(int move : moves) {
            Board clone = board.clone();
            clone.placeMarker(move, maxPlayer.symbol());
            scores.add(miniMax(maxPlayer, clone, DEFAULT_MIN_SCORE, DEFAULT_MAX_SCORE, 1));
        }

        int bestScore = DEFAULT_MIN_SCORE;
        int bestMove = DEFAULT_BEST_MOVE;
        for(int i = 0; i < scores.size(); i++) {
            if(scores.get(i) > bestScore) {
                bestScore = scores.get(i);
                bestMove = moves.get(i);
            }
        }
        return bestMove;
    }

    public int miniMax(PlayerMarkers currentPlayer, Board board, int alpha, int beta, int depth) {
        BoardEvaluator evaluator = new BoardEvaluator(board);
        if(evaluator.evaluate().equals(GameState.Win) && currentPlayer == maxPlayer) {
            return MAX_PLAYER_WIN_SCORE;
        }

        if(evaluator.evaluate().equals(GameState.Win) && currentPlayer != maxPlayer) {
            return MIN_PLAYER_WIN_SCORE;
        }

        if(evaluator.evaluate().equals(GameState.Tie)) {
            return TIE_SCORE;
        }

        if(depth >= 5) {
            return -1;
        }

        currentPlayer = changePlayer(currentPlayer);

        if(currentPlayer == maxPlayer){
            for(int move : board.availableMoves()) {
                Board clone = board.clone();
                clone.placeMarker(move, currentPlayer.symbol());
                int score = miniMax(currentPlayer, clone, alpha, beta, depth++);
                if(score > alpha) {
                    alpha = score;
                }
                if(alpha >= beta) {
                    break;
                }
            }
            return alpha;
        }
        else {
            for(int move : board.availableMoves()) {
                Board clone = board.clone();
                clone.placeMarker(move, currentPlayer.symbol());
                int score = miniMax(currentPlayer, clone, alpha, beta, depth++);
                if(score < beta) {
                    beta = score;
                }
                if(alpha >= beta) {
                    break;
                }
            }
            return beta;
        }
    }

    private PlayerMarkers changePlayer(PlayerMarkers currentPlayer) {
        if (currentPlayer == PlayerMarkers.X) {
            return PlayerMarkers.O;
        } else {
            return PlayerMarkers.X;
        }
    }

    private boolean nonCalculatedMove(Board board) {
        return (board.sideLength() > 3) && board.availableMoves().size() > (board.size() - 5);
    }
}
