package app.delivery.core.shared_kernel;

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

    public int getXCoordinate() {
        return xCoordinate;
    }

    public int getYCoordinate() {
        return yCoordinate;
    }

    public int calculateDistance(Location toDistance) {
        Objects.requireNonNull(toDistance);
        int distanceToX = Math.abs(getXCoordinate() - toDistance.getXCoordinate());
        int distanceToY = Math.abs(getYCoordinate() - toDistance.getYCoordinate());
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
