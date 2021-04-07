package com.psamatt.challenges.battleships.board;

import static org.assertj.core.api.Assertions.assertThat;

import com.psamatt.challenges.battleships.coordinates.Coordinate;
import com.psamatt.challenges.battleships.coordinates.Coordinates;
import com.psamatt.challenges.battleships.ship.FleetStatus;
import com.psamatt.challenges.battleships.ship.Ship;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BoardTest {

    private static final Coordinate LOWER = Coordinate.of(1, 0);
    private static final Coordinate UPPER = Coordinate.of(2, 0);
    private Board board;

    @BeforeEach
    void setUp() {
        board = new Board(5);
        board.place(new Ship(Coordinates.fromBoundaries(LOWER, UPPER)));
    }

    @Test
    void shouldRecordShotAndFleetStillAlive() {
        FleetStatus fleetStatus = board.recordShot(LOWER);

        assertThat(fleetStatus).isEqualTo(FleetStatus.ALIVE);
    }

    @Test
    void shouldRecordSinkingShot() {
        board.recordShot(LOWER);
        FleetStatus fleetStatus = board.recordShot(UPPER);

        assertThat(fleetStatus).isEqualTo(FleetStatus.SUNK);
    }

    @Test
    void shouldGetCellStastusOfSunk() {
        board.recordShot(LOWER);
        board.recordShot(UPPER);

        assertThat(board.getCellStatus(LOWER)).isEqualTo(CellStatus.SUNK);
    }

    @Test
    void shouldGetCellStatusOfHit() {
        board.recordShot(LOWER);

        assertThat(board.getCellStatus(LOWER)).isEqualTo(CellStatus.HIT);
    }

    @Test
    void shouldGetCellStatusOfMiss() {
        Coordinate coordinate = Coordinate.of(5, 5);
        board.recordShot(coordinate);

        assertThat(board.getCellStatus(coordinate)).isEqualTo(CellStatus.MISS);
    }

    @Test
    void shouldGetCellStatusOfInactive() {
        assertThat(board.getCellStatus(Coordinate.of(4, 4))).isEqualTo(CellStatus.INACTIVE);
    }
}
