package com.psamatt.challenges.battleships.ship;

import static org.assertj.core.api.Assertions.assertThat;

import com.psamatt.challenges.battleships.coordinates.Coordinate;
import com.psamatt.challenges.battleships.coordinates.Coordinates;
import org.junit.jupiter.api.Test;

class ShipTest {

    public static final Coordinate LOWER = Coordinate.of(1, 0);
    public static final Coordinate UPPER = Coordinate.of(2, 0);

    @Test
    void shouldSinkShipOnAllHits() {
        Ship ship = new Ship(Coordinates.fromBoundaries(LOWER, UPPER));

        ship.attemptShot(LOWER);
        ship.attemptShot(UPPER);

        assertThat(ship.isAlive()).isFalse();
    }

    @Test
    void shouldBeAliveOnSingleShot() {
        Ship ship = new Ship(Coordinates.fromBoundaries(LOWER, UPPER));

        ship.attemptShot(LOWER);

        assertThat(ship.isAlive()).isTrue();
    }

    @Test
    void shouldBeAliveOnSingleShotAndMissedShot() {
        Ship ship = new Ship(Coordinates.fromBoundaries(LOWER, UPPER));

        ship.attemptShot(LOWER);
        ship.attemptShot(Coordinate.of(8, 9));

        assertThat(ship.isAlive()).isTrue();
    }
}
