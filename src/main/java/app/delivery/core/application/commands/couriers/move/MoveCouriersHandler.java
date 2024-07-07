package app.delivery.core.application.commands.couriers.move;

import app.delivery.core.application.commands.CommandHandler;
import app.delivery.core.domain.order.aggregate.OrderStatus;
import app.delivery.core.ports.CourierRepository;
import app.delivery.core.ports.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MoveCouriersHandler implements CommandHandler<MoveCouriersCommand> {

    private final CourierRepository courierRepository;
    private final OrderRepository orderRepository;


    @Transactional
    @Override
    public void handle(MoveCouriersCommand command) {
        command.courier().moveTowardsOrderLocation(command.order());

        courierRepository.save(command.courier());
        if (OrderStatus.COMPLETED.equals(command.order().getStatus())) {
            orderRepository.save(command.order());
        }
    }
}
