package com.psamatt.challenges.bookshoporder.bookorder;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.catchThrowable;

import java.time.Instant;
import org.junit.jupiter.api.Test;

class PurchaseDateTest {

    @Test
    void shouldThrowPurchaseDateInTheFutureOnDateInFuture() {
        Instant futureDate = Instant.now().plusMillis(100);

        Throwable t = catchThrowable(() -> new PurchaseDate(futureDate));

        assertThat(t)
                .isExactlyInstanceOf(PurchaseDate.PurchaseDateInTheFuture.class)
                .hasMessage("Purchase Date " + futureDate + " must not be in the future");
    }

    @Test
    void shouldAcceptDateInPast() {
        assertThatCode(() -> new PurchaseDate(Instant.now().minusMillis(1)))
                .doesNotThrowAnyException();
    }
}
