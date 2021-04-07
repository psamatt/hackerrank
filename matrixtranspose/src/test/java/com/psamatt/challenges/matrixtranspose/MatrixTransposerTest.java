package com.psamatt.challenges.matrixtranspose;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MatrixTransposerTest {

    private MatrixTransposer transposer;

    @BeforeEach
    void setUp() {
        transposer = new MatrixTransposer();
    }

    @Test
    void shouldTransposeTwoByTwoSquare() {
        int[][] matrix = {new int[] {1, 2}, new int[] {3, 4}};

        transposer.transpose(matrix);

        assertThat(matrix).isEqualTo(new int[][] {new int[] {1, 3}, new int[] {2, 4}});
    }

    @Test
    void shouldTransposeThreeByThreeSquare() {
        int[][] matrix = {new int[] {1, 2, 3}, new int[] {4, 5, 6}, new int[] {7, 8, 9}};

        transposer.transpose(matrix);

        assertThat(matrix)
                .isEqualTo(
                        new int[][] {
                            new int[] {1, 4, 7}, new int[] {2, 5, 8}, new int[] {3, 6, 9}
                        });
    }
}
