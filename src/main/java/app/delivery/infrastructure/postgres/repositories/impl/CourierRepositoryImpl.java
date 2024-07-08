package app.delivery.infrastructure.postgres.repositories.impl;

import app.delivery.core.domain.courier.aggregate.Courier;
import app.delivery.core.domain.courier.aggregate.CourierStatus;
import app.delivery.core.ports.CourierRepository;
import app.delivery.infrastructure.postgres.converters.impl.CourierConverter;
import app.delivery.infrastructure.postgres.entities.CourierEntity;
import app.delivery.infrastructure.postgres.repositories.CourierJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CourierRepositoryImpl implements CourierRepository {

    private final CourierJpaRepository repository;
    private final CourierConverter courierConverter;


    @Override
    public Courier save(Courier courier) {
        CourierEntity savedEntity = repository.save(courierConverter.convertToEntity(courier));
        return courierConverter.convertToDomain(savedEntity);
    }

    @Override
    public void update(Courier courier) {
        repository.save(courierConverter.convertToEntity(courier));
    }

    @Override
    public Courier findById(UUID id) {
        return courierConverter.convertToDomain(
                repository.findById(id)
                        .orElseThrow(() -> new EntityNotFoundException("Courier with id %s not found.".formatted(id)))
        );
    }

    @Override
    public List<Courier> findAllFreeCouriers() {
        return repository.findAllByStatus(CourierStatus.READY)
                .stream()
                .map(courierConverter::convertToDomain)
                .toList();
    }

    @Override
    public List<Courier> findAllCouriers() {
        return repository.findAll()
                .stream()
                .map(courierConverter::convertToDomain)
                .toList();
    }
}
