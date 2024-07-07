package app.delivery.core.application.queries.couriers;

import app.delivery.core.application.queries.QueryHandler;
import app.delivery.core.domain.courier.aggregate.CourierStatus;
import app.delivery.infrastructure.postgres.repositories.CourierJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetBusyCouriersQueryHandler implements QueryHandler<List<GetBusyCouriersResponse>> {

    private final CourierJpaRepository courierJpaRepository;


    @Override
    public List<GetBusyCouriersResponse> handle() {
        return courierJpaRepository.findAllByStatus(CourierStatus.BUSY).stream()
                .map(courierEntity -> new GetBusyCouriersResponse(courierEntity.getId(), courierEntity.getName(), courierEntity.getLocation(), courierEntity.getTransport()))
                .toList();
    }
}
