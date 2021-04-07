package com.psamatt.challenges.battleships;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GameConfigurationTest {

    @Test
    void shoulDefaultSizeToFive() {
        GameConfiguration configuration = GameConfiguration.withDefaultValues();

        assertThat(configuration.getBoardSize()).isEqualTo(5);
    }

    @Test
    void shouldDefaultShotsToTen() {
        GameConfiguration configuration = GameConfiguration.withDefaultValues();

        assertThat(configuration.getTotalShots()).isEqualTo(10);
    }
}
