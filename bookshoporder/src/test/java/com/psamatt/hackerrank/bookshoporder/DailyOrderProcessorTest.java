package com.psamatt.hackerrank.bookshoporder;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.BDDMockito.given;

import com.psamatt.hackerrank.bookshoporder.bookorder.BookCode;
import com.psamatt.hackerrank.bookshoporder.bookorder.BookOrder;
import com.psamatt.hackerrank.bookshoporder.bookorder.BookOrders;
import com.psamatt.hackerrank.bookshoporder.bookorder.PurchaseDate;
import com.psamatt.hackerrank.bookshoporder.bookorder.Quantity;
import com.psamatt.hackerrank.bookshoporder.bookorder.Surname;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class DailyOrderProcessorTest {

    private static final String ORDER_LINE_BLOGGS_QTY_ONE =
            "Bloggs AB12 1 2012-01-01T02:10:01.0000Z";
    private static final String ORDER_LINE_BLOGGS_QTY_TWO =
            "Bloggs AB99 2 2012-01-01T01:10:01.0000Z";
    private static final BookOrder BOOK_ORDER_BLOGGS_QTY_ONE = buildOrder("Bloggs", "AB12", 1);
    private static final BookOrder BOOK_ORDER_BLOGGS_QTY_TWO = buildOrder("Bloggs", "AB99", 2);

    @Mock private OrderLineConverter converter;

    private DailyOrderProcessor processor;

    @BeforeEach
    void setUp() {
        processor = new DailyOrderProcessor(converter);
    }

    @Test
    void shouldProcessOneLine() {
        List<String> orderLines = singletonList(ORDER_LINE_BLOGGS_QTY_ONE);
        given(converter.toBookOrders(orderLines))
                .willReturn(singletonList(BOOK_ORDER_BLOGGS_QTY_ONE));

        BookOrders orders = processor.process(orderLines);

        assertThat(orders).containsExactly(BOOK_ORDER_BLOGGS_QTY_ONE);
    }

    @Test
    void shouldOrderSameSurnameOrdersByQuantityDesc() {
        List<String> orderLines = asList(ORDER_LINE_BLOGGS_QTY_ONE, ORDER_LINE_BLOGGS_QTY_TWO);
        given(converter.toBookOrders(orderLines))
                .willReturn(asList(BOOK_ORDER_BLOGGS_QTY_ONE, BOOK_ORDER_BLOGGS_QTY_TWO));

        BookOrders orders = processor.process(orderLines);

        assertThat(orders).containsExactly(BOOK_ORDER_BLOGGS_QTY_TWO, BOOK_ORDER_BLOGGS_QTY_ONE);
    }

    @Test
    void shouldOrderAsSameSurnameFirstFollowedByOtherSurname() {
        String orderLineSmith = "Smith AB12 1 2012-01-01T03:10:01.0000Z";
        BookOrder bookOrderSmith = buildOrder("Smith", "AB99", 1);

        List<String> orderLines =
                asList(ORDER_LINE_BLOGGS_QTY_ONE, orderLineSmith, ORDER_LINE_BLOGGS_QTY_TWO);
        given(converter.toBookOrders(orderLines))
                .willReturn(
                        asList(
                                BOOK_ORDER_BLOGGS_QTY_ONE,
                                bookOrderSmith,
                                BOOK_ORDER_BLOGGS_QTY_TWO));

        BookOrders orders = processor.process(orderLines);

        assertThat(orders)
                .containsExactly(
                        bookOrderSmith, BOOK_ORDER_BLOGGS_QTY_TWO, BOOK_ORDER_BLOGGS_QTY_ONE);
    }

    private static BookOrder buildOrder(String surname, String code, int qty) {
        return new BookOrder(
                new Surname(surname),
                new BookCode(code),
                new Quantity(qty),
                new PurchaseDate("2012-01-01T01:10:01.0000Z"));
    }
}
