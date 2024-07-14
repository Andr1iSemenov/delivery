package app.delivery.core.application.commands.orders.create;

import app.delivery.core.application.commands.CommandHandler;
import app.delivery.core.domain.order.aggregate.Order;
import app.delivery.core.ports.OrderRepository;
import app.delivery.core.shared.kernel.Location;
import app.delivery.infrastructure.grpc.geo.GeoService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateOrderHandler implements CommandHandler<CreateOrderCommand> {

    private final OrderRepository orderRepository;
    private final GeoService geoService;


    @Transactional
    @Override
    public void handle(CreateOrderCommand command) {
        Location location = geoService.getLocation(command.street());
        orderRepository.save(Order.create(command.basketId(), location, command.weight()));
    }
}
