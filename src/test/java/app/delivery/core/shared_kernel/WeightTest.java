package app.delivery.core.shared_kernel;

import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WeightTest {

    @Nested
    class Create {

        @Test
        void givenValidWeight_thenSuccessfullyCompleted() {
            Weight weight = Weight.create(10);

            assertNotNull(weight);
            assertEquals(10, weight.getKilograms());
        }

        @Test
        void givenNegativeOrZeroWeight_thenThrowException() {
            IllegalArgumentException negativeWeightException = assertThrows(IllegalArgumentException.class, () -> {
                Weight.create(-1);
            });

            IllegalArgumentException zeroWeightException = assertThrows(IllegalArgumentException.class, () -> {
                Weight.create(0);
            });

            assertTrue(negativeWeightException.getMessage().startsWith("Weight should be greater than"));
            assertTrue(zeroWeightException.getMessage().startsWith("Weight should be greater than"));
        }
    }

    @Nested
    class Equals {

        Weight weight1 = Weight.create(10);

        @Test
        void givenSameWeights_thenAssertEqual() {
            Weight weight2 = Weight.create(weight1.getKilograms());
            assertEquals(weight1, weight2);
        }

        @Test
        void givenDifferentCoordinates_thenAssertNotEqual() {
            Weight weight2 = Weight.create(20);
            assertNotEquals(weight1, weight2);
        }
    }
}
