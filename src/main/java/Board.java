import java.util.ArrayList;
import java.util.List;

public class Board {

    private String[] spaces;

    public Board(int size) {
        spaces = new String[size * size];

        for(int i = 0; i < size * size; i ++) {
            Integer contents = i + 1;
            spaces[i] = contents.toString();
        }
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
        List<Integer> row = new ArrayList<>();
        int lineStartIndex = rowNumber * sideLength();

        for (int i = lineStartIndex; i < lineStartIndex + sideLength(); i++) {
            row.add(i);
        }
        return new Line(row);
    }

    public Line getColumn(int columnNumber) {
        List<Integer> column = new ArrayList<>();
        int maximumColumnValue = maximumColumnValue(columnNumber);

        for (int i = columnNumber; i < maximumColumnValue + 1; i += sideLength()) {
            column.add(i);
        }
        return new Line(column);
    }

    public Line getLeftToRightDiagonal() {
        List<Integer> diagonal = new ArrayList<>();

        for (int i = 0; i < size() + 1; i += (sideLength()) + 1) {
            diagonal.add(i);
        }
        return new Line(diagonal);
    }

    public Line getRightToLeftDiagonal() {
        List<Integer> diagonal = new ArrayList<>();

        for (int i = (sideLength() - 1); i < (size() - 1); i += (sideLength()) + -1) {
            diagonal.add(i);
        }
        return new Line(diagonal);
    }

    public List<Line> allLines() {
        List<Line> lines = new ArrayList<>();

        for (int i = 0; i < sideLength(); i++) {
            lines.add(getRow(i));
            lines.add(getColumn(i));
        }

        lines.add(getLeftToRightDiagonal());
        lines.add(getRightToLeftDiagonal());
        return lines;
    }

    private int maximumColumnValue(int columnNumber) {
        return ((sideLength() * sideLength()) - sideLength()) + columnNumber;
    }

    public List<Integer> availableMoves() {
        List<Integer> availableMoves = new ArrayList<>();

        for (int i = 0; i < size(); i++) {
            if (!isOccupied(i)) {
                availableMoves.add(i);
            }
        }
        return availableMoves;
    }

    @Override
    public Board clone() {
        Board clone = new Board(this.sideLength());
        for (int i = 0; i < this.size(); i++){
            if(isOccupied(i)){
                clone.placeMarker(i, spaces[i]);
            }
        }

        return clone;
    }

    public boolean selectionOnBoard(int space) {
        if(space > (size() - 1) || space < 0) {
            return false;
        }
        return true;
    }
}
