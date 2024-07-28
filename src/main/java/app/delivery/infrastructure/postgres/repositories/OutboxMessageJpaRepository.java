package app.delivery.infrastructure.postgres.repositories;

import app.delivery.infrastructure.postgres.entities.OutboxMessage;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OutboxMessageJpaRepository extends JpaRepository<OutboxMessage, Long> {

    List<OutboxMessage> findAllByPublishDateIsNullOrderByCreateDate(Pageable pageable);
}
