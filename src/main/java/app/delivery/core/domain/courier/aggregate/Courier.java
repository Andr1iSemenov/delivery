package app.delivery.core.domain.courier.aggregate;

import app.delivery.core.domain.order.aggregate.Order;
import app.delivery.core.shared.kernel.Location;
import jakarta.persistence.*;
import lombok.*;

import java.util.UUID;

@Entity
@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@EqualsAndHashCode(of = "id")
public class Courier {

    public static final int DEFAULT_LOCATION_X = 1;
    public static final int DEFAULT_LOCATION_Y = 1;

    @Id
    private UUID id;

    private String name;

    private Transport transport;

    @Embedded
    private Location location;

    @Enumerated(EnumType.STRING)
    private CourierStatus status;


    public static Courier create(@NonNull UUID id, @NonNull String name, @NonNull Transport transport) {
        return Courier.builder()
                .id(id)
                .name(name)
                .transport(transport)
                .location(new Location(DEFAULT_LOCATION_X, DEFAULT_LOCATION_Y))
                .status(CourierStatus.NOT_AVAILABLE)
                .build();
    }

    public void startWorkDay() {
        if (!CourierStatus.NOT_AVAILABLE.equals(status)) {
            throw new IllegalStateException("Failed to start work day. Courier is %s".formatted(status));
        }
        this.status = CourierStatus.READY;
    }

    public void endWorkDay() {
        if (!CourierStatus.READY.equals(status)) {
            throw new IllegalStateException("Failed to end work day. Courier is %s".formatted(status));
        }
        this.status = CourierStatus.NOT_AVAILABLE;
    }

    public void assignOrder() {
        if (!CourierStatus.READY.equals(status)) {
            throw new IllegalStateException("Failed to assign order. Courier is %s".formatted(status));
        }
        this.status = CourierStatus.BUSY;
    }

    public void moveTowardsOrderLocation(@NonNull Order order) {
        this.location = location.moveTowards(order.getLocation(), transport.getSpeed());
        if (calculateSteps(order.getLocation()) == 0) {
            order.complete();
            this.status = CourierStatus.READY;
        }
    }

    public int calculateSteps(@NonNull Location orderLocation) {
        int distanceTo = location.calculateDistance(orderLocation);
        if (distanceTo <= 0) {
            return 0;
        }
        return (int) Math.ceil((double) distanceTo / transport.getSpeed());
    }
}
