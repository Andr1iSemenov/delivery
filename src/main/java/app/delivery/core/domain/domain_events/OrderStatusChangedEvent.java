package app.delivery.core.domain.domain_events;

import app.delivery.core.domain.order.aggregate.OrderStatus;
import lombok.Getter;
import lombok.ToString;
import org.springframework.context.ApplicationEvent;

import java.util.UUID;

@ToString
@Getter
public class OrderStatusChangedEvent extends ApplicationEvent {

    private final UUID orderId;
    private final OrderStatus orderStatus;

    public OrderStatusChangedEvent(Object source, UUID orderId, OrderStatus orderStatus) {
        super(source);
        this.orderId = orderId;
        this.orderStatus = orderStatus;
    }
}
