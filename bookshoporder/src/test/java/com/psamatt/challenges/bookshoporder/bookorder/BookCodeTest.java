package com.psamatt.challenges.bookshoporder.bookorder;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class BookCodeTest {

    private static final String UPPERCASE_CODE = "AB12";

    @Test
    void shouldUppercaseCode() {
        BookCode code = new BookCode("ab12");

        assertThat(code.getCode()).isEqualTo(UPPERCASE_CODE);
    }

    @Test
    void shouldLeaveUpperCaseCodeAsUppercase() {
        BookCode code = new BookCode(UPPERCASE_CODE);

        assertThat(code.getCode()).isEqualTo(UPPERCASE_CODE);
    }
}
