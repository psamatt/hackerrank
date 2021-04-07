package com.psamatt.challenges.bookshoporder.bookorder;

import lombok.Value;

@Value
public class BookOrder {
    Surname surname;
    BookCode code;
    Quantity qty;
    PurchaseDate timestamp;
}
