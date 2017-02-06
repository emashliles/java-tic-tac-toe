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
}
