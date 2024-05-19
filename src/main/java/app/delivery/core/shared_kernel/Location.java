package app.delivery.core.shared_kernel;

import java.util.Objects;

public class Location {

    private static final double MINIMUM_COORDINATE = 1.1;
    private static final double MAXIMUM_COORDINATE = 10.10;

    private final double xCoordinate;
    private final double yCoordinate;


    private Location(double xCoordinate, double yCoordinate) {
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    public double getXCoordinate() {
        return xCoordinate;
    }

    public double getYCoordinate() {
        return yCoordinate;
    }

    public static Location create(double xCoordinate, double yCoordinate) {
        if (xCoordinate < MINIMUM_COORDINATE || xCoordinate > MAXIMUM_COORDINATE) {
            throw new IllegalArgumentException("xCoordinate is out of bounds");
        }
        if (yCoordinate < MINIMUM_COORDINATE || yCoordinate > MAXIMUM_COORDINATE) {
            throw new IllegalArgumentException("yCoordinate is out of bounds");
        }

        return new Location(xCoordinate, yCoordinate);
    }

    public double calculateDistance(Location toDistance) {
        Objects.requireNonNull(toDistance);
        double distanceToX = Math.abs(getXCoordinate() - toDistance.getXCoordinate());
        double distanceToY = Math.abs(getYCoordinate() - toDistance.getYCoordinate());
        return distanceToX + distanceToY;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location)) return false;
        return Double.compare(xCoordinate, location.xCoordinate) == 0 && Double.compare(yCoordinate, location.yCoordinate) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(xCoordinate, yCoordinate);
    }
}
