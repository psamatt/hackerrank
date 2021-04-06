package com.psamatt.hackerrank.bookshoporder;

import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;

import com.psamatt.hackerrank.bookshoporder.bookorder.BookCode;
import com.psamatt.hackerrank.bookshoporder.bookorder.BookOrder;
import com.psamatt.hackerrank.bookshoporder.bookorder.PurchaseDate;
import com.psamatt.hackerrank.bookshoporder.bookorder.Quantity;
import com.psamatt.hackerrank.bookshoporder.bookorder.Surname;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderLineConverterTest {

    private OrderLineConverter converter;

    @BeforeEach
    void setUp() {
        converter = new OrderLineConverter();
    }

    @Test
    void shouldConvertNoLineItemsToEmptyBookOrders() {
        List<BookOrder> bookOrders = converter.toBookOrders(Collections.emptyList());

        assertThat(bookOrders).isEmpty();
    }

    @Test
    void shouldConvertLineItemsToBookOrders() {
        String orderLine = "Smith AB12 1 2012-01-01T03:10:01.0000Z";
        List<BookOrder> bookOrders = converter.toBookOrders(singletonList(orderLine));

        assertThat(bookOrders)
                .containsExactly(
                        new BookOrder(
                                new Surname("Smith"),
                                new BookCode("AB12"),
                                new Quantity(1),
                                new PurchaseDate("2012-01-01T03:10:01.0000Z")));
    }
}
