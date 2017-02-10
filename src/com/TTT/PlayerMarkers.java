package com.TTT;

public enum PlayerMarkers {
    X ("X", "\u001B[31m  X \u001B[0m"),
    O ("O", "\u001B[34m  O \u001B[0m");

    private String display;
    private String symbol;

    PlayerMarkers(String symbol, String display) {
        this.display = display;
        this.symbol = symbol;
    }

    public String display(){
        return display;
    }

    public String symbol(){
        return symbol;
    }
}
