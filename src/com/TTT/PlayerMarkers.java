package com.TTT;

public enum PlayerMarkers {
    X ("\u001B[31m " + "X" + " \u001B[0m"),
    O("\u001B[34m " + "O" + " \u001B[0m");

    private String printString;

    PlayerMarkers(String printString) {
        this.printString = printString;
    }

    public String printString(){
        return printString;
    }
}
