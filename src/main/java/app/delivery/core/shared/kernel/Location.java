package app.delivery.core.shared.kernel;

import java.util.Objects;

public record Location(int xCoordinate, int yCoordinate) {

    public static final int MINIMUM_COORDINATE = 1;
    public static final int MAXIMUM_COORDINATE = 10;


    public Location {
        if (xCoordinate < MINIMUM_COORDINATE || xCoordinate > MAXIMUM_COORDINATE) {
            throw new IllegalArgumentException("xCoordinate: %s is out of bounds".formatted(xCoordinate));
        }
        if (yCoordinate < MINIMUM_COORDINATE || yCoordinate > MAXIMUM_COORDINATE) {
            throw new IllegalArgumentException("yCoordinate: %s is out of bounds".formatted(yCoordinate));
        }
    }

    public int calculateDistance(Location toDistance) {
        Objects.requireNonNull(toDistance);
        int distanceToX = Math.abs(xCoordinate - toDistance.xCoordinate);
        int distanceToY = Math.abs(yCoordinate - toDistance.yCoordinate);
        return distanceToX + distanceToY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location)) return false;
        return xCoordinate == location.xCoordinate && yCoordinate == location.yCoordinate;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }
}
