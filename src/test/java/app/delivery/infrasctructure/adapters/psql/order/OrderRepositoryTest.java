package app.delivery.infrasctructure.adapters.psql.order;

import app.delivery.configs.ContainersEnvironment;
import app.delivery.core.domain.order.aggregate.Order;
import app.delivery.core.domain.order.aggregate.OrderStatus;
import app.delivery.core.ports.OrderRepository;
import app.delivery.core.shared.kernel.Location;
import app.delivery.core.shared.kernel.Weight;
import app.delivery.utils.JsonFileReader;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@Transactional
@SpringBootTest
class OrderRepositoryTest extends ContainersEnvironment {

    private static final UUID ORDER_ID = UUID.fromString("11111111-1111-1111-1111-111111111111");


    @Autowired
    OrderRepository orderRepository;


    @Test
    @Sql("/files/infrastructure/adapters/postgres/order/sql/00_truncate.sql")
    void saveOrder() {
        UUID orderId = UUID.randomUUID();
        Order order = Order.create(orderId, Location.createWithMinimumCoordinates(), new Weight(5.0));

        Order savedOrder = orderRepository.save(order);

        assertAll(
                () -> assertNotNull(savedOrder),
                () -> assertEquals(orderId, savedOrder.getId())
        );
    }

    @Test
    @Sql({
            "/files/infrastructure/adapters/postgres/order/sql/00_truncate.sql",
            "/files/infrastructure/adapters/postgres/order/sql/01_insert_order_CREATED.sql"
    })
    void updateOrder() throws IOException {
        Order order = JsonFileReader.readFromFile("/files/core/domain/order/aggregate/order_ASSIGNED.json", Order.class);

        assertDoesNotThrow(() -> orderRepository.update(order));
    }

    @Test
    @Sql({
            "/files/infrastructure/adapters/postgres/order/sql/00_truncate.sql",
            "/files/infrastructure/adapters/postgres/order/sql/01_insert_order_CREATED.sql"
    })
    void findById() {
        Order foundOrder = orderRepository.findById(ORDER_ID);

        assertAll(
                () -> assertNotNull(foundOrder),
                () -> assertEquals(ORDER_ID, foundOrder.getId())
        );
    }

    @Test
    void findByIdNotFound() {
        UUID id = UUID.randomUUID();

        Throwable exception = assertThrows(JpaObjectRetrievalFailureException.class,
                () -> orderRepository.findById(id));
        assertEquals(EntityNotFoundException.class, exception.getCause().getClass());
    }

    @Test
    @Sql({
            "/files/infrastructure/adapters/postgres/order/sql/00_truncate.sql",
            "/files/infrastructure/adapters/postgres/order/sql/01_insert_order_CREATED.sql",
            "/files/infrastructure/adapters/postgres/order/sql/02_insert_order_ASSIGNED.sql",
            "/files/infrastructure/adapters/postgres/order/sql/03_insert_order_COMPLETED.sql"
    })
    void findNewOrders() {
        List<Order> newOrders = orderRepository.findNewOrders();

        assertAll(
                () -> assertEquals(1, newOrders.size()),
                () -> assertTrue(newOrders.stream().allMatch(order -> OrderStatus.CREATED.equals(order.getStatus())))
        );
    }

    @Test
    @Sql({
            "/files/infrastructure/adapters/postgres/order/sql/00_truncate.sql",
            "/files/infrastructure/adapters/postgres/order/sql/01_insert_order_CREATED.sql",
            "/files/infrastructure/adapters/postgres/order/sql/02_insert_order_ASSIGNED.sql",
            "/files/infrastructure/adapters/postgres/order/sql/03_insert_order_COMPLETED.sql"
    })
    void findAssignedOrders() {
        List<Order> assignedOrders = orderRepository.findAssignedOrders();

        assertAll(
                () -> assertEquals(1, assignedOrders.size()),
                () -> assertTrue(assignedOrders.stream().allMatch(order -> OrderStatus.ASSIGNED.equals(order.getStatus())))
        );
    }
}

