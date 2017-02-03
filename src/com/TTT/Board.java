package com.TTT;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private String[] spaces;

    public Board() {
        spaces = new String[]{"1","2","3","4","5","6","7","8","9"};
    }

    public int size() {
        return spaces.length;
    }

    public boolean isOccupied(int space) {
        return spaces[space] == "X";
    }

    public void placeMarker(int space, String marker) {
        spaces[space] = marker;
    }

    public String markerAt(int space) {
        return spaces[space];
    }

    public TTTRow getRow(int rowNumber) {
        List<Integer> row= new ArrayList<>();
        int rowStartIndex = rowNumber * sideLength();

        for(int i = rowStartIndex; i < rowStartIndex + sideLength() ; i++) {
            row.add(i);
        }
        return new TTTRow(row);
    }

    public int sideLength() {
        return 3;
    }

    public TTTRow getColumn(int columnNumber) {
        List<Integer> row = new ArrayList<>();
        int columnStartIndex = columnNumber;
        int maximumColumnValue =((sideLength() * sideLength()) - sideLength()) + (columnStartIndex + 1);

        for(int i = columnStartIndex; i < maximumColumnValue; i += sideLength()) {
            row.add(i);
        }
        return new TTTRow(row);
    }
}
