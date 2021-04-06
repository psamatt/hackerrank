package com.psamatt.hackerrank.bookshoporder.bookorder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class SurnameTest {

    private static final String CAPTALIZED_SURNAME = "Smith";

    @Test
    void shouldCapitalizeSurname() {
        Surname surname = new Surname("smith");

        assertThat(surname.getSurname()).isEqualTo(CAPTALIZED_SURNAME);
    }

    @Test
    void shouldKeepSurnameCapitalized() {
        Surname surname = new Surname(CAPTALIZED_SURNAME);

        assertThat(surname.getSurname()).isEqualTo(CAPTALIZED_SURNAME);
    }
}
