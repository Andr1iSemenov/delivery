package app.delivery.api.adapters;

import app.delivery.core.application.commands.orders.assign.AssignOrderCommand;
import app.delivery.core.application.commands.orders.assign.AssignOrderHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class AssignOrdersJob {

    private final AssignOrderHandler assignOrderHandler;


    @Scheduled(initialDelay = 5, fixedDelay = 1, timeUnit = TimeUnit.SECONDS)
    public void assignOrdersJob() {
        log.info("Running assign orders job");
        assignOrderHandler.handle(new AssignOrderCommand());
    }
}
