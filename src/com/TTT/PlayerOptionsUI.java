package com.TTT;

import java.io.ByteArrayInputStream;
import java.io.PrintStream;

public class PlayerOptionsUI {
    public PlayerOptionsUI(ByteArrayInputStream in, PrintStream out) {
    }

    public IPlayer getPlayer1() {
        return new HumanPlayer();
    }
}
