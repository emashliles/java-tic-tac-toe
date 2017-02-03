package com.TTT;

import java.util.List;

public class TTTRow {
    private List<Integer> spaces;

    public TTTRow(List<Integer> spaces) {

        this.spaces = spaces;
    }

    public int size() {
        return spaces.size();
    }

    public int getSpaceIndex(int i) {
        return spaces.get(i);
    }
}
