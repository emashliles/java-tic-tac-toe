package com.TTT;

public class Board {

    private String[] spaces;

    public Board() {
        spaces = new String[]{"1","2","3","4"};
    }

    public int size() {
        return 2;
    }

    public int getContents(int space) {
        return 3;
    }

    public boolean isOccupied(int space) {
        return spaces[space] == "X";
    }

    public void placeMarker(int space, String marker) {
        spaces[space] = marker;
    }
}
