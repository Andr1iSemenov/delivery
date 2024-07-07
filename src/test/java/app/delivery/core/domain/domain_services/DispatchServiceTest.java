package app.delivery.core.domain.domain_services;

import app.delivery.core.domain.courier.aggregate.Courier;
import app.delivery.core.domain.courier.aggregate.Transport;
import app.delivery.core.domain.order.aggregate.Order;
import app.delivery.core.shared.kernel.Location;
import app.delivery.core.shared.kernel.Weight;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class DispatchServiceTest {

    private final DispatchService dispatchService = new DispatchService();

    @Test
    void shouldFindCourier(){
        Order order = Order.create(UUID.randomUUID(), Location.createWithMinimumCoordinates(), new Weight(1));
        Courier courier = Courier.create(UUID.randomUUID(), "John", Transport.CAR);

        Courier foundCourier = dispatchService.dispatch(order, List.of(courier));

        assertAll(
                () -> assertNotNull(foundCourier),
                () -> assertEquals(courier.getId(), foundCourier.getId())
        );
    }

    @Test
    void shouldThrowExceptionWhenWeightIsExceedTransportWeight() {
        Order order = Order.create(UUID.randomUUID(), Location.createWithMinimumCoordinates(), new Weight(100));
        Courier courier = Courier.create(UUID.randomUUID(), "Bob", Transport.PEDESTRIAN);

        var exception = assertThrows(IllegalStateException.class, () -> dispatchService.dispatch(order, List.of(courier)));
        assertTrue(exception.getMessage().contains("No couriers found that can carry order"));
    }

    @Test
    void shouldFindFasterCourier() {
        Order order = Order.create(UUID.randomUUID(), new Location(10, 10), new Weight(1));
        Courier courier1 = Courier.create(UUID.randomUUID(), "Jane", Transport.SCOOTER);
        Courier courier2 = Courier.create(UUID.randomUUID(), "Closest", Transport.PEDESTRIAN);
        Courier fasterCourier = Courier.create(UUID.randomUUID(), "John", Transport.CAR);

        Courier foundCourier = dispatchService.dispatch(order, List.of(courier1, courier2, fasterCourier));

        assertAll(
                () -> assertNotNull(foundCourier),
                () -> assertEquals(fasterCourier.getId(), foundCourier.getId())
        );
    }
}