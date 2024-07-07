package app.delivery.core.application.commands.orders.assign;

import app.delivery.core.application.commands.CommandHandler;
import app.delivery.core.domain.courier.aggregate.Courier;
import app.delivery.core.domain.domain_services.DispatchService;
import app.delivery.core.domain.order.aggregate.Order;
import app.delivery.core.ports.CourierRepository;
import app.delivery.core.ports.OrderRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class AssignOrderHandler implements CommandHandler<AssignOrderCommand> {

    private final OrderRepository orderRepository;
    private final CourierRepository courierRepository;
    private final DispatchService dispatchService;
    private final ApplicationContext applicationContext;


    @Override
    public void handle(AssignOrderCommand command) {
        List<Order> newOrders = orderRepository.findNewOrders();
        List<Courier> freeCouriers = courierRepository.findAllFreeCouriers();

        newOrders.forEach(order -> getProxy().handle(order, freeCouriers));
    }

    @Transactional
    public void handle(Order order, List<Courier> freeCouriers) {
        try {
            Courier assignedCourier = dispatchService.dispatch(order, freeCouriers);
            assignedCourier.assignOrder();
            order.assignCourier(assignedCourier.getId());

            courierRepository.save(assignedCourier);
            orderRepository.save(order);
        } catch (Exception e) {
            log.error("While assigning order {} got", order, e);
        }
    }

    public AssignOrderHandler getProxy() {
        return applicationContext.getBean(AssignOrderHandler.class);
    }
}
