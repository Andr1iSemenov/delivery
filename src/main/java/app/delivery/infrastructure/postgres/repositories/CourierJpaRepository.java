package app.delivery.infrastructure.postgres.repositories;

import app.delivery.core.domain.courier.aggregate.CourierStatus;
import app.delivery.infrastructure.postgres.entities.CourierEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CourierJpaRepository extends JpaRepository<CourierEntity, UUID> {

    List<CourierEntity> findAllByStatus(CourierStatus status);
}
