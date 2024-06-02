package app.delivery.core.shared_kernel;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static app.delivery.core.shared_kernel.Weight.MINIMUM_WEIGHT;
import static org.junit.jupiter.api.Assertions.*;

public class WeightTest {

    @Nested
    class Create {

        @Test
        void givenValidWeight_thenSuccessfullyCompleted() {
            Weight weight = new Weight(10);
            assertAll(
                    () -> assertNotNull(weight),
                    () -> assertEquals(10, weight.getKilograms())
            );
        }

        @Test
        void givenNegativeWeight_thenThrowException() {
            assertTrue(assertThrows(IllegalArgumentException.class, () -> {
                new Weight(-1);
            }).getMessage().startsWith("Weight should be greater than " + MINIMUM_WEIGHT));
        }

        @Test
        void givenZeroWeight_thenThrowException() {
            assertTrue(assertThrows(IllegalArgumentException.class, () -> {
                new Weight(0);
            }).getMessage().startsWith("Weight should be greater than " + MINIMUM_WEIGHT));
        }
    }

    @Nested
    class Equals {

        Weight weight1 = new Weight(10);

        @Test
        void givenSameWeights_thenAssertEqual() {
            Weight weight2 = new Weight(weight1.getKilograms());
            assertEquals(weight1, weight2);
        }

        @Test
        void givenDifferentCoordinates_thenAssertNotEqual() {
            Weight weight2 = new Weight(20);
            assertNotEquals(weight1, weight2);
        }
    }

    @Nested
    class Compare {
        @Test
        void givenTwoEqualWeights_whenComparing_thenResultIsZero() {
            Weight weight1 = new Weight(5.0);
            Weight weight2 = new Weight(5.0);
            assertEquals(0, weight1.compareTo(weight2));
        }

        @Test
        void givenFirstWeightLighter_whenComparing_thenResultIsNegative() {
            Weight weight1 = new Weight(5.0);
            Weight weight2 = new Weight(10.0);
            assertTrue(weight1.compareTo(weight2) < 0);
        }

        @Test
        void givenFirstWeightHeavier_whenComparing_thenResultIsPositive() {
            Weight weight1 = new Weight(10.0);
            Weight weight2 = new Weight(5.0);
            assertTrue(weight1.compareTo(weight2) > 0);
        }
    }
}
