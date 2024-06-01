package app.delivery.core.shared.kernel;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LocationTest {

    private final int BELLOW_MIN_COORDINATE = 0;
    private final int VALID_COORDINATE_FIVE = 5;
    private final int ABOVE_MAX_VALID_COORDINATE = 11;

    @Nested
    class Create {

        @Test
        void givenValidCoordinate_thenSuccessfullyCompleted() {
            Location location = new Location(Location.MINIMUM_COORDINATE, Location.MINIMUM_COORDINATE);
            assertAll(
                    () -> assertNotNull(location),
                    () -> Assertions.assertEquals(Location.MINIMUM_COORDINATE, location.xCoordinate()),
                    () -> Assertions.assertEquals(Location.MINIMUM_COORDINATE, location.yCoordinate())
            );
        }

        @Test
        void givenBelowMinimumXCoordinate_thenThrowException() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                new Location(BELLOW_MIN_COORDINATE, Location.MINIMUM_COORDINATE);
            });
            assertEquals("xCoordinate: %s is out of bounds".formatted(BELLOW_MIN_COORDINATE), exception.getMessage());
        }

        @Test
        void givenBelowMinimumYCoordinate_thenThrowException() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                new Location(Location.MINIMUM_COORDINATE, BELLOW_MIN_COORDINATE);
            });
            assertEquals("yCoordinate: %s is out of bounds".formatted(BELLOW_MIN_COORDINATE), exception.getMessage());
        }

        @Test
        void givenAboveMaximumXCoordinate_thenThrowException() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                new Location(ABOVE_MAX_VALID_COORDINATE, Location.MINIMUM_COORDINATE);
            });
            assertEquals("xCoordinate: %s is out of bounds".formatted(ABOVE_MAX_VALID_COORDINATE), exception.getMessage());
        }

        @Test
        void givenAboveMaximumYCoordinate_thenThrowException() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                new Location(Location.MINIMUM_COORDINATE, ABOVE_MAX_VALID_COORDINATE);
            });
            assertEquals("yCoordinate: %s is out of bounds".formatted(ABOVE_MAX_VALID_COORDINATE), exception.getMessage());
        }
    }


    @Nested
    class Distance {

        @Test
        void givenValidDistance_thenSuccessfullyCompleted() {
            int expectedDistance = 8; //5-1 + 5-1
            Location location1 = new Location(Location.MINIMUM_COORDINATE, Location.MINIMUM_COORDINATE);
            Location location2 = new Location(VALID_COORDINATE_FIVE, VALID_COORDINATE_FIVE);

            int distance = location1.calculateDistance(location2);
            assertEquals(expectedDistance, distance);
        }
    }

    @Nested
    class Equals {

        Location location1 = new Location(Location.MINIMUM_COORDINATE, Location.MINIMUM_COORDINATE);

        @Test
        void givenSameCoordinates_thenAssertEqual() {
            Location location2 = new Location(location1.xCoordinate(), location1.yCoordinate());
            assertEquals(location1, location2);
        }

        @Test
        void givenDifferentCoordinates_thenAssertNotEqual() {
            Location location2 = new Location(VALID_COORDINATE_FIVE, VALID_COORDINATE_FIVE);
            assertNotEquals(location1, location2);
        }
    }
}
