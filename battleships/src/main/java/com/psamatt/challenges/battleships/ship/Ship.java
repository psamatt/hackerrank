package com.psamatt.challenges.battleships.ship;

import com.psamatt.challenges.battleships.coordinates.Coordinate;
import com.psamatt.challenges.battleships.coordinates.Coordinates;
import lombok.Data;

@Data
public class Ship {

    private final Coordinates coordinates;
    private final Hits hits;
    private boolean alive;

    public Ship(Coordinates coordinates) {
        this.alive = true;
        this.coordinates = coordinates;
        this.hits = new Hits();
    }

    public boolean attemptShot(Coordinate coordinate) {
        if (coordinates.contains(coordinate)) {
            hits.add(coordinate);
            if (coordinates.size() == hits.size()) {
                alive = false;
            }
            return true;
        }
        return false;
    }

    public boolean isAlive() {
        return alive;
    }

    public boolean isDead() {
        return !alive;
    }
}
