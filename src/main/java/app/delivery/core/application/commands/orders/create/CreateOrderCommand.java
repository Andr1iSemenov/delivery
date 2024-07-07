package app.delivery.core.application.commands.orders.create;

import app.delivery.core.shared.kernel.Weight;
import lombok.NonNull;

import java.util.UUID;

public record CreateOrderCommand(@NonNull UUID basketId, @NonNull String street, @NonNull Weight weight) {

    public CreateOrderCommand {
        if (street.isBlank()) {
            throw new IllegalArgumentException("Street cannot be blank");
        }
    }
}
