package com.psamatt.hackerrank.battleships.board;

import com.psamatt.hackerrank.battleships.coordinates.Coordinate;
import com.psamatt.hackerrank.battleships.ship.Ship;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class BoardShotLogger {

    private final Map<Coordinate, CellStatus> shots;

    public BoardShotLogger() {
        this.shots = new HashMap<>();
    }

    public void logHit(Coordinate coordinate) {
        shots.put(coordinate, CellStatus.HIT);
    }

    public void logMiss(Coordinate coordinate) {
        shots.put(coordinate, CellStatus.MISS);
    }

    public void logSunk(Ship ship) {
        ship.getCoordinates().forEach(coordinate -> shots.put(coordinate, CellStatus.SUNK));
    }

    public CellStatus getCellStatus(Coordinate c) {
        return Optional.ofNullable(shots.get(c)).orElse(CellStatus.INACTIVE);
    }
}
