package app.delivery.core.domain.courier.aggregate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourierStatusTest {

    @Test
    void shouldReturnCorrectCourierStatusForValidIds() {
        assertAll(
                () -> assertEquals(CourierStatus.NOT_AVAILABLE, CourierStatus.of(0)),
                () -> assertEquals(CourierStatus.READY, CourierStatus.of(1)),
                () -> assertEquals(CourierStatus.BUSY, CourierStatus.of(2))
        );
    }

    @Test
    void shouldThrowExceptionForInvalidIds() {
        assertAll(
                () -> assertEquals("Unknown courier status: " + 3, assertThrows(IllegalArgumentException.class, () -> CourierStatus.of(3)).getMessage()),
                () -> assertEquals("Unknown courier status: " + 4, assertThrows(IllegalArgumentException.class, () -> CourierStatus.of(4)).getMessage()),
                () -> assertEquals("Unknown courier status: " + 5, assertThrows(IllegalArgumentException.class, () -> CourierStatus.of(5)).getMessage())
        );
    }

    @Test
    void shouldReturnCorrectCourierStatusForValidNames() {
        assertAll(
                () -> assertEquals(CourierStatus.NOT_AVAILABLE, CourierStatus.of("NotAvailable")),
                () -> assertEquals(CourierStatus.READY, CourierStatus.of("Ready")),
                () -> assertEquals(CourierStatus.BUSY, CourierStatus.of("Busy"))
        );
    }

    @Test
    void shouldThrowExceptionForInvalidNames() {
        assertAll(
                () -> assertEquals("Unknown courier status: " + 3, assertThrows(IllegalArgumentException.class, () -> CourierStatus.of(3)).getMessage()),
                () -> assertEquals("Unknown courier status: " + 4, assertThrows(IllegalArgumentException.class, () -> CourierStatus.of(4)).getMessage()),
                () -> assertEquals("Unknown courier status: " + 5, assertThrows(IllegalArgumentException.class, () -> CourierStatus.of(5)).getMessage())
        );
    }
}
