package app.delivery.api.adapters.kafka.converters;

import app.delivery.api.adapters.kafka.order_status_changed.OrderStatus;
import app.delivery.api.adapters.kafka.order_status_changed.OrderStatusChangedIntegrationEvent;
import app.delivery.core.domain.domain_events.OrderStatusChangedEvent;
import org.springframework.stereotype.Component;

@Component
public class OrderStatusChangedEventConverter {

    public OrderStatusChangedIntegrationEvent convert(OrderStatusChangedEvent event) {
        return OrderStatusChangedIntegrationEvent.newBuilder()
                .setOrderId(event.orderId().toString())
                .setOrderStatus(OrderStatus.valueOf(event.orderStatus().getName()))
                .build();
    }
}
