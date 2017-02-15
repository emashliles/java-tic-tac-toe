package com.TTT;

import java.util.ArrayList;
import java.util.List;

public class MiniMax {

    public int nextMove(Board board, String currentPlayerSymbol){
        return -1;
    }

    public int getScoreForMove(int move, Board board, String playerSymbol, String maxingPlayerSymbol, String minimizingPlayerSymbol, int depth) {


        return -1;
    }

    private String changePlayerSymbol(String currentPlayerSymbol) {
        if (currentPlayerSymbol == PlayerMarkers.X.symbol()) {
            return PlayerMarkers.O.symbol();
        } else {
            return PlayerMarkers.X.symbol();
        }
    }
}
