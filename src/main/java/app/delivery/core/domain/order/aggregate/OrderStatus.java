package app.delivery.core.domain.order.aggregate;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Objects;
import java.util.stream.Stream;

@Getter
@AllArgsConstructor
public enum OrderStatus {

    CREATED(0, "Created"),
    ASSIGNED(1, "Assigned"),
    COMPLETED(2, "Completed"),;

    private final int id;
    private final String name;


    public static OrderStatus of(Integer id) {
        return Stream.of(OrderStatus.values())
                .filter(s -> Objects.equals(s.id, id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown order status: " + id));
    }

    public static OrderStatus of(String name) {
        return Stream.of(OrderStatus.values())
                .filter(s -> Objects.equals(s.name, name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown order name: " + name));
    }
}
