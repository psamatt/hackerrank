package com.psamatt.hackerrank.battleships.coordinates;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = false)
public class Coordinates extends AbstractCollection<Coordinate> {

    private final Collection<Coordinate> coordinates;

    private Coordinates(Collection<Coordinate> coordinates) {
        this.coordinates = List.copyOf(coordinates);
    }

    public static Coordinates fromBoundaries(Coordinate lower, Coordinate upper) {
        if (lower.getX() == upper.getX()) {
            return new Coordinates(
                    IntStream.rangeClosed(lower.getY(), upper.getY())
                            .mapToObj(i -> Coordinate.of(lower.getX(), i))
                            .collect(Collectors.toList()));
        }
        return new Coordinates(
                IntStream.rangeClosed(lower.getX(), upper.getX())
                        .mapToObj(i -> Coordinate.of(i, lower.getY()))
                        .collect(Collectors.toList()));
    }

    @Override
    public Iterator<Coordinate> iterator() {
        return coordinates.iterator();
    }

    @Override
    public int size() {
        return coordinates.size();
    }
}
