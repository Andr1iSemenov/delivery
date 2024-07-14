package app.delivery.core.application.queries.orders;

import app.delivery.core.application.queries.QueryHandler;
import app.delivery.core.domain.order.aggregate.OrderStatus;
import app.delivery.infrastructure.postgres.repositories.OrderJpaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetUncompletedOrdersQueryHandler implements QueryHandler<List<GetUncompletedOrdersResponse>> {

    private final OrderJpaRepository orderJpaRepository;
    private final OrderEntityToResponse orderEntityToResponse;


    @Override
    public List<GetUncompletedOrdersResponse> handle() {
        return orderEntityToResponse.toGetUncompletedOrdersResponseList(orderJpaRepository.findAllByStatusIn(List.of(OrderStatus.CREATED, OrderStatus.ASSIGNED)));
    }
}
