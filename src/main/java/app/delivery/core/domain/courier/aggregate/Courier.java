package app.delivery.core.domain.courier.aggregate;

import app.delivery.core.domain.order.aggregate.Order;
import app.delivery.core.shared.kernel.Location;
import lombok.*;

import java.util.UUID;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@EqualsAndHashCode(of = "id")
public class Courier {

    private static final int STEP_SIZE = 1;
    public static final int DEFAULT_LOCATION_X = 1;
    public static final int DEFAULT_LOCATION_Y = 1;

    private UUID id;

    private String name;

    private Transport transport;

    private Location location;

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
        if (CourierStatus.BUSY.equals(status)) {
            throw new IllegalStateException("Failed to start work day. Courier is %s".formatted(status));
        }
        this.status = CourierStatus.READY;
    }

    public void endWorkDay() {
        if (CourierStatus.BUSY.equals(status)) {
            throw new IllegalStateException("Failed to end work day. Courier is %s".formatted(status));
        }
        this.status = CourierStatus.NOT_AVAILABLE;
    }

    public void assignOrder() {
        if (CourierStatus.BUSY.equals(status) || CourierStatus.NOT_AVAILABLE.equals(status)) {
            throw new IllegalStateException("Failed to assign order. Courier is %s".formatted(status));
        }
        this.status = CourierStatus.BUSY;
    }

    public void moveTowardsOrderLocation(@NonNull Order order) {
        Location orderLocation = order.getLocation();

        int currentXCoordinate = location.xCoordinate();
        int currentYCoordinate = location.yCoordinate();

        int xOffset = currentXCoordinate - orderLocation.xCoordinate();
        int yOffset = currentYCoordinate - orderLocation.yCoordinate();
        for (int i = 0; i < transport.getSpeed() && !reachedCoordinate(xOffset, yOffset); i++) {

            if (Math.abs(xOffset) >= Math.abs(yOffset)) {
                currentXCoordinate = adjustCoordinateTowardsTarget(xOffset, currentXCoordinate);
            } else {
                currentYCoordinate = adjustCoordinateTowardsTarget(yOffset, currentYCoordinate);
            }

            xOffset = currentXCoordinate - orderLocation.xCoordinate();
            yOffset = currentYCoordinate - orderLocation.yCoordinate();
        }

        if (reachedCoordinate(xOffset, yOffset)) {
            order.complete();
            this.status = CourierStatus.READY;
        }

        this.location = new Location(currentXCoordinate, currentYCoordinate);
    }

    public int calculateSteps(@NonNull Location orderLocation) {
        int distanceTo = location.calculateDistance(orderLocation);
        if (distanceTo <= 0) {
            return 0;
        }
        return distanceTo / transport.getSpeed();
    }

    private int adjustCoordinateTowardsTarget(int offset, int currentCoordinate) {
        return offset >= 0 ? currentCoordinate - STEP_SIZE : currentCoordinate + STEP_SIZE;
    }

    private boolean reachedCoordinate(int xOffset, int yOffset) {
        return xOffset == 0 && yOffset == 0;
    }
}
