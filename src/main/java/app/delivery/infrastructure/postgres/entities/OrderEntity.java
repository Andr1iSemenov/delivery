package app.delivery.infrastructure.postgres.entities;

import app.delivery.core.domain.order.aggregate.OrderStatus;
import app.delivery.core.shared.kernel.Location;
import app.delivery.core.shared.kernel.Weight;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@Entity
@Table(name = "orders")
public class OrderEntity {

    @Id
    private UUID id;

    private UUID courierId;

    @Enumerated(EnumType.STRING)
    private OrderStatus status;

    @Embedded
    private Weight weight;

    @Embedded
    private Location location;
}
