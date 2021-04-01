package com.psamatt.hackerrank.fibonaccinumber;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FibonacciNumberRecursiveTest {

    @ParameterizedTest
    @CsvSource({"0,0", "3,2", "6,8", "8,21", "10,55"})
    void shouldReturnNumber(int n, int expected) {
        FibonacciNumberRecursive recursive = new FibonacciNumberRecursive();

        assertThat(recursive.nthNumber(n)).isEqualTo(expected);
        assertThat(recursive.nthNumberComplex(n)).isEqualTo(expected);
        assertThat(recursive.nthNumberTailRecursive(n, 1, 0)).isEqualTo(expected);
    }
}
