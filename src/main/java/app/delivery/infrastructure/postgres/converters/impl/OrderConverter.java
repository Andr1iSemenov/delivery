package app.delivery.infrastructure.postgres.converters.impl;

import app.delivery.core.domain.order.aggregate.Order;
import app.delivery.infrastructure.postgres.converters.Converter;
import app.delivery.infrastructure.postgres.entities.OrderEntity;
import org.springframework.stereotype.Component;

@Component
public class OrderConverter implements Converter<Order, OrderEntity> {

    @Override
    public Order convertToDomain(OrderEntity entity) {
        return new Order(
                entity.getId(),
                entity.getCourierId(),
                entity.getStatus(),
                entity.getWeight(),
                entity.getLocation()
        );
    }

    @Override
    public OrderEntity convertToEntity(Order order) {
        OrderEntity entity = new OrderEntity();
        entity.setId(order.getId());
        entity.setCourierId(order.getCourierId());
        entity.setStatus(order.getStatus());
        entity.setWeight(order.getWeight());
        entity.setLocation(order.getLocation());
        return entity;
    }
}
