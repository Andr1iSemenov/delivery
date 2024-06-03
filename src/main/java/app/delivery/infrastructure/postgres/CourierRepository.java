package app.delivery.infrastructure.postgres;

import app.delivery.core.domain.courier.aggregate.Courier;
import app.delivery.core.domain.courier.aggregate.CourierStatus;
import app.delivery.core.ports.ICourierRepository;
import app.delivery.infrastructure.postgres.jpa.CourierJpaRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@RequiredArgsConstructor
public class CourierRepository implements ICourierRepository {

    private final CourierJpaRepository repository;


    @Override
    public Courier save(Courier courier) {
        return repository.save(courier);
    }

    @Override
    public void update(Courier courier) {
        repository.save(courier);
    }

    @Override
    public Courier findById(UUID id) {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Courier with id %s not found.".formatted(id)));
    }

    @Override
    public List<Courier> findAllFreeCouriers() {
        return repository.findAllByStatus(CourierStatus.READY);
    }
}
