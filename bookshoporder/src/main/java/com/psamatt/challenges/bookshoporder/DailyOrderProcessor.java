package com.psamatt.challenges.bookshoporder;

import static java.util.Comparator.comparing;
import static java.util.stream.Collectors.collectingAndThen;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

import com.psamatt.challenges.bookshoporder.bookorder.BookOrder;
import com.psamatt.challenges.bookshoporder.bookorder.BookOrders;
import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DailyOrderProcessor {

    private final OrderLineConverter orderLineConverter;

    public BookOrders process(List<String> orderLines) {
        List<BookOrder> bookOrders = orderLineConverter.toBookOrders(orderLines);
        return sortAndGroup(bookOrders)
                .flatMap(Collection::stream)
                .collect(collectingAndThen(toList(), BookOrders::new));
    }

    private Stream<List<BookOrder>> sortAndGroup(List<BookOrder> bookOrders) {
        return bookOrders.stream()
                .sorted(comparing(BookOrder::getQty).reversed())
                .collect(groupingBy(BookOrder::getSurname))
                .values()
                .stream();
    }
}
