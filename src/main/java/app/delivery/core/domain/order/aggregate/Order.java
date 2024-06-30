package app.delivery.core.domain.order.aggregate;

import app.delivery.core.shared.kernel.Location;
import app.delivery.core.shared.kernel.Weight;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Table(name = "orders")
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id")
public class Order {

    @Id
    private UUID id;

    private UUID courierId;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Embedded
    private Weight weight;

    @Embedded
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

