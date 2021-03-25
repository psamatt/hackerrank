package com.psamatt.hackerrank.battleships.ship;

import com.psamatt.hackerrank.battleships.coordinates.Coordinate;
import java.util.AbstractSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import lombok.EqualsAndHashCode;
import lombok.Value;

@Value
@EqualsAndHashCode(callSuper = true)
public class Hits extends AbstractSet<Coordinate> {

    Set<Coordinate> hits;

    public Hits() {
        this.hits = new HashSet<>();
    }

    @Override
    public Iterator<Coordinate> iterator() {
        return hits.iterator();
    }

    @Override
    public int size() {
        return hits.size();
    }

    @Override
    public boolean add(Coordinate coordinate) {
        return hits.add(coordinate);
    }
}
