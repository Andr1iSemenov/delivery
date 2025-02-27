package app.delivery.core.ports;

import app.delivery.core.domain.courier.aggregate.Courier;

import java.util.List;
import java.util.UUID;

public interface CourierRepository {

    Courier save(Courier courier);

    void update(Courier courier);

    Courier findById(UUID id);

    List<Courier> findAllFreeCouriers();

    List<Courier> findAllCouriers();
}
