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
        assertEquals("Unknown courier status id: " + 3, assertThrows(IllegalArgumentException.class, () -> CourierStatus.of(3)).getMessage());
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
        String notExistingStatusName = "Waiting";
        assertEquals("Unknown courier status name: " + notExistingStatusName, assertThrows(IllegalArgumentException.class, () -> CourierStatus.of(notExistingStatusName)).getMessage());
    }
}
