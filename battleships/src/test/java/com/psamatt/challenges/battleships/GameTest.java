package com.psamatt.challenges.battleships;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

import com.psamatt.challenges.battleships.coordinates.Coordinate;
import com.psamatt.challenges.battleships.coordinates.CoordinateReader;
import com.psamatt.challenges.battleships.coordinates.Coordinates;
import com.psamatt.challenges.battleships.ship.FleetStatus;
import java.util.Collection;
import java.util.concurrent.atomic.AtomicInteger;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GameTest {

    @Mock private GameOutputWriter gameOutputWriter;

    private Game game;

    @Test
    void shouldHaveAliveFleetOnNotAllHits() {
        game = new Game(twoShotBoard(), new StubbedCoordinateReader(1), gameOutputWriter);

        FleetStatus status = game.start();

        assertThat(status).isEqualTo(FleetStatus.ALIVE);
    }

    @Test
    void shouldHaveSunkFleetOnAllHits() {
        game = new Game(twoShotBoard(), new StubbedCoordinateReader(0), gameOutputWriter);

        FleetStatus status = game.start();

        assertThat(status).isEqualTo(FleetStatus.SUNK);
    }

    private static GameConfiguration twoShotBoard() {
        return GameConfiguration.nShots(2);
    }

    private static class StubbedCoordinateReader implements CoordinateReader {

        private final AtomicInteger integer;

        public StubbedCoordinateReader(int initialValue) {
            integer = new AtomicInteger(initialValue);
        }

        @Override
        public Collection<Coordinates> readCoordinates() {
            return singletonList(
                    Coordinates.fromBoundaries(Coordinate.of(1, 0), Coordinate.of(2, 0)));
        }

        @Override
        public Coordinate readCoordinate() {
            int i = integer.incrementAndGet();
            return Coordinate.of(i, 0);
        }
    }
}
