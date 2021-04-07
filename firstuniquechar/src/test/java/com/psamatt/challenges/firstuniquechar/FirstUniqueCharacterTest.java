package com.psamatt.challenges.firstuniquechar;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FirstUniqueCharacterTest {

    private FirstUniqueCharacter firstUniqueCharacter;

    @BeforeEach
    void setUp() {
        firstUniqueCharacter = new FirstUniqueCharacter();
    }

    @Test
    void shouldFindFirstUniqueC() {
        char actual = firstUniqueCharacter.find("ababc");

        assertThat(actual).isEqualTo('c');
    }

    @Test
    void shouldFindFirstUniqueCOnPrefixedDuplicated() {
        char actual = firstUniqueCharacter.find("ababaaaaaaacaaabbbb");

        assertThat(actual).isEqualTo('c');
    }

    @Test
    void shouldFindFirstUniqueCOfReallyLongString() {
        char actual = firstUniqueCharacter.find("abab".repeat(999999) + "c");

        assertThat(actual).isEqualTo('c');
    }

    @Test
    void shouldThrowExceptionOnNoUnknownUniqueChar() {
        String s = "abcabc";

        Throwable t = catchThrowable(() -> firstUniqueCharacter.find(s));

        assertThat(t)
                .isExactlyInstanceOf(NoFirstUniqueCharacterFound.class)
                .hasMessage("No first unique character found in " + s);
    }
}
