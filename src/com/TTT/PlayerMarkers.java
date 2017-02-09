package com.TTT;

public enum PlayerMarkers {
    X ("\u001B[31m X \u001B[0m"),
    O ("\u001B[34m O \u001B[0m");

    private String display;

    PlayerMarkers(String display) {
        this.display = display;
    }

    public String display(){
        return display;
    }
}
