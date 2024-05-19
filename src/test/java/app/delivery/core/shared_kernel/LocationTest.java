package app.delivery.core.shared_kernel;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class LocationTest {

    @Nested
    class Create {

        @Test
        void givenValidCoordinate_thenSuccessfullyCompleted() {
            Location location = Location.create(1.1, 1.1);

            assertNotNull(location);
            assertEquals(1.1, location.getXCoordinate());
            assertEquals(1.1, location.getYCoordinate());
        }

        @Test
        void givenBelowMinimumCoordinate_thenThrowException() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                Location.create(1.0, 1.1);
            });
            assertEquals("xCoordinate is out of bounds", exception.getMessage());

            exception = assertThrows(IllegalArgumentException.class, () -> {
                Location.create(1.1, 1.0);
            });
            assertEquals("yCoordinate is out of bounds", exception.getMessage());
        }

        @Test
        void givenAboveMaximumCoordinate_thenThrowException() {
            IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
                Location.create(10.11, 1.1);
            });
            assertEquals("xCoordinate is out of bounds", exception.getMessage());

            exception = assertThrows(IllegalArgumentException.class, () -> {
                Location.create(1.1, 10.11);
            });
            assertEquals("yCoordinate is out of bounds", exception.getMessage());
        }
    }


    @Nested
    class Distance {

        @Test
        void givenValidDistance_thenSuccessfullyCompleted() {
            Location location1 = Location.create(1.1, 1.1);
            Location location2 = Location.create(2.2, 2.2);

            double distance = location1.calculateDistance(location2);
            assertEquals(2.2, distance);
        }
    }

    @Nested
    class Equals {

        Location location1 = Location.create(1.1, 1.1);

        @Test
        void givenSameCoordinates_thenAssertEqual() {
            Location location2 = Location.create(location1.getXCoordinate(), location1.getYCoordinate());
            assertEquals(location1, location2);
        }

        @Test
        void givenDifferentCoordinates_thenAssertNotEqual() {
            Location location2 = Location.create(2.2, 2.2);
            assertNotEquals(location1, location2);
        }
    }
}
