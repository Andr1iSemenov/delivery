package app.delivery.infrastructure.kafka.consumers;

import app.delivery.core.application.commands.orders.create.CreateOrderCommand;
import app.delivery.core.application.commands.orders.create.CreateOrderHandler;
import app.delivery.core.shared.kernel.Weight;
import app.delivery.infrastructure.kafka.gen.BasketConfirmedIntegrationEvent;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.util.JsonFormat;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class KafkaBasketConfirmedConsumer {

    private final ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
    private final CreateOrderHandler createOrderHandler;

    private final KafkaConsumer<String, String> basketConfirmedConsumer;


    @PostConstruct
    public void init() {
        executorService.scheduleAtFixedRate(this::consumeMessages, 0, 3, TimeUnit.SECONDS);
    }

    private void consumeMessages() {
        try {
            ConsumerRecords<String, String> records = basketConfirmedConsumer.poll(Duration.ofMillis(3000));
            records.forEach(this::processRecord);
        } catch (Exception e) {
            log.error("Failed to poll messages", e);
        }
    }

    private void processRecord(ConsumerRecord<String, String> kafkaRecord) {
        try {
            BasketConfirmedIntegrationEvent event = parseRecord(kafkaRecord);
            log.info("Got record: {}", kafkaRecord);

            createOrderHandler.handle(new CreateOrderCommand(
                    UUID.fromString(event.getBasketId()),
                    event.getAddress().getStreet(),
                    new Weight(1)
            ));
        } catch (Exception e) {
            log.error("Failed to process record: {}", kafkaRecord, e);
        }
    }

    private BasketConfirmedIntegrationEvent parseRecord(ConsumerRecord<String, String> kafkaRecord) throws InvalidProtocolBufferException {
        BasketConfirmedIntegrationEvent.Builder builder = BasketConfirmedIntegrationEvent.newBuilder();
        JsonFormat.parser().ignoringUnknownFields().merge(kafkaRecord.value(), builder);
        return builder.build();
    }
}
