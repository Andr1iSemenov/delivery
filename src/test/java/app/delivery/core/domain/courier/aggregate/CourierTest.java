package app.delivery.core.domain.courier.aggregate;

import app.delivery.core.domain.order.aggregate.Order;
import app.delivery.core.domain.order.aggregate.OrderStatus;
import app.delivery.core.shared.kernel.Location;
import app.delivery.core.shared.kernel.Weight;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.UUID;
import java.util.stream.Stream;

import static app.delivery.core.domain.courier.aggregate.Courier.DEFAULT_LOCATION_X;
import static app.delivery.core.domain.courier.aggregate.Courier.DEFAULT_LOCATION_Y;
import static app.delivery.core.shared.kernel.Location.MAXIMUM_COORDINATE;
import static org.junit.jupiter.api.Assertions.*;

public class CourierTest {

    private static final String COURIER_NAME = "Bob";


    @Nested
    class Create {

        @Test
        void givenValidFields_thenSuccessfullyCreated() {
            UUID id = UUID.randomUUID();
            Courier courier = Courier.create(id, COURIER_NAME, Transport.PEDESTRIAN);
            assertAll(
                    () -> assertEquals(id, courier.getId()),
                    () -> assertEquals(COURIER_NAME, courier.getName()),
                    () -> assertEquals(Transport.PEDESTRIAN, courier.getTransport()),
                    () -> assertEquals(CourierStatus.NOT_AVAILABLE, courier.getStatus()),
                    () -> assertNotNull(courier.getLocation())
            );
        }

        @Test
        void givenNullId_thenThrowException() {
            assertThrows(NullPointerException.class, () -> Courier.create(null, COURIER_NAME, Transport.PEDESTRIAN));
        }

        @Test
        void givenNullName_thenThrowException() {
            assertThrows(NullPointerException.class, () -> Courier.create(UUID.randomUUID(), null, Transport.PEDESTRIAN));
        }

        @Test
        void givenNullTransport_thenThrowException() {
            assertThrows(NullPointerException.class, () -> Courier.create(UUID.randomUUID(), COURIER_NAME, null));
        }
    }

    @Nested
    class StartWorkDay {

        @Test
        void whenStartWorkDay_thenCourierStatusIsReady() {
            Courier courier = Courier.create(UUID.randomUUID(), COURIER_NAME, Transport.PEDESTRIAN);
            courier.startWorkDay();
            assertEquals(CourierStatus.READY, courier.getStatus());
        }

        @Test
        void whenStartWorkDay_butCourierIsBusy_thenThrowException() {
            Courier courier = new Courier(UUID.randomUUID(), COURIER_NAME, Transport.BICYCLE, new Location(1, 1), CourierStatus.BUSY);
            assertEquals("Failed to start work day. Courier is %s".formatted(CourierStatus.BUSY), assertThrows(IllegalStateException.class, courier::startWorkDay).getMessage());
        }
    }

    @Nested
    class EndWorkDay {

        @Test
        void whenEndWorkDay_thenCourierStatusIsNotAvailable() {
            Courier courier = Courier.create(UUID.randomUUID(), COURIER_NAME, Transport.PEDESTRIAN);
            courier.endWorkDay();
            assertEquals(CourierStatus.NOT_AVAILABLE, courier.getStatus());
        }

        @Test
        void whenStartWorkDay_butCourierIsBusy_thenThrowException() {
            Courier courier = new Courier(UUID.randomUUID(), COURIER_NAME, Transport.BICYCLE, new Location(1, 1), CourierStatus.BUSY);
            assertEquals("Failed to end work day. Courier is %s".formatted(CourierStatus.BUSY), assertThrows(IllegalStateException.class, courier::endWorkDay).getMessage());
        }
    }

    @Nested
    class AssignOrder {

        @Test
        void whenAssignOrder_thenCourierStatusIsBusy() {
            Courier courier = new Courier(UUID.randomUUID(), COURIER_NAME, Transport.BICYCLE, new Location(1, 1), CourierStatus.READY);
            courier.assignOrder();
            assertEquals(CourierStatus.BUSY, courier.getStatus());
        }

        @Test
        void whenAssignOrder_butCourierIsBusy_thenThrowException() {
            Courier courier = new Courier(UUID.randomUUID(), COURIER_NAME, Transport.BICYCLE, new Location(1, 1), CourierStatus.BUSY);
            assertEquals("Failed to assign order. Courier is %s".formatted(CourierStatus.BUSY), assertThrows(IllegalStateException.class, courier::assignOrder).getMessage());
        }
    }

    @Nested
    class CalculateSteps {

        @Test
        void whenDistanceIsZero_thenCalculatedZeroStep() {
            Courier courier = Courier.create(UUID.randomUUID(), COURIER_NAME, Transport.PEDESTRIAN);
            assertEquals(0, courier.calculateSteps(new Location(DEFAULT_LOCATION_X, DEFAULT_LOCATION_Y)));
        }

        @ParameterizedTest
        @MethodSource("availableTransports")
        void whenSpeedEqualToDistance_thenCalculatedOneStep(Transport transport) {
            Courier courier = Courier.create(UUID.randomUUID(), COURIER_NAME, transport);
            int yCoordinate = DEFAULT_LOCATION_Y + transport.getSpeed();
            assertEquals(1, courier.calculateSteps(new Location(DEFAULT_LOCATION_X, yCoordinate)));
        }


        public static Stream<Arguments> availableTransports() {
            return Arrays.stream(Transport.values()).map(Arguments::of);
        }
    }

    @Nested
    class MoveTowardsOrderLocation {

        @ParameterizedTest
        @MethodSource("availableTransports")
        void whenOrderLocationIsReachedWithinSpeed_thenOrderCompletedAndCourierReady(Transport transport) {

            Courier courier = Courier.create(UUID.randomUUID(), COURIER_NAME, transport);
            courier.startWorkDay();
            Order order = Order.create(UUID.randomUUID(), new Location(DEFAULT_LOCATION_X + transport.getSpeed(), DEFAULT_LOCATION_Y), new Weight(5));
            order.assignCourier(courier.getId());
            courier.assignOrder();
            courier.moveTowardsOrderLocation(order);

            assertAll(
                    () -> assertEquals(OrderStatus.COMPLETED, order.getStatus()),
                    () -> assertEquals(CourierStatus.READY, courier.getStatus())
            );
        }

        @ParameterizedTest
        @MethodSource("availableTransports")
        void whenOrderLocationIsNotReached_thenOrderAssignedAndCourierIsBusy(Transport transport) {

            Courier courier = Courier.create(UUID.randomUUID(), COURIER_NAME, transport);
            courier.startWorkDay();
            Order order = Order.create(UUID.randomUUID(), new Location(MAXIMUM_COORDINATE, MAXIMUM_COORDINATE), new Weight(5));
            order.assignCourier(courier.getId());
            courier.assignOrder();
            courier.moveTowardsOrderLocation(order);

            assertAll(
                    () -> assertEquals(OrderStatus.ASSIGNED, order.getStatus()),
                    () -> assertEquals(CourierStatus.BUSY, courier.getStatus())
            );
        }

        public static Stream<Arguments> availableTransports() {
            return Arrays.stream(Transport.values()).map(Arguments::of);
        }
    }
}
