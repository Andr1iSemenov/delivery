package app.delivery.core.application.domain_event_handlers.order;

import app.delivery.api.adapters.kafka.order_status_changed.KafkaOrderStatusChangedProducer;
import app.delivery.core.domain.domain_events.OrderStatusChangedEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Service;
import org.springframework.transaction.event.TransactionPhase;
import org.springframework.transaction.event.TransactionalEventListener;

@Slf4j
@Service
@RequiredArgsConstructor
public class OrderStatusChangedEventHandler {

    private final KafkaOrderStatusChangedProducer kafkaOrderStatusChangedProducer;


    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    @EventListener
    public void handleOrderStatusChangedEvent(OrderStatusChangedEvent event) {
        log.info("Handling order status changed event: {}", event);
        kafkaOrderStatusChangedProducer.sendMessage(event);
    }
}
