package com.psamatt.challenges.battleships.coordinates;

import java.util.Collection;

public interface CoordinateReader {
    Collection<Coordinates> readCoordinates();

    Coordinate readCoordinate();
}
