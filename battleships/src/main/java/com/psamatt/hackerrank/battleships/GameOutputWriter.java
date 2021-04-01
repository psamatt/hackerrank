package com.psamatt.hackerrank.battleships;

import com.psamatt.hackerrank.battleships.board.Board;
import com.psamatt.hackerrank.battleships.board.CellStatus;
import com.psamatt.hackerrank.battleships.coordinates.Coordinate;
import java.io.PrintStream;

public class GameOutputWriter {

    private final PrintStream out;

    public GameOutputWriter(PrintStream out) {
        this.out = out;
    }

    public void outputHeader(String command) {
        out.println("Register ships to start the game, one per line in the format ");
        out.println("In the format of their lower and upper coordinate boundaries i.e 1 0:2 0");
        out.println("Once finished, start the game by entering " + command);
    }

    public void outputStart() {
        out.println("Shots are registered for each coordinate i.e 1 0");
    }

    public void output(Board board) {
        int size = board.getSize();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                CellStatus cellStatus = board.getCellStatus(Coordinate.of(i, j));
                out.print(cellStatus.getChar() + " ");
            }
            out.println();
        }
    }

    public void outputVictory() {
        out.println("Congratulations, you have won!");
    }
}
