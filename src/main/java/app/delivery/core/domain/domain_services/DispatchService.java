package app.delivery.core.domain.domain_services;

import app.delivery.core.domain.courier.aggregate.Courier;
import app.delivery.core.domain.courier.aggregate.CourierStatus;
import app.delivery.core.domain.order.aggregate.Order;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class DispatchService {

    public Courier dispatch(Order order, List<Courier> couriers) {
        return couriers.stream()
                .filter(courier -> CourierStatus.READY.equals(courier.getStatus()))
                .filter(courier -> courier.getTransport().canCarry(order.getWeight().kg()))
                .collect(Collectors.groupingBy(
                        courier -> courier.calculateSteps(order.getLocation()),
                        TreeMap::new,
                        Collectors.toList()
                ))
                .entrySet().stream().findFirst()
                .orElseThrow(() -> new IllegalStateException("No couriers found that can carry order %s with weight %s".formatted(order.getId(), order.getWeight())))
                .getValue().getFirst();
    }
}
