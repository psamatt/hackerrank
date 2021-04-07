package com.psamatt.challenges.battleships.coordinates;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class CoordinatesTest {

    @Test
    void shouldGetCoordinatesFromXAxis() {
        Coordinate lower = Coordinate.of(4, 0);
        Coordinate upper = Coordinate.of(6, 0);

        Coordinates coordinates = Coordinates.fromBoundaries(lower, upper);

        assertThat(coordinates).containsExactlyInAnyOrder(lower, Coordinate.of(5, 0), upper);
    }

    @Test
    void shouldGetCoordinatesFromYAxis() {
        Coordinate lower = Coordinate.of(0, 2);
        Coordinate upper = Coordinate.of(0, 4);

        Coordinates coordinates = Coordinates.fromBoundaries(lower, upper);

        assertThat(coordinates).containsExactlyInAnyOrder(lower, Coordinate.of(0, 3), upper);
    }

    @Test
    void shouldBeOfSizeThree() {
        Coordinate lower = Coordinate.of(0, 2);
        Coordinate upper = Coordinate.of(0, 4);

        Coordinates coordinates = Coordinates.fromBoundaries(lower, upper);

        assertThat(coordinates.size()).isEqualTo(3);
    }
}
