package app.delivery.core.shared.kernel;

import java.util.Objects;
import java.util.Random;

public record Location(int xCoordinate, int yCoordinate) {

    private static final Random RANDOM = new Random();
    private static final int STEP_SIZE = 1;

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

    public static Location createWithMinimumCoordinates() {
        return new Location(MINIMUM_COORDINATE, MINIMUM_COORDINATE);
    }

    public static Location createWithRandomCoordinates() {
        return new Location(RANDOM.nextInt(10) + 1, RANDOM.nextInt(10) + 1);
    }

    public int calculateDistance(Location toDistance) {
        Objects.requireNonNull(toDistance);
        int distanceToX = Math.abs(xCoordinate - toDistance.xCoordinate);
        int distanceToY = Math.abs(yCoordinate - toDistance.yCoordinate);
        return distanceToX + distanceToY;
    }

    public Location moveTowards(Location toLocation, int speed) {

        int currentXCoordinate = this.xCoordinate;
        int currentYCoordinate = this.yCoordinate;

        int xOffset = currentXCoordinate - toLocation.xCoordinate();
        int yOffset = currentYCoordinate - toLocation.yCoordinate();
        for (int i = 0; i < speed && !reachedCoordinate(xOffset, yOffset); i++) {

            if (Math.abs(xOffset) >= Math.abs(yOffset)) {
                currentXCoordinate = adjustCoordinateTowardsTarget(xOffset, currentXCoordinate);
            } else {
                currentYCoordinate = adjustCoordinateTowardsTarget(yOffset, currentYCoordinate);
            }

            xOffset = currentXCoordinate - toLocation.xCoordinate();
            yOffset = currentYCoordinate - toLocation.yCoordinate();
        }

        return new Location(currentXCoordinate, currentYCoordinate);
    }

    private int adjustCoordinateTowardsTarget(int offset, int currentCoordinate) {
        return offset >= 0 ? currentCoordinate - STEP_SIZE : currentCoordinate + STEP_SIZE;
    }

    private boolean reachedCoordinate(int xOffset, int yOffset) {
        return xOffset == 0 && yOffset == 0;
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
