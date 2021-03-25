package com.psamatt.hackerrank.battleships.coordinates;

import java.util.Collection;

public interface CoordinateReader {
    Collection<Coordinates> readCoordinates();

    Coordinate readCoordinate();
}
