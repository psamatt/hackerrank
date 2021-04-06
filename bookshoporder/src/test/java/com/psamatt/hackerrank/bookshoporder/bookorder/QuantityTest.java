package com.psamatt.hackerrank.bookshoporder.bookorder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class QuantityTest {

    @CsvSource({"1", "10", "100", "1000"})
    @ParameterizedTest
    void shouldAllowValuesGreaterThanZero(int value) {
        assertThatCode(() -> new Quantity(value)).doesNotThrowAnyException();
    }

    @CsvSource({"0", "-1", "-10", "-100"})
    @ParameterizedTest
    void shouldThrowExceptionOnValuesLessThanOne(int value) {
        Throwable t = catchThrowable(() -> new Quantity(value));

        assertThat(t)
                .isExactlyInstanceOf(Quantity.InvalidQuantityException.class)
                .hasMessage("Quantity " + value + " must be greater than zero");
    }
}
