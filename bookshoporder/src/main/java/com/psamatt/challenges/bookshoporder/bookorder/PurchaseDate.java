package com.psamatt.challenges.bookshoporder.bookorder;

import com.psamatt.challenges.bookshoporder.InvalidBookLineItem;
import java.time.Instant;
import lombok.Value;

@Value
public class PurchaseDate {
    Instant timestamp;

    public PurchaseDate(String timestamp) {
        this(Instant.parse(timestamp));
    }

    public PurchaseDate(Instant timestamp) {
        if (timestamp.isAfter(Instant.now())) {
            throw new PurchaseDateInTheFuture(timestamp);
        }
        this.timestamp = timestamp;
    }

    public static class PurchaseDateInTheFuture extends InvalidBookLineItem {
        public PurchaseDateInTheFuture(Instant date) {
            super(String.format("Purchase Date %s must not be in the future", date));
        }
    }
}
