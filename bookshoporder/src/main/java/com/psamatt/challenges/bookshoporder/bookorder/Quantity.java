package com.psamatt.challenges.bookshoporder.bookorder;

import com.psamatt.challenges.bookshoporder.InvalidBookLineItem;
import lombok.Value;

@Value
public class Quantity implements Comparable<Quantity> {
    int value;

    public Quantity(String value) {
        this(Integer.parseInt(value));
    }

    public Quantity(int value) {
        if (value < 1) {
            throw new InvalidQuantityException(value);
        }
        this.value = value;
    }

    @Override
    public int compareTo(Quantity other) {
        return Integer.compare(value, other.value);
    }

    public static class InvalidQuantityException extends InvalidBookLineItem {
        public InvalidQuantityException(int qty) {
            super(String.format("Quantity %s must be greater than zero", qty));
        }
    }
}
