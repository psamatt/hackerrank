package com.psamatt.challenges.battleships.coordinates;

import static java.lang.Integer.parseInt;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Scanner;

public class StdInCoordinateReader implements CoordinateReader {

    private final Scanner scanner;
    private final String stopCommand;

    public StdInCoordinateReader(Scanner scanner, String stopCommand) {
        this.scanner = scanner;
        this.stopCommand = stopCommand;
    }

    @Override
    public Collection<Coordinates> readCoordinates() {
        Collection<Coordinates> coordinates = new ArrayList<>();
        String line = scanner.nextLine();
        while (!line.equalsIgnoreCase(stopCommand)) {
            coordinates.add(toCoordinates(line));
            line = scanner.nextLine();
        }
        return List.copyOf(coordinates);
    }

    @Override
    public Coordinate readCoordinate() {
        return buildCoordinate(scanner.nextLine());
    }

    private Coordinates toCoordinates(String line) {
        String[] coords = line.split(":");
        Coordinate lower = buildCoordinate(coords[0]);
        Coordinate upper = buildCoordinate(coords[1]);
        return Coordinates.fromBoundaries(lower, upper);
    }

    private Coordinate buildCoordinate(String coords) {
        String[] upperCoords = coords.split(" ");
        return Coordinate.of(parseInt(upperCoords[0]), parseInt(upperCoords[1]));
    }
}
