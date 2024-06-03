package app.delivery.infrastructure.postgres.jpa;

import app.delivery.core.domain.order.aggregate.Order;
import app.delivery.core.domain.order.aggregate.OrderStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderJpaRepository extends JpaRepository<Order, UUID> {

    List<Order> findAllByStatus(OrderStatus status);
}
