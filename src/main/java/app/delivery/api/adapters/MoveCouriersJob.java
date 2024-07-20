package app.delivery.api.adapters;

import app.delivery.core.application.commands.couriers.move.MoveCourierCommand;
import app.delivery.core.application.commands.couriers.move.MoveCourierHandler;
import app.delivery.core.application.queries.couriers.GetBusyCouriersQueryHandler;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Slf4j
@Service
@RequiredArgsConstructor
public class MoveCouriersJob {

    private final MoveCourierHandler moveCourierHandler;
    private final GetBusyCouriersQueryHandler getBusyCouriersQueryHandler;


    @Scheduled(initialDelay = 5, fixedDelay = 2, timeUnit = TimeUnit.SECONDS)
    public void moveCouriers() {
        log.info("Running moveCouriers job");
        getBusyCouriersQueryHandler.handle().forEach(busyCouriersResponse -> moveCourierHandler.handle(new MoveCourierCommand(busyCouriersResponse.id())));
    }
}
