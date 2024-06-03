package app.delivery.infrastructure.postgres.jpa;

import app.delivery.core.domain.courier.aggregate.Courier;
import app.delivery.core.domain.courier.aggregate.CourierStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CourierJpaRepository extends JpaRepository<Courier, UUID> {

    List<Courier> findAllByStatus(CourierStatus status);
}
