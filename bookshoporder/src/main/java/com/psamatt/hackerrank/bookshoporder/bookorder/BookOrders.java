package com.psamatt.hackerrank.bookshoporder.bookorder;

import java.util.Collection;
import java.util.Iterator;

public class BookOrders implements Iterable<BookOrder> {

    private final Collection<BookOrder> bookOrders;

    public BookOrders(Collection<BookOrder> bookOrders) {
        this.bookOrders = bookOrders;
    }

    @Override
    public Iterator<BookOrder> iterator() {
        return bookOrders.iterator();
    }
}
