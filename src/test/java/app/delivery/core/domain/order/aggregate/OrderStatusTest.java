package app.delivery.core.domain.order.aggregate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderStatusTest {

    @Test
    void shouldReturnCorrectOrderStatusForValidIds() {
        assertAll(
                () -> assertEquals(OrderStatus.CREATED, OrderStatus.of(0)),
                () -> assertEquals(OrderStatus.ASSIGNED, OrderStatus.of(1)),
                () -> assertEquals(OrderStatus.COMPLETED, OrderStatus.of(2))
        );
    }

    @Test
    void shouldThrowExceptionForInvalidIds() {
        assertAll(
                () -> assertEquals("Unknown order status: " + 3, assertThrows(IllegalArgumentException.class, () -> OrderStatus.of(3)).getMessage()),
                () -> assertEquals("Unknown order status: " + 4, assertThrows(IllegalArgumentException.class, () -> OrderStatus.of(4)).getMessage()),
                () -> assertEquals("Unknown order status: " + 5, assertThrows(IllegalArgumentException.class, () -> OrderStatus.of(5)).getMessage())
        );
    }

    @Test
    void shouldReturnCorrectOrderStatusForValidNames() {
        assertAll(
                () -> assertEquals(OrderStatus.CREATED, OrderStatus.of("Created")),
                () -> assertEquals(OrderStatus.ASSIGNED, OrderStatus.of("Assigned")),
                () -> assertEquals(OrderStatus.COMPLETED, OrderStatus.of("Completed"))
        );
    }

    @Test
    void shouldThrowExceptionForInvalidNames() {
        assertAll(
                () -> assertEquals("Unknown order status: " + 3, assertThrows(IllegalArgumentException.class, () -> OrderStatus.of(3)).getMessage()),
                () -> assertEquals("Unknown order status: " + 4, assertThrows(IllegalArgumentException.class, () -> OrderStatus.of(4)).getMessage()),
                () -> assertEquals("Unknown order status: " + 5, assertThrows(IllegalArgumentException.class, () -> OrderStatus.of(5)).getMessage())
        );
    }
}
