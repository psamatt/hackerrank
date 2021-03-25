package com.psamatt.hackerrank.battleships;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GameConfiguration {

    @Builder.Default private final int boardSize = 5;
    @Builder.Default private final int totalShots = 10;

    public static GameConfiguration nShots(int n) {
        return GameConfiguration.builder().totalShots(n).build();
    }

    public static GameConfiguration withDefaultValues() {
        return GameConfiguration.builder().build();
    }
}
