package com.psamatt.hackerrank.bookshoporder;

import com.psamatt.hackerrank.bookshoporder.bookorder.BookCode;
import com.psamatt.hackerrank.bookshoporder.bookorder.BookOrder;
import com.psamatt.hackerrank.bookshoporder.bookorder.PurchaseDate;
import com.psamatt.hackerrank.bookshoporder.bookorder.Quantity;
import com.psamatt.hackerrank.bookshoporder.bookorder.Surname;
import java.util.List;
import java.util.stream.Collectors;

public class OrderLineConverter {

    public List<BookOrder> toBookOrders(List<String> lineItems) {
        return lineItems.stream().map(this::toBookOrder).collect(Collectors.toList());
    }

    private BookOrder toBookOrder(String line) {
        String[] segments = splitBySpace(line);
        return new BookOrder(
                new Surname(segments[0]),
                new BookCode(segments[1]),
                new Quantity(segments[2]),
                new PurchaseDate(segments[3]));
    }

    private static String[] splitBySpace(String line) {
        return line.split(" ");
    }
}
