package com.TTT;

import java.util.ArrayList;
import java.util.List;

public class Move {

    public int moveIndex;
    public int moveScore;
    public List<Move> childMoves;
    public boolean isParent;

    public Move(Integer move, int score) {
        this.moveIndex = move;
        this.moveScore = score;
        childMoves = new ArrayList<>();
    }
}
