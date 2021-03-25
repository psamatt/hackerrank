package com.psamatt.hackerrank.battleships;

import com.psamatt.hackerrank.battleships.board.Board;
import com.psamatt.hackerrank.battleships.coordinates.Coordinate;
import com.psamatt.hackerrank.battleships.coordinates.CoordinateReader;
import com.psamatt.hackerrank.battleships.coordinates.Coordinates;
import com.psamatt.hackerrank.battleships.coordinates.StdInCoordinateReader;
import com.psamatt.hackerrank.battleships.ship.FleetStatus;
import com.psamatt.hackerrank.battleships.ship.Ship;
import java.util.Collection;
import java.util.Scanner;

public class Game {

    private static final String START_CMD = "BEGIN";

    private final GameConfiguration gameConfiguration;
    private final CoordinateReader coordinateReader;
    private final GameOutputWriter gameOutputWriter;

    public Game(
            GameConfiguration gameConfiguration,
            CoordinateReader coordinateReader,
            GameOutputWriter gameOutputWriter) {
        this.gameConfiguration = gameConfiguration;
        this.coordinateReader = coordinateReader;
        this.gameOutputWriter = gameOutputWriter;
    }

    public FleetStatus start() {
        gameOutputWriter.outputHeader(START_CMD);
        Board board = new Board(gameConfiguration.getBoardSize());
        Collection<Coordinates> coordinates = coordinateReader.readCoordinates();
        coordinates.forEach(coords -> board.place(new Ship(coords)));

        return takeShots(board).getFleetStatus();
    }

    private Board takeShots(Board board) {
        gameOutputWriter.outputStart();
        int shots = 0;
        Coordinate coordinate = coordinateReader.readCoordinate();
        while (gameConfiguration.getTotalShots() > shots) {
            shots++;
            FleetStatus fleetStatus = board.recordShot(coordinate);
            if (fleetStatus == FleetStatus.SUNK) {
                gameOutputWriter.outputVictory();
                break;
            } else {
                gameOutputWriter.output(board);
                coordinate = coordinateReader.readCoordinate();
            }
        }
        gameOutputWriter.output(board);
        return board;
    }

    public static void main(String[] args) {
        Game game =
                new Game(
                        GameConfiguration.withDefaultValues(),
                        new StdInCoordinateReader(new Scanner(System.in), START_CMD),
                        new GameOutputWriter(System.out));
        game.start();
    }
}
