package app.delivery.infrastructure.postgres;

import app.delivery.core.domain.order.aggregate.Order;
import app.delivery.core.domain.order.aggregate.OrderStatus;
import app.delivery.core.ports.IOrderRepository;
import app.delivery.infrastructure.postgres.jpa.OrderJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class OrderRepository implements IOrderRepository {

    private final OrderJpaRepository repository;


    @Override
    public Order save(Order order) {
        return repository.save(order);
    }

    @Override
    public void update(Order order) {
        repository.save(order);
    }

    @Override
    public Order findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order with id %s not found.".formatted(id)));
    }

    @Override
    public List<Order> findNewOrders() {
        return repository.findAllByStatus(OrderStatus.CREATED);
    }

    @Override
    public List<Order> findAssignedOrders() {
        return repository.findAllByStatus(OrderStatus.ASSIGNED);
    }
}
