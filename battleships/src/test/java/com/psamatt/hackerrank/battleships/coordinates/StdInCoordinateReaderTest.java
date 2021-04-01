package com.psamatt.hackerrank.battleships.coordinates;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Collection;
import java.util.Scanner;
import org.junit.jupiter.api.Test;

class StdInCoordinateReaderTest {

    private static final String STOP = "STOP";

    private StdInCoordinateReader coordinateReader;

    @Test
    void shouldReadCoordinates() {
        coordinateReader =
                new StdInCoordinateReader(
                        new Scanner("1 0:2 0" + System.lineSeparator() + STOP), STOP);

        Collection<Coordinates> coordinates = coordinateReader.readCoordinates();

        assertThat(coordinates)
                .containsExactly(
                        Coordinates.fromBoundaries(Coordinate.of(1, 0), Coordinate.of(2, 0)));
    }

    @Test
    void shouldReadCoordinate() {
        coordinateReader =
                new StdInCoordinateReader(new Scanner("1 0" + System.lineSeparator() + STOP), STOP);

        Coordinate coordinate = coordinateReader.readCoordinate();

        assertThat(coordinate).isEqualTo(Coordinate.of(1, 0));
    }
}
