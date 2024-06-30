package app.delivery.core.domain.order.aggregate;

import app.delivery.core.shared.kernel.Location;
import app.delivery.core.shared.kernel.Weight;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    @Nested
    class Create {

        @Test
        void givenValidFields_thenSuccessfullyCreated() {
            UUID id = UUID.randomUUID();
            Order order = Order.create(id, new Location(Location.MINIMUM_COORDINATE, Location.MAXIMUM_COORDINATE), new Weight(5));
            assertAll(
                    () -> assertEquals(id, order.getId()),
                    () -> assertEquals(5, order.getWeight().kg()),
                    () -> assertEquals(OrderStatus.CREATED, order.getStatus()),
                    () -> assertNotNull(order.getLocation())
            );
        }
    }

    @Nested
    class AssignCourier {

        @Test
        void whenAssigningCourier_thenStatusIsAssigned() {
            Order order = Order.create(UUID.randomUUID(), new Location(Location.MINIMUM_COORDINATE, Location.MAXIMUM_COORDINATE), new Weight(5));
            UUID courierId = UUID.randomUUID();

            order.assignCourier(courierId);

            assertAll(
                    () -> assertEquals(OrderStatus.ASSIGNED, order.getStatus()),
                    () -> assertEquals(courierId, order.getCourierId())
            );
        }
    }

    @Nested
    class CompleteOrder {

        @Test
        void whenCompletingAssignedOrder_thenStatusIsCompleted() {
            Order order = Order.create(UUID.randomUUID(), new Location(Location.MINIMUM_COORDINATE, Location.MAXIMUM_COORDINATE), new Weight(5));
            order.assignCourier(UUID.randomUUID());

            order.complete();

            assertEquals(OrderStatus.COMPLETED, order.getStatus());
        }

        @Test
        void whenCompletingUnassignedOrder_thenExceptionThrown() {
            Order order = Order.create(UUID.randomUUID(), new Location(Location.MINIMUM_COORDINATE, Location.MAXIMUM_COORDINATE), new Weight(5));
            assertEquals("Cannot complete order. Expected status should be ASSIGNED but was %s".formatted(OrderStatus.CREATED), assertThrows(IllegalStateException.class, order::complete).getMessage());
        }

        @Test
        void whenCompletingCompletedOrder_thenExceptionThrown() {
            Order order = Order.create(UUID.randomUUID(), new Location(Location.MINIMUM_COORDINATE, Location.MAXIMUM_COORDINATE), new Weight(5));
            UUID courierId = UUID.randomUUID();
            order.assignCourier(courierId);
            order.complete();

            assertThrows(IllegalStateException.class, order::complete);
        }
    }
}
