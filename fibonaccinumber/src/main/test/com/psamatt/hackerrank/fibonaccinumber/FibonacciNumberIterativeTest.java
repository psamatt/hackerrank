package com.psamatt.hackerrank.fibonaccinumber;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class FibonacciNumberIterativeTest {

    @ParameterizedTest
    @CsvSource({"0,0", "3,2", "6,8", "8,21", "10,55"})
    void shouldReturnNumber(int n, int expected) {
        FibonacciNumberIterative iterative = new FibonacciNumberIterative();

        assertThat(iterative.nthNumber(n)).isEqualTo(expected);
    }
}
