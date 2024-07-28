package app.delivery.infrastructure.postgres.repositories.impl;

import app.delivery.core.domain.order.aggregate.Order;
import app.delivery.core.domain.order.aggregate.OrderStatus;
import app.delivery.core.ports.OrderRepository;
import app.delivery.infrastructure.postgres.converters.impl.OrderConverter;
import app.delivery.infrastructure.postgres.entities.OrderEntity;
import app.delivery.infrastructure.postgres.entities.OutboxMessage;
import app.delivery.infrastructure.postgres.repositories.OrderJpaRepository;
import app.delivery.infrastructure.postgres.repositories.OutboxMessageJpaRepository;
import com.google.gson.Gson;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class OrderRepositoryImpl implements OrderRepository {

    private final OrderJpaRepository repository;
    private final OrderConverter orderConverter;
    private final Gson gson;
    private final OutboxMessageJpaRepository outboxMessageJpaRepository;


    @Override
    public Order save(Order order) {
        OrderEntity savedOrder = repository.save(orderConverter.convertToEntity(order));
        outboxMessageJpaRepository.saveAll(order.getDomainEvents().stream().map(domainEvent -> {
            OutboxMessage outboxMessage = new OutboxMessage();
            outboxMessage.setType(domainEvent.getClass().getTypeName());
            outboxMessage.setContent(gson.toJson(domainEvent));
            return outboxMessage;
        }).toList());
        order.clearDomainEvents();
        return orderConverter.convertToDomain(savedOrder);
    }

    @Override
    public void update(Order order) {
        repository.save(orderConverter.convertToEntity(order));
    }

    @Override
    public Order findById(UUID id) {
        return orderConverter.convertToDomain(
                repository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Order with id %s not found.".formatted(id)))
        );
    }

    @Override
    public Order findByCourierId(UUID courierId) {
        return orderConverter.convertToDomain(
                repository.findByCourierIdAndStatus(courierId, OrderStatus.ASSIGNED)
                        .orElseThrow(() -> new EntityNotFoundException("Order with courier id %s not found.".formatted(courierId)))
        );
    }

    @Override
    public List<Order> findNewOrders() {
        return repository.findAllByStatus(OrderStatus.CREATED)
                .stream()
                .map(orderConverter::convertToDomain)
                .toList();
    }

    @Override
    public List<Order> findAssignedOrders() {
        return repository.findAllByStatus(OrderStatus.ASSIGNED)
                .stream()
                .map(orderConverter::convertToDomain)
                .toList();
    }
}
