package app.delivery.core.application.commands.orders.create;

import app.delivery.core.application.commands.CommandHandler;
import app.delivery.core.domain.order.aggregate.Order;
import app.delivery.core.ports.OrderRepository;
import app.delivery.core.shared.kernel.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CreateOrderHandler implements CommandHandler<CreateOrderCommand> {

    private final OrderRepository orderRepository;


    @Transactional
    @Override
    public void handle(CreateOrderCommand command) {
        //todo user real location once get will be implemented
        orderRepository.save(Order.create(command.basketId(), Location.createWithMinimumCoordinates(), command.weight()));
    }
}
