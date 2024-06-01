package app.delivery.core.domain.courier.aggregate;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Objects;
import java.util.stream.Stream;

@Getter
@RequiredArgsConstructor
public enum CourierStatus {

    NOT_AVAILABLE(0, "NotAvailable"),
    READY(1, "Ready"),
    BUSY(2, "Busy");

    private final int id;
    private final String name;


    public static CourierStatus of(Integer id) {
        return Stream.of(CourierStatus.values())
                .filter(s -> Objects.equals(s.id, id))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown courier status: " + id));
    }

    public static CourierStatus of(String name) {
        return Stream.of(CourierStatus.values())
                .filter(s -> Objects.equals(s.name, name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("Unknown courier name: " + name));
    }
}
