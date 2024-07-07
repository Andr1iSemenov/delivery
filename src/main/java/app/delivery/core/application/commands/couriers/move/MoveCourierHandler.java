package app.delivery.core.application.commands.couriers.move;

import app.delivery.core.application.commands.CommandHandler;
import app.delivery.core.domain.courier.aggregate.Courier;
import app.delivery.core.domain.order.aggregate.Order;
import app.delivery.core.domain.order.aggregate.OrderStatus;
import app.delivery.core.ports.CourierRepository;
import app.delivery.core.ports.OrderRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MoveCourierHandler implements CommandHandler<MoveCourierCommand> {

    private final CourierRepository courierRepository;
    private final OrderRepository orderRepository;


    @Transactional
    @Override
    public void handle(MoveCourierCommand command) {
        Courier courier = courierRepository.findById(command.courierId());
        Order order = orderRepository.findByCourierId(command.courierId());
        courier.moveTowardsOrderLocation(order);

        courierRepository.save(courier);
        if (OrderStatus.COMPLETED.equals(order.getStatus())) {
            orderRepository.save(order);
        }
    }
}
