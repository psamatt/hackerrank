package com.psamatt.challenges.bookshoporder;

public class InvalidBookLineItem extends RuntimeException {

    public InvalidBookLineItem(String message) {
        super(message);
    }
}
