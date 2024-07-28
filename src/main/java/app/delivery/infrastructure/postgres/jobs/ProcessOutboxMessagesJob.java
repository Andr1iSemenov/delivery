package app.delivery.infrastructure.postgres.jobs;

import app.delivery.infrastructure.postgres.entities.OutboxMessage;
import app.delivery.infrastructure.postgres.repositories.OutboxMessageJpaRepository;
import com.google.gson.Gson;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProcessOutboxMessagesJob {

    private final ApplicationContext applicationContext;
    private final ApplicationEventPublisher eventPublisher;
    private final OutboxMessageJpaRepository outboxMessageJpaRepository;
    private final Gson gson;


    @Scheduled(initialDelay = 5, fixedDelay = 5, timeUnit = TimeUnit.SECONDS)
    public void processOutboxMessages() {
        outboxMessageJpaRepository.findAllByPublishDateIsNullOrderByCreateDate(Pageable.ofSize(20)).forEach(getProxy()::publishEvent);
    }

    @Transactional
    public void publishEvent(OutboxMessage event) {
        try {
            eventPublisher.publishEvent(gson.fromJson(event.getContent(), Class.forName(event.getType())));
            event.setPublishDate(new Date());
            outboxMessageJpaRepository.save(event);
        } catch (ClassNotFoundException e) {
            log.error("Failed to find class for type: {}", event.getType(), e);
        } catch (Exception e) {
            log.error("Unexpected error occurred while publishing event: {}", event, e);
        }
    }

    private ProcessOutboxMessagesJob getProxy() {
        return applicationContext.getBean(this.getClass());
    }
}
