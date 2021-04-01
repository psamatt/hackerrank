package com.psamatt.hackerrank.battleships.board;

import com.psamatt.hackerrank.battleships.coordinates.Coordinate;
import com.psamatt.hackerrank.battleships.ship.FleetStatus;
import com.psamatt.hackerrank.battleships.ship.Ship;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Optional;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RequiredArgsConstructor
@Slf4j
public class Board {

    @Getter private final int size;
    private final BoardShotLogger boardShotLogger;
    private Collection<Ship> ships;

    public Board(int size) {
        this.size = size;
        boardShotLogger = new BoardShotLogger();
        ships = new ArrayList<>();
    }

    public void place(Ship ship) {
        ships.add(ship);
    }

    public FleetStatus recordShot(Coordinate coordinate) {
        Optional<Ship> hitShip =
                ships.stream()
                        .filter(Ship::isAlive)
                        .filter(ship -> ship.attemptShot(coordinate))
                        .findFirst();
        hitShip.ifPresentOrElse(
                ship -> logHit(ship, coordinate), () -> boardShotLogger.logMiss(coordinate));

        return getFleetStatus();
    }

    public CellStatus getCellStatus(Coordinate coordinate) {
        return boardShotLogger.getCellStatus(coordinate);
    }

    public FleetStatus getFleetStatus() {
        boolean allSunk = ships.stream().noneMatch(Ship::isAlive);
        if (allSunk) {
            return FleetStatus.SUNK;
        }
        return FleetStatus.ALIVE;
    }

    private void logHit(Ship ship, Coordinate coordinate) {
        log.info("Hit Coordinate[{}]", coordinate);
        boardShotLogger.logHit(coordinate);
        if (ship.isDead()) {
            boardShotLogger.logSunk(ship);
        }
    }
}
