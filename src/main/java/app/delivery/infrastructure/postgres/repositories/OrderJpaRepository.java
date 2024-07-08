package app.delivery.infrastructure.postgres.repositories;

import app.delivery.core.domain.order.aggregate.OrderStatus;
import app.delivery.infrastructure.postgres.entities.OrderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OrderJpaRepository extends JpaRepository<OrderEntity, UUID> {

    List<OrderEntity> findAllByStatus(OrderStatus status);
}
