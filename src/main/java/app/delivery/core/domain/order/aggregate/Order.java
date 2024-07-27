package app.delivery.core.domain.order.aggregate;

import app.delivery.core.domain.domain_events.OrderStatusChangedEvent;
import app.delivery.core.shared.kernel.Location;
import app.delivery.core.shared.kernel.Weight;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Builder
@AllArgsConstructor
@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "id")
public class Order {

    private List<Object> domainEvents = new ArrayList<>();

    private UUID id;

    private UUID courierId;

    private OrderStatus status;

    private Weight weight;

    private Location location;


    public static Order create(@NonNull UUID id, @NonNull Location location, @NonNull Weight weight) {
        return Order.builder()
                .id(id)
                .location(location)
                .weight(weight)
                .status(OrderStatus.CREATED)
                .domainEvents(new ArrayList<>())
                .build();
    }

    public Order(UUID id, UUID courierId, OrderStatus status, Weight weight, Location location) {
        this.id = id;
        this.courierId = courierId;
        this.status = status;
        this.weight = weight;
        this.location = location;
    }

    public void assignCourier(@NonNull UUID courierId) {
        this.courierId = courierId;
        this.status = OrderStatus.ASSIGNED;
        domainEvents.add(new OrderStatusChangedEvent(this.id, this.status));
    }

    public void complete() {
        if (!OrderStatus.ASSIGNED.equals(this.status)) {
            throw new IllegalStateException("Cannot complete order. Expected status should be ASSIGNED but was %s".formatted(this.status));
        }
        this.status = OrderStatus.COMPLETED;
        domainEvents.add(new OrderStatusChangedEvent(this.id, this.status));
    }

    public void clearDomainEvents() {
        domainEvents.clear();
    }
}

