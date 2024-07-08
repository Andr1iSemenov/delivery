package app.delivery.core.application.commands.orders.create;

import app.delivery.core.application.commands.CommandHandler;
import app.delivery.core.domain.order.aggregate.Order;
import app.delivery.core.ports.OrderRepository;
import app.delivery.core.shared.kernel.Location;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class CreateOrderHandler implements CommandHandler<CreateOrderCommand> {

    private final OrderRepository orderRepository;
    private final Random random = new Random();


    @Transactional
    @Override
    public void handle(CreateOrderCommand command) {
        //todo user real location once get will be implemented
        //todo move random location to Location method
        orderRepository.save(Order.create(command.basketId(), new Location(random.nextInt(10) + 1, random.nextInt(10) + 1), command.weight()));
    }
}
