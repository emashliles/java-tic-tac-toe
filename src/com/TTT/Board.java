package com.TTT;

import java.util.ArrayList;
import java.util.List;

public class Board {

    private String[] spaces;

    public Board() {
        spaces = new String[]{"1","2","3","4","5","6","7","8","9"};
    }

    public Board(int size) {
        spaces = new String[]{"1","2","3","4","5","6","7","8","9","10","11", "12", "13", "14", "15", "16"};
    }

    public int size() {
        return spaces.length;
    }

    public int sideLength() {
        return (int) Math.sqrt(spaces.length);
    }

    public boolean isOccupied(int space) {
        return spaces[space].equals(PlayerMarkers.O.symbol()) || spaces[space].equals(PlayerMarkers.X.symbol());
    }

    public void placeMarker(int space, String marker) {
        spaces[space] = marker;
    }

    public String markerAt(int space) {
        return spaces[space];
    }

    public Line getRow(int rowNumber) {
        List<Integer> row= new ArrayList<>();
        int rowStartIndex = rowNumber * sideLength();

        for(int i = rowStartIndex; i < rowStartIndex + sideLength() ; i++) {
            row.add(i);
        }
        return new Line(row);
    }

    public Line getColumn(int columnNumber) {
        List<Integer> column = new ArrayList<>();
        int maximumColumnValue = maximumColumnValue(columnNumber);

        for(int i = columnNumber; i < maximumColumnValue + 1; i += sideLength()) {
            column.add(i);
        }
        return new Line(column);
    }

    public Line getLeftToRightDiagonal() {
        List<Integer> diagonal = new ArrayList<>();

        for(int i = 0; i < size() + 1; i += (sideLength()) + 1) {
            diagonal.add(i);
        }
        return new Line(diagonal);
    }

    public Line getRightToLeftDiagonal() {
        List<Integer> diagonal = new ArrayList<>();

        for(int i = (sideLength() - 1); i < (size() -1); i += (sideLength()) + -1) {
            diagonal.add(i);
        }
        return new Line(diagonal);
    }

    private int maximumColumnValue(int columnNumber) {
        return ((sideLength() * sideLength()) - sideLength()) + columnNumber;
    }

    public List<Line> allLines() {
        List<Line> lines = new ArrayList<>();

        for(int i = 0; i < sideLength(); i ++) {
            lines.add(getRow(i));
            lines.add(getColumn(i));
        }

        lines.add(getLeftToRightDiagonal());
        lines.add(getRightToLeftDiagonal());
        return lines;
    }

}
