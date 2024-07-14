package app.delivery.core.domain.domain_services;

import app.delivery.core.domain.courier.aggregate.Courier;
import app.delivery.core.domain.order.aggregate.Order;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;

@Service
public class DispatchService {

    public Courier dispatch(Order order, List<Courier> freeCouriers) {
        return freeCouriers.stream()
                .filter(courier -> courier.getTransport().canCarry(order.getWeight().kg()))
                .min(Comparator.comparingInt(courier -> courier.calculateSteps(order.getLocation())))
                .orElseThrow(() -> new IllegalStateException("No couriers found that can carry order %s with weight %s".formatted(order.getId(), order.getWeight())));
    }
}
