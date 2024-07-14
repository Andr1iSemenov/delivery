package app.delivery.core.application.queries.orders;

import app.delivery.infrastructure.postgres.entities.OrderEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderEntityToResponse {

    public GetUncompletedOrdersResponse toGetUncompletedOrdersResponse(OrderEntity orderEntity) {
        return new GetUncompletedOrdersResponse(
                orderEntity.getId(),
                orderEntity.getCourierId(),
                orderEntity.getStatus(),
                orderEntity.getWeight(),
                orderEntity.getLocation()
        );
    }

    public List<GetUncompletedOrdersResponse> toGetUncompletedOrdersResponseList(List<OrderEntity> orderEntities) {
        return orderEntities.stream()
                .map(this::toGetUncompletedOrdersResponse)
                .toList();
    }
}
