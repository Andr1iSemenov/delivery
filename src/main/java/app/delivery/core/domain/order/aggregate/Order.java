package app.delivery.core.domain.order.aggregate;

import app.delivery.core.shared.kernel.Location;
import app.delivery.core.shared.kernel.Weight;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "id")
public class Order {

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
                .build();
    }

    public void assignCourier(@NonNull UUID courierId) {
        this.courierId = courierId;
        this.status = OrderStatus.ASSIGNED;
    }

    public void complete() {
        if (!OrderStatus.ASSIGNED.equals(this.status)) {
            throw new IllegalStateException("Cannot complete order. Expected status should be ASSIGNED but was %s".formatted(this.status));
        }
        this.status = OrderStatus.COMPLETED;
    }
}

