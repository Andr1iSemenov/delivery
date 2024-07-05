package app.delivery.infrastructure.postgres.converters.impl;

import app.delivery.core.domain.courier.aggregate.Courier;
import app.delivery.infrastructure.postgres.converters.Converter;
import app.delivery.infrastructure.postgres.entities.CourierEntity;
import org.springframework.stereotype.Component;

@Component
public class CourierConverter implements Converter<Courier, CourierEntity> {

    @Override
    public Courier convertToDomain(CourierEntity entity) {
        return new Courier(
                entity.getId(),
                entity.getName(),
                entity.getTransport(),
                entity.getLocation(),
                entity.getStatus()
        );
    }

    @Override
    public CourierEntity convertToEntity(Courier courier) {
        CourierEntity entity = new CourierEntity();
        entity.setId(courier.getId());
        entity.setName(courier.getName());
        entity.setTransport(courier.getTransport());
        entity.setLocation(courier.getLocation());
        entity.setStatus(courier.getStatus());
        return entity;
    }
}
