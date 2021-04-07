package com.psamatt.challenges.battleships.coordinates;

import lombok.Value;

@Value(staticConstructor = "of")
public class Coordinate {

    int x;
    int y;
}
