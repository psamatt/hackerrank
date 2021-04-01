package com.psamatt.hackerrank.battleships.board;

public enum CellStatus {
    INACTIVE('-'),
    HIT('h'),
    MISS('m'),
    SUNK('s');

    private final char c;

    CellStatus(char c) {
        this.c = c;
    }

    public char getChar() {
        return c;
    }
}
