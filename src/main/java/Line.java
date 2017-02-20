import java.util.List;

public class Line {

    private List<Integer> spaces;

    public Line(List<Integer> spaces) {
        this.spaces = spaces;
    }

    public int size() {
        return spaces.size();
    }

    public int getSpaceIndex(int i) {
        return spaces.get(i);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Line line = (Line) o;

        return (this.hashCode() == line.hashCode());
    }

    @Override
    public int hashCode() {
        return spaces.hashCode();
    }
}
