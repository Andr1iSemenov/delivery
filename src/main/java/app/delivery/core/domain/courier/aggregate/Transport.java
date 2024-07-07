package app.delivery.core.domain.courier.aggregate;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.stream.Stream;

@RequiredArgsConstructor
@Getter
public enum Transport {

    PEDESTRIAN(0, "Pedestrian", 1, 1),
    BICYCLE(1, "Bicycle", 2, 4),
    SCOOTER(2, "Scooter", 3, 6),
    CAR(3, "Car", 4, 8);

    private final int id;
    private final String name;
    private final int speed;
    private final int capacity;


    public boolean canCarry(double weight) {
        return capacity >= weight;
    }

    public static Transport of(String name) {
        return Stream.of(Transport.values())
                .filter(e -> e.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown Transport name: " + name));
    }
}