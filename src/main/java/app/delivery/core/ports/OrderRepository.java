package app.delivery.core.ports;

import app.delivery.core.domain.order.aggregate.Order;

import java.util.List;
import java.util.UUID;

public interface OrderRepository {

    Order save(Order order);

    void update(Order order);

    Order findById(UUID id);

    Order findByCourierId(UUID courierId);

    List<Order> findNewOrders();

    List<Order> findAssignedOrders();
}
