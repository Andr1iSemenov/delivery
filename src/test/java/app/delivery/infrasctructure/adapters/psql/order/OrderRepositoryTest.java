package app.delivery.infrasctructure.adapters.psql.order;

import app.delivery.configs.ContainersEnvironment;
import app.delivery.core.domain.order.aggregate.Order;
import app.delivery.core.domain.order.aggregate.OrderStatus;
import app.delivery.core.ports.OrderRepository;
import app.delivery.core.shared.kernel.Location;
import app.delivery.core.shared.kernel.Weight;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class OrderRepositoryTest extends ContainersEnvironment {

    @Autowired
    OrderRepository orderRepository;


    @Test
    void testSaveOrder() {
        UUID orderId = UUID.randomUUID();
        Order order = Order.create(orderId, Location.createWithMinimumCoordinates(), new Weight(5.0));

        Order savedOrder = orderRepository.save(order);

        assertAll(
                () -> assertNotNull(savedOrder),
                () -> assertEquals(orderId, savedOrder.getId())
        );
    }

    @Test
    void testUpdateOrder() {
        UUID orderId = UUID.randomUUID();
        Order order = Order.create(orderId, Location.createWithMinimumCoordinates(), new Weight(5.0));

        orderRepository.save(order);
        order.assignCourier(UUID.randomUUID());

        orderRepository.update(order);
        Order updatedOrder = orderRepository.findById(orderId);

        assertEquals(order.getCourierId(), updatedOrder.getCourierId());
    }

    @Test
    void testFindById() {
        UUID orderId = UUID.randomUUID();
        Order order = Order.create(orderId, Location.createWithMinimumCoordinates(), new Weight(5.0));

        orderRepository.save(order);
        Order foundOrder = orderRepository.findById(orderId);

        assertAll(
                () -> assertNotNull(foundOrder),
                () -> assertEquals(orderId, foundOrder.getId())
        );
    }

    @Test
    void testFindByIdNotFound() {
        UUID id = UUID.randomUUID();
        Throwable exception = assertThrows(JpaObjectRetrievalFailureException.class,
                () -> orderRepository.findById(id));
        assertEquals(EntityNotFoundException.class, exception.getCause().getClass());
    }

    @Test
    void testFindNewOrders() {
        Order order1 = Order.create(UUID.randomUUID(), Location.createWithMinimumCoordinates(), new Weight(5.0));
        Order order2 = Order.create(UUID.randomUUID(), Location.createWithMinimumCoordinates(), new Weight(3.0));

        orderRepository.save(order1);
        orderRepository.save(order2);

        List<Order> newOrders = orderRepository.findNewOrders();

        assertAll(
                () -> assertEquals(2, newOrders.size()),
                () -> assertTrue(newOrders.stream().allMatch(order -> OrderStatus.CREATED.equals(order.getStatus())))
        );
    }

    @Test
    void testFindAssignedOrders() {
        Order order1 = Order.create(UUID.randomUUID(), Location.createWithMinimumCoordinates(), new Weight(5.0));
        Order order2 = Order.create(UUID.randomUUID(), Location.createWithMinimumCoordinates(), new Weight(3.0));
        Order order3 = Order.create(UUID.randomUUID(), Location.createWithMinimumCoordinates(), new Weight(1.0));

        order1.assignCourier(UUID.randomUUID());
        order3.assignCourier(UUID.randomUUID());

        orderRepository.save(order1);
        orderRepository.save(order2);
        orderRepository.save(order3);

        List<Order> assignedOrders = orderRepository.findAssignedOrders();

        assertAll(
                () -> assertEquals(2, assignedOrders.size()),
                () -> assertTrue(assignedOrders.stream().allMatch(order -> OrderStatus.ASSIGNED.equals(order.getStatus())))
        );
    }
}

