package app.delivery.core.application.queries.couriers;

import app.delivery.infrastructure.postgres.entities.CourierEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CourierEntityToResponse {

    public GetBusyCouriersResponse toGetBusyCouriersResponse(CourierEntity courierEntity) {
        return new GetBusyCouriersResponse(
                courierEntity.getId(),
                courierEntity.getName(),
                courierEntity.getLocation(),
                courierEntity.getTransport()
        );
    }

    public List<GetBusyCouriersResponse> toGetBusyCouriersResponseList(List<CourierEntity> courierEntities) {
        return courierEntities.stream()
                .map(this::toGetBusyCouriersResponse)
                .toList();
    }
}
