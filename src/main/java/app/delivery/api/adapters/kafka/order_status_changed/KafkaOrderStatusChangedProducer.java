package app.delivery.api.adapters.kafka.order_status_changed;

import app.delivery.api.adapters.kafka.converters.OrderStatusChangedEventConverter;
import app.delivery.core.domain.domain_events.OrderStatusChangedEvent;
import com.google.protobuf.util.JsonFormat;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaOrderStatusChangedProducer {

    @Value("${delivery.kafka.order.status.changed.topic}")
    private String topic;

    private final KafkaProducer<String, byte[]> producer;
    private final OrderStatusChangedEventConverter orderStatusChangedEventConverter;


    public void sendMessage(OrderStatusChangedEvent event) {
        try {
            String jsonMessage = JsonFormat.printer().print(orderStatusChangedEventConverter.convert(event));
            producer.send(new ProducerRecord<>(topic, jsonMessage.getBytes(StandardCharsets.UTF_8)));
        } catch (Exception e) {
            log.error("While send message for order id {} got", event.getOrderId(), e);
        }
    }
}