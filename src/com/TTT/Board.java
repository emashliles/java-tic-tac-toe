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

    public int sideLength() {
        return 3;
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

    public TTTLine getRow(int rowNumber) {
        List<Integer> row= new ArrayList<>();
        int rowStartIndex = rowNumber * sideLength();

        for(int i = rowStartIndex; i < rowStartIndex + sideLength() ; i++) {
            row.add(i);
        }
        return new TTTLine(row);
    }

    public TTTLine getColumn(int columnNumber) {
        List<Integer> column = new ArrayList<>();
        int maximumColumnValue = maximumColumnValue(columnNumber);

        for(int i = columnNumber; i < maximumColumnValue + 1; i += sideLength()) {
            column.add(i);
        }
        return new TTTLine(column);
    }

    public TTTLine getLeftToRightDiagonal() {
        List<Integer> diagonal = new ArrayList<>();

        for(int i = 0; i < size() + 1; i += (sideLength()) + 1) {
            diagonal.add(i);
        }
        return new TTTLine(diagonal);
    }

    public TTTLine getRightToLeftDiagonal() {
        List<Integer> diagonal = new ArrayList<>();

        for(int i = (sideLength() - 1); i < (size() -1); i += (sideLength()) + -1) {
            diagonal.add(i);
        }
        return new TTTLine(diagonal);
    }

    private int maximumColumnValue(int columnNumber) {
        return ((sideLength() * sideLength()) - sideLength()) + columnNumber;
    }
}
