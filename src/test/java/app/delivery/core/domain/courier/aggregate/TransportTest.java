package app.delivery.core.domain.courier.aggregate;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TransportTest {

    @Test
    void shouldReturnCorrectTransportForValidNames() {
        assertAll(
                () -> assertEquals(Transport.PEDESTRIAN, Transport.of("Pedestrian")),
                () -> assertEquals(Transport.BICYCLE, Transport.of("Bicycle")),
                () -> assertEquals(Transport.SCOOTER, Transport.of("Scooter")),
                () -> assertEquals(Transport.CAR, Transport.of("Car"))
        );
    }

    @Test
    void shouldThrowExceptionForInvalidNames() {
        assertAll(
                () -> assertEquals("Unknown Transport name: " + "Plane", assertThrows(IllegalArgumentException.class, () -> Transport.of("Plane")).getMessage()),
                () -> assertEquals("Unknown Transport name: " + "Boat", assertThrows(IllegalArgumentException.class, () -> Transport.of("Boat")).getMessage()),
                () -> assertEquals("Unknown Transport name: " + "Train", assertThrows(IllegalArgumentException.class, () -> Transport.of("Train")).getMessage())
        );
    }

    @Test
    void shouldReturnTrueWhenCapacityIsSufficient() {
        assertAll(
                () -> assertTrue(Transport.PEDESTRIAN.canCarry(1)),
                () -> assertTrue(Transport.BICYCLE.canCarry(2)),
                () -> assertTrue(Transport.SCOOTER.canCarry(3)),
                () -> assertTrue(Transport.CAR.canCarry(4))
        );
    }

    @Test
    void shouldReturnFalseWhenCapacityIsInsufficient() {
        assertAll(
                () -> assertFalse(Transport.PEDESTRIAN.canCarry(2)),
                () -> assertFalse(Transport.BICYCLE.canCarry(5)),
                () -> assertFalse(Transport.SCOOTER.canCarry(7)),
                () -> assertFalse(Transport.CAR.canCarry(9))
        );
    }
}